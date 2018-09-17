package FileOutputs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TextFileCreator implements FileCreator {

  private Path path = Paths.get("");

  private String directoryPathString;

  public TextFileCreator(final String directoryPathString) {
    this.directoryPathString = directoryPathString;
  }

  public Path getPath() {
    return path;
  }

  public void setPath(final String name) {
    final Path filePath = Paths.get(getDirectoryPathString() + "/" + name + ".txt");
    this.path = filePath;
  }

  public String getDirectoryPathString() {
    return directoryPathString;
  }

  public void setDirectoryPathString(final String directoryPathString) {
    this.directoryPathString = directoryPathString;
  }

  @Override
  public void outputFileFromObject(final Object object) {
    final byte[] stringBytes = object.toString().getBytes();
    try {
      Files.write(getPath(), stringBytes);
    } catch (final IOException ioE) {
      ioE.printStackTrace();
    }
  }

  @Override
  public void outputFilesFromArray(final ArrayList<Object> arrayList) {
    int counter = 1;
    for (final Object object : arrayList) {
      setPath("TextFile" + Integer.toString(counter));
      outputFileFromObject(object);
      counter++;
    }
  }

}
