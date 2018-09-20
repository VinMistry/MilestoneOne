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

class TextFileCreatorTest {

  private ArrayList<Object> objectArrayList;
  private TextFileCreator textFileCreator;
  private MyFilePaths myFilePaths = new MyFilePaths();
  private File file;

  @BeforeEach
  public void setUp() {
    //Create Pojo.Customer objects
    final Launch launch = new Launch();
    textFileCreator = new TextFileCreator();
    objectArrayList = launch.createCustomerProfileArray();
  }

  @AfterEach
  public void tearDown() {
    final File dir = new File(myFilePaths.getOutputDirectoryPath() + "/text");
    try {
      FileUtils.cleanDirectory(dir);
    } catch (final IOException e) {
      e.printStackTrace();
    }
    objectArrayList = null;
    textFileCreator = null;
    myFilePaths = null;
    file = null;
  }

  @Test
  void outputFileFromObject() {
    textFileCreator.outputFileFromObject("testFile", objectArrayList.get(0));
    myFilePaths.setFileName("testFile");
    file = new File(myFilePaths.getTextOutputFilePath());
    Assertions.assertTrue(file.canRead());
  }

  @Test
  void outputFilesFromArray() {
    textFileCreator.outputFilesFromArray(objectArrayList);
    myFilePaths.setFileName("TextFile3");
    final File file = new File(myFilePaths.getTextOutputFilePath());
    Assertions.assertTrue(file.canRead());
  }
}