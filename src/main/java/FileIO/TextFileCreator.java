package FileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TextFileCreator implements FileCreator {

  private MyFilePaths filePaths = new MyFilePaths();

  public MyFilePaths getFilePaths() {
    return filePaths;
  }

  @Override
  public void outputFileFromObject(final String name, final Object object) {
    getFilePaths().setFileName(name);
    final byte[] stringBytes = object.toString().getBytes();
    try {
      Files.write(Paths.get(getFilePaths().getTextOutputFilePath()), stringBytes);
    } catch (final IOException ioE) {
      ioE.printStackTrace();
    }
  }

  @Override
  public void outputFilesFromArray(final ArrayList<Object> arrayList) {
    int counter = 1;
    for (final Object object : arrayList) {

      outputFileFromObject("TextFile" + Integer.toString(counter), object);
      counter++;
    }
  }

}
