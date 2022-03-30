package sample.records;

public class UsingRecords {

	public void createPoints() {
		Point point = new Point(10, 15);
		point.x();
		point.y();
		
		System.out.println(point);
		
		LegacyPoint legacyPoint = new LegacyPoint(10, 15);
		System.out.println(legacyPoint);
	}
	
	public static void main(String []args) {
		UsingRecords ur = new UsingRecords();
		ur.createPoints();
	}
}
