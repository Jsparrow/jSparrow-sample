package sample.unused.fields;

import java.io.Serializable;

import org.apiguardian.api.API;
import org.apiguardian.api.API.Status;

@SuppressWarnings("rawtypes")
public class UnusedFields implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String publicUnusedField = "";//1
	public String publicFieldReassignedInternally = "";//2
	public String publicFieldReassignedExternally = "";//3
	public String publicFieldReassignedInternallyAndExternally = "";//4
	
	public String publicFieldUsedExternally = "";//5
	public String publicFieldUsedInternally = "";//6
	public String publicFieldUsedInternallyAndExternally = "";//7
	
	
	protected String protectedUnusedField = "";//8
	protected String protectedReassignedField = "";//9
	
	String packageProtectedUnusedField = "";//10
	

	private String privateUnusedField = "";//11
	private String privateFieldReassignedInternally = "";//12
	private String privateFieldUsedInternally = "";
	
	@Deprecated(forRemoval = true)
	private String unusedDeprecatedForRemovalAnnoation = "";
	
	@Deprecated
	private String unusedDeprecatedAnnoation = "";
	
	@SuppressWarnings("unused")
	private String unusedAnnotation = "";
	
	@API(status = Status.INTERNAL)
	public String api;
	
	void reassignemnts() {
		publicFieldReassignedInternally = "value";//13
		publicFieldUsedInternallyAndExternally = "new value";//14
		publicFieldReassignedInternallyAndExternally = "";//15
		protectedReassignedField = "";//16
	}
	
	void blackHole() {
		System.out.println(publicFieldUsedInternally);
		System.out.println(publicFieldUsedInternallyAndExternally);
		System.out.println(privateFieldUsedInternally);
	}

}
