package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private ArrayList<Person> clients = new ArrayList<Person>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {

    // Check size of persons arraylist to print different messages.
    if (clients.isEmpty() == true) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (clients.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", ":", "");
      System.out.println(" 1: " + clients.get(0).getName() + ", " + clients.get(0).getAge());
    } else if (clients.size() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(clients.size()), "s", ":");
      for (int j = 0; j < clients.size(); j++) {
        System.out.println(
            " "
                + String.valueOf(j + 1)
                + ": "
                + clients.get(j).getName()
                + ", "
                + clients.get(j).getAge());
      }
    }
  }

  public void createNewProfile(String userName, String age) {

    // Change userName to Titled case
    String titledName =
        userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();

    // Check if name matches.
    if (clients.isEmpty() == false) {
      for (int i = 0; i < clients.size(); i++) {
        if (clients.get(i).getName().equals(titledName)) {
          MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(titledName);
          return;
        }
      }
    }

    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(titledName);
      // Check if age entered is valid.
    } else if (age.matches(".*[a-zA-Z]+.*")) {
      MessageCli.INVALID_AGE.printMessage(age, titledName);
    } else if ((Double.parseDouble(age) < 0)
        || (Double.parseDouble(age) > 0 && Double.parseDouble(age) % 1 != 0)) {
      MessageCli.INVALID_AGE.printMessage(age, titledName);
      // Add client to database if both name and age valid.
    } else {
      MessageCli.PROFILE_CREATED.printMessage(titledName, age);
      Person client = new Person(age, titledName);
      clients.add(client);
    }
  }

  public void loadProfile(String userName) {}

  public void unloadProfile() {}

  public void deleteProfile(String userName) {}

  public void createPolicy(PolicyType type, String[] options) {}
}
