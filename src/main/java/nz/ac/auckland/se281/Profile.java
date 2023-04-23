package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {
  private String userName;
  private String age;
  private boolean Loaded = false;
  private int policyCount = 0;
  public ArrayList<Policy> profPolicies = new ArrayList<Policy>();

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
}
