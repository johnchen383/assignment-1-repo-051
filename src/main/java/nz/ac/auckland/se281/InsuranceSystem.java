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
    } else if (database.size() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(database.size()), "s", ":");
    }

    for (Profile profile : database) {

      // If the profile is loaded print out the profile with the loaded message
      if (profile.getLoaded() == true) {
        if (profile.getPolicyCount() == 0) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              String.valueOf(database.indexOf(profile) + 1),
              profile.getUserName(),
              profile.getAge(),
              String.valueOf(profile.getPolicyCount()),
              "ies",
              String.valueOf(profile.getPremiumSum()));

        } else if (profile.getPolicyCount() == 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              String.valueOf(database.indexOf(profile) + 1),
              profile.getUserName(),
              profile.getAge(),
              String.valueOf(profile.getPolicyCount()),
              "y",
              String.valueOf(profile.getPremiumSum()));
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              String.valueOf(database.indexOf(profile) + 1),
              profile.getUserName(),
              profile.getAge(),
              String.valueOf(profile.getPolicyCount()),
              "ies",
              String.valueOf(profile.getPremiumSum()));
        }

      } else {

        if (profile.getPolicyCount() == 0) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "",
              String.valueOf(database.indexOf(profile) + 1),
              profile.getUserName(),
              profile.getAge(),
              String.valueOf(profile.getPolicyCount()),
              "ies",
              String.valueOf(profile.getPremiumSum()));

        } else if (profile.getPolicyCount() == 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "",
              String.valueOf(database.indexOf(profile) + 1),
              profile.getUserName(),
              profile.getAge(),
              String.valueOf(profile.getPolicyCount()),
              "y",
              String.valueOf(profile.getPremiumSum()));
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "",
              String.valueOf(database.indexOf(profile) + 1),
              profile.getUserName(),
              profile.getAge(),
              String.valueOf(profile.getPolicyCount()),
              "ies",
              String.valueOf(profile.getPremiumSum()));
        }
      }

      for (Policy policy : profile.getPolicy()) {
        int discount = policy.basePremium();
        if (profile.getPolicyCount() == 2) {
          discount = (int) (0.9 * policy.basePremium());
        } else if (profile.getPolicyCount() >= 3) {
          discount = (int) (0.8 * policy.basePremium());
        }
        if (policy instanceof Home) {
          Home newPol = (Home) policy;
          MessageCli.PRINT_DB_HOME_POLICY.printMessage(
              newPol.getAddress(),
              String.valueOf(newPol.getSum()),
              String.valueOf(newPol.basePremium()),
              String.valueOf(discount));
        } else if (policy instanceof Life) {
          Life newPol = (Life) policy;
          MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
              String.valueOf(newPol.getSum()),
              String.valueOf(newPol.basePremium()),
              String.valueOf(discount));
        } else if (policy instanceof Car) {
          Car newPol = (Car) policy;
          MessageCli.PRINT_DB_CAR_POLICY.printMessage(
              newPol.getMakeNmodel(),
              String.valueOf(newPol.getSum()),
              String.valueOf(newPol.basePremium()),
              String.valueOf(discount));
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
        if (type == PolicyType.HOME) {
          if (options[2].startsWith("y") || options[2].startsWith("Y")) {
            options[2] = "True";
          } else {
            options[2] = "False";
          }
          MessageCli.NEW_POLICY_CREATED.printMessage("home", profile.getUserName());
          Home policy =
              new Home(Integer.parseInt(options[0]), options[1], Boolean.parseBoolean(options[2]));
          profile.increasePolicyCount();
          profile.addPolicy(policy);
          // profile.increasePolicyCount();
          if (profile.getPolicyCount() == 1) {
            profile.setAsPremiumOne();
          } else if (profile.getPolicyCount() == 2) {
            profile.setAsPremiumTwo();
          } else if (profile.getPolicyCount() >= 3) {
            profile.setAsPremiumThree();
          }

        } else if (type == PolicyType.CAR) {

          if (options[3].startsWith("y") || options[3].startsWith("Y")) {
            options[3] = "True";
          } else {
            options[3] = "False";
          }
          MessageCli.NEW_POLICY_CREATED.printMessage("car", profile.getUserName());
          Car policy =
              new Car(
                  Integer.parseInt(options[0]),
                  options[1],
                  options[2],
                  Boolean.parseBoolean(options[3]),
                  Integer.parseInt(profile.getAge()));
          profile.addPolicy(policy);
          // profile.increasePolicyCount();
          if (profile.getPolicyCount() == 1) {
            profile.setAsPremiumOne();
          } else if (profile.getPolicyCount() == 2) {
            profile.setAsPremiumTwo();
          } else if (profile.getPolicyCount() >= 3) {
            profile.setAsPremiumThree();
          }

        } else if (type == PolicyType.LIFE) {
          if (Integer.parseInt(profile.getAge()) >= 100) {
            MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(profile.getUserName());
          } else {
            MessageCli.NEW_POLICY_CREATED.printMessage("life", profile.getUserName());
            Life policy =
                new Life(Integer.parseInt(options[0]), Integer.parseInt(profile.getAge()));
            profile.addPolicy(policy);
            // profile.increasePolicyCount();
            if (profile.getPolicyCount() == 1) {
              profile.setAsPremiumOne();
            } else if (profile.getPolicyCount() == 2) {
              profile.setAsPremiumTwo();
            } else if (profile.getPolicyCount() >= 3) {
              profile.setAsPremiumThree();
            }
          }
        }
      }
    }
  }
}
