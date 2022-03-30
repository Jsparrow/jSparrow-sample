package sample.markers;

public class RemoveDoubleNegations {

	
	public void removeDoubleNegations() {
		boolean a = !!true; // 2 times
		
		a = !!!!!!true; // 2n times
	}
	
	public void removeDoubleNegations_expected() {
		boolean a = true; // 2 times
	}
	
	public void reduceTripleNegation() {
		boolean a = !!!!!!!true; // 3 times
	}
	
	public void reduceTripleNegation_expected() {
		boolean a = !true; // 3 times
	}
}
