package nz.ac.auckland.se281;

public class Life extends Policy {

  boolean hasLifePolicy = false;

  public Life(int sumToInsure, int age) {
    super(sumToInsure);
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public int getSum() {
    return sumToInsure;
  }

  public boolean getHasLifePolicy() {
    return hasLifePolicy;
  }

  public void giveLifePolicy() {
    hasLifePolicy = true;
  }

  @Override
  public double basePremium() {
    if (age > 100) {
      MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage();
      return 0.0;
    }

    if (hasLifePolicy) {
      MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage();
      return 0.0;
    }
    int sum = getSum();
    sum = sum * (1 + age / 100) / 100;
    return sum;
  }
}
