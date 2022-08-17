import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager{  //Creating Formula1ChampionshipManger class which implements the ChampionshipManager

    private static Formula1ChampionshipManager formula1ChampionshipManager;   // Creating instant variables
    private String driverName;
    private String driverLocation;
    private Formula1Driver formula1Driver;
    public static final String ANSI_RESET = "\u001B[0m";   //Creating colour code methods
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public static ArrayList<Formula1Driver> listOfDrivers = new ArrayList<>();   //Creating array list to store the list of drivers
    public static  ArrayList<Race> listOfRaces = new ArrayList<>();   // Creating array list to store races

    public static Formula1ChampionshipManager getInstance() {   // Creating getInstant method tto instantiate the array
        if (formula1ChampionshipManager == null) {
            synchronized (Formula1ChampionshipManager.class) {
                if (formula1ChampionshipManager == null) {
                    formula1ChampionshipManager = new Formula1ChampionshipManager();
                }
            }
        }
        return formula1ChampionshipManager;
    }

    // Creating add new driver method to add a new driver

    @Override
    public void addNewDriver(Formula1Driver formula1Driver) {

        boolean check1 = false;
        boolean check2 = false;
        for (Formula1Driver driver : listOfDrivers) {  // Creating for loop to iterate over the list of the drivers
            if (formula1Driver.getDriverID().equals(driver.getDriverID())) {
                check1 = true;
                break;

            } else if (formula1Driver.getTeamName().equals(driver.getTeamName())) {
                check2 = true;
                break;
            }
        }

        if (check1) {
            System.out.println(ANSI_RED + "\nDriver ID exists! Try Again...\n" + ANSI_RESET);
        } else if (check2) {
            System.out.println(ANSI_RED + "\nThis team already have a driver! Try Again...\n" + ANSI_RESET);
        } else {
            listOfDrivers.add(formula1Driver);
            System.out.println(ANSI_CYAN + "\nDriver Added Successfully!\n" + ANSI_RESET);
        }
    }

    //Creating delete driver method driver to delete an exciting driver from the array

    @Override
    public void deleteDriver(String driverID) {
        if (listOfDrivers.isEmpty()) {
            System.out.println(ANSI_RED + "\nList is empty\n" + ANSI_RESET);
        }else {
            boolean b = false;
            for (Formula1Driver driver : listOfDrivers){  // Crating for loop to iterate over the list of drivers
                if (driverID.equals(driver.getDriverID())){
                    b = true;
                    System.out.println(driver);
                    listOfDrivers.remove(driver);
                    System.out.println(ANSI_CYAN + "\nDriver Deleted Successfully!\n" + ANSI_RESET);
                    break;
                }
            }
            if (!b){
                System.out.println(ANSI_RED + "\nDriver Does Not Exists! Try Again...\n" + ANSI_RESET);
            }
        }
    }

    //Creating a method to search drivers

    @Override
    public void searchDriver(String driverID) {
        if (listOfDrivers.isEmpty()) {
            System.out.println(ANSI_RED + "\nList is empty.\n" + ANSI_RESET);
        }else {
            boolean b = false;
            for (Formula1Driver driver : listOfDrivers){
                if (driverID.equals(driver.getDriverID())){
                    b = true;
                    System.out.println(driver);
                    break;
                }
            }
            if (!b){
                System.out.println(ANSI_RED + "\nDriver Does Not Exists! Try Again\n" + ANSI_RESET);
            }
        }
    }

    //Creating method to change the exiting driver

    @Override
    public void changeDriver(String teamName) {

        if (listOfDrivers.isEmpty()) {
            System.out.println(ANSI_RED + "\nList is empty.\n" + ANSI_RESET);
        }else{
            boolean b = false;
            for (Formula1Driver driver : listOfDrivers){
                if (teamName.equals(driver.getTeamName())){
                    b = true;
                    listOfDrivers.remove(driver);
                    System.out.println(ANSI_CYAN + "\nCurrent Driver Removed Successfully!\n" + ANSI_RESET);
                    System.out.println(driver);
                    break;
                }
            }
            if (!b){
                System.out.println(ANSI_RED + "\nTeam Not Exists! Try Again...\n" + ANSI_RESET);
            }else{
                System.out.print("Enter Driver new ID: ");
                String driverID = sc.next().toUpperCase();

                System.out.print("Enter Driver Name: ");
                driverName = sc.next().toUpperCase();

                System.out.print("Enter Driver Location: ");
                driverLocation= sc.next().toUpperCase();

                formula1Driver = new Formula1Driver(driverID,driverName,driverLocation,teamName);
                addNewDriver(formula1Driver);

            }
        }
    }

    // Creating method to view all exciting drivers in the list of drivers array

    @Override
    public void viewDriverTable() {
        if (listOfDrivers.isEmpty()) {
            System.out.println(ANSI_RED + "\nList is empty.\n" + ANSI_RESET);
        }else {
            Collections.sort(listOfDrivers);
            System.out.printf("%-20s", "Driver ID");
            System.out.printf("%-20s", "Driver Name");
            System.out.printf("%-24s", "Driver Location");
            System.out.printf("%-17s", "Team Name");
            System.out.printf("%-20s", "Num Of First Pos.");
            System.out.printf("%-21s", "Num Of Second Pos.");
            System.out.printf("%-21s", "Num Of Third Pos.");
            System.out.printf("%-19s", "Num Of Points");
            System.out.printf("%-20s", "Num Of Races");
            System.out.println("\n");
            for (Formula1Driver driver : listOfDrivers){
                System.out.println(driver);
            }
        }
    }
    static Scanner sc = new Scanner(System.in);

    //Creating method to  view all race in  the list of races array

    @Override
    public void viewRacesTable(){

        if (listOfRaces.isEmpty()) {
            System.out.println(ANSI_RED + "\nList is empty.\n" + ANSI_RESET);
        }else {
            System.out.println("|| ... Races Table ... ||");
            Collections.sort(listOfRaces);
            for (Race race : listOfRaces){
                System.out.println();
                System.out.println(race);
                System.out.println();
                //System.out.println(race.getRaceDrivers());
                System.out.printf("%-20s", "Driver ID");
                System.out.printf("%-20s", "Driver Name");
                System.out.printf("%-24s", "Driver Location");
                System.out.printf("%-17s", "Team Name");
                System.out.printf("%-20s", "Num Of First Pos.");
                System.out.printf("%-21s", "Num Of Second Pos.");
                System.out.printf("%-21s", "Num Of Third Pos.");
                System.out.printf("%-19s", "Num Of Points");
                System.out.printf("%-20s", "Num Of Races");
                System.out.println("\n");
                for(Formula1Driver formula1RaceDriver : race.getRaceDrivers())
                    race.printRaceDrivers(formula1RaceDriver);
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println();
            }
        }
    }

    // Creating new method to add new race in to the list of arrays

    @Override
    public void addNewRace() {
        while (true) {

            ArrayList<Formula1Driver> raceDrivers = new ArrayList<>();
            ArrayList<String> firstPosition = new ArrayList<>();
            ArrayList<String> secondPosition = new ArrayList<>();
            ArrayList<String> thirdPosition = new ArrayList<>();

            int count = 0;
            int numOfCompletedRace = 0;

            System.out.print("Enter Date (yyyy/mm/dd) : ");
            String validatedDate = sc.next().toUpperCase();
            String date = validateDateFormat(validatedDate);

            System.out.print("Enter Location : ");
            String location = sc.next().toUpperCase();

            boolean value1 = true;
            int numOfDrivers = 0;
            while (value1) {
                try {
                    System.out.print("Enter Number Of Drivers : ");
                    numOfDrivers = sc.nextInt();
                    value1 = false;
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "\nEnter a valid Integer!\n" + ANSI_RESET);
                    sc.next();
                }
            }

            for (int i = 0; i < numOfDrivers; i++) {
                System.out.print("Enter Driver ID: ");
                String driverID = sc.next().toUpperCase();

                boolean a = false;
                for (Formula1Driver raceDriver : raceDrivers) {
                    if (driverID.equals(raceDriver.getDriverID())) {
                        a = true;
                        i--;
                        break;
                    }
                }
                if (a) {
                    System.out.println(ANSI_RED + "\nDriver is already in the race!\n" + ANSI_RESET);
                } else {
                    boolean b = false;
                    for (Formula1Driver driver : listOfDrivers) {
                        if (driverID.equals(driver.getDriverID())) {
                            b = true;
                            //System.out.println(driver);
                            formula1Driver = driver;
                            break;
                        }
                    }
                    if (!b) {
                        System.out.print("Enter Driver Name: ");
                        driverName = sc.next().toUpperCase();

                        System.out.print("Enter Driver Location: ");
                        driverLocation = sc.next().toUpperCase();

                        System.out.print("Enter Team Name: ");
                        String teamName = sc.next().toUpperCase();

                        formula1Driver = new Formula1Driver(driverID, driverName, driverLocation, teamName);
                        addNewDriver(formula1Driver);
                    }

                    boolean value2 = true;
                    String completedRace = null;

                    while (value2) {
                        System.out.print("Does driver completed the race? (y/n) : ");
                        completedRace = sc.next().toLowerCase();

                        if (completedRace.equals("y") || completedRace.equals("n") || completedRace.equals("yes") || completedRace.equals("no")) {
                            value2 = false;

                        } else {
                            System.out.println(ANSI_RED + "\nEnter a valid input!\n" + ANSI_RESET);
                        }
                    }
                    if (completedRace.equals("y")) {

                        numOfCompletedRace++;

                        boolean value3 = true;
                        int driverPosition = 0;
                        while (value3) {
                            try {
                                System.out.print("Position of the Driver : ");
                                driverPosition = sc.nextInt();
                                formula1Driver.setPositionOfTheDriver(driverPosition);
                                value3 = false;
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED + "\nEnter a valid Integer!\n" + ANSI_RESET);
                                sc.next();
                            }
                        }

                        if (driverPosition == 1) {
                            firstPosition.add(driverID);
                            formula1Driver.setNumberOfFirstPositions(formula1Driver.getNumberOfFirstPositions() + 1);
                            formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 25);
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        } else if (driverPosition == 2) {
                            secondPosition.add(driverID);
                            formula1Driver.setNumberOfSecondPositions(formula1Driver.getNumberOfFirstPositions() + 1);
                            formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 18);
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        } else if (driverPosition == 3) {
                            thirdPosition.add(driverID);
                            formula1Driver.setNumberOfThirdPositions(formula1Driver.getNumberOfFirstPositions() + 1);
                            formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 15);
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        } else if (driverPosition == 4) {
                            formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 12);
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        } else if (driverPosition == 5) {
                            formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 10);
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        } else if (driverPosition == 6) {
                            formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 8);
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        } else if (driverPosition == 7) {
                            formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 6);
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        } else if (driverPosition == 8) {
                            formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 4);
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        } else if (driverPosition == 9) {
                            formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 2);
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        } else if (driverPosition == 10) {
                            formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 1);
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        } else {
                            formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                        }
                    }
                    Formula1Driver formula1RaceDriver = new Formula1Driver(driverID, formula1Driver.getDriverName(), formula1Driver.getDriverLocation(), formula1Driver.getTeamName(), formula1Driver.getNumberOfFirstPositions(), formula1Driver.getNumberOfSecondPositions(), formula1Driver.getNumberOfThirdPositions(), formula1Driver.getNumberOfPoints(), formula1Driver.getNumberOfRaces(), formula1Driver.getPositionOfTheDriver());
                    raceDrivers.add(formula1RaceDriver);
                    count++;
                    System.out.println(ANSI_CYAN + "\nDriver " + count + " Successfully Added!\n" + ANSI_RESET);
                }

            }
            Race newRace = new Race(date, location, numOfDrivers, raceDrivers, numOfCompletedRace, firstPosition, secondPosition, thirdPosition);
            listOfRaces.add(newRace);

            System.out.print("Do you need to add another race (y/n)?");
            String input = sc.next().toLowerCase();
            if(input.equals("n")){
                break;
            }
        }
    }

    // Creating method to save list of drivers and also to save list of races

    @Override
    public void save() {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("SaveFile.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            for (Formula1Driver driver : listOfDrivers) {
                outputStream.writeObject(driver);
            }
            outputStream.close();
            fileOutputStream.close();

            System.out.println(ANSI_CYAN + "Save is successful" + ANSI_RESET);

        } catch (Exception e) {
            System.out.println(ANSI_RED + "Error! Try Again." + ANSI_RESET);
        }

        try {
            FileOutputStream fileOutputStream1 = new FileOutputStream("SaveFile1.txt");
            ObjectOutputStream outputStream1 = new ObjectOutputStream(fileOutputStream1);

            for (Race race : listOfRaces) {
                outputStream1.writeObject(race);
            }
            outputStream1.close();
            fileOutputStream1.close();

            System.out.println(ANSI_CYAN + "Save is successful" + ANSI_RESET);

        } catch (Exception e){
            System.out.println(ANSI_RED + "Error! Try Again." + ANSI_RESET);
        }
    }

    // Creating method to load previosly saved list of drivers table and list of races table

    @Override
    public void load() {

        try {
            FileInputStream fileInputStream = new FileInputStream("SaveFile.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            for (; ; ) {  //infinite for loop
                try {
                    Formula1Driver driver1 = (Formula1Driver) objectInputStream.readObject();

                    for (Formula1Driver driver2 : listOfDrivers){
                        if (driver1.getDriverID().equals(driver2.getDriverID())){
                            listOfDrivers.remove(driver2);
                            //System.out.println("\nExisting driver '" + driver2.getDriverID() + "' deleted!\n");
                            break;
                        }
                    }
                    listOfDrivers.add(driver1);

                } catch (EOFException e) {
                    break;
                }
            }

            objectInputStream.close();
            fileInputStream.close();

            System.out.println(ANSI_CYAN + "\nLoad is successful" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Error! Try Again." + ANSI_RESET);
        }

        //match load
        try {
            FileInputStream fileInputStream1 = new FileInputStream("SaveFile1.txt");
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);

            for (; ; ) {            //infinite for loop
                try {
                    Race race = (Race) objectInputStream1.readObject();
                    listOfRaces.add(race);
                } catch (EOFException e) {      //end of file exception
                    break;
                }
            }

            objectInputStream1.close();
            fileInputStream1.close();

            System.out.println(ANSI_CYAN + "Load is successful" + ANSI_RESET);

        } catch (Exception e) {
            System.out.println(ANSI_RED + "Error! Try Again." + ANSI_RESET);
        }
    }

    // Creating method to validate the date format entered while adding new race

    public String validateDateFormat(String dateToValidate) {

        String date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        //To make strict date format validation
        formatter.setLenient(false);
        Date parsedDate;
        boolean check = true;
        while (check) {
            try {
                parsedDate = formatter.parse(dateToValidate);
                date = formatter.format(parsedDate);
                check = false;
            } catch (ParseException e) {
                System.out.println(ANSI_RED + "\nInvalid Date Input!\n" + ANSI_RESET);
                System.out.print("Enter Date (yyyy/mm/dd) : ");
                dateToValidate = sc.next().toUpperCase();

            }
        }
        return date;
    }

    //Creating method to start GUI

    public void startGUI(){

        Table gui = new Table();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        gui.setSize(screenSize.width,screenSize.height);
        gui.setVisible(true);
        gui.setTitle("My First Jav Table");
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
