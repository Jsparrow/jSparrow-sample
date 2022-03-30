package sample;

public class Foo {
	
	// bound to fooMethod as leading comment.    
	/**      
	 * bound to fooMethod as javadoc
	 */
	public void fooMethod() {
		// bound to foo method as internal comment    
	}// bound to foo method as trailing comment. 

	// there are two blank lines above and below this comment. Hence, it is not bound to any class member 

	// bound to fooField as leading comment
	private String fooField = "";
	// bound to fooField as trailing comment
}