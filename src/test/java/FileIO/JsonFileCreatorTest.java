package FileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.Address;
import Pojo.Car;
import Pojo.Customer;
import Pojo.CustomerProfile;
import run.Launch;

@ExtendWith(MockitoExtension.class)
class JsonFileCreatorTest {

  private ArrayList<Object> objectArrayList;
  private JsonFileCreator jsonFileCreator;
  private MyFilePaths myFilePaths = new MyFilePaths();
  private File file;
  private String expectedJSON = "{\"customer\":{\"firstName\":\"Vinesh\",\"lastName\":\"Mistry\"},\"address\":{\"postcode\":\"BL3 6TS\",\"houseNumber\":\"31\",\"street\":\"Street\",\"city\":\"Bolton\"},\"car\":{\"registration\":\"CFM 139W\",\"make\":\"BMW\",\"model\":\"M3\",\"engineSize\":\"1\"}}";


  private Customer customer;
  private CustomerProfile customerProfile;
  private Car car;
  private Address address;


  @BeforeEach
  public void setUp() {
    //Create Pojo.Customer objects
    final Launch launch = new Launch();
    jsonFileCreator = new JsonFileCreator();
    objectArrayList = launch.createCustomerProfileArray();
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
  void mockitoFile() {
    customerProfile = Mockito.mock(CustomerProfile.class);
    customerProfile.setCustomer(customer);
    //kk when(customerProfile.getCustomer()).thenReturn();
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

  @Test
  void checkCorrectOutput() throws IOException {
    final Launch l = new Launch();
    l.creatJsonsFromArray(objectArrayList);
    //read json file data to String
    final byte[] jsonData = Files.readAllBytes(Paths.get(myFilePaths.getOutputDirectoryPath() + "/json/JsonFile1.json"));

    //create ObjectMapper instance
    final ObjectMapper objectMapper = new ObjectMapper();

    //read JSON like DOM Parser
    final JsonNode rootNode = objectMapper.readTree(jsonData);
    final JsonNode custNode = rootNode.path("customer");
    final JsonNode addrNode = rootNode.path("address");
    final JsonNode carNode = rootNode.path("car");
    final String jsonFromFile = "{\"customer\":" + custNode.toString() + ",\"address\":" + addrNode.toString() + ",\"car\":" + carNode.toString() + "}";
    Assertions.assertEquals(expectedJSON, jsonFromFile);
  }
}
