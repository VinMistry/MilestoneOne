public class Car {

  private String carDetails, registration, make, model, engineSize;

  public Car(final String carDetails, final String registration, final String make, final String model, final String engineSize) {
    this.carDetails = carDetails;
    this.registration = registration;
    this.make = make;
    this.model = model;
    this.engineSize = engineSize;
  }

  public String getCarDetails() {
    return carDetails;
  }

  public void setCarDetails(final String carDetails) {
    this.carDetails = carDetails;
  }

  public String getRegistration() {
    return registration;
  }

  public void setRegistration(final String registration) {
    this.registration = registration;
  }

  public String getMake() {
    return make;
  }

  public void setMake(final String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(final String model) {
    this.model = model;
  }

  public String getEngineSize() {
    return engineSize;
  }

  public void setEngineSize(final String engineSize) {
    this.engineSize = engineSize;
  }
}
