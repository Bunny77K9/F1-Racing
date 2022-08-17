public interface ChampionshipManager {

    void addNewDriver(Formula1Driver formula1Driver); // Crating methods that should be implemented and overriding in thr Formula1Championship Class
    void deleteDriver(String driverID);
    void searchDriver(String driverID);
    void changeDriver(String teamName);
    void viewDriverTable();
    void viewRacesTable();
    void addNewRace();
    void save();
    void load();
}
