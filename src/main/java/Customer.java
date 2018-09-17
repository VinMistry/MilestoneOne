public class Customer {

  private String firstName, lastName;
  private Address address;

  public Customer() {
    firstName = "";
    lastName = "";
    address = new Address();
  }

  public Customer(final String firstName, final String lastName,
      final Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(final Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Customer: \n" +
        " firstName: " + firstName +
        ",\n lastName: " + lastName + "\n"
        + getAddress().toString();
  }
}
