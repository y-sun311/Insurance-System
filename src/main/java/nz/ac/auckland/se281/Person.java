package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Person {

  private String name;
  private String age;
  private int loadStatus;
  ArrayList<Policy> policies = new ArrayList<Policy>();

  // Add a policy to the client's policy list.
  public void addPolicy(Policy policy) {
    policies.add(policy);
  }

  // Check how many policies the client has.
  public int getPolicyCount() {
    return policies.size();
  }

  public int getTotalPremium() {
    int totalPremium = 0;
    // Check if client has no policies.
    if (policies.size() == 0) {
      return 0;
    }
    for (int i = 0; i < policies.size(); i++) {
      totalPremium += premiumDiscounted(i);
    }

    return totalPremium;
  }

  // This method getDiscount to output the discount of a policy (if not eligible for discount,
  // return basePremium).
  public int premiumDiscounted(int numInArrlist) {
    if (policies.size() == 2) {
      return policies.get(numInArrlist).getDiscountedPremium2();
    } else if (policies.size() >= 3) {
      return policies.get(numInArrlist).getDiscountedPremium3();
    } else {
      return policies.get(numInArrlist).basePremium;
    }
  }

  // Check number of Life policies the client has.
  public int getLifePolicyCount() {
    int lifePolicyCount = 0;
    for (int i = 0; i < policies.size(); i++) {
      if (policies.get(i) instanceof LifePolicy) {
        lifePolicyCount++;
      }
    }
    return lifePolicyCount;
  }

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
