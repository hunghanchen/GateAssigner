package Airport.Flight;

import Airport.time.TimeOfFlight;
import java.time.LocalDate;

/**
 *
 * @author ayfer
 */
public class International extends Flight {

    protected String Custom;

    public International(String Custom, String Airline, String FlightNo,
            String ARR, String DEP, LocalDate dateOfArrival,
            LocalDate dateOfDeparture, TimeOfFlight timeOfArrival,
            TimeOfFlight timeOfDepature) {
        super(Airline, FlightNo, ARR, DEP, dateOfArrival, dateOfDeparture, timeOfArrival, timeOfDepature);
        this.Custom = Custom;
    }

    public String getCustom() {
        return Custom;
    }

    public void setCustom(String Custom) {
        this.Custom = Custom;
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

    @Override
    public String toString() {

        String format = "International, %s, %s, %tF, %s,%tF, %s, %s, %s";

        return String.format(format, Airline, FlightNo, dateOfArrival,timeOfArrival
                ,dateOfDeparture,timeOfDepature, ARR, DEP);

    }

    public void CustomProcess(String Custom) {
        System.out.println("This international Flight needs " + Custom + "Custom Process");
    }

    @Override
    public void landed(String FlightNo) {
        System.out.println("International Flight, Flight Number " + FlightNo + " is landed");
    }

    @Override
    public void takingoff(String FlightNo) {
        System.out.println("International Flight, Flight Number" + FlightNo + "is Taking Off");
    }

}
