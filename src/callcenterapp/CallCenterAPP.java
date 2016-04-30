package callcenterapp;

/**
* The CallCenterApp program simulated numbers of concurrent calls enter to a call center 
* according to the following conditions:
* <ol>
* <li> you have a call center with three levels of employees: fresher, technical lead (TL), product manager (PM).
* <li> There can be multiple employees, but only one TL or PM. 
* <li> An incoming telephone call must be allocated to a fresher who is free. 
* <li> If no freshers are free, or if the current fresher is unable to solve the caller’s problem (determined by a simple dice roll), he or she must escalate the call to technical lead.
* <li> If the TL is not free or not able to handle it, then the call should be escalated to the PM.
* <li> If the PM is not free, then the call would be ended.
* </ol>
*
* @see Call
* @see Employee
* @see CallCenter
*/
public class CallCenterAPP {
    
    static final int NUM_FRESHERS = 5;
    static final int NUM_CALLS = 10;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread[] threads = new Thread[NUM_CALLS];
        Employee PM = new Employee (1, "PM");
        Employee TL = new Employee (0.8, "TL");
        Employee[] freshers = new Employee[NUM_FRESHERS];
        for (int i = 0; i < NUM_FRESHERS ; i++ ) {
            freshers[i] = new  Employee (0.5, "fresher_" + i);
        }
        
        CallCenter callCenter = new CallCenter(PM, TL, freshers);
        for (int i = 0; i < NUM_CALLS ; i++) {
            Runnable call = new Call(i, callCenter);
            threads[i] = new Thread(call);
            threads[i].start();
        }
    }
    
}
