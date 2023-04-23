package nz.ac.auckland.se281;

public class Home extends Policy {
  private String address;
  private boolean rental;
public double actualSum;

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
  public double basePremium() {
    double actualSum = getSum();
    if (getRental() == true) {
      actualSum = 0.02 * getSum();
    } else {
      actualSum = 0.01 * getSum();
    }
    return actualSum;
  }
}
