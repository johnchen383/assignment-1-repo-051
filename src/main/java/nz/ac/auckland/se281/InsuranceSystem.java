package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  ArrayList database = new ArrayList<>();

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
    // MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
    // MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
  }

  public void createNewProfile(String userName, String age) {

    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    } else {
      database.add(userName);
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          String.valueOf(database.size()), userName, age);
    }

    // TODO: Complete this method.
  }

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
