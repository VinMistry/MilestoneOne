package FileIO;

import java.util.ArrayList;

public interface FileCreator {

  void outputFileFromObject(String name, Object object);

  void outputFilesFromArray(ArrayList<Object> arrayList);

}
