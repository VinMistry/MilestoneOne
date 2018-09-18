package Pojo;

public class CustomerProfile {

  private Customer customer;
  private Address address;
  private Car car;

  public CustomerProfile() {
    customer = new Customer();
    address = new Address();
    car = new Car();

  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null) {
      return false;
    } else if (obj instanceof CustomerProfile) {
      final CustomerProfile customerProfile = (CustomerProfile) obj;
      if (customerProfile.getCustomer() == null && customer == null || customerProfile.getAddress() == null && address == null
          || customerProfile.getCar() == null && car == null) {
        return true;
      } else if (customerProfile.getCar().equals(customer) || customerProfile.getAddress().equals(address) || customerProfile.getCar().equals(car)) {
        return true;
      }
    }
    return false;
  }

  public CustomerProfile(final Customer customer, final Address address, final Car car) {
    this.customer = customer;
    this.address = address;
    this.car = car;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(final Customer customer) {
    this.customer = customer;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(final Car car) {
    this.car = car;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(final Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Pojo.Customer Profile: \n" + getCustomer().toString() + "\n" + getAddress().toString() + "\n" + getCar().toString();
  }

}
