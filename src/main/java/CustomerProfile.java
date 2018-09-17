import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomerProfile {

  private Customer customer;
  private Car car;
  private FilePersistor filePersistor;

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

  private FilePersistor getFilePersistor() {
    return filePersistor;
  }

  public void setFilePersistor(final FilePersistor filePersistor) {
    this.filePersistor = filePersistor;
  }

  public void printCustomerDetails() {
    System.out.println(customer.toString());

    System.out.println(car.toString() + "\n");
  }

  public void writeSingleProfileToTextFile(final String name) throws IOException {
    final String str = customer.toString() + "\n" + car.toString();
    final byte[] strToBytes = str.getBytes();
    final Path path = Paths.get("");
    final String dirPath = path.toAbsolutePath().toString();
    final Path currentDirPath = Paths.get(dirPath + "/" + name + ".txt");
    getFilePersistor().persistData(currentDirPath, strToBytes);
  }

  @Override
  public String toString() {
    return "Customer Profile: \n" + customer.toString() + "\n" + car.toString();
  }

  public static void main(final String[] args) {
  }
}
