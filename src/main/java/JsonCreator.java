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

}
