/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2016, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ----------------
 * ChartCanvas.java
 * ----------------
 * (C) Copyright 2014-2016, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes:
 * --------
 * 25-Jun-2014 : Version 1 (DG);
 * 19-Jul-2014 : Add clearRect() call for each draw (DG);
 *
 */

package chart.fx;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import chart.ChartMouseEvent;
import chart.ChartRenderingInfo;
import chart.JFreeChart;
import chart.entity.ChartEntity;
import chart.event.ChartChangeEvent;
import chart.event.ChartChangeListener;
import chart.event.OverlayChangeEvent;
import chart.event.OverlayChangeListener;
import chart.fx.interaction.ChartMouseEventFX;
import chart.fx.interaction.ChartMouseListenerFX;
import chart.fx.interaction.MouseHandlerFX;
import chart.fx.interaction.TooltipHandlerFX;
import chart.fx.overlay.OverlayFX;
import chart.plot.PlotRenderingInfo;
import chart.util.ParamChecks;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.FontSmoothingType;

/**
 * A canvas for displaying a {@link JFreeChart} in JavaFX. You can use the
 * canvas directly to display charts, but usually the {@link ChartViewer} class
 * (which embeds a canvas) is a better option.
 * <p>
 * The canvas installs several default mouse handlers, if you don't like the
 * behaviour provided by these you can retrieve the handler by ID and disable or
 * remove it (the IDs are "tooltip", "scroll", "anchor", "pan" and "dispatch").
 * </p>
 * <p>
 * The {@code FontSmoothingType} for the underlying {@code GraphicsContext} is
 * set to {@code FontSmoothingType.LCD} as this gives better results on the
 * systems we've tested on. You can modify this using
 * {@code getGraphicsContext().setFontSmoothingType(yourValue)}.
 * </p>
 * 
 * <p>
 * THE API FOR THIS CLASS IS SUBJECT TO CHANGE IN FUTURE RELEASES. This is so
 * that we can incorporate feedback on the (new) JavaFX support in JFreeChart.
 * </p>
 * 
 * @since 1.0.18
 */
@SuppressWarnings("restriction")
public class ChartCanvas extends Canvas implements ChartChangeListener, OverlayChangeListener {

	/** The chart being displayed in the canvas (never null). */
	private JFreeChart chart;

	/**
	 * The graphics drawing context (will be an instance of FXGraphics2D).
	 */
	private Graphics2D g2;

	/**
	 * The anchor point (can be null) is usually updated to reflect the most recent
	 * mouse click and is used during chart rendering to update crosshairs belonging
	 * to the chart.
	 */
	private Point2D anchor;

	/** The chart rendering info from the most recent drawing of the chart. */
	private ChartRenderingInfo info;

	/** The tooltip object for the canvas (can be null). */
	private Tooltip tooltip;

	/**
	 * A flag that controls whether or not tooltips will be generated from the chart
	 * as the mouse pointer moves over it.
	 */
	private boolean tooltip_Enabled;

	/** Storage for registered chart mouse listeners. */
	private transient List<ChartMouseListenerFX> chart_Mouse_Listeners;

	/** The current live handler (can be null). */
	private MouseHandlerFX live_Handler;

	/**
	 * The list of available live mouse handlers (can be empty but not null).
	 */
	private List<MouseHandlerFX> available_Mouse_Handlers;

	/** The auxiliary mouse handlers (can be empty but not null). */
	private List<MouseHandlerFX> auxiliary_Mouse_Handlers;

	private ObservableList<OverlayFX> overlays;

	/**
	 * A flag that can be used to override the plot setting for domain (x) axis
	 * zooming.
	 */
	private boolean domain_Zoomable;

	/**
	 * A flag that can be used to override the plot setting for range (y) axis
	 * zooming.
	 */
	private boolean range_Zoomable;

	/**
	 * Creates a new canvas to display the supplied chart in JavaFX. If
	 * {@code chart} is null, a blank canvas will be displayed.
	 * 
	 * @param chart the chart.
	 */
	public ChartCanvas(JFreeChart chart) {
		this.chart = chart;
		if (this.chart != null) {
			this.chart.addChangeListener(this);
		}
		this.tooltip = null;
		this.tooltip_Enabled = true;
		this.chart_Mouse_Listeners = new ArrayList<ChartMouseListenerFX>();

		widthProperty().addListener(e -> draw());
		heightProperty().addListener(e -> draw());
		// change the default font smoothing for better results
		GraphicsContext gc = getGraphicsContext2D();
		gc.setFontSmoothingType(FontSmoothingType.LCD);
		this.live_Handler = null;
		this.available_Mouse_Handlers = new ArrayList<MouseHandlerFX>();

		this.auxiliary_Mouse_Handlers = new ArrayList<MouseHandlerFX>();
		this.auxiliary_Mouse_Handlers.add(new TooltipHandlerFX("tooltip"));

		this.overlays = FXCollections.observableArrayList();

		setOnMouseMoved(e -> handleMouseMoved(e));
		setOnMouseClicked(e -> handleMouseClicked(e));
		setOnMousePressed(e -> handleMousePressed(e));
		setOnMouseDragged(e -> handleMouseDragged(e));
		setOnMouseReleased(e -> handleMouseReleased(e));
		setOnScroll(e -> handleScroll(e));
	}

	/**
	 * Returns the chart that is being displayed by this node.
	 * 
	 * @return The chart (possibly {@code null}).
	 */
	public JFreeChart getChart() {
		return this.chart;
	}

	/**
	 * Sets the chart to be displayed by this node.
	 * 
	 * @param chart the chart ({@code null} permitted).
	 */
	public void setChart(JFreeChart chart) {
		if (this.chart != null) {
			this.chart.removeChangeListener(this);
		}
		this.chart = chart;
		if (this.chart != null) {
			this.chart.addChangeListener(this);
		}
		draw();
	}

	/**
	 * Returns the flag that determines whether or not zooming is enabled for the
	 * domain axis.
	 *
	 * @return A boolean.
	 * 
	 * @since 1.0.20
	 */
	public boolean isDomainZoomable() {
		return this.domain_Zoomable;
	}

	/**
	 * Sets the flag that controls whether or not domain axis zooming is enabled. If
	 * the underlying plot does not support domain axis zooming, then setting this
	 * flag to {@code true} will have no effect.
	 * 
	 * @param zoomable
	 * 
	 * @since 1.0.20
	 */
	public void setDomainZoomable(boolean zoomable) {
		this.domain_Zoomable = zoomable;
	}

	/**
	 * Returns the flag that determines whether or not zooming is enabled for the
	 * range axis.
	 *
	 * @return A boolean.
	 * 
	 * @since 1.0.20
	 */
	public boolean isRangeZoomable() {
		return this.range_Zoomable;
	}

	/**
	 * Sets the flag that controls whether or not range axis zooming is enabled. If
	 * the underlying plot does not support range axis zooming, then setting this
	 * flag to {@code true} will have no effect.
	 * 
	 * @param zoomable
	 * 
	 * @since 1.0.20
	 */
	public void setRangeZoomable(boolean zoomable) {
		this.range_Zoomable = zoomable;
	}

	/**
	 * Returns the rendering info from the most recent drawing of the chart.
	 * 
	 * @return The rendering info (possibly {@code null}).
	 */
	public ChartRenderingInfo getRenderingInfo() {
		return this.info;
	}

	/**
	 * Returns the flag that controls whether or not tooltips are enabled. The
	 * default value is {@code true}. The {@link TooltipHandlerFX} class will only
	 * update the tooltip if this flag is set to {@code true}.
	 * 
	 * @return The flag.
	 */
	public boolean isTooltipEnabled() {
		return this.tooltip_Enabled;
	}

	/**
	 * Sets the flag that controls whether or not tooltips are enabled.
	 * 
	 * @param tooltipEnabled the new flag value.
	 */
	public void setTooltipEnabled(boolean tooltipEnabled) {
		this.tooltip_Enabled = tooltipEnabled;
	}

	/**
	 * Set the anchor point and forces a redraw of the chart (the anchor point is
	 * used to determine the position of the crosshairs on the chart, if they are
	 * visible).
	 * 
	 * @param anchor the anchor ({@code null} permitted).
	 */
	public void setAnchor(Point2D anchor) {
		this.anchor = anchor;
		if (this.chart != null) {
			this.chart.setNotify(true); // force a redraw
		}
	}

	/**
	 * Add an overlay to the canvas.
	 *
	 * @param overlay the overlay ({@code null} not permitted).
	 *
	 * @since 1.0.20
	 */
	public void addOverlay(OverlayFX overlay) {
		ParamChecks.nullNotPermitted(overlay, "overlay");
		this.overlays.add(overlay);
		overlay.addChangeListener(this);
		draw();
	}

	/**
	 * Removes an overlay from the canvas.
	 *
	 * @param overlay the overlay to remove ({@code null} not permitted).
	 *
	 * @since 1.0.20
	 */
	public void removeOverlay(OverlayFX overlay) {
		ParamChecks.nullNotPermitted(overlay, "overlay");
		boolean removed = this.overlays.remove(overlay);
		if (removed) {
			overlay.removeChangeListener(this);
			draw();
		}
	}

	/**
	 * Handles a change to an overlay by repainting the chart canvas.
	 *
	 * @param event the event.
	 *
	 * @since 1.0.20
	 */
	@Override
	public void overlayChanged(OverlayChangeEvent event) {
		draw();
	}

	/**
	 * Registers a listener to receive {@link ChartMouseEvent} notifications.
	 *
	 * @param listener the listener ({@code null} not permitted).
	 */
	public void addChartMouseListener(ChartMouseListenerFX listener) {
		ParamChecks.nullNotPermitted(listener, "listener");
		this.chart_Mouse_Listeners.add(listener);
	}

	/**
	 * Removes a listener from the list of objects listening for chart mouse events.
	 *
	 * @param listener the listener.
	 */
	public void removeChartMouseListener(ChartMouseListenerFX listener) {
		this.chart_Mouse_Listeners.remove(listener);
	}

	/**
	 * Returns the mouse handler with the specified ID, or {@code null} if there is
	 * no handler with that ID. This method will look for handlers in both the
	 * regular and auxiliary handler lists.
	 * 
	 * @param id the ID ({@code null} not permitted).
	 * 
	 * @return The handler with the specified ID
	 */
	public MouseHandlerFX getMouseHandler(String id) {
		for (MouseHandlerFX h : this.available_Mouse_Handlers) {
			if (h.getID() == id) {
				return h;
			}
		}
		for (MouseHandlerFX h : this.auxiliary_Mouse_Handlers) {
			if (h.getID() == id) {
				return h;
			}
		}
		return null;
	}

	/**
	 * Adds a mouse handler to the list of available handlers (handlers that are
	 * candidates to take the position of live handler). The handler must have an ID
	 * that uniquely identifies it amongst the handlers registered with this canvas.
	 * 
	 * @param handler the handler ({@code null} not permitted).
	 */
	public void addMouseHandler(MouseHandlerFX handler) {
		if (!this.hasUniqueID(handler)) {
			throw new IllegalArgumentException("There is already a handler with that ID (" + handler.getID() + ").");
		}
		this.available_Mouse_Handlers.add(handler);
	}

	/**
	 * Removes a handler from the list of available handlers.
	 * 
	 * @param handler the handler ({@code null} not permitted).
	 */
	public void removeMouseHandler(MouseHandlerFX handler) {
		this.available_Mouse_Handlers.remove(handler);
	}

	/**
	 * Validates that the specified handler has an ID that uniquely identifies it
	 * amongst the existing handlers for this canvas.
	 * 
	 * @param handler the handler ({@code null} not permitted).
	 * 
	 * @return A boolean.
	 */
	private boolean hasUniqueID(MouseHandlerFX handler) {
		for (MouseHandlerFX h : this.available_Mouse_Handlers) {
			if (handler.getID() == h.getID()) {
				return false;
			}
		}
		for (MouseHandlerFX h : this.auxiliary_Mouse_Handlers) {
			if (handler.getID() == h.getID()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Clears the current live handler. This method is intended for use by the
	 * handlers themselves, you should not call it directly.
	 */
	public void clearLiveHandler() {
		this.live_Handler = null;
	}

	/**
	 * Draws the content of the canvas and updates the {@code renderingInfo}
	 * attribute with the latest rendering information.
	 */
	public final void draw() {
		GraphicsContext ctx = getGraphicsContext2D();
		ctx.save();
		double width = getWidth();
		double height = getHeight();
		if (width > 0 && height > 0) {
			ctx.clearRect(0, 0, width, height);
			this.info = new ChartRenderingInfo();
			if (this.chart != null) {
				this.chart.draw(this.g2, new Rectangle((int) width, (int) height), this.anchor, this.info);
			}
		}
		ctx.restore();
		for (OverlayFX overlay : this.overlays) {
			overlay.paintOverlay(g2, this);
		}
		this.anchor = null;
	}

	/**
	 * Returns the data area (the area inside the axes) for the plot or subplot.
	 *
	 * @param point the selection point (for subplot selection).
	 *
	 * @return The data area.
	 */
	public Rectangle2D findDataArea(Point2D point) {
		PlotRenderingInfo plotInfo = this.info.getPlotInfo();
		Rectangle2D result;
		if (plotInfo.getSubplotCount() == 0) {
			result = plotInfo.getDataArea();
		} else {
			int subplotIndex = plotInfo.getSubplotIndex(point);
			if (subplotIndex == -1) {
				return null;
			}
			result = plotInfo.getSubplotInfo(subplotIndex).getDataArea();
		}
		return result;
	}

	/**
	 * Return {@code true} to indicate the canvas is resizable.
	 * 
	 * @return {@code true}.
	 */
	@Override
	public boolean isResizable() {
		return true;
	}

	/**
	 * Sets the tooltip text, with the (x, y) location being used for the anchor. If
	 * the text is {@code null}, no tooltip will be displayed. This method is
	 * intended for calling by the {@link TooltipHandlerFX} class, you won't
	 * normally call it directly.
	 * 
	 * @param text the text ({@code null} permitted).
	 * @param x    the x-coordinate of the mouse pointer.
	 * @param y    the y-coordinate of the mouse pointer.
	 */
	public void setTooltip(String text, double x, double y) {
		if (text != null) {
			if (this.tooltip == null) {
				this.tooltip = new Tooltip(text);
				Tooltip.install(this, this.tooltip);
			} else {
				this.tooltip.setText(text);
				this.tooltip.setAnchorX(x);
				this.tooltip.setAnchorY(y);
			}
		} else {
			Tooltip.uninstall(this, this.tooltip);
			this.tooltip = null;
		}
	}

	/**
	 * Handles a mouse pressed event by (1) selecting a live handler if one is not
	 * already selected, (2) passing the event to the live handler if there is one,
	 * and (3) passing the event to all enabled auxiliary handlers.
	 * 
	 * @param e the mouse event.
	 */
	private void handleMousePressed(MouseEvent e) {
		if (this.live_Handler == null) {
			for (MouseHandlerFX handler : this.available_Mouse_Handlers) {
				if (handler.isEnabled() && handler.hasMatchingModifiers(e)) {
					this.live_Handler = handler;
				}
			}
		}

		if (this.live_Handler != null) {
			this.live_Handler.handleMousePressed(this, e);
		}

		// pass on the event to the auxiliary handlers
		for (MouseHandlerFX handler : this.auxiliary_Mouse_Handlers) {
			if (handler.isEnabled()) {
				handler.handleMousePressed(this, e);
			}
		}
	}

	/**
	 * Handles a mouse moved event by passing it on to the registered handlers.
	 * 
	 * @param e the mouse event.
	 */
	private void handleMouseMoved(MouseEvent e) {
		if (this.live_Handler != null && this.live_Handler.isEnabled()) {
			this.live_Handler.handleMouseMoved(this, e);
		}

		for (MouseHandlerFX handler : this.auxiliary_Mouse_Handlers) {
			if (handler.isEnabled()) {
				handler.handleMouseMoved(this, e);
			}
		}
	}

	/**
	 * Handles a mouse dragged event by passing it on to the registered handlers.
	 * 
	 * @param e the mouse event.
	 */
	private void handleMouseDragged(MouseEvent e) {
		if (this.live_Handler != null && this.live_Handler.isEnabled()) {
			this.live_Handler.handleMouseDragged(this, e);
		}

		// pass on the event to the auxiliary handlers
		for (MouseHandlerFX handler : this.auxiliary_Mouse_Handlers) {
			if (handler.isEnabled()) {
				handler.handleMouseDragged(this, e);
			}
		}
	}

	/**
	 * Handles a mouse released event by passing it on to the registered handlers.
	 * 
	 * @param e the mouse event.
	 */
	private void handleMouseReleased(MouseEvent e) {
		if (this.live_Handler != null && this.live_Handler.isEnabled()) {
			this.live_Handler.handleMouseReleased(this, e);
		}

		// pass on the event to the auxiliary handlers
		for (MouseHandlerFX handler : this.auxiliary_Mouse_Handlers) {
			if (handler.isEnabled()) {
				handler.handleMouseReleased(this, e);
			}
		}
	}

	/**
	 * Handles a mouse released event by passing it on to the registered handlers.
	 * 
	 * @param e the mouse event.
	 */
	private void handleMouseClicked(MouseEvent e) {
		if (this.live_Handler != null && this.live_Handler.isEnabled()) {
			this.live_Handler.handleMouseClicked(this, e);
		}

		// pass on the event to the auxiliary handlers
		for (MouseHandlerFX handler : this.auxiliary_Mouse_Handlers) {
			if (handler.isEnabled()) {
				handler.handleMouseClicked(this, e);
			}
		}
	}

	/**
	 * Handles a scroll event by passing it on to the registered handlers.
	 * 
	 * @param e the scroll event.
	 */
	protected void handleScroll(ScrollEvent e) {
		if (this.live_Handler != null && this.live_Handler.isEnabled()) {
			this.live_Handler.handleScroll(this, e);
		}
		for (MouseHandlerFX handler : this.auxiliary_Mouse_Handlers) {
			if (handler.isEnabled()) {
				handler.handleScroll(this, e);
			}
		}
	}

	/**
	 * Receives a notification from the chart that it has been changed and responds
	 * by redrawing the chart entirely.
	 * 
	 * @param event event information.
	 */
	@Override
	public void chartChanged(ChartChangeEvent event) {
		draw();
	}

	public void dispatchMouseMovedEvent(Point2D point, MouseEvent e) {
		double x = point.getX();
		double y = point.getY();
		ChartEntity entity = this.info.getEntityCollection().getEntity(x, y);
		ChartMouseEventFX event = new ChartMouseEventFX(this.chart, e, entity);
		for (ChartMouseListenerFX listener : this.chart_Mouse_Listeners) {
			listener.chartMouseMoved(event);
		}
	}

	public void dispatchMouseClickedEvent(Point2D point, MouseEvent e) {
		double x = point.getX();
		double y = point.getY();
		ChartEntity entity = this.info.getEntityCollection().getEntity(x, y);
		ChartMouseEventFX event = new ChartMouseEventFX(this.chart, e, entity);
		for (ChartMouseListenerFX listener : this.chart_Mouse_Listeners) {
			listener.chartMouseClicked(event);
		}
	}
}
