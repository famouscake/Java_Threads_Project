/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author Peter
 */
public class Threads {
    
    
     static int serial_fibonacci(int m)
    {
        if(m<=1)
            return m;
         
        int a=serial_fibonacci(m-1); 
        int b=serial_fibonacci(m-2);
   
        return a+b;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        
        int n=50;
        long a;
        Tests t=new Tests();
   
        //////////////////////////////////////////////////////////PART 1 

        long time=System.currentTimeMillis();
        
        a=t.run_test_on_dinamic_fib(n);
        
        System.out.printf("It took the threaded algorithm a total of %d miliseconds to compute that!\n",System.currentTimeMillis()-time);
        
        //////////////////////////////////////////////////////////PART 2 

        time=System.currentTimeMillis();
        
        a=t.run_test_on_static_4_fib(n);
        
        System.out.printf("It took the optimized for 4 threads algorithm a total of %d miliseconds to compute that!\n",System.currentTimeMillis()-time);
        
        
        /////////////////////////////////////////////////PART 3 
        
        time=System.currentTimeMillis();
        
        long b=t.run_test_on_serial_fib(n);
        
        System.out.printf("It took the serial algorithm a total of %d miliseconds to compute that!\n",System.currentTimeMillis()-time);
        
        
        //Checking is the result is correct
        if(a==b)
            
            System.out.println("The algorithms works perfectly correct!");
        else
            System.out.println("The algorithms made a mistake :/");
  
    
    
    }
}
