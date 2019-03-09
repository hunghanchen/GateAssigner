

package Airport;

/**
 *
 * @author ayfer
 */
public class Others extends Flight{
    public Others (String Airline, String FlightNo,String ARR, String DEP) {
        super(Airline,FlightNo,ARR,DEP);
    }
    
     @Override
     public String toString() {

        String format = "This Flight is %s`s Flight and Flight no is %s Arrival time is %s and departure time is %s";
        return String.format(format, Airline,FlightNo, ARR,DEP);

    }
      @Override
    public void landed(String FlightNo){
        System.out.println(" Flight Number "+FlightNo+" is landed");
    }
    @Override
    public void takingoff(String FlightNo){
        System.out.println("Flight Number"+FlightNo+"is Taking Off");
    }

}
