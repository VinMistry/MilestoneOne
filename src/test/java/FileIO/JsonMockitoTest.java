package FileIO;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.CustomerProfile;

@ExtendWith(MockitoExtension.class)
public class JsonMockitoTest {

  private ArrayList<Object> objectArrayList;

  private JsonFileCreator jsonFileCreator;

  private MyFilePaths myFilePaths = new MyFilePaths();
  private File file;
  private String expectedJSON = "{\"customer\":{\"firstName\":\"Vinesh\",\"lastName\":\"Mistry\"},\"address\":{\"postcode\":\"BL3 6TS\",\"houseNumber\":\"31\",\"street\":\"Street\",\"city\":\"Bolton\"},\"car\":{\"registration\":\"CFM 139W\",\"make\":\"BMW\",\"model\":\"M3\",\"engineSize\":\"1\"}}";


  @Mock
  private CustomerProfile customerProfile;

  @Mock
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    jsonFileCreator = new JsonFileCreator(myFilePaths, objectMapper);
  }

  @Test
  void saveJsonMockito() throws IOException {
    jsonFileCreator.outputFileFromObject("test", customerProfile);
    verify(objectMapper).writeValue(any(File.class), eq(customerProfile));
  }
}
