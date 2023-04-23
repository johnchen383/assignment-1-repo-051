package nz.ac.auckland.se281;

public class Home extends Policy {
  private String address;
  private boolean rental;

  public Home(int sumToInsure, String address, boolean rental) {
    super(sumToInsure);
    this.address = address;
    this.rental = rental;
  }

  public String getAddress() {
    return address;
  }

  public boolean getRental() {
    return rental;
  }

  public int getSum() {
    return sumToInsure;
  }

  @Override
  public int basePremium() {
    int sum = getSum();
    if (getRental() == true) {
      sum = (int) (0.02 * getSum());
    } else {
      sum = (int) (0.01 * getSum());
    }
    return sum;
  }
}
