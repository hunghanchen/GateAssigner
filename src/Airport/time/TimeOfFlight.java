

package Airport.time;

/**
 *
 * @author Nancy Chen
 */
public class TimeOfFlight {
    
    protected String clock;
    protected String minute;

    public TimeOfFlight() {
        
    }
    public TimeOfFlight(String clock, String minute) {
        this.clock = clock;
        this.minute = minute;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
    
    @Override
    public String toString(){
        String format = " %s : %s ";
        return String.format(format, getClock(),getMinute());
    }
    
    
    
    
    
    
    
    

}
