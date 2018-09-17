package FileOutputs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileCreator implements FileCreator {

  private Path path = Paths.get("");

  private String directoryPathString;

  public JsonFileCreator(final String directoryPathString) {
    this.directoryPathString = directoryPathString;
  }

  public Path getPath() {
    return path;
  }

  public void setPath(final String name) {
    final Path filePath = Paths.get(getDirectoryPathString() + "/" + name + ".json");
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
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.GETTER, Visibility.PUBLIC_ONLY);
    objectMapper.setVisibility(PropertyAccessor.SETTER, Visibility.NONE);
    try {
      objectMapper.writeValue(new File(getPath().toString()), object);
    } catch (final IOException ioE) {
      ioE.printStackTrace();
    }
  }

  @Override
  public void outputFilesFromArray(final ArrayList<Object> arrayList) {
    int counter = 1;
    for (final Object object : arrayList) {
      setPath("JsonFile" + Integer.toString(counter));
      outputFileFromObject(object);
      counter++;
    }
  }


}
