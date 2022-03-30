package sample.loops.bufferedreader;

import java.io.BufferedReader;
import java.io.FileReader;

public class UsingBufferedReaderFiles {
	
	public void savingComments() {
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.name.txt"))) {		
			/* 1*/
			String /* 2*/ line; /* 3*/
			
			/* 4*/
			while(/* 5*/(line = bufferedReader.readLine()) /* 6*/ != null) /* 7*/ {
				/* 8*/
				System.out.println(line);
			}/* 9*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
