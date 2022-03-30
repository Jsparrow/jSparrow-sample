package sample.markers;

public class RemoveEmptyStatements {

	
	public void unnecessarySemiColon() {
	    ;
	    int a = 0;
	}
	
	public void unnecessaryMultipleSemiColon() {
	    ;;;
	    int a = 0;;;
	    ;;;;
	}
}
