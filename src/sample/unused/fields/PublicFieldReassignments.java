package sample.unused.fields;

public class PublicFieldReassignments extends UnusedFields {
	
	void reassigingPublicMethods() {
		UnusedFields unusedFields = new UnusedFields();
		unusedFields.protectedReassignedField = "";
		unusedFields.publicFieldReassignedExternally = "";
		unusedFields.publicFieldReassignedInternallyAndExternally = "";
	}
	
	void reassignParentFields() {
		publicFieldReassignedExternally = "new value";
		publicFieldReassignedInternallyAndExternally = "";
		protectedReassignedField = "";
	}
	
	void reassignParentProtectedFields() {
		protectedReassignedField = "";
	}

}
