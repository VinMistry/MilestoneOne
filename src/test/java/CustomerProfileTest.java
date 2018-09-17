import java.io.IOException;

import org.junit.jupiter.api.Test;

class CustomerProfileTest extends CustomerProfile {

  @Test
  void testPrintCustomerDetails() {
  }

  @Test
  void testWriteSingleProfileToTextFile() {
    try {
      writeSingleProfileToTextFile("1");
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }
}