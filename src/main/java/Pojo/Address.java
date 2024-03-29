package Pojo;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Address {

  private String postcode, houseNumber, street, city;

  public Address() {
    postcode = "";
    houseNumber = "";
    street = "";
    city = "";
  }

  public Address(final String postcode, final String houseNumber, final String street, final String city) {
    this.postcode = postcode;
    this.houseNumber = houseNumber;
    this.street = street;
    this.city = city;
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
    return "Address: \n" +
        "postcode: " + postcode +
        ", \nhouseNumber: " + houseNumber +
        ", \nstreet: " + street +
        ", \ncity: " + city;
  }
}
