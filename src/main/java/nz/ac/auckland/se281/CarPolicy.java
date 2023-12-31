package nz.ac.auckland.se281;

public class CarPolicy extends Policy {

  private String carMakeModel;
  private String carRegNum;
  private boolean coverMechBreakdown;

  public CarPolicy(String[] stringInput, int age) {
    this.sumInsured = Integer.valueOf(stringInput[0]);
    this.carMakeModel = stringInput[1];
    this.carRegNum = stringInput[2];
    if (stringInput[3].equals("yes")) {
      this.coverMechBreakdown = true;
    } else {
      this.coverMechBreakdown = false;
    }
    this.age = age;
    this.discount = 0;
  }

  public String getCarMakeModel() {
    return this.carMakeModel;
  }

  public String getCarRegNum() {
    return this.carRegNum;
  }

  @Override
  // Override abstract method from Policy class to calculate basePremium.
  public void setBasePremium() {
    // 10% of sumInsured for drivers 25 or over.
    if (age >= 25) {
      double doublePremium = 0.10 * sumInsured;
      this.basePremium = (int) Math.round(doublePremium);
    } else { // 15% of sumInsured for drivers under 25.
      double doublePremium = 0.15 * sumInsured;
      this.basePremium = (int) Math.round(doublePremium);
    }
    // Add $80 if mechanical breakdown cover is selected.
    if (coverMechBreakdown) {
      this.basePremium = this.basePremium + 80;
    }
  }
}
