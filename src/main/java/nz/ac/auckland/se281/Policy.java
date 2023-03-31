package nz.ac.auckland.se281;

public abstract class Policy {

  protected int sumInsured;
  protected int basePremium;
  protected int age;
  protected int discount;

  // Method for calculating discounted premium for 2 policies under the same clie
  public int getDiscountedPremium2() {
    this.discount = (int) Math.round(basePremium * 0.9);
    return this.discount;
  }
  // Method for calculating discounted premium for 3 or more policies under the same client.
  public int getDiscountedPremium3() {
    this.discount = (int) Math.round(basePremium * 0.8);
    return this.discount;
  }

  // Abstract method for calculating basePremium, which is different for each type of policy.
  public abstract void setBasePremium();
}
