

package Airport;

/**
 *
 * @author ayfer
 */
public class Bridge implements Gate{
    protected int GateNo;
    protected String Driver;

  

   
        
    
    @Override
    public String toString() {

        String format = "This Flight is taking Bridge Parking Position Number : %f";
        return String.format(format, GateNo);

    }
    @Override
    public void calling_Driver(String Driver,String FlightNo,int GateNo){
        System.out.println("Flight Number " +FlightNo+" is taking the Bridge parking position Number: "+GateNo+" Driver name is "+Driver);
    }

}
