package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // Create a new arrayList where all the profiles are saved
  ArrayList<Profile> database = new ArrayList<Profile>();

  // Create a new arrayList where invalid usernames can be checked against
  ArrayList<String> invalidUsername = new ArrayList<String>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }
  /** The printDatabase method is responsible for printing how many profiles the database has */
  public void printDatabase() {

    // If the database is empty
    if (database.size() == 0) {
      System.out.println("Database has 0 profiles.");
    }
    // If the database only has 1 profile
    if (database.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
    }

    // If the database has more than 1 profile
    if (database.size() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(database.size()), "s", ":");

      // Prints out the number of profiles
      for (Profile profile : database) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            String.valueOf(database.indexOf(profile) + 1), profile.getUserName(), profile.getAge());
      }
    }
  }

  /**
   * The method createNewProfile can be used to create new profiles given the profiles meet the
   * required conditions
   *
   * @param userName
   * @param age
   */
  public void createNewProfile(String userName, String age) {

    // Any test cases that are under 3 would deliver an invalid message
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    }
    // Returns invalid message if the age is a non positive number
    else if (Integer.valueOf(age) <= 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
      // Checks if the username has been used before
    } else if (invalidUsername.contains(userName)) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    }
    // Makes the username into a proper noun with a capital first word and the rest lower case and
    // adds the username to the database
    else {
      userName = userName.toLowerCase();
      userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);
      Profile profile = new Profile(userName, age);
      database.add(profile);
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
    }
  }

  public void loadProfile(String userName) {
    
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
