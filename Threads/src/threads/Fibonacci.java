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
public class Fibonacci extends Thread {
    
    private int n;//
    public int nth_fib_value;
    int thread_num;
    

    public int get_value()
    {
        return nth_fib_value;
    }
    
    Fibonacci(int _thread_num,int _n)
    {    
        thread_num=_thread_num;
        n=_n;
    }
    
    
    @Override
    public void run() {
        nth_fib_value=multi_fib_compute(n);
        //nth_fib_value=serial_fib_compute(n);
        
        //System.out.printf("Thread %d computed that the %dth fibonacci number is - %d\n",thread_num,n,nth_fib_value);  
    }
    

    private int multi_fib_compute(int m)
    {
        if(m<=1)
            return m;
        
        System.out.println(Thread.activeCount());
        
        long active=Thread.activeCount();
            if(active>4)
                return serial_fib_compute(m);
            
                
        
        thread_num++;
        
        Fibonacci th=new Fibonacci(thread_num, m-2);
        

        th.start();
 
        int a=multi_fib_compute(m-1); 
        
        try {
            th.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fibonacci.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        int b = th.get_value();
        
        return a+b;
    }
    
 
    
    
    int serial_fib_compute(int m)
    {
        if(m<=1)
            return m;
        
         
        int a=serial_fib_compute(m-1); 
        int b=serial_fib_compute(m-2);
   
        return a+b;
    }
}
