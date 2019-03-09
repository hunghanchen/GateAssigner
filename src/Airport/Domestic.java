

package Airport;

/**
 *
 * @author ayfer
 */
public class Domestic extends Flight {
    public Domestic(String Airline, String FlightNo,String ARR, String DEP) {
        super(Airline,FlightNo,ARR,DEP);
    }
     @Override
     public String toString() {

        String format = "This Domestic Flight is %s`s Flight and Flight no is %s Arrival time is %s and departure time is %s";
        return String.format(format, Airline,FlightNo, ARR,DEP);

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
