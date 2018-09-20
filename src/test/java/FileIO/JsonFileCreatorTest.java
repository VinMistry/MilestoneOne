package FileIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Pojo.Address;
import Pojo.Car;
import Pojo.Customer;
import Pojo.CustomerProfile;

class JsonFileCreatorTest {

  private ArrayList<Object> objectArrayList;
  private JsonFileCreator jsonFileCreator;
  private MyFilePaths myFilePaths = new MyFilePaths();
  private File file;

  @BeforeEach
  public void setUp() {
    //Create Pojo.Customer objects
    final Customer c1 = new Customer("Vinesh", "Mistry");
    final Customer c2 = new Customer("Dan", "Graef");
    final Customer c3 = new Customer("Jon", "Kneller");
    //Create Pojo.Car objects
    final Car vroom1 = new Car("CFM 139W", "BMW", "M3", "1");
    final Car vroom2 = new Car("CSZ 2614", "Hyundai", "i10", "1.2");
    final Car vroom3 = new Car("EHA 642", "Kia", "Sportage", "1.4");
    //Create customer profile objects
    final CustomerProfile cp1 = new CustomerProfile(c1, new Address("BL3 6TS", "31", "Street", "Bolton"), vroom1);
    final CustomerProfile cp2 = new CustomerProfile(c2, new Address("M2 2BT", "1", "Road", "Manchester"), vroom2);
    final CustomerProfile cp3 = new CustomerProfile(c3, new Address("M3 3IS", "90", "Queen", "Manchester"), vroom3);
    jsonFileCreator = new JsonFileCreator();
    objectArrayList = new ArrayList<>();
    objectArrayList.add(cp1);
    objectArrayList.add(cp2);
    objectArrayList.add(cp3);
  }

  @AfterEach
  public void tearDown() {
    final File dir = new File(myFilePaths.getOutputDirectoryPath() + "/json");
    try {
      FileUtils.cleanDirectory(dir);
    } catch (final IOException e) {
      e.printStackTrace();
    }
    objectArrayList = null;
    jsonFileCreator = null;
    myFilePaths = null;
  }

  @Test
  void canReadOutputFileFromObject() {
    jsonFileCreator.outputFileFromObject("testFile", objectArrayList.get(0));
    myFilePaths.setFileName("testFile");
    file = new File(myFilePaths.getJsonOutputFilePath());
    Assertions.assertTrue(file.canRead());
  }

  @Test
  void outputFilesFromArray() {
    jsonFileCreator.outputFilesFromArray(objectArrayList);
    myFilePaths.setFileName("JsonFile2");
    final File file = new File(myFilePaths.getJsonOutputFilePath());
    Assertions.assertTrue(file.canRead());
  }

}