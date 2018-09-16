public class Customer {

  private String firstName, lastName;
  private String postcode, houseNumber, street, city;

  public Customer() {
    firstName = "";
    lastName = "";
    postcode = "";
    houseNumber = "";
    street = "";
    city = "";
  }

  public Customer(final String firstName, final String lastName, final String postcode, final String houseNumber, final String street,
      final String city) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.postcode = postcode;
    this.houseNumber = houseNumber;
    this.street = street;
    this.city = city;
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

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(final String postcode) {
    this.postcode = postcode;
  }

  public String getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(final String houseNumber) {
    this.houseNumber = houseNumber;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(final String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Customer: \n" +
        " firstName: " + firstName +
        ",\n lastName: " + lastName +
        ",\n postcode: " + postcode +
        ",\n houseNumber: " + houseNumber +
        ",\n street: " + street +
        ",\n city: " + city;
  }
}
