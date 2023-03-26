package nz.ac.auckland.se281;

public class Person {

  private String name;
  private String age;
  private int loadStatus;

  // Person class contains age and name of a new client.
  public Person(String age, String name) {
    this.age = age;
    this.name = name;
    // Initialise field loadstatus to 0 to indicate that client is not loaded.
    this.loadStatus = 0;
  }

  public void setLoadStatus(int loadStatus) {
    this.loadStatus = loadStatus;
  }

  public int getLoadStatus() {
    return this.loadStatus;
  }

  // This Method getAge to output client's age(string)
  public String getAge() {
    return this.age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
