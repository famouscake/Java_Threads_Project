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
    public long nth_fib_value;
    int thread_num;
    String mode;
    

    public long get_value()
    {
        return nth_fib_value;
    }
    
    Fibonacci(int _thread_num,int _n,String mode)
    {    
        thread_num=_thread_num;
        n=_n;
        this.mode=mode;
    }
    
    
    @Override
    public void run() {
        
        if ("thread".equals(mode))
            nth_fib_value=multi_fib_compute(n);
        
        if("serial".equals(mode))
            nth_fib_value=serial_fib_compute(n);
        
        //System.out.printf("Thread %d computed that the %dth fibonacci number is - %d\n",thread_num,n,nth_fib_value);  
    }
    

    private long multi_fib_compute(int m)
    {
        if(m<=1)
            return m;
        
        //System.out.println(Thread.activeCount());
        
        int max_threads = Runtime.getRuntime().availableProcessors();    
        int active=Thread.activeCount();
        
        if(active > max_threads)
             return serial_fib_compute(m);
 

        Fibonacci a=new Fibonacci(active, m-1,"thread");
        a.start();
 
        long b=multi_fib_compute(m-2); 
        
        try {
            a.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fibonacci.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   
        return a.get_value()+b;
    }
    
 
    
    
    long serial_fib_compute(long m)
    {
        if(m<=1)
            return m;
        
         
        long a=serial_fib_compute(m-1); 
        long b=serial_fib_compute(m-2);
   
        return a+b;
    }
}
