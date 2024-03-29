package FileIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileCreator implements FileCreator {

  private MyFilePaths filePaths;
  private ObjectMapper objectMapper;

  public JsonFileCreator(final MyFilePaths filePaths, final ObjectMapper objectMapper) {
    this.filePaths = filePaths;
    this.objectMapper = objectMapper;
  }

  public MyFilePaths getFilePaths() {
    return filePaths;
  }

  @Override
  public void outputFileFromObject(final String name, final Object object) {
    getFilePaths().setFileName(name);
    objectMapper.setVisibility(PropertyAccessor.GETTER, Visibility.PUBLIC_ONLY);
    objectMapper.setVisibility(PropertyAccessor.SETTER, Visibility.NONE);
    try {
      objectMapper.writeValue(new File(getFilePaths().getJsonOutputFilePath()), object);
    } catch (final IOException ioE) {

    }
  }

  @Override
  public void outputFilesFromArray(final ArrayList<Object> arrayList) {
    int counter = 1;
    for (final Object object : arrayList) {

      outputFileFromObject("JsonFile" + Integer.toString(counter), object);
      counter++;
    }
  }


}
