package FileIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import Pojo.Address;
import Pojo.Car;
import Pojo.Customer;
import Pojo.CustomerProfile;

public class CsvInput {

  public ArrayList<Object> csvToCustomerProfiles(final String fileName) throws IOException {
    final ArrayList<Object> arrayList = new ArrayList<>();
    CustomerProfile customerProfile;
    final File csvFile = new File(fileName);
    final CsvMapper mapper = new CsvMapper();
    final CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
    final MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class)
        .with(schema)
        .readValues(csvFile);
    while (it.hasNext()) {
      final Map<String, String> rowAsMap = it.next();
      // access by column name, as defined in the header row...
      customerProfile = new CustomerProfile(new Customer(rowAsMap.get("firstName"), rowAsMap.get("lastName")),
          new Address(rowAsMap.get("postcode"), rowAsMap.get("houseNumber"), rowAsMap.get("street"), rowAsMap.get("city")),
          new Car(rowAsMap.get("registration"), rowAsMap.get("make"), rowAsMap.get("model"), rowAsMap.get("engineSize")));
      arrayList.add(customerProfile);
    }
    return arrayList;
  }
}
