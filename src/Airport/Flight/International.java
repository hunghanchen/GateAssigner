

package Airport.Flight;

import java.time.LocalDate;

/**
 *
 * @author ayfer
 */
public class International extends Flight {
    protected String Custom;

    public International(String Custom, String Airline, String FlightNo, String ARR, String DEP, LocalDate dateOfArrival, LocalDate dateOfDeparture) {
        super(Airline, FlightNo, ARR, DEP, dateOfArrival, dateOfDeparture);
        this.Custom = Custom;
    }

    
//     @Override
//    public String toString() {
//
//        String format = "This International Flight is %s`s Flight and Flight no is %s Arrival time is %s and departure time is %s";
//        return String.format(format, Airline,FlightNo, ARR,DEP);
//
//    }
    public void CustomProcess(String Custom){
        System.out.println("This international Flight needs "+Custom + "Custom Process");
    }
    @Override
    public void landed(String FlightNo){
        System.out.println("International Flight, Flight Number "+FlightNo+" is landed");
    }
    @Override
    public void takingoff(String FlightNo){
        System.out.println("International Flight, Flight Number"+FlightNo+"is Taking Off");
    }

}
