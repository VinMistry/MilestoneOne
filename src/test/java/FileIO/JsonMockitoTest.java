package FileIO;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Pojo.Address;
import Pojo.Car;
import Pojo.Customer;
import Pojo.CustomerProfile;


public class JsonMockitoTest {

  private ArrayList<Object> objectArrayList;
  private JsonFileCreator jsonFileCreator;
  private MyFilePaths myFilePaths = new MyFilePaths();
  private File file;
  private String expectedJSON = "{\"customer\":{\"firstName\":\"Vinesh\",\"lastName\":\"Mistry\"},\"address\":{\"postcode\":\"BL3 6TS\",\"houseNumber\":\"31\",\"street\":\"Street\",\"city\":\"Bolton\"},\"car\":{\"registration\":\"CFM 139W\",\"make\":\"BMW\",\"model\":\"M3\",\"engineSize\":\"1\"}}";


  private Customer customer;
  private CustomerProfile customerProfile;
  private Car car;
  private Address address;

  @Test
  void mockito() {

  }
}
