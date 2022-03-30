package sample.markers;

public interface RemoveModifiersInInterfaceProperties {

	public String FIELD_WITH_PUBLIC_MODIFIER = "";

	public static String FIELD_WITH_PUBLIC_STATIC_MODIFIER = "";

	public static final String FIELD_WITH_PUBLIC_STATIC_FINAL_MODIFIER = "";

	void method();

	public void publicMethod();

	public static void publicStaticMethod() {

	}

	public default void publicDefaultMethod() {

	}
}
