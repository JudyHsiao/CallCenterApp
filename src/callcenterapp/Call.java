package callcenterapp;

/**
* The class Call implements Runnable interface to simulate the concuurent behavior of  calls
*
*/
public class Call implements Runnable {
    public final int id ;
    public final double difficulty;
    public final CallCenter callCenter;
    
    /**
     * Constructs  a Call object by a given id and call center. 
     * The difficity the caller's problem is also randomized in the constructor.
     * 
     * @param id the identifier of each call
     * @param callCenter the serving call center of the call
     * @see CallCenter
     */
    public Call (int id, CallCenter callCenter) {
        this.id = id;
        difficulty = Math.random();
        this.callCenter = callCenter;
    }
    
    /**
     * Make a call to a call center and print out whether the caller's problem is solved.
     *
     */
    @Override
    public void run() {
        System.out.printf("Call(%d) is ringing\n", id);
        boolean result = callCenter.serveCall(this);
        if (result == false) {
            System.out.printf("Call(%d) is not solved\n", id);
        } else {
            System.out.printf("Call(%d) is solved\n", id);
        }
    }
}
