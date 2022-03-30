package sample.flattern;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Order {

    private User user;
    private List<OrderItem> orderItems;
    private ZonedDateTime placeTimestamp;
    private BigDecimal discount  = BigDecimal.ZERO;
    public Order(User user, List<OrderItem> orderItems) {
        this.user = user;
        this.orderItems = orderItems;
        this.placeTimestamp = ZonedDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getTotalPrice() {
        return orderItems
                .stream()
                .map(OrderItem::calcTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public ZonedDateTime getPlaceTimestamp() {
        return placeTimestamp;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setPlaceTimestamp(ZonedDateTime placeTimestamp) {
        this.placeTimestamp = placeTimestamp;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    
    public void setPercentageDiscount(Double percentage) {
    	BigDecimal p = BigDecimal.valueOf(percentage);
    	BigDecimal d = getTotalPrice().multiply(p);
    	setDiscount(d);
    }

    public BigDecimal computeFinalAmount() {
        return getTotalPrice().subtract(discount);
    }
}

