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
      // Check if the client is loaded.
      if (clients.get(0).getLoadStatus() == 1) {
        // Check number of policies.
        if (clients.get(0).getPolicyCount() == 0) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ", "1", clients.get(0).getName(), clients.get(0).getAge(), "0", "ies", "0");

        } else if (clients.get(0).getPolicyCount() == 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              "1",
              clients.get(0).getName(),
              clients.get(0).getAge(),
              "1",
              "y",
              String.valueOf(clients.get(0).getTotalPremium()));

          // Print out policy depending on policy type.
          Policy policy = clients.get(0).policies.get(0);
          printPolicy(policy, policy.basePremium);

        } else if (clients.get(0).getPolicyCount() > 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              "1",
              clients.get(0).getName(),
              clients.get(0).getAge(),
              String.valueOf(clients.get(0).getPolicyCount()),
              "ies",
              String.valueOf(clients.get(0).getTotalPremium()));

          // Print out policies depending on policy types.
          for (int i = 0; i < clients.get(0).policies.size(); i++) {
            Policy policy = clients.get(0).policies.get(i);

            printPolicy(policy, clients.get(0).getDiscount(i));
          }
        }
      } else if (clients.get(0).getLoadStatus() == 0) {
        // When the client is not loaded and only one client in the database, print out the policy
        // details.
        if (clients.get(0).getPolicyCount() == 0) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "1", "", clients.get(0).getName(), clients.get(0).getAge(), "0", "ies", "0");

        } else if (clients.get(0).getPolicyCount() == 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "1",
              "",
              clients.get(0).getName(),
              clients.get(0).getAge(),
              "1",
              "y",
              String.valueOf(clients.get(0).getTotalPremium()));

          Policy policy = clients.get(0).policies.get(0);
          printPolicy(policy, policy.basePremium);

        } else if (clients.get(0).getPolicyCount() > 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "1",
              "",
              clients.get(0).getName(),
              clients.get(0).getAge(),
              String.valueOf(clients.get(0).getPolicyCount()),
              "ies",
              String.valueOf(clients.get(0).getTotalPremium()));

          // Print out policies depending on policy types.
          for (int i = 0; i < clients.get(0).policies.size(); i++) {
            Policy policy = clients.get(0).policies.get(i);
            printPolicy(policy, clients.get(0).getDiscount(i));
          }
        }
      }
    } else if (clients.size() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(clients.size()), "s", ":");
      for (int j = 0; j < clients.size(); j++) {
        // Check if a client is loaded.
        if (clients.get(j).getLoadStatus() == 1) {

          // If there is more than one client in the database and a client is found loaded, print
          // out the policy details.
          if (clients.get(j).getPolicyCount() == 0) {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                "*** ",
                String.valueOf(j + 1),
                clients.get(j).getName(),
                clients.get(j).getAge(),
                "0",
                "ies",
                "0");

          } else if (clients.get(j).getPolicyCount() == 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                "*** ",
                String.valueOf(j + 1),
                clients.get(j).getName(),
                clients.get(j).getAge(),
                "1",
                "y",
                String.valueOf(clients.get(j).getTotalPremium()));

            Policy policy = clients.get(j).policies.get(0);
            printPolicy(policy, policy.basePremium);

            // If mulitple policies exist for the client, while loaded.
          } else if (clients.get(j).getPolicyCount() > 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                "*** ",
                String.valueOf(j + 1),
                clients.get(j).getName(),
                clients.get(j).getAge(),
                String.valueOf(clients.get(j).getPolicyCount()),
                "ies",
                String.valueOf(clients.get(j).getTotalPremium()));

            for (int i = 0; i < clients.get(j).policies.size(); i++) {
              Policy policy = clients.get(j).policies.get(i);
              printPolicy(policy, clients.get(j).getDiscount(i));
            }
          }

        } else if (clients.get(j).getLoadStatus() == 0) {

          // Zero policy exist for the client and the client is not loaded.
          if (clients.get(j).getPolicyCount() == 0) {

            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                String.valueOf(j + 1),
                "",
                clients.get(j).getName(),
                clients.get(j).getAge(),
                "0",
                "ies",
                "0");

            // One policy exist for the client.
          } else if (clients.get(j).getPolicyCount() == 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                String.valueOf(j + 1),
                "",
                clients.get(j).getName(),
                clients.get(j).getAge(),
                "1",
                "y",
                String.valueOf(clients.get(j).getTotalPremium()));

            Policy policy = clients.get(j).policies.get(0);
            printPolicy(policy, policy.basePremium);

            // More than one policy exist for the client.
          } else if (clients.get(j).getPolicyCount() > 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                String.valueOf(j + 1),
                "",
                clients.get(j).getName(),
                clients.get(j).getAge(),
                String.valueOf(clients.get(j).getPolicyCount()),
                "ies",
                String.valueOf(clients.get(j).getTotalPremium()));

            for (int i = 0; i < clients.get(j).policies.size(); i++) {
              Policy policy = clients.get(j).policies.get(i);
              printPolicy(policy, clients.get(j).getDiscount(i));
            }
          }
        }
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

  public void loadProfile(String userName) {
    // Change userName to Titled case
    String titledName =
        userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();

    // Check if name matches.
    if (clients.isEmpty() == false) {
      // Check if a client is already loaded.
      for (int i = 0; i < clients.size(); i++) {
        if (clients.get(i).getLoadStatus() == 1) {
          clients.get(i).setLoadStatus(0);
        }
      }

      for (int j = 0; j < clients.size(); j++) {
        if (clients.get(j).getName().equals(titledName)) {
          MessageCli.PROFILE_LOADED.printMessage(titledName);
          clients.get(j).setLoadStatus(1);
          return;
        }
      }
    }

    MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(titledName);
  }

  public void unloadProfile() {
    for (int i = 0; i < clients.size(); i++) {
      if (clients.get(i).getLoadStatus() == 1) {
        MessageCli.PROFILE_UNLOADED.printMessage(clients.get(i).getName());
        clients.get(i).setLoadStatus(0);
        return;
      }
    }
    System.out.println("No profile is currently loaded.");
  }

  public void deleteProfile(String userName) {
    // Change userName to titled case
    String titledName =
        userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();

    for (int i = 0; i < clients.size(); i++) {
      if (clients.get(i).getName().equals(titledName)) {
        // Cannot delete the client if loaded.
        if (clients.get(i).getLoadStatus() == 1) {
          MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(titledName);
          return;
        } else {
          MessageCli.PROFILE_DELETED.printMessage(titledName);
          clients.remove(i);
          return;
        }
      }
    }

    MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(titledName);
  }

  public void createPolicy(PolicyType type, String[] options) {
    // Check for a  current loaded client before creating policy.
    for (int i = 0; i < clients.size(); i++) {
      if (clients.get(i).getLoadStatus() == 1) {
        // Check input for policy type.
        switch (type) {
          case LIFE:
            // Check if the client already has a life policy.
            if (clients.get(i).getLifePolicyCount() != 0) {
              MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(clients.get(i).getName());
              return;

              // Check if the client is over the age limit.
            } else if (Integer.valueOf(clients.get(i).getAge()) > 100) {
              MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(clients.get(i).getName());
              return;
            } else {
              // Create a new life policy.
              LifePolicy newLifePolicy =
                  new LifePolicy(options, Integer.valueOf(clients.get(i).getAge()));
              clients.get(i).addPolicy(newLifePolicy);
              MessageCli.NEW_POLICY_CREATED.printMessage("life", clients.get(i).getName());
              return;
            }
          case CAR:
            // Create a new car policy.
            CarPolicy newCarPolicy =
                new CarPolicy(options, Integer.valueOf(clients.get(i).getAge()));
            clients.get(i).addPolicy(newCarPolicy);
            MessageCli.NEW_POLICY_CREATED.printMessage("car", clients.get(i).getName());
            return;

          case HOME:
            // Create a new home policy.
            HomePolicy newHomePolicy =
                new HomePolicy(options, Integer.valueOf(clients.get(i).getAge()));
            clients.get(i).addPolicy(newHomePolicy);
            MessageCli.NEW_POLICY_CREATED.printMessage("home", clients.get(i).getName());
            return;
        }
      }
    }

    MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
  }
  // Print policy details.
  public static void printPolicy(Policy policy, int discounted) {

    if (policy instanceof CarPolicy) {
      MessageCli.PRINT_DB_CAR_POLICY.printMessage(
          ((CarPolicy) policy).getCarMakeModel(),
          Integer.toString(policy.sumInsured),
          String.valueOf(policy.basePremium),
          String.valueOf(discounted));

    } else if (policy instanceof LifePolicy) {
      MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
          Integer.toString(policy.sumInsured),
          String.valueOf(policy.basePremium),
          String.valueOf(discounted));

    } else if (policy instanceof HomePolicy) {
      MessageCli.PRINT_DB_HOME_POLICY.printMessage(
          ((HomePolicy) policy).getAddress(),
          Integer.toString(policy.sumInsured),
          String.valueOf(policy.basePremium),
          String.valueOf(discounted));
    }
  }
}
