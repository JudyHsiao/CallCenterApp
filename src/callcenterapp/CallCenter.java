package callcenterapp;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
* The class CallCenter simulate  a a call center which contruct by three levels of employees: fresher, technical lead (TL), product manager (PM).
* There can be multiple employees, but only one TL or PM. 
* It aslo defined its protocol of answering a call in the serveCall method
*/
public class CallCenter {
    Queue <Employee> freshers;
    Queue <Employee> TL ;
    Queue <Employee> PM ;
    
   /**
    * Constructs  a CallCenter object by a given PM, a TL, and  multiple freshers
    * 
     * @param PM PM of the call center
     * @param TL TL of the call center
     * @param freshers freshers of the call center
     * @see  Employee
    */
    public CallCenter(Employee PM, Employee TL, Employee[] freshers) {
        this.freshers =  new ConcurrentLinkedQueue<>(Arrays.asList(freshers));
        this.TL =  new ConcurrentLinkedQueue<>();
        this.PM =  new ConcurrentLinkedQueue<>();
           
        this.TL.add(TL);
        this.PM.add(PM);
    }
    
    /**
    * Define the protocol of answering a call.
    * 
    * <ol>
    * <li> An incoming telephone call must be allocated to a fresher who is free.
    * <li> If no freshers are free, or if the current fresher is unable to solve the caller’s problem (determined by a simple dice roll), he or she must escalate the call to technical lead.
    * <li> If the TL is not free or not able to handle it, then the call should be escalated to the PM.
    * <li> If the PM is not free, then the call would be ended.
    * <li> If the PM is not free, then the call would be ended.
    * </ol>
    * 
    * @param call a dial in call
    * @return whether the call is soleved
    * @see Call
    */
    public boolean serveCall(Call call) {
        
        if (dispatch (call, "fresher", freshers)) {
            return true;
        }
             
        if (dispatch (call, "TL", TL)) {
            return true;
        }
        
        if (dispatch (call, "PM", PM)) {
            return true;
        }
        return false;
    }
    
    
   /**
    * dispach  a call to the queue of  employees.
    *  
    * @param Call a dial in call
    * @param queue the queue to dispatch
    * @return whether the call is soleved
    * @see Call
    */
    private boolean dispatch (Call call, String typeName, Queue<Employee> queue) {
        // take an employee from free list
        Employee answerer = queue.poll();
        
        if ( answerer != null) {
            System.out.printf("Employee(%s) answers the call(%d) \n",answerer.id, call.id);
            boolean result = answerer.solve(call);            
            
            // put pack the answerer to free list
            queue.add(answerer);
            System.out.printf("Employee(%s) ends the call(%d) \n",answerer.id, call.id);
            return result;
        } else{
            System.out.printf("No %s available to answer the call(%d)\n", typeName, call.id);     
        }
        return false;
    }
}