package sample.flattern;

public class User implements Comparable<User> {

    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private Address address;
    private UserPreferences preferences = new UserPreferences();

    public User(String email, String phoneNumber, String firstName, String lastName,
                Address address) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public UserPreferences getPreferences() {
    	return preferences;
    }

	@Override
	public int compareTo(User o) {
		
		return 0;
	}
}
