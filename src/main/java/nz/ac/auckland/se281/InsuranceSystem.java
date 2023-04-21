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

      for (Profile profile : database) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            String.valueOf(database.indexOf(profile) + 1), profile.getUserName(), profile.getAge());
      }
    }

    // If the database has more than 1 profile
    else if (database.size() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(database.size()), "s", ":");

      // Prints out the number of profiles
      for (Profile profile : database) {
        if(profile.getLoaded()){
          MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage("*** ",
              String.valueOf( database.indexOf(profile) + 1), profile.getUserName(), profile.getAge());
             profile.setAsUnloaded();
        }
        else{
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            String.valueOf(database.indexOf(profile) + 1), profile.getUserName(), profile.getAge());
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

    // Checks if a profile is already loaded
    if(Profile.getClassLoaded() == true) {
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(userName);
      return;
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

  public void loadProfile(String userName) {
  
    Profile.setClassUnloaded();
    userName = userName.toLowerCase();
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);

    // Checks if the username is already in database
    for(Profile profile : database) {
      profile.setAsUnloaded();
      if (profile.getUserName().equals(userName) && Profile.getClassLoaded() == false) {
        MessageCli.PROFILE_LOADED.printMessage(userName);
        profile.setAsLoaded();
        Profile.setClassLoaded();
        return;
      } 
    }
        MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
  }

  public void unloadProfile() {
    if(Profile.getClassLoaded() == false){
      MessageCli.NO_PROFILE_LOADED.printMessage();
      return;
    }

    for(Profile profile : database) {
      if(profile.getLoaded()){
        MessageCli.PROFILE_UNLOADED.printMessage(profile.getUserName());
        profile.setAsUnloaded();
        Profile.setClassUnloaded();
        return;
      }
    }
    
  }

  public void deleteProfile(String userName) {
    userName = userName.toLowerCase();
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);

    for(Profile profile : database) {
      if(profile.getUserName().equals(userName)){
        if(profile.getLoaded()){
          MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(userName);
          return;
        }

        database.remove(profile);
        MessageCli.PROFILE_DELETED.printMessage(userName);
        return;
      }
    }

    MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
