package Pojo;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Customer {

  private String firstName, lastName;

  public Customer() {
    firstName = "";
    lastName = "";
  }

  public Customer(final String firstName, final String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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

  @Override
  public String toString() {
    return "Pojo.Customer: \n" +
        " firstName: " + firstName +
        ",\n lastName: " + lastName;
  }
}
