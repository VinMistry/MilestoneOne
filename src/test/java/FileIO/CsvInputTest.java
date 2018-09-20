package FileIO;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Pojo.Address;
import Pojo.Car;
import Pojo.Customer;
import Pojo.CustomerProfile;

class CsvInputTest {

  private ArrayList<Object> arrayList;
  private CsvInput csvInput;
  ArrayList<Object> returnArray;

  @BeforeEach
  public void setUp() throws Exception {
    csvInput = new CsvInput();
    returnArray = new ArrayList<>();
    final Customer c1 = new Customer("Vinesh", "Mistry");
    final Car vroom1 = new Car("CFM 139W", "BMW", "M3", "1");
    final CustomerProfile customerProfile = new CustomerProfile(c1, new Address("BL3 6TS", "31", "Street", "Bolton"), vroom1);
    arrayList = new ArrayList<>();
    arrayList.add(customerProfile);
  }

  @AfterEach
  public void tearDown() {
    arrayList = null;
    returnArray = null;
  }

  @Test
  void csvInputUsingJackson() {
    final MyFilePaths myFilePaths = new MyFilePaths();
    myFilePaths.setFileName("test_data");
    try {
      returnArray = csvInput.csvToCustomerProfiles(myFilePaths.getCsvInputFilePath());
    } catch (final Exception e) {
      e.printStackTrace();
    }
    Assertions.assertTrue(arrayList.get(0).equals(returnArray.get(0)));
  }
}