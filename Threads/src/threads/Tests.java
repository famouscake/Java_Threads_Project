/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter
 */
public class Tests {
    
    
   
    
    public long run_test_on_dinamic_fib(int n) 
    {
               
        Fibonacci thread1=new Fibonacci(1, n);       
        
        thread1.start();
        
        try {
            thread1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        return thread1.get_value();
        
    
    }
    
    
     public long run_test_on_serial_fib(int m)
    {
        if(m<=1)
            return m;
         
        long a=run_test_on_serial_fib(m-1); 
        long b=run_test_on_serial_fib(m-2);
   
        return a+b;
    }
    
    
    
    
}
