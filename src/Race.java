import java.util.ArrayList;
import java.util.Objects;

public class Race extends Formula1Driver{  //Creating race class that extends

    private String date;           //Creating instant variables
    private String location;
    private int numOfDrivers;
    private ArrayList<Formula1Driver> raceDrivers;
    private int numOfCompletedRace;
    private ArrayList<String> firstPosition;
    private ArrayList<String> secondPosition;
    private ArrayList<String> thirdPosition;

    // Creating constructor for the class

    public Race(String date, String location, int numOfDrivers, ArrayList<Formula1Driver> raceDrivers, int numOfCompletedRace, ArrayList<String> firstPosition, ArrayList<String> secondPosition, ArrayList<String> thirdPosition) {
        this.date = date;
        this.location = location;
        this.numOfDrivers = numOfDrivers;
        this.raceDrivers = raceDrivers;
        this.numOfCompletedRace = numOfCompletedRace;
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
    }

    // Creating getters and setters method

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumOfDrivers() {
        return numOfDrivers;
    }

    public void setNumOfDrivers(int numOfDrivers) {
        this.numOfDrivers = numOfDrivers;
    }

    public ArrayList<Formula1Driver> getRaceDrivers() {
        return raceDrivers;
    }

    public void setRaceDrivers(ArrayList<Formula1Driver> raceDrivers) {
        this.raceDrivers = raceDrivers;
    }

    public int getNumOfCompletedRace() {
        return numOfCompletedRace;
    }

    public void setNumOfCompletedRace(int numOfCompletedRace) {
        this.numOfCompletedRace = numOfCompletedRace;
    }

    public ArrayList<String> getFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(ArrayList<String> firstPosition) {
        this.firstPosition = firstPosition;
    }

    public ArrayList<String> getSecondPosition() {
        return secondPosition;
    }

    public void setSecondPosition(ArrayList<String> secondPosition) {
        this.secondPosition = secondPosition;
    }

    public ArrayList<String> getThirdPosition() {
        return thirdPosition;
    }

    public void setThirdPosition(ArrayList<String> thirdPosition) {
        this.thirdPosition = thirdPosition;
    }

    // Creating get equals method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race)) return false;
        if (!super.equals(o)) return false;
        Race race = (Race) o;
        return getNumOfDrivers() == race.getNumOfDrivers() && getNumOfCompletedRace() == race.getNumOfCompletedRace() && Objects.equals(getDate(), race.getDate()) && Objects.equals(getLocation(), race.getLocation()) && Objects.equals(getRaceDrivers(), race.getRaceDrivers()) && Objects.equals(getFirstPosition(), race.getFirstPosition()) && Objects.equals(getSecondPosition(), race.getSecondPosition()) && Objects.equals(getThirdPosition(), race.getThirdPosition());
    }

    // Creating hash code method

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDate(), getLocation(), getNumOfDrivers(), getRaceDrivers(), getNumOfCompletedRace(), getFirstPosition(), getSecondPosition(), getThirdPosition());
    }

    //Creating methods to print drivers

    public void printRaceDrivers(Formula1Driver raceDriver) {

        StringBuilder sb = new StringBuilder();
        sb.append(raceDriver.getDriverID()).append(spc(15 - raceDriver.getDriverID().length()));
        sb.append("|").append(spc(5));
        sb.append(raceDriver.getDriverName()).append(spc(15 - raceDriver.getDriverName().length()));
        sb.append("|").append(spc(5));
        sb.append(raceDriver.getDriverLocation()).append(spc(15 - raceDriver.getDriverLocation().length()));
        sb.append("|").append(spc(5));
        sb.append(raceDriver.getTeamName()).append(spc(15 - raceDriver.getTeamName().length()));
        sb.append("|").append(spc(10));
        sb.append(raceDriver.getNumberOfFirstPositions()).append(spc(10 - String.valueOf(raceDriver.getNumberOfFirstPositions()).length()));
        sb.append("|").append(spc(10));
        sb.append(raceDriver.getNumberOfSecondPositions()).append(spc(10 - String.valueOf(raceDriver.getNumberOfSecondPositions()).length()));
        sb.append("|").append(spc(10));
        sb.append(raceDriver.getNumberOfThirdPositions()).append(spc(10 - String.valueOf(raceDriver.getNumberOfThirdPositions()).length()));
        sb.append("|").append(spc(5));
        sb.append(raceDriver.getNumberOfPoints()).append(spc(10 - String.valueOf(raceDriver.getNumberOfPoints()).length()));
        sb.append("|").append(spc(10));
        sb.append(raceDriver.getNumberOfRaces()).append(spc(10 - String.valueOf(raceDriver.getNumberOfRaces()).length()));
        sb.append("|");


        System.out.println(sb);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("| Date: '").append(date).append('\'' + " | ").append(spc(10 - String.valueOf(date).length()));
        sb.append("Location: '").append(location).append('\'' + " | ").append(spc(10 - String.valueOf(date).length()));
        sb.append("Number Of Drivers Participated: '").append(numOfDrivers).append('\'' + " | ").append(spc(10 - String.valueOf(date).length()));
        sb.append("Number Of Drivers Completed The Race: '").append(numOfCompletedRace).append('\'' + " | ").append(spc(10 - String.valueOf(date).length()));
        sb.append("\n| First Position: ").append(firstPosition).append(" | ").append(spc(10 - String.valueOf(firstPosition).length()));
        sb.append("Second Position: ").append(secondPosition).append(" | ").append(spc(10 - String.valueOf(secondPosition).length()));
        sb.append("Third Position: ").append(thirdPosition).append(" | ").append(spc(10 - String.valueOf(thirdPosition).length()));
        sb.append("\n| Drivers : ");

        return sb.toString();
    }
}
