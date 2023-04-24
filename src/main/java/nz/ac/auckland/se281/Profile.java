package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {
  private String userName;
  private String age;
  private boolean Loaded = false;
  public int policyCount = 0;
  public ArrayList<Policy> profPolicies = new ArrayList<Policy>();
  private int premiumSum = 0;
  boolean hasLifePolicy = false;

  public Profile(String userName, String age) {
    this.userName = userName;
    this.age = age;
  }

  public String getUserName() {
    return userName;
  }

  public String getAge() {
    return age;
  }
  // Creare a boolean that sets the profile as loaded

  public void setAsLoaded() {
    Loaded = true;
  }

  public void setAsUnloaded() {
    Loaded = false;
  }

  public boolean getLoaded() {
    return Loaded;
  }

  public int getPolicyCount() {
    return policyCount;
  }

  public void increasePolicyCount() {
    policyCount++;
  }

  public void decreasePolicyCount() {
    policyCount--;
  }

  public void addPolicy(Policy policy) {
    this.profPolicies.add(policy);
  }

  public void setAsPremiumOne() {
    premiumSum = 0;
    for (Policy policy : profPolicies) {
      premiumSum += policy.basePremium();
    }
  }

  public void setAsPremiumTwo() {
    premiumSum = 0;
    for (Policy policy : profPolicies) {
      premiumSum += 0.9 * policy.basePremium();
    }
  }

  public void setAsPremiumThree() {
    premiumSum = 0;
    for (Policy policy : profPolicies) {
      premiumSum += policy.basePremium();
    }
    premiumSum *= 0.8;
  }

  public int getPremiumSum() {
    return premiumSum;
  }

  public ArrayList<Policy> getPolicy() {
    return profPolicies;
  }

  public boolean getHasLifePolicy() {
    return hasLifePolicy;
  }

  public void giveLifePolicy() {
    hasLifePolicy = true;
  }
}
