package nz.ac.auckland.se281;

public class Person {

  private String name;
  private String age;

  // Person class contains age and name of a new client.
  public Person(String age, String name) {
    this.age = age;
    this.name = name;
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
