public class CustomerProfile {

  private Customer customer;
  private Car car;

  public CustomerProfile() {
    customer = new Customer();
    car = new Car();
  }

  public CustomerProfile(final Customer customer, final Car car) {
    this.customer = customer;
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

  @Override
  public String toString() {
    return "Customer Profile: \n" + customer.toString() + "\n" + car.toString();
  }

}
