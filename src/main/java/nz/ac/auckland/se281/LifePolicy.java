package nz.ac.auckland.se281;

public class LifePolicy extends Policy {

  // Create constructor for LifePolicy class.
  public LifePolicy(String[] stringInput, int age) {
    this.sumInsured = Integer.valueOf(stringInput[0]);
    this.age = age;
    this.discount = 0;
  }

  @Override
  public void setBasePremium() {
    double doublePremium = (1 + ((double) age / 100)) * 0.01 * (double) sumInsured;
    this.basePremium = (int) Math.round(doublePremium);
  }
}
