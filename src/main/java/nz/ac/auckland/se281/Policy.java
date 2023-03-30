package nz.ac.auckland.se281;

public abstract class Policy {

  protected int sumInsured;
  protected int basePremium;
  protected int age;
  protected int discount;

  public int getDiscountPremium2() {
    this.discount = (int) Math.round(basePremium * 0.9);
    return this.discount;
  }

  public int getDiscountPremium3() {
    this.discount = (int) Math.round(basePremium * 0.8);
    return this.discount;
  }
}
