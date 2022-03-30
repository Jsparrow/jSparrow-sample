package sample.make_final;

public class ReviewSim1736 {
	
	public static class InnerClass {
		public static class InnerInnerClass {
			private int intValue = 0;
		}
	}

	public void assignIntValueInInnerInnerClass() {
		InnerClass.InnerInnerClass xInnerInnerClass = new InnerClass.InnerInnerClass();
		xInnerInnerClass.intValue = 1;
	}
	
	public void sampleMethod() {


		final Inner.InnerInner cls = new Inner.InnerInner();
		cls.field = 1;
	}

	static class Inner {
		
		
		public static class InnerInner {
			private double field = 0;
			
		}
	}

}
