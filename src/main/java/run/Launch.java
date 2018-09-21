package run;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import FileIO.CsvInput;
import FileIO.JsonFileCreator;
import FileIO.MyFilePaths;
import FileIO.TextFileCreator;
import Pojo.Address;
import Pojo.Car;
import Pojo.Customer;
import Pojo.CustomerProfile;

public class Launch {

  public ArrayList<Object> createCustomerProfileArray() {
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

    final ArrayList<Object> j = new ArrayList<>();
    j.add(cp1);
    j.add(cp2);
    j.add(cp3);

    return j;
  }

  public MyFilePaths getMyFilePath() {
    final MyFilePaths myFilePaths = new MyFilePaths();
    return myFilePaths;
  }

  public void createTextFilesFromArray(final ArrayList<Object> objectArrayList) {
    final MyFilePaths myfile = getMyFilePath();
    final TextFileCreator textFileCreator = new TextFileCreator(myfile);
    textFileCreator.outputFilesFromArray(objectArrayList);
  }

  public void creatJsonsFromArray(final ArrayList<Object> objectArrayList) {
    final JsonFileCreator jsonFileCreator = new JsonFileCreator(getMyFilePath(), new ObjectMapper());
    jsonFileCreator.outputFilesFromArray(objectArrayList);
  }

  public void createJsonFromCsv(final String filename) {
    final MyFilePaths myfile = getMyFilePath();
    myfile.setFileName(filename);
    final JsonFileCreator jsonFileCreator = new JsonFileCreator(myfile, new ObjectMapper());
    ArrayList<Object> customerProfileArrayList = new ArrayList<>();
    final CsvInput csvInput = new CsvInput();
    try {
      customerProfileArrayList = csvInput.csvToCustomerProfiles(myfile.getCsvInputFilePath());

    } catch (final IOException ioE) {
      ioE.printStackTrace();
    }
    jsonFileCreator.outputFilesFromArray(customerProfileArrayList);
  }


  public static void main(final String[] args) {
    final Launch launch = new Launch();
    // launch.createTextFilesFromArray(launch.createCustomerProfileArray());
    launch.creatJsonsFromArray(launch.createCustomerProfileArray());
    // launch.createJsonFromCsv("mock_data");
  }
}
