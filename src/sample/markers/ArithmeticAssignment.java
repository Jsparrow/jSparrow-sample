package sample.markers;

public class ArithmeticAssignment {

	void operatorPlusEquals() {
		int i = 0;
		i = i + 3;
		i = 3 + i;
		i = i + (3 + 4);
	}
	
	void operatorMinusEquals() {
		int i = 10;
		i = i - 3;
		i = -3 + i;
		i = i - (3 + 4);
	}
	
	void operatorMultipluEqual() {
		int i = 10;
		i = i * 3;
		i = i * (3 + 4);
	}
	
	void operatorDivideEqual() {
		int i = 30;
		i = i / 3;
		i = i / (3 + 4);
	}
}
