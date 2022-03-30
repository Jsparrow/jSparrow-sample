package sample.writestring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilesWriteStringSamples {

	void sample() throws IOException {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/test/testpath"));
				BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("/home/test/testpath"))) {
			// some comment
			bufferedWriter.write("Hello World!");
			bufferedWriter2.write("");
		}

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/test/testpath"))) {
			// some comment
			bufferedWriter.write("Hello World!");
		}
	}

}
