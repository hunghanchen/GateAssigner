package Airport;

/**
 *
 * @author ayfer
 */
public class Open implements Gate{
     protected int GateNo;
     protected String BusDriver;

   
    @Override
    public String toString() {

        String format = "This Flight is taking Open Parking Position Number : %f";
        return String.format(format, GateNo);

    }
    @Override
    public void calling_Driver(String BusDriver,String FlightNo, int GateNo){
        System.out.println("Flight number : "+FlightNo+" is approaching to the Oper parking poisition number : "+GateNo+ " Cobus Driver is : "+BusDriver);
    }

    

}
