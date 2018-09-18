package Pojo;

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
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null) {
      return false;
    } else if (obj instanceof Customer) {
      final Customer customer = (Customer) obj;
      if ((customer.getFirstName() == null && firstName == null) && (customer.getLastName() == null && lastName == null)) {
        return true;
      } else if (customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
        return true;
      }

    }
    return false;
  }

  @Override
  public String toString() {
    return "Pojo.Customer: \n" +
        " firstName: " + firstName +
        ",\n lastName: " + lastName;
  }
}
