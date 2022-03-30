package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReading {

	public void fileReaderInitializedWithString() {
		
		Charset c = Charset.forName("UTF-8");
		
		try (FileReader reader = new FileReader("path/to/file"); BufferedReader br = new BufferedReader(reader)) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void anonymousClass() {
		try (BufferedReader br = new BufferedReader(new FileReader("path/to/file")) {
		}) {
			// ..
		} catch (IOException e) {
		}
	}

	public String openFileForReading(String path) {

		Charset utf8 = Charset.forName("UTF-8");
		Charset charset = StandardCharsets.UTF_8;

		String encoding = System.getProperty("file.encoding");
		Charset defaultCharset = Charset.defaultCharset();

		StringBuilder sb = new StringBuilder();
		File file = new File(path);
		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			
		} catch (IOException e1) {
			
		}
		
		try {
			BufferedWriter bw = Files.newBufferedWriter(file.toPath(), Charset.defaultCharset());
		} catch (IOException e1) {}
	
		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public void baseCase() throws Exception {
		try (FileReader reader = new FileReader(new File("path/to/file"));
				BufferedReader br = new BufferedReader(reader)) {
			//...
		} catch (IOException e) {
		}

		String location = "path/to/file";
		BufferedReader br = new BufferedReader(new FileReader(location));
	}

	public void usingInputStreamReader() {
		try (InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("file")));
				BufferedReader br = new BufferedReader(reader)) {

		} catch (IOException e) {
		}
	}

	public void nullInitializer() {
		try (BufferedReader br = new LineNumberReader(null)) {

		} catch (IOException e) {
		}
	}

	public void baseCase2() {
		try (BufferedReader br = new BufferedReader(new FileReader("path/to/file"))) {
		} catch (IOException e) {
		}

		try (BufferedReader br = new BufferedReader(new FileReader(new File("path/to/parent", "path/to/child")))) {
		} catch (IOException e) {
		}

		try (BufferedReader br = Files.newBufferedReader(Paths.get("path/to/parent", "path/to/child"),
				Charset.defaultCharset())) {
		} catch (IOException e) {
		}
	}

	public void methodInvocationInitializer() {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get("path/to/file"));
		} catch (IOException e) {
		}
	}

	public void multipleArguments() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("path/to/file"), 100);
		} catch (IOException e) {
		}
	}

	public void fileReaderDeclaredBeforeTWR() {

		try {
			FileReader fileReader = new FileReader("path/to/file");
			try (BufferedReader br = new BufferedReader(fileReader)) {
			} catch (IOException e) {
			}
		} catch (FileNotFoundException e1) {
		}

	}

	public void missingFileReaderInitializer() {
		try (FileReader fileReader = null; BufferedReader br = new BufferedReader(fileReader)) {
		} catch (IOException e) {
		}
	}

	public void reuseFileReaderInTWR() {
		try (FileReader fileReader = new FileReader(new File("path/to/file"));
				BufferedReader br = new BufferedReader(fileReader)) {
			System.out.println(fileReader.getEncoding());
		} catch (IOException e) {
		}
	}

	public void missingFileReader() {
		BufferedReader br = new BufferedReader(new InputStreamReader(null));
	}

	public void baseCase2Outcome() {

		try (BufferedReader br = Files.newBufferedReader(Paths.get("path/to/file", "path/to/child"),
				Charset.defaultCharset())) {
		} catch (IOException e) {
		}

	}

	public String openFileForReading2(String path) throws IOException {
		StringBuilder sb = new StringBuilder();
		File file = new File(path);
		try (BufferedReader br = Files.newBufferedReader(file.toPath(), Charset.defaultCharset())) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public void usingReadAllLines(String path) throws Exception {
		List<String> content = Files.readAllLines(Paths.get(path));
	}

	public void createTempFile() {
		try (FileReader reader = new FileReader(File.createTempFile("prefix", "suffix"));
				BufferedReader br = new BufferedReader(reader)) {

		} catch (IOException e) {
		}
	}
}
