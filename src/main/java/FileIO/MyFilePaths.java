package FileIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFilePaths {

  private String fileName;

  public MyFilePaths() {
    fileName = "";
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(final String fileName) {
    this.fileName = fileName;
  }

  public String getCurrentDirectoryPath() {
    final Path path = Paths.get("");
    return path.toAbsolutePath().toString();
  }

  public String getOutputDirectoryPath() {
    final Path path = Paths.get(getCurrentDirectoryPath() + "/outputFiles");
    return path.toString();
  }

  public String getJsonOutputFilePath() {
    final Path filePath = Paths.get(getCurrentDirectoryPath() + "/outputFiles/json/" + getFileName() + ".json");
    return filePath.toString();
  }

  public String getTextOutputFilePath() {
    final Path filePath = Paths.get(getCurrentDirectoryPath() + "/outputFiles/text/" + getFileName() + ".txt");
    return filePath.toString();
  }

  public String getCsvInputFilePath() {
    final Path filePath = Paths.get(getCurrentDirectoryPath() + "/inputFiles/csvData/" + getFileName() + ".csv");
    return filePath.toString();
  }

}
