public class Customer {
  private int custID;
  private String name;
  private String skiiLevel;
  static int nextID = 1;

  public Customer() {
  }

  public Customer(String name) {
      custID = nextID++;
      this.name = name;
  }

  public Customer(String name, String skiiLevel) {
      custID = nextID++;
      this.name = name;
      this.skiiLevel = skiiLevel;
  }

  public int getCustID() {
      return custID;
  }

  public int setCustID() {
      return custID;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getSkiiLevel() {
      return skiiLevel;
  }

  public void setSkiiLevel(String skiiLevel) {
      this.skiiLevel = skiiLevel;
  }

  public String toString() {
      return "Customer ID: " + custID + ", Name: " + name + ", Ski Level: " + skiiLevel;
  }
}