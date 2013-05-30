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
               
        Fibonacci thread1=new Fibonacci(1, n,"thread");       
        
        thread1.start();
        
        try {
            thread1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        return thread1.get_value();
        
    }
    
    public long run_test_on_static_4_fib(int n) 
    {
        long a=0;
        
        try {
            Fibonacci thread1=new Fibonacci(1, n-3,"thread");
            Fibonacci thread2=new Fibonacci(2, n-4,"thread");
            Fibonacci thread3=new Fibonacci(3, n-5,"thread");
            Fibonacci thread4=new Fibonacci(4, n-6,"thread");
            
            
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            
            long f3,f4,f5,f6;
            
            f3=thread1.get_value();
            f4=thread2.get_value();
            f5=thread3.get_value();
            f6=thread4.get_value();
            
            a=f3+3*f4+3*f5+f6;
        } catch (InterruptedException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
        
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
