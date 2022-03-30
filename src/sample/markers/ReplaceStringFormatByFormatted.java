package sample.markers;

public class ReplaceStringFormatByFormatted {

	public void foo(String name, String phone, String address, double salary) {
		String output = String.format("Name: %s, Phone: %s, Address: %s, Salary: $%.2f", name, phone, address, salary);
		System.out.println(output);
	}

	public void foo_expected(String name, String phone, String address, double salary) {
		String output = "Name: %s, Phone: %s, Address: %s, Salary: $%.2f".formatted(name, phone, address, salary);
		System.out.println(output);
	}
}