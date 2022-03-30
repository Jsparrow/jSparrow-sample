package sample.multicatch;

public class MultiCatchExamples {
	
	private void identicalCatchClauses_shouldNotTransform() {
		try {
			throwsTypeOne();
			throwsTypeOnTwo();
		} catch (TypeOneException e) {
			e.childMethod();
		} catch (TypeTwoException e) {
			e.childMethod();
		}
	}
	
	
	private void identicalCatchClauses_shouldTransform() {
		try {
			throwsTypeOne();
			throwsTypeOnTwo();
		} catch (TypeOneException e) {
			e.appExceptionMethod();
		} catch (TypeTwoException e) {
			e.appExceptionMethod();
		}
	}
	
	
	private void throwsTypeOne() throws TypeOneException {
		
	}
	
	private void throwsTypeOnTwo() throws TypeTwoException {
		
	}

}
