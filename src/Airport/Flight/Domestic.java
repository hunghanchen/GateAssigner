

package Airport.Flight;

import java.time.LocalDate;

/**
 *
 * @author ayfer
 */
public class Domestic extends Flight {

    public Domestic(String Airline, String FlightNo, String ARR, String DEP, LocalDate dateOfArrival, LocalDate dateOfDeparture) {
        super(Airline, FlightNo, ARR, DEP, dateOfArrival, dateOfDeparture);
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

        String format = "This Flight is Domestic %s Flight and Flight no is %s Arrival"
                + " arrival time is %tF and departure time is %tF"
                + "comes from %s and goes to %s";
        return String.format(format, Airline, FlightNo, dateOfArrival, dateOfDeparture, ARR, DEP);

    }
      @Override
    public void landed(String FlightNo){
        System.out.println("Domestic Flight, Flight Number "+FlightNo+" is landed");
    }
    @Override
    public void takingoff(String FlightNo){
        System.out.println("Domestic Flight, Flight Number"+FlightNo+"is Taking Off");
    }
}
