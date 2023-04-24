package nz.ac.auckland.se281;

public class Car extends Policy {
  private String makeNmodel;
  private String plate;
  private boolean breakdown;

  public Car(int sumToInsure, String makeNmodel, String plate, boolean breakdown, int age) {
    super(sumToInsure);
    this.makeNmodel = makeNmodel;
    this.plate = plate;
    this.breakdown = breakdown;
    this.age = age;
  }

  public String getMakeNmodel() {
    return makeNmodel;
  }

  public String getPlate() {
    return plate;
  }

  public boolean getBreakdown() {
    return breakdown;
  }

  public int getAge() {
    return age;
  }

  public int getSum() {
    return sumToInsure;
  }

  @Override
  // Calculates the premium for a car policy based on the age and sum insured
  // and whether or not the car has breakdown cover
  public int basePremium() {
    int sum = getSum();
    if (getAge() < 25) {
      sum *= .15;
    } else {
      sum *= .1;
    }
    if (getBreakdown() == true) {
      sum += 80;
    }
    return sum;
  }
}
