package callcenterapp;

/**
* The class Employee simulates  a employee of a call center who 
* can solve a call problem according to his ability.
*/
public class Employee{
    private final double ability;
    public final String id;
    
    /**
     * Constructs  a Employee object by give ability and id
     * 
     * @param ability a call problem can be soleved if the difficulty of a call is smaller than the employee's ability
     * @param id the identifier of a employee
     */
    public Employee (double ability, String id) {
        this.ability = ability;
        this.id = id;
    }
    
    /**
     * Returns whether a call problem can be solved.
     * 
     * A call problem can be soleved if the difficulty of a call is smaller than the employee's ability
     * If the problem can be solved, return true;
     * Otherwise, return false. 
     * endCall(call) is called before return
     *
     * @param call the call to be answered
     * @return  boolean whether a problem can be solved
     * @see Call
     */
     public boolean solve (Call call) {
        boolean isSolved =  ( call.difficulty  <  ability) ;
        if (isSolved == true) {
            System.out.printf("%s solved Call(%d)\n", id, call.id);
        } else {
            System.out.printf("%s can not solve Call(%d)\n", id, call.id);
        }
        return isSolved;
     }
}
