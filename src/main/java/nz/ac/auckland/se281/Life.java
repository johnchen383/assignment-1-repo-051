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
  public int basePremium() {

    if (hasLifePolicy) {
      MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage();
      return 0;
    }
    double sum = getSum();
    sum /= 100;
    sum *= (1 + (double) getAge() / 100);
    return (int) sum;
  }
}
