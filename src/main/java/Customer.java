public class Customer {

  private String firstName, lastName;
  private String postcode, address, houseNumber, street, town, city;

  public Customer(final String firstName, final String lastName, final String postcode, final String address, final String houseNumber, final String street,
      final String town, final String city) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.postcode = postcode;
    this.address = address;
    this.houseNumber = houseNumber;
    this.street = street;
    this.town = town;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(final String address) {
    this.address = address;
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

  public String getTown() {
    return town;
  }

  public void setTown(final String town) {
    this.town = town;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }
}
