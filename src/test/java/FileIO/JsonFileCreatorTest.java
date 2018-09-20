package FileIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import run.Launch;

class JsonFileCreatorTest {

  private ArrayList<Object> objectArrayList;
  private JsonFileCreator jsonFileCreator;
  private MyFilePaths myFilePaths = new MyFilePaths();
  private File file;

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