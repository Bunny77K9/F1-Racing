import java.io.Serializable;
import java.util.Objects;

public abstract class Driver implements Serializable { //Creating abstract class for the Driver

    private String driverID;       //Creating instant variables
    private String driverName;
    private String driverLocation;
    private String teamName;

    public Driver() {       //Default constructor

    }

    public Driver(String driverID, String driverName, String driverLocation, String teamName) {  //Creating constructor with local variables
        this.driverID = driverID;
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.teamName = teamName;
    }

    public String getDriverID() {
        return driverID;
    }  //Creating getters and setters for the variables

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    //Creating equals method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(getDriverID(), driver.getDriverID()) && Objects.equals(getDriverName(), driver.getDriverName()) && Objects.equals(getDriverLocation(), driver.getDriverLocation()) && Objects.equals(getTeamName(), driver.getTeamName());
    }

    //Creating hash Code method

    @Override
    public int hashCode() {
        return Objects.hash(getDriverID(), getDriverName(), getDriverLocation(), getTeamName());
    }

    public String spc(int n)
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) sb.append(" ");
        return sb.toString();
    }

    //To String method to print the ArrayList

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(driverID).append(spc(15 - driverID.length()));
        sb.append("|").append(spc(5));
        sb.append(driverName).append(spc(15 - driverName.length()));
        sb.append("|").append(spc(5));
        sb.append(driverLocation).append(spc(15 - driverLocation.length()));
        sb.append("|").append(spc(5));
        sb.append(teamName).append(spc(15 - teamName.length()));
        sb.append("|").append(spc(10));
        return sb.toString();
    }
}
