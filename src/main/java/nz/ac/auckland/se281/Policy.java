package nz.ac.auckland.se281;

public class Policy {
  protected int sumToInsure;
  protected int age;

  public Policy(int sumToInsure) {
    this.sumToInsure = sumToInsure;
  }

  public int basePremium() {
    return 0;
  }
}
