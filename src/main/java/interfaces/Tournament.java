package interfaces;
import java.util.List;

/**
 * @author ideffx
 *
 */ 
public interface Tournament<T> extends Iterable<T> {
	
	/**
	 * Use this method to start tournament after you add all participants
	 */
	void start();
	
	/**
	 * 
	 * @param t Participant of tournament
	 * @return true if participant has been added, false if not
	 */
	boolean addParticipant(T t);
	
	/**
	 * 
	 * @param participants Participants container
	 * @return true if participant has been added, false if not
	 */
	boolean addParticipants(Iterable<T> participants);
	
	
	/**
	 * 
	 * @param t Participant of tournament
	 * @return true if participant has been removed, false if not
	 */
	boolean removeParticipant(T t);
	
	/**
	 * 
	 * @return Number of participants
	 */
	int getParticipantsCount();
	
	/**
	 * 
	 * @return List of all participants in tournament
	 */
	List<T> getParticipants();
	
	/**
	 * 
	 * @return All duels in tournament on every level
	 */
	List<Duel<T>> getDuels();
	
	/**
	 * 
	 * @param level Level of tournament bracket
	 * @return List of all duels
	 */
	List<Duel<T>> getDuels(int level);
	
	/**
	 * 
	 * @param t Tournament participant
	 * @return List of duels that participant is involved in
	 */
	List<Duel<T>> getDuels(T t);
	
	/**
	 * 
	 * @return Tournament level
	 */
	int getTournamentLevel();
	
	/**
	 * 
	 * @return Final duel
	 */
	Duel<T> getFinal();
	
}
