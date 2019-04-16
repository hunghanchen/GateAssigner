package Airport.Flight;

import Airport.time.TimeOfFlight;
import java.time.LocalDate;

/**
 *
 * @author ayfer
 */
public class Domestic extends Flight {

    public Domestic(String Airline, String FlightNo, String ARR, String DEP, LocalDate dateOfArrival, LocalDate dateOfDeparture, TimeOfFlight timeOfArrival, TimeOfFlight timeOfDepature) {
        super(Airline, FlightNo, ARR, DEP, dateOfArrival, dateOfDeparture, timeOfArrival, timeOfDepature);
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

    @Override
    public String toString() {

        String format = "Domestic, %s, %s, %tF, %s,%tF, %s, %s, %s";

        return String.format(format, Airline, FlightNo, dateOfArrival,timeOfArrival
                ,dateOfDeparture,timeOfDepature, ARR, DEP);

    }

    @Override
    public void landed(String FlightNo) {
        System.out.println("Domestic Flight, Flight Number " + FlightNo + " is landed");
    }

    @Override
    public void takingoff(String FlightNo) {
        System.out.println("Domestic Flight, Flight Number" + FlightNo + "is Taking Off");
    }
}
