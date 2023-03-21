package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // Create a new arrayList where all the profiles are saved
  ArrayList<Profile> database = new ArrayList<Profile>();
  ArrayList<String> invalidUsername = new ArrayList<String>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {

    if (database.size() == 0) {
      System.out.println("Database has 0 profiles.");
    }
    if (database.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
    }
    if (database.size() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(database.size()), "s", ":");
      for (Profile profile : database) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            String.valueOf(database.indexOf(profile) + 1), profile.getUserName(), profile.getAge());
      }
    }
  }

  public void createNewProfile(String userName, String age) {

    // Any test cases that are under 3
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    } else if (Integer.valueOf(age) <= 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
    } else if (invalidUsername.contains(userName)) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else {
      userName = userName.toLowerCase();
      userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);
      Profile profile = new Profile(userName, age);
      database.add(profile);
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
    }
  }

  // TODO: Complete this method.

  public void loadProfile(String userName) {

    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
