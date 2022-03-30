package sample.methodreference;

import java.util.Comparator;

public class Sim1902Demo {
	
	public void usingAnOverloadWithCompilationErrors(CompilationErrorInMethodDeclarationClass cls) {
		cls.run(() -> { cls.foo();});
	}

	public void casitngInUnresolvedMethodBindings() {
		CompilationErrorInMethodDeclarationClass cls = new CompilationErrorInMethodDeclarationClass<>();
		cls.foo3((Runnable) () -> {});
	}
	
	void compilationErrorsInMethodDeclaration() {
		CompilationErrorInMethodDeclarationClass c = new CompilationErrorInMethodDeclarationClass();
		Comparator<String> t = (String lhs, String rhs) -> lhs.compareTo(rhs);
		c.foo5((String lhs, String rhs) -> lhs.compareTo(rhs));
	}
}
