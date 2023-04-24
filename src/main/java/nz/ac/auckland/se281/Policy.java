package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class Policy {
  protected int sumToInsure;
  protected int age;
  protected PolicyType type;
  protected int premium;

  public Policy(int sumToInsure) {
    this.sumToInsure = sumToInsure;
  }

  public int basePremium() {
    return 0;
  }

  public int polPremium() {
    return premium;
  }

  public PolicyType getPolicyType() {
    return type;
  }
}
