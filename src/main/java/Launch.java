public class Launch {

  public static void main(final String[] args) {
    //Create Customer objects
    final Customer c1 = new Customer("Vinesh", "Mistry", new Address("BL3 6TS", "31", "Street", "Bolton"));
    final Customer c2 = new Customer("Dan", "Graef", new Address("M2 2BT", "1", "Road", "Manchester"));
    final Customer c3 = new Customer("Jon", "Kneller", new Address("M3 3IS", "90", "Queen", "Manchester"));
    //Create Car objects
    final Car vroom1 = new Car("CFM 139W", "BMW", "M3", "1");
    final Car vroom2 = new Car("CSZ 2614", "Hyundai", "i10", "1.2");
    final Car vroom3 = new Car("EHA 642", "Kia", "Sportage", "1.4");
    //Create customer profile objects
    final CustomerProfile cp1 = new CustomerProfile(c1, vroom1);
    final CustomerProfile cp2 = new CustomerProfile(c2, vroom2);
    final CustomerProfile cp3 = new CustomerProfile(c3, vroom3);

    /*try {
      cp1.writeSingleProfileToTextFile("CP1");
    } catch (final IOException ioE) {
      ioE.printStackTrace();
    }*/
    //Do JSON actions
    final JsonCreator j = new JsonCreator();

    j.addToCustomerProfileArray(cp1);
    j.addToCustomerProfileArray(cp2);
    j.addToCustomerProfileArray(cp3);

    j.printCustomerProfileArray();
    j.createJsonFilesFromArray();
  }
}
