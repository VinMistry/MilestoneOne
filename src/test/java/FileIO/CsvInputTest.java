package FileIO;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Pojo.Address;
import Pojo.Car;
import Pojo.Customer;
import Pojo.CustomerProfile;

class CsvInputTest {

  @Test
  void csvInputUsingJackson() {
    final MyFilePaths myFilePaths = new MyFilePaths();
    myFilePaths.setFileName("test_data");
    final Customer c1 = new Customer("Vinesh  ", "Mistry");
    final Car vroom1 = new Car("CFM 139W", "BMW", "M3", "1");
    final CustomerProfile cp1 = new CustomerProfile(c1, new Address("BL3 6TS", "31", "Street", "Bolton"), vroom1);
    final ArrayList<Object> arrayList = new ArrayList<>();
    arrayList.add(cp1);

    final CsvInput csvInput = new CsvInput();
    ArrayList<Object> returnArray = new ArrayList<>();

    try {
      returnArray = csvInput.csvInputUsingJackson(myFilePaths.getCsvInputFilePath());
    } catch (final Exception e) {
      e.printStackTrace();
    }
    Assertions.assertEquals(arrayList.get(0).toString(), returnArray.get(0).toString());
    Assertions.
  }
}