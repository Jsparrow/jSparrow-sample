package sample.records;

import java.util.Objects;

public class LegacyPoint {

	private final int x;
	private final int y;

	public LegacyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LegacyPoint other = (LegacyPoint) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "LegacyPoint [x=" + x + ", y=" + y + "]";
	}
}
