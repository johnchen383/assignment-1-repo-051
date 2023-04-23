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

      // Prints out the number of profiles
      // for (Profile profile : database) {
      //   MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
      //       String.valueOf(database.indexOf(profile) + 1), profile.getUserName(),
      // profile.getAge());
      for (Profile profile : database) {

        // If the profile is loaded print out the profile with the loaded message
        if (profile.getLoaded() == true) {
          if (profile.getPolicyCount() == 0) {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "*** ",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "ies");
          } else if (profile.getPolicyCount() == 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "*** ",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "y");
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "*** ",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "ies");
          }
          // MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
          //     "*** ",
          //     String.valueOf(database.indexOf(profile) + 1),
          //     profile.getUserName(),
          //     profile.getAge());
        } else {

          if (profile.getPolicyCount() == 0) {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "ies");
          } else if (profile.getPolicyCount() == 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "y");
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "ies");
          }
        }
      }
    }
    // If the database has more than 1 profile
    else if (database.size() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(database.size()), "s", ":");

      // Prints out the number of profiles
      for (Profile profile : database) {

        // If the profile is loaded print out the profile with the loaded message
        if (profile.getLoaded() == true) {
          if (profile.getPolicyCount() == 0) {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "*** ",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "ies");
          } else if (profile.getPolicyCount() == 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "*** ",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "y");
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "*** ",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "ies");
          }
          // MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
          //     "*** ",
          //     String.valueOf(database.indexOf(profile) + 1),
          //     profile.getUserName(),
          //     profile.getAge());
        } else {

          if (profile.getPolicyCount() == 0) {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "ies");
          } else if (profile.getPolicyCount() == 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "y");
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "",
                String.valueOf(database.indexOf(profile) + 1),
                profile.getUserName(),
                profile.getAge(),
                String.valueOf(profile.getPolicyCount()),
                "ies");
          }

          // If the profile is not loaded print out the profile without the loaded message
          // MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          //     String.valueOf(database.indexOf(profile) + 1),
          //     profile.getUserName(),
          //     profile.getAge());
        }
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
    userName = userName.toLowerCase();
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);

    // loop through all profiles
    for (Profile profile : database) {
      // if the profile is loaded
      if (profile.getLoaded()) {
        // print message
        MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(userName);
        // return
        return;
      }
    }

    // Any test cases that are under 3 would deliver an invalid message
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    }

    // Returns invalid message if the age is a non positive number
    else if (Integer.valueOf(age) <= 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);

      // Checks if the username is already in the arraylist
    } else if (invalidUsername.contains(userName)) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    }

    // Makes the username into a proper noun with a capital first word and the rest lower case and
    // adds the username to the database
    else {
      Profile profile = new Profile(userName, age);
      database.add(profile);
      invalidUsername.add(userName);
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
    }
  }

  // The method loadProfile can be used to load a profile given the profile exists, taking in the
  // parameter
  // userName.
  public void loadProfile(String userName) {

    // Makes the username into a proper noun with a capital first word and the rest lower case
    userName = userName.toLowerCase();
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);

    // Set all profiles to unloaded
    for (Profile profile : database) {
      profile.setAsUnloaded();
    }

    // Checks if the username is already in database and sets the username and classProfile to
    // loaded
    for (Profile profile : database) {
      if (profile.getUserName().equals(userName)) {
        MessageCli.PROFILE_LOADED.printMessage(userName);
        profile.setAsLoaded();
        return;
      }
    }

    // If the username is not in the database print out the message
    MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
  }

  // The method unloadProfile can be used to unload a profile given the profile is loaded
  public void unloadProfile() {

    // Checks if the profile is loaded and sets the profile to unloaded
    for (Profile profile : database) {
      if (profile.getLoaded()) {
        MessageCli.PROFILE_UNLOADED.printMessage(profile.getUserName());
        profile.setAsUnloaded();
        // Profile.setClassUnloaded();
        return;
      }

      // If the profile is not loaded print out the message
      MessageCli.NO_PROFILE_LOADED.printMessage();
    }
  }

  // The method deleteProfile can be used to delete a profile given the profile is not loaded
  public void deleteProfile(String userName) {

    // Makes the username into a proper noun with a capital first word and the rest lower case
    userName = userName.toLowerCase();
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);

    // Checks if the profile is loaded and sets the profile to unloaded
    for (Profile profile : database) {
      if (profile.getUserName().equals(userName)) {
        if (profile.getLoaded() == true) {
          MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(userName);
          return;
        }
        database.remove(profile);
        invalidUsername.remove(userName);
        MessageCli.PROFILE_DELETED.printMessage(userName);
        return;
      }
    }

    // If the profile is not loaded print out the message
    MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
  }

  public void createPolicy(PolicyType type, String[] options) {
    for (Profile profile : database) {
      if (!profile.getLoaded()) {
        MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
      }

      if (profile.getLoaded()) {
        profile.increasePolicyCount();
        if (type == PolicyType.HOME) {
          if (options[2].startsWith("y") || options[2].startsWith("Y")) {
            options[2] = "1";
          } else {
            options[2] = "0";
          }
          MessageCli.NEW_POLICY_CREATED.printMessage("home", profile.getUserName());
          // Create a new home policy
          MessageCli.PRINT_DB_HOME_POLICY.printMessage(options[1], options[0], "20000", "20000");
          for (String string : options) {
            System.out.println(string);
            // Add the options to the policy
          }
        }
      }
    }
  }
}
