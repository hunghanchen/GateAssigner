/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airport;

/**
 *
 * @author ayfer
 */
public interface Gate {
    String toString();
    void calling_Driver(String Driver,String FlightNo,int GateNo);
   // void call_cobus(String BusDriver,String FlightNo, int GateNo);
    
}
