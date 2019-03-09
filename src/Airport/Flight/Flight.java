

package Airport.Flight;

/**
 *
 * @author 
 */
public class Flight {
    protected String Airline;
    protected String FlightNo;
    protected String ARR;
    protected String DEP;
    protected DateOfFlight date;

    public Flight(String Airline, String FlightNo, String ARR, String DEP, DateOfFlight date) {
        this.Airline = Airline;
        this.FlightNo = FlightNo;
        this.ARR = ARR;
        this.DEP = DEP;
        this.date = date;
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
     @Override
    public String toString() {

        String format = "This Flight is %s`s Flight and Flight no is %s Arrival time is %s and departure time is %s";
        return String.format(format, Airline,FlightNo, ARR,DEP);

    }
    public void landed(String FlightNo){
        System.out.println("Flight Number "+FlightNo+" is landed");
    }
    public void takingoff(String FlightNo){
        System.out.println("Fligh Number"+FlightNo+"is Taking Off");
    }
   
    
}
