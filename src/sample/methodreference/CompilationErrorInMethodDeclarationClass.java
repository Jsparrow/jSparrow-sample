package sample.methodreference;

import java.util.Comparator;
import java.util.List;

public class CompilationErrorInMethodDeclarationClass<T extends org.apache.Tee> {
	
	public CompilationErrorInMethodDeclarationClass() {
		foo2(12);
	}
	
	public void run(Runnable r) {}
	
	public void foo() {}
	
	public List<Lisst<org.apache.Tee>> foo2(int i) {
		return;
	}
	
	public List<Lisst<org.apache.Tee>> foo3(Runnable r) {
		return;
	}

	public List<Lisst<org.apache.Tee>> foo4(Comparator<String> c) {
		return;
	}
	
	public void foo5(Comparator<String> c) {
		return;
	}
}
