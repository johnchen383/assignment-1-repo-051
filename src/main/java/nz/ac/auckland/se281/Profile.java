package nz.ac.auckland.se281;

public class Profile {
  private String userName;
  private String age;
  private boolean Loaded = false;
  private static boolean classLoaded = false;

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
  //Creare a boolean that sets the profile as loaded

  public  void setAsLoaded() {
    Loaded = true;
  }

  public void setAsUnloaded() {
    Loaded = false;
  }

  public boolean getLoaded() {
    return Loaded;
  }

  public static void setClassLoaded() {
    classLoaded = true;
  }

  public static void setClassUnloaded() {
    classLoaded = false;
  }

  public static boolean getClassLoaded() {
    return classLoaded;
  }
}
