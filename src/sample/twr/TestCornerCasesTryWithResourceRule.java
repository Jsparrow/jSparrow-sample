package sample.twr;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public class TestCornerCasesTryWithResourceRule {
	
	static void readFirstLineFromFile(String path) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedReader br2 = new BufferedReader(new FileReader(path));
			Closeable cl = new BufferedReader(new FileReader(path));
			
			try {
				BufferedReader br4 = new BufferedReader(new FileReader(path));
				BufferedReader br5 = new BufferedReader(new FileReader(path));
				Closeable cl1 = new BufferedReader(new FileReader(path));
				if(true) 				
					{ br4.close(); }
				
				br5.close();
				cl1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(true) {				
				br.close();
			}
			br2.close();
			cl.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void multipleCloseStatements(String path) {
		try {
			BufferedReader br4 = new BufferedReader(new FileReader(path)), br6;
			BufferedReader br5 = new BufferedReader(new FileReader(path));
			Closeable cl1 = new BufferedReader(new FileReader(path));
			br4.lines();
				
			if(true)   br4.close(); 
			cl1.close();
			br5.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
