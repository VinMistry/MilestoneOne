import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCreator {

  private ArrayList<CustomerProfile> cpArray = new ArrayList<CustomerProfile>();

  public ArrayList<CustomerProfile> getCpArray() {
    return cpArray;
  }

  public void setCpArray(final ArrayList<CustomerProfile> cpArray) {
    this.cpArray = cpArray;
  }

  public void addToCustomerProfileArray(final CustomerProfile customerProfile) {
    cpArray.add(customerProfile);
  }

  public void printCustomerProfileArray() {
    for (final CustomerProfile cp : cpArray) {
      System.out.println(cp.toString() + "\n");
    }
  }

  public void createSingleJsonFile(final CustomerProfile customerProfile, final String name) {
    final ObjectMapper objectMapper = new ObjectMapper();
    final Path path = Paths.get("");
    final String dirPath = path.toAbsolutePath().toString();
    final Path currentDirPath = Paths.get(dirPath + "/customerJSONProfile" + name + ".json");
    try {
      objectMapper.writeValue(new File(currentDirPath.toString()), customerProfile);
    } catch (final IOException ioE) {
      ioE.printStackTrace();
    }
  }

  public void createJsonFilesFromArray() {
    int counter = 1;
    for (final CustomerProfile cp : cpArray) {
      createSingleJsonFile(cp, Integer.toString(counter));
      counter++;
    }
  }

  public static void main(final String[] args) {
    final Customer c1 = new Customer("Vinesh", "Mistry", "BL3 6TS", "31", "Street", "Bolton");
    final Customer c2 = new Customer("Dan", "Graef", "M2 2BT", "1", "Road", "Manchester");
    final Customer c3 = new Customer("Jon", "Kneller", "M3 3IS", "90", "Queen", "Manchester");

    final Car vroom1 = new Car("CFM 139W", "BMW", "M3", "1");
    final Car vroom2 = new Car("CSZ 2614", "Hyundai", "i10", "1.2");
    final Car vroom3 = new Car("EHA 642", "Kia", "Sportage", "1.4");

    final CustomerProfile cp1 = new CustomerProfile(c1, vroom1);
    final CustomerProfile cp2 = new CustomerProfile(c2, vroom2);
    final CustomerProfile cp3 = new CustomerProfile(c3, vroom3);

    final JsonCreator j = new JsonCreator();
    j.addToCustomerProfileArray(cp1);
    j.addToCustomerProfileArray(cp2);
    j.addToCustomerProfileArray(cp3);
    j.printCustomerProfileArray();
    j.createJsonFilesFromArray();

    /*
    try {
      cp1.writeToSingleProfileToTextFile("Vinesh");
    } catch (final IOException ioE) {
      ioE.printStackTrace();
    }
    cp1.printCustomerDetails();
    cp2.printCustomerDetails();
    cp3.printCustomerDetails();
    j.createSingleJsonFile(cp1);
    int counter = 1;
    try {
      for (final CustomerProfile cp : j.cpArray) {
        cp.writeToSingleProfileToFile(cp.getCustomer().toString(), cp.getCar().toString(), Integer.toString(counter));
        counter++;
      }
    } catch (final IOException e) {
      e.printStackTrace();
    }*/
  }

}
