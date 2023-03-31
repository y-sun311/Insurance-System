package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  private String address;
  private boolean rentOut;

  public HomePolicy(String[] stringInput, int age) {
    this.sumInsured = Integer.valueOf(stringInput[0]);
    this.address = stringInput[1];
    if (stringInput[2].equals("yes")) {
      this.rentOut = true;
    } else {
      this.rentOut = false;
    }
    this.age = age;
    this.discount = 0;
  }

  public String getAddress() {
    return this.address;
  }

  @Override
  public void setBasePremium() {
    if (rentOut) {
      this.basePremium = (int) Math.round(0.02 * (double) sumInsured);

    } else {
      this.basePremium = (int) Math.round(0.01 * (double) sumInsured);
    }
  }
}
