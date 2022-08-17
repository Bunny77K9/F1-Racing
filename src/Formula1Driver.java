import java.io.Serializable;
import java.util.Objects;

public class Formula1Driver extends Driver implements Comparable<Formula1Driver>, Serializable {  //Creating class that extends the abstract class driver

    private int numberOfFirstPositions;  //Creating instant variables
    private int numberOfSecondPositions;
    private int numberOfThirdPositions;
    private double numberOfPoints;
    private int numberOfRaces;
    private int positionOfTheDriver;

    public Formula1Driver() {  //Creating default constructor
    }

    public Formula1Driver(String driverID, String driverName, String driverLocation, String teamName) {  //Creating constructor with the local variables
        super(driverID,driverName, driverLocation, teamName);
    }

    public Formula1Driver(String driverID, String driverName, String driverLocation, String teamName,int numberOfFirstPositions, int numberOfSecondPositions, int numberOfThirdPositions, double numberOfPoints, int numberOfRaces) {  //
        super(driverID,driverName, driverLocation, teamName);
        this.numberOfFirstPositions = numberOfFirstPositions;
        this.numberOfSecondPositions = numberOfSecondPositions;
        this.numberOfThirdPositions = numberOfThirdPositions;
        this.numberOfPoints = numberOfPoints;
        this.numberOfRaces = numberOfRaces;
    }

    public Formula1Driver(String driverID, String driverName, String driverLocation, String teamName,int numberOfFirstPositions, int numberOfSecondPositions, int numberOfThirdPositions, double numberOfPoints, int numberOfRaces, int positionOfTheDriver) {
        super(driverID,driverName, driverLocation, teamName);
        this.numberOfFirstPositions = numberOfFirstPositions;
        this.numberOfSecondPositions = numberOfSecondPositions;
        this.numberOfThirdPositions = numberOfThirdPositions;
        this.numberOfPoints = numberOfPoints;
        this.numberOfRaces = numberOfRaces;
        this.positionOfTheDriver = positionOfTheDriver;
    }

    //Creating methods for the getters and setters

    public int getNumberOfFirstPositions() {
        return numberOfFirstPositions;
    }

    public void setNumberOfFirstPositions(int numberOfFirstPositions) {
        this.numberOfFirstPositions = numberOfFirstPositions;
    }

    public int getNumberOfSecondPositions() {
        return numberOfSecondPositions;
    }

    public void setNumberOfSecondPositions(int numberOfSecondPositions) {
        this.numberOfSecondPositions = numberOfSecondPositions;
    }

    public int getNumberOfThirdPositions() {
        return numberOfThirdPositions;
    }

    public void setNumberOfThirdPositions(int numberOfThirdPositions) {
        this.numberOfThirdPositions = numberOfThirdPositions;
    }

    public double getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(double numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }

    public int getPositionOfTheDriver() {
        return positionOfTheDriver;
    }

    public void setPositionOfTheDriver(int positionOfTheDriver) {
        this.positionOfTheDriver = positionOfTheDriver;
    }

    //Creating equals method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formula1Driver)) return false;
        if (!super.equals(o)) return false;
        Formula1Driver that = (Formula1Driver) o;
        return getNumberOfFirstPositions() == that.getNumberOfFirstPositions() && getNumberOfSecondPositions() == that.getNumberOfSecondPositions() && getNumberOfThirdPositions() == that.getNumberOfThirdPositions() && Double.compare(that.getNumberOfPoints(), getNumberOfPoints()) == 0 && getNumberOfRaces() == that.getNumberOfRaces() && getPositionOfTheDriver() == that.getPositionOfTheDriver();
    }

    //Creating hashcode method

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumberOfFirstPositions(), getNumberOfSecondPositions(), getNumberOfThirdPositions(), getNumberOfPoints(), getNumberOfRaces(), getPositionOfTheDriver());
    }

    //Creating toString method to print the arraylist

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(numberOfFirstPositions).append(spc(10 - String.valueOf(numberOfFirstPositions).length()));
        sb.append("|").append(spc(10));
        sb.append(numberOfSecondPositions).append(spc(10 - String.valueOf(numberOfSecondPositions).length()));
        sb.append("|").append(spc(10));
        sb.append(numberOfThirdPositions).append(spc(10 - String.valueOf(numberOfThirdPositions).length()));
        sb.append("|").append(spc(5));
        sb.append(numberOfPoints).append(spc(10 - String.valueOf(numberOfPoints).length()));
        sb.append("|").append(spc(10));
        sb.append(numberOfRaces).append(spc(10 - String.valueOf(numberOfRaces).length()));
        sb.append("|");


        return sb.toString();
    }

    //Creating compare to method to compare between object to sort them

    @Override
    public int compareTo(Formula1Driver o) {
        if (numberOfPoints == o.numberOfPoints){
            if(numberOfFirstPositions  == o.numberOfFirstPositions){
                return 0;
            }else if(numberOfFirstPositions < o.numberOfFirstPositions){
                return 1;
            }else{
                return -1;
            }
        }else if (numberOfPoints < o.numberOfPoints){
            return 1;
        }else {
            return -1;
        }
    }

//    @Override
//    public String toString() {
//        return "Formula1Driver{" +
//                "numberOfFirstPositions=" + numberOfFirstPositions +
//                ", numberOfSecondPositions=" + numberOfSecondPositions +
//                ", numberOfThirdPositions=" + numberOfThirdPositions +
//                ", numberOfPoints=" + numberOfPoints +
//                ", numberOfRaces=" + numberOfRaces +
//                '}';
//    }

}
