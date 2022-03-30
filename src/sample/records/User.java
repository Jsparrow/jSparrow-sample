package sample.records;

public class User {
	

	void someMethod() {
		class Address {
			private final  String street;
			private final String number;
			private final String zipCode;
			private final String city;
			private final String country;
			
			public Address(String street, String number, String zipCode, String city, String country) {
				this.street = street;
				this.number = number;
				this.zipCode = zipCode;
				this.city = city;
				this.country = country;
			}
		}
		
		var address = new Address("", "", "", "", "");
		System.out.println(address.street + address.number + address.zipCode + address.city + address.country);
		
	}
	
	void someMethod2() {
		class Address {
			private final  String street;
			private final String number;
			private final String zipCode;
			private final String city;
			private final String country;
			
			public Address(String street, String number, String zipCode, String city, String country) {
				this.street = street;
				this.number = number;
				this.zipCode = zipCode;
				this.city = city;
				this.country = country;
			}
		}
		
		var address = new Address("", "", "", "", "");
		System.out.println(address.street + address.number + address.zipCode + address.city + address.country);
		
	}
	
}
