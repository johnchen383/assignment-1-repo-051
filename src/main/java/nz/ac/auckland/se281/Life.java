package nz.ac.auckland.se281;

public class Life extends Policy {

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

  @Override
  public int basePremium() {
    double sum = getSum();
    sum /= 100;
    sum *= (1 + (double) getAge() / 100);
    return (int) sum;
  }
}
