import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main { //Creating main method for CLI

    private static Formula1ChampionshipManager formula1ChampionshipManager;  // Creating instant for Formula1ChampionshipManager

    public static void main(String[] args) {                                 // Creating main method

        Scanner sc = new Scanner(System.in);                                 // Creating Scanner object to get inputs

        try {
            formula1ChampionshipManager = Formula1ChampionshipManager.getInstance();    // Synchronizing the formula1ChampionshipManager object with it's class
        } catch (Exception e) {
            System.out.println("Error!");
        }

        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("    _________   ________                          _                  __    _          __  ___                                 \n" +
                "   / ____/  /  / ____/ /_  ____ _____ ___  ____  (_)___  ____  _____/ /_  (_)___     /  |/  /___ _____  ____ _____ ____  _____\n" +
                "  / /_   / /  / /   / __ \\/ __ `/ __ `__ \\/ __ \\/ / __ \\/ __ \\/ ___/ __ \\/ / __ \\   / /|_/ / __ `/ __ \\/ __ `/ __ `/ _ \\/ ___/\n" +
                " / __/  / /  / /___/ / / / /_/ / / / / / / /_/ / / /_/ / / / (__  ) / / / / /_/ /  / /  / / /_/ / / / / /_/ / /_/ /  __/ /    \n" +
                "/_/    /_/   \\____/_/ /_/\\__,_/_/ /_/ /_/ .___/_/\\____/_/ /_/____/_/ /_/_/ .___/  /_/  /_/\\__,_/_/ /_/\\__,_/\\__, /\\___/_/     \n" +
                "                                       /_/                              /_/                                /____/             ");
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ Version: 1.o | By: Nandun Diaz +-+");

        formula1ChampionshipManager.load();

        loop1:
        while (true) {                                                                               // While loop to predict menu until user need to quite from the programme

            System.out.println("\n============================================================");    //Printing the menu on the console
            System.out.println("╔═╗┌─┐┌─┐┬─┐┌─┐┌┬┐┌─┐┬─┐  ╔╦╗┌─┐┌┐┌┬ ┬  ╔═╗┌─┐┌┬┐┬┌─┐┌┐┌┌─┐\n" +
                    "║ ║├─┘├┤ ├┬┘├─┤ │ │ │├┬┘  ║║║├┤ ││││ │  ║ ║├─┘ │ ││ ││││└─┐\n" +
                    "╚═╝┴  └─┘┴└─┴ ┴ ┴ └─┘┴└─  ╩ ╩└─┘┘└┘└─┘  ╚═╝┴   ┴ ┴└─┘┘└┘└─┘");
            System.out.println("============================================================");
            System.out.println("|| Press '1' to Add a New Driver                          ||");
            System.out.println("|| Press '2' to Delete a Driver                           ||");
            System.out.println("|| Press '3' to Change a Driver                           ||");
            System.out.println("|| Press '4' to Search For a Driver                       ||");
            System.out.println("|| Press '5' to View Drivers Table                        ||");
            System.out.println("|| Press '6' to View Races Table                          ||");
            System.out.println("|| Press '7' to Add New Race                              ||");
            System.out.println("|| Press '8' to Store Program Data into File              ||");
            System.out.println("|| Press '9' to Load Program Data from File               ||");
            System.out.println("|| Press 'X' to Open Graphical User Interface (GUI)       ||");
            System.out.println("|| Press '0' to Exit The Program                          ||");
            System.out.println("============================================================");
            System.out.println();

            System.out.print("Enter your choice here: ");  //Getting inputs
            String input = sc.next().toUpperCase();

            switch (input) {                                           //Creating switch to switch between cases
                case "1":
                    System.out.print("Enter Driver ID: ");
                    String driverID = sc.next().toUpperCase();

                    System.out.print("Enter Driver Name: ");
                    String driverName = sc.next().toUpperCase();

                    System.out.print("Enter Driver Location: ");
                    String driverLocation= sc.next().toUpperCase();

                    System.out.print("Enter Team Name: ");
                    String teamName= sc.next().toUpperCase();

                    Formula1Driver formula1Driver = new Formula1Driver(driverID,driverName,driverLocation,teamName);
                    formula1ChampionshipManager.addNewDriver(formula1Driver);
                    break;

                case "2":
                    System.out.print("Enter Driver ID to Delete : ");
                    driverID = sc.next().toUpperCase();
                    formula1ChampionshipManager.deleteDriver(driverID);
                    break;

                case "3":
                    System.out.print("Enter Team Name here: : ");
                    teamName = sc.next().toUpperCase();
                    formula1ChampionshipManager.changeDriver(teamName);
                    break;

                case "4":
                    System.out.print("Enter Driver ID to Search : ");
                    driverID = sc.next().toUpperCase();
                    System.out.println();
                    formula1ChampionshipManager.searchDriver(driverID);
                    break;

                case "5":
                    System.out.println();
                    formula1ChampionshipManager.viewDriverTable();
                    break;

                case "6":
                    System.out.println();
                    formula1ChampionshipManager.viewRacesTable();
                    break;

                case "7":
                    formula1ChampionshipManager.addNewRace();
                    break;

                case "8":
                    formula1ChampionshipManager.save();
                    break;

                case "9":
                    formula1ChampionshipManager.load();
                    break;

                case "X":
                    formula1ChampionshipManager.startGUI();
                    break;

                case "0":
                    System.out.println("\nYou are exiting the program..!");
                    System.out.println("Thank You..!");
                    break loop1;

                default:
                    //Default error message
                    System.out.println(Formula1ChampionshipManager.ANSI_RED + "\nPlease, Enter a Valid Input!.\n"+ Formula1ChampionshipManager.ANSI_RESET);
            }
        }
    }
}
