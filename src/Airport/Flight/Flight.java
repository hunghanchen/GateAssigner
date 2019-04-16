package Airport.Flight;

import Airport.time.TimeOfFlight;
import java.time.LocalDate;

/**
 *
 * @author
 */
public class Flight {

    protected String Airline;
    protected String FlightNo;
    protected String ARR;
    protected String DEP;
    protected LocalDate dateOfArrival;
    protected LocalDate dateOfDeparture;
    protected TimeOfFlight timeOfArrival;
    protected TimeOfFlight timeOfDepature;

    public Flight(String Airline, String FlightNo, String ARR, String DEP, 
            LocalDate dateOfArrival, LocalDate dateOfDeparture, 
            TimeOfFlight timeOfArrival, TimeOfFlight timeOfDepature) {
        this.Airline = Airline;
        this.FlightNo = FlightNo;
        this.ARR = ARR;
        this.DEP = DEP;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
        this.timeOfArrival = timeOfArrival;
        this.timeOfDepature = timeOfDepature;
    }

    public TimeOfFlight getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(TimeOfFlight timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public TimeOfFlight getTimeOfDepature() {
        return timeOfDepature;
    }

    public void setTimeOfDepature(TimeOfFlight timeOfDepature) {
        this.timeOfDepature = timeOfDepature;
    }

    

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String Airline) {
        this.Airline = Airline;
    }

    public String getFlightNo() {
        return FlightNo;
    }

    public void setFlightNo(String FlightNo) {
        this.FlightNo = FlightNo;
    }

    /*
    public International getIntFlightNo() {
        return IntFlightNo;
    }

    public void setIntFlightNo(International IntFlightNo) {
        this.IntFlightNo = IntFlightNo;
    }

    public Domestic getDomFlightNo() {
        return DomFlightNo;
    }

    public void setDomFlightNo(Domestic DomFlightNo) {
        this.DomFlightNo = DomFlightNo;
    }

    public Others getOthFlightNo() {
        return OthFlightNo;
    }

    public void setOthFlightNo(Others OthFlightNo) {
        this.OthFlightNo = OthFlightNo;
    }*/
    public String getARR() {
        return ARR;
    }

    public void setARR(String ARR) {
        this.ARR = ARR;
    }

    public String getDEP() {
        return DEP;
    }

    public void setDEP(String DEP) {
        this.DEP = DEP;
    }

//    @Override
//    public String toString() {
//
//        String format = "This Flight is %s`s Flight and Flight no is %s Arrival time is %s and departure time is %s";
//        return String.format(format, Airline, FlightNo, ARR, DEP);
//
//    }
    @Override
    public String toString() {
        String format = "%s, %s, %tF, %tF, %s, %s\n";
        return String.format(format, Airline, FlightNo, dateOfArrival, dateOfDeparture, ARR, DEP);

    }

    public void landed(String FlightNo) {
        System.out.println("Flight Number " + FlightNo + " is landed");
    }

    public void takingoff(String FlightNo) {
        System.out.println("Fligh Number" + FlightNo + "is Taking Off");
    }

}
