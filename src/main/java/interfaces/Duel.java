package interfaces;
import java.util.List;

/**
 * 
 */

/**
 * @author ideff
 *
 */
public interface Duel<T> {

	/**
	 * 
	 * @param t Duel winner
	 * @return true if ok, false if error
	 */
	boolean setWinner(T t);
	
	/**
	 * 
	 * @return Winner. Return null if winner is not set
	 */
	T getWinner();
	
	/**
	 * 
	 * @return List of participants
	 */
	List<T> getParticipants();
	
	/**
	 * 
	 * Adds participant to duel. Duel can contains only 2 participants
	 * 
	 * @param t Participant to add
	 * @return True if ok, false if error
	 */
	boolean addParticipant(T t);
	
	/**
	 * 
	 * @param t Participant to remove
	 * @return True if ok, false if error
	 */
	boolean removeParticipant(T t);
	
}
