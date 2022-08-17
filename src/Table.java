import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Table extends JFrame {  // Creating Table class which extends JFrame to implements th GUI

    public static  ArrayList<Formula1Driver> raceDrivers2 = new ArrayList<>();   //Creating instant variables
    public static  ArrayList<Race> newRaceInfo = new ArrayList<>();

    public Table(){                         // Creating Table
        setLayout(new FlowLayout());
        final boolean[] check = {true};

        JButton button = new JButton("Sort Ascending Order By Points");
        JButton button1 = new JButton("Sort Descending Order By First Positions");
        JButton button2 = new JButton("Click Here to Add A New Race");
        JButton button4 = new JButton("Click Here to Add A New Race with Probability");
        JButton button3 = new JButton("Click Here to View All Races");
        JTextField searchArea = new JTextField(100);
        JButton searchButton = new JButton("Search");
        button.setSize(200,50);
        button1.setSize(200,50);
        button2.setSize(200,50);
        button3.setSize(200,50);
        button4.setSize(200,50);

        JLabel label = new JLabel("New Race Information Table");
        JLabel label2 = new JLabel("New Race Drivers Table");
        JLabel label3 = new JLabel("All Races Table");
        JLabel label4 = new JLabel("Search Result");

        Object[] row = new Object[9];
        String[] column = {"DRIVER ID","DRIVER NAME","DRIVER LOCATION", "TEAM NAME", "NUM OF FIRST POSITIONS", "NUM OF SECOND POSITIONS", "NUM OF THIRD POSITIONS", "NUM OF POINTS", "NUM OF RACES"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        JTable table = new JTable(tableModel);
        table.setDefaultEditor(Object.class, null);

        for(Formula1Driver driver : Formula1ChampionshipManager.listOfDrivers) {
            row[0] = driver.getDriverID();
            row[1] = driver.getDriverName();
            row[2] = driver.getDriverLocation();
            row[3] = driver.getTeamName();
            row[4] = driver.getNumberOfFirstPositions();
            row[5] = driver.getNumberOfSecondPositions();
            row[6] = driver.getNumberOfThirdPositions();
            row[7] = driver.getNumberOfPoints();
            row[8] = driver.getNumberOfRaces();

            tableModel.addRow(row);
        }

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
                table.setRowSorter(sorter);
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();

                if(check[0]) {

                    sortKeys.add(new RowSorter.SortKey(7, SortOrder.ASCENDING));
                    sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                    sorter.setSortKeys(sortKeys);

                    button.setText("Sort Descending Order By Points");
                    check[0] = false;
                }
                else{

                    sortKeys.add(new RowSorter.SortKey(7, SortOrder.DESCENDING));
                    sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
                    sorter.setSortKeys(sortKeys);

                    button.setText("Sort Acceding Order By Points");
                    check[0] = true;
                }
            }
        });

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
                table.setRowSorter(sorter);
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();

                if(check[0]) {

                    sortKeys.add(new RowSorter.SortKey(4, SortOrder.DESCENDING));
                    sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
                    sorter.setSortKeys(sortKeys);

                    button1.setText("Sort Ascending Order By First Positions");
                    check[0] = false;
                }
                else{
                    sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
                    sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                    sorter.setSortKeys(sortKeys);

                    button1.setText("Sort Descending Order By First Positions");
                    check[0] = true;
                }

            }
        });
        Object[] raceRow = new Object[7];
        String[] raceColumn = {"DATE","LOCATION","NUM OF PARTICIPANTS", "NUM OF COMPLETED RACE", "FIRST POSITION(S)", "SECOND POSITION(S)", "THIRD POSITION(S)"};
        DefaultTableModel tableModel2 = new DefaultTableModel(raceColumn, 0);
        JTable table2 = new JTable(tableModel2);

        Object[] driverRow = new Object[9];
        String[] driverColumn = {"DRIVER ID","DRIVER NAME","DRIVER LOCATION", "TEAM NAME", "NUM OF FIRST POSITIONS", "NUM OF SECOND POSITIONS", "NUM OF THIRD POSITIONS", "NUM OF POINTS", "NUM OF RACES"};
        DefaultTableModel tableModel3 = new DefaultTableModel(driverColumn, 0);
        JTable table3 = new JTable(tableModel3);

        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                raceDrivers2 = addNewRace();

                tableModel2.getDataVector().removeAllElements();
                tableModel2.fireTableDataChanged();

                for(Race race : newRaceInfo) {
                    raceRow[0] = race.getDate();
                    raceRow[1] = race.getLocation();
                    raceRow[2] = race.getNumOfDrivers();
                    raceRow[3] = race.getNumOfCompletedRace();
                    raceRow[4] = race.getFirstPosition();
                    raceRow[5] = race.getSecondPosition();
                    raceRow[6] = race.getThirdPosition();

                    tableModel2.addRow(raceRow);
                }

                tableModel3.getDataVector().removeAllElements();
                tableModel3.fireTableDataChanged();

                for(Formula1Driver driver : raceDrivers2) {
                    driverRow[0] = driver.getDriverID();
                    driverRow[1] = driver.getDriverName();
                    driverRow[2] = driver.getDriverLocation();
                    driverRow[3] = driver.getTeamName();
                    driverRow[4] = driver.getNumberOfFirstPositions();
                    driverRow[5] = driver.getNumberOfSecondPositions();
                    driverRow[6] = driver.getNumberOfThirdPositions();
                    driverRow[7] = driver.getNumberOfPoints();
                    driverRow[8] = driver.getNumberOfRaces();

                    tableModel3.addRow(driverRow);

                }
            }
        });

        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                raceDrivers2 = addNewRace2();
                tableModel2.getDataVector().removeAllElements();
                tableModel2.fireTableDataChanged();
                tableModel3.getDataVector().removeAllElements();
                tableModel3.fireTableDataChanged();


                for(Race race : newRaceInfo) {
                    raceRow[0] = race.getDate();
                    raceRow[1] = race.getLocation();
                    raceRow[2] = race.getNumOfDrivers();
                    raceRow[3] = race.getNumOfCompletedRace();
                    raceRow[4] = race.getFirstPosition();
                    raceRow[5] = race.getSecondPosition();
                    raceRow[6] = race.getThirdPosition();

                    tableModel2.addRow(raceRow);
                }

                for(Formula1Driver driver : raceDrivers2) {
                    driverRow[0] = driver.getDriverID();
                    driverRow[1] = driver.getDriverName();
                    driverRow[2] = driver.getDriverLocation();
                    driverRow[3] = driver.getTeamName();
                    driverRow[4] = driver.getNumberOfFirstPositions();
                    driverRow[5] = driver.getNumberOfSecondPositions();
                    driverRow[6] = driver.getNumberOfThirdPositions();
                    driverRow[7] = driver.getNumberOfPoints();
                    driverRow[8] = driver.getNumberOfRaces();

                    tableModel3.addRow(driverRow);

                }
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        table2.setPreferredScrollableViewportSize(new Dimension(screenSize.width-40,15));
        table2.setFillsViewportHeight(true);
        table2.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane2= new JScrollPane(table2);


        table3.setPreferredScrollableViewportSize(new Dimension(screenSize.width-40,screenSize.height/8));
        table3.setFillsViewportHeight(true);
        table3.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane3= new JScrollPane(table3);


        Object[] allRacesRow = new Object[7];
        String[] allRacesColumn = {"DATE","LOCATION","NUM OF PARTICIPANTS", "NUM OF COMPLETED RACE", "FIRST POSITION(S)", "SECOND POSITION(S)", "THIRD POSITION(S)"};
        DefaultTableModel tableModelAllRaces = new DefaultTableModel(allRacesColumn, 0);
        JTable allRacesTable = new JTable(tableModelAllRaces);
        allRacesTable.setDefaultEditor(Object.class, null);

        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                tableModelAllRaces.getDataVector().removeAllElements();
                tableModelAllRaces.fireTableDataChanged();

                for(Race race : Formula1ChampionshipManager.listOfRaces) {
                    allRacesRow[0] = race.getDate();
                    allRacesRow[1] = race.getLocation();
                    allRacesRow[2] = race.getNumOfDrivers();
                    allRacesRow[3] = race.getNumOfCompletedRace();
                    allRacesRow[4] = race.getFirstPosition();
                    allRacesRow[5] = race.getSecondPosition();
                    allRacesRow[6] = race.getThirdPosition();

                    tableModelAllRaces.addRow(allRacesRow);
                }

            }
        });

        allRacesTable.setPreferredScrollableViewportSize(new Dimension(screenSize.width-40,screenSize.height/8));
        allRacesTable.setFillsViewportHeight(true);
        JScrollPane allRacesScrollPane= new JScrollPane(allRacesTable);

        Object[] searchRacesRow = new Object[8];
        String[] searchRacesColumn = {"DATE","LOCATION","NUM OF PARTICIPANTS", "NUM OF COMPLETED RACE", "FIRST POSITION(S)", "SECOND POSITION(S)", "THIRD POSITION(S)", "POSITION OF THE DRIVER"};
        DefaultTableModel tableModelSearchRaces = new DefaultTableModel(searchRacesColumn, 0);
        JTable searchRacesTable = new JTable(tableModelSearchRaces);
        searchRacesTable.setDefaultEditor(Object.class, null);
        searchRacesTable.setVisible(false);
        label4.setVisible(false);

        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                tableModelSearchRaces.getDataVector().removeAllElements();
                tableModelSearchRaces.fireTableDataChanged();

                String textFieldInput = searchArea.getText();
                for (Race race : Formula1ChampionshipManager.listOfRaces){
                    for(Formula1Driver driver : race.getRaceDrivers()){
                        if(driver.getDriverID().equals(textFieldInput)){

                            searchRacesTable.setVisible(true);
                            label4.setVisible(true);

                            searchRacesRow[0] = race.getDate();
                            searchRacesRow[1] = race.getLocation();
                            searchRacesRow[2] = race.getNumOfDrivers();
                            searchRacesRow[3] = race.getNumOfCompletedRace();
                            searchRacesRow[4] = race.getFirstPosition();
                            searchRacesRow[5] = race.getSecondPosition();
                            searchRacesRow[6] = race.getThirdPosition();
                            searchRacesRow[7] = driver.getPositionOfTheDriver();

                            tableModelSearchRaces.addRow(searchRacesRow);
                        }
                    }
                }
            }
        });

        searchRacesTable.setPreferredScrollableViewportSize(new Dimension(screenSize.width-40,screenSize.height/8));
        searchRacesTable.setFillsViewportHeight(true);
        JScrollPane scrollPaneSearch= new JScrollPane(searchRacesTable);

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(allRacesTable.getModel());
        allRacesTable.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);

        table.setPreferredScrollableViewportSize(new Dimension(screenSize.width-40,screenSize.height/8));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(button);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(searchArea);
        add(searchButton);
        add (scrollPane);
        add(label);
        add (scrollPane2);
        add(label2);
        add (scrollPane3);
        add(label3);
        add (allRacesScrollPane);
        add(label4);
        add (scrollPaneSearch);
    }

    //Creating method to randomly generate races on button click

    public static ArrayList<Formula1Driver> addNewRace(){
        ArrayList<Formula1Driver> raceDrivers = new ArrayList<>();
        ArrayList<String> firstPosition = new ArrayList<>();
        ArrayList<String> secondPosition = new ArrayList<>();
        ArrayList<String> thirdPosition = new ArrayList<>();
        String[] locationList = {"Hambanthota","Galle","Kandy","Gampaha","Nuwara-Eliya","Jaffna","Colombo","Trincomalee"};
        String[] completedStatus = {"y","n"};
        String date;
        String location;
        String completed;
        int count = 0;
        int numOfCompletedRace = 0;
        int driverPosition;

        Random random = new Random();

        int day = random.nextInt((30-1) + 1);
        int month = random.nextInt((12-1) + 1);
        int year = (int) ((Math.random() * (2021 - 2010)) + 2010);
        date = year + "/" + month + "/" + day;

        int randomLocation = random.nextInt(locationList.length);
        location = locationList[randomLocation];

        for(int i = 0; i<Formula1ChampionshipManager.listOfDrivers.size();i++) {

            int driver = random.nextInt(Formula1ChampionshipManager.listOfDrivers.size());
            Formula1Driver formula1Driver = Formula1ChampionshipManager.listOfDrivers.get(driver);

            boolean a = false;
            for (Formula1Driver raceDriver : raceDrivers) {
                if (formula1Driver.getDriverID().equals(raceDriver.getDriverID())) {
                    a = true;
                    i--;
                    break;
                }
            }
            if (!a){

                int randomCompletedStatus = random.nextInt(completedStatus.length);
                completed = completedStatus[randomCompletedStatus];

                if (completed.equals("y")) {

                    numOfCompletedRace++;
                    if(numOfCompletedRace <=3) {
                        driverPosition = numOfCompletedRace;
                    }else{
                        driverPosition = random.nextInt(Formula1ChampionshipManager.listOfDrivers.size());
                    }

                    formula1Driver.setPositionOfTheDriver(driverPosition);

                    if (driverPosition == 1) {
                        firstPosition.add(formula1Driver.getDriverID());
                        formula1Driver.setNumberOfFirstPositions(formula1Driver.getNumberOfFirstPositions() + 1);
                        formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 25);
                        formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                    } else if (driverPosition == 2) {
                        secondPosition.add(formula1Driver.getDriverID());
                        formula1Driver.setNumberOfSecondPositions(formula1Driver.getNumberOfFirstPositions() + 1);
                        formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 18);
                        formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                    } else if (driverPosition == 3) {
                        thirdPosition.add(formula1Driver.getDriverID());
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
                Formula1Driver formula1RaceDriver = new Formula1Driver(formula1Driver.getDriverID(), formula1Driver.getDriverName(), formula1Driver.getDriverLocation(), formula1Driver.getTeamName(), formula1Driver.getNumberOfFirstPositions(), formula1Driver.getNumberOfSecondPositions(), formula1Driver.getNumberOfThirdPositions(), formula1Driver.getNumberOfPoints(), formula1Driver.getNumberOfRaces(), formula1Driver.getPositionOfTheDriver());
                raceDrivers.add(formula1RaceDriver);
                count++;
            }
        }

        Race newRace = new Race(date,location,count,raceDrivers,numOfCompletedRace,firstPosition,secondPosition,thirdPosition);
        Formula1ChampionshipManager.listOfRaces.add(newRace);
        newRaceInfo.clear();
        newRaceInfo.add(newRace);

        return raceDrivers;
    }

    //Creating method to randomly generate race with probability

    public static ArrayList<Formula1Driver> addNewRace2(){
        ArrayList<Formula1Driver> raceDrivers = new ArrayList<>();
        ArrayList<String> firstPosition = new ArrayList<>();
        ArrayList<String> secondPosition = new ArrayList<>();
        ArrayList<String> thirdPosition = new ArrayList<>();
        ArrayList<Integer> probabilityArray = new ArrayList<>();
        for(int i = 0; i<100;i++){
            if(probabilityArray.size() <= 40) {
                probabilityArray.add(1);
            }else if(probabilityArray.size() <= 70) {
                probabilityArray.add(2);
            }else if(probabilityArray.size() <= 80) {
                probabilityArray.add(3);
            }else if(probabilityArray.size() <= 90) {
                probabilityArray.add(4);
            }else if(probabilityArray.size() <= 92) {
                probabilityArray.add(5);
            }else if(probabilityArray.size() <= 94) {
                probabilityArray.add(6);
            }else if(probabilityArray.size() <= 96) {
                probabilityArray.add(7);
            }else if(probabilityArray.size() <= 98) {
                probabilityArray.add(8);
            } else if(probabilityArray.size() <= 100) {
                probabilityArray.add(9);
            }
        }

        String[] locationList = {"Hambanthota","Galle","Kandy","Gampaha","Nuwara-Eliya","Jaffna","Colombo","Trincomalee"};
        String[] completedStatus = {"y","n"};
        String date;
        String location;
        String completed;
        int count = 0;
        int numOfCompletedRace = 0;
        int driverPosition;

        Random random = new Random();

        int day = random.nextInt((30-1) + 1);
        int month = random.nextInt((12-1) + 1);
        int year = (int) ((Math.random() * (2021 - 2010)) + 2010);
        date = year + "/" + month + "/" + day;

        int randomLocation = random.nextInt(locationList.length);
        location = locationList[randomLocation];

        for(int i = 0; i<Formula1ChampionshipManager.listOfDrivers.size();i++) {

            int driver = random.nextInt(Formula1ChampionshipManager.listOfDrivers.size());
            Formula1Driver formula1Driver = Formula1ChampionshipManager.listOfDrivers.get(driver);

            boolean a = false;
            for (Formula1Driver raceDriver : raceDrivers) {
                if (formula1Driver.getDriverID().equals(raceDriver.getDriverID())) {
                    a = true;
                    i--;
                    break;
                }
            }
            if (!a){
                int driverStartPosition = random.nextInt((Formula1ChampionshipManager.listOfDrivers.size() - 1) + 1) + 1;
                int randomCompletedStatus = random.nextInt(completedStatus.length);
                completed = completedStatus[randomCompletedStatus];

                if (completed.equals("y")) {

                    numOfCompletedRace++;
                    Collections.shuffle(probabilityArray);
                    int randomInteger = new Random().nextInt(probabilityArray.size());
                    int randomPosition = probabilityArray.get(randomInteger);

                    if(driverStartPosition == randomPosition){
                        driverPosition = 1;
                    }else{
                        driverPosition = random.nextInt((Formula1ChampionshipManager.listOfDrivers.size() - 2) + 1) + 2;
                    }

                    formula1Driver.setPositionOfTheDriver(driverPosition);

                    if (driverPosition == 1) {
                        firstPosition.add(formula1Driver.getDriverID());
                        formula1Driver.setNumberOfFirstPositions(formula1Driver.getNumberOfFirstPositions() + 1);
                        formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 25);
                        formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                    } else if (driverPosition == 2) {
                        secondPosition.add(formula1Driver.getDriverID());
                        formula1Driver.setNumberOfSecondPositions(formula1Driver.getNumberOfFirstPositions() + 1);
                        formula1Driver.setNumberOfPoints(formula1Driver.getNumberOfPoints() + 18);
                        formula1Driver.setNumberOfRaces(formula1Driver.getNumberOfRaces() + 1);
                    } else if (driverPosition == 3) {
                        thirdPosition.add(formula1Driver.getDriverID());
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
                Formula1Driver formula1RaceDriver = new Formula1Driver(formula1Driver.getDriverID(), formula1Driver.getDriverName(), formula1Driver.getDriverLocation(), formula1Driver.getTeamName(), formula1Driver.getNumberOfFirstPositions(), formula1Driver.getNumberOfSecondPositions(), formula1Driver.getNumberOfThirdPositions(), formula1Driver.getNumberOfPoints(), formula1Driver.getNumberOfRaces(), formula1Driver.getPositionOfTheDriver());
                raceDrivers.add(formula1RaceDriver);
                count++;
            }
        }

        Race newRace = new Race(date,location,count,raceDrivers,numOfCompletedRace,firstPosition,secondPosition,thirdPosition);
        Formula1ChampionshipManager.listOfRaces.add(newRace);
        newRaceInfo.clear();
        newRaceInfo.add(newRace);

        return raceDrivers;
    }
}