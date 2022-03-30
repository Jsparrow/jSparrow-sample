package sample.unused.fields;

public class PublicFieldsConsumer {

	void consumingPublicFields() {
		UnusedFields unusedFields = new UnusedFields();
		System.out.println(unusedFields.publicFieldUsedExternally);
		System.out.println(unusedFields.publicFieldUsedInternallyAndExternally);
		unusedFields.publicFieldReassignedExternally = "";
	}
}
