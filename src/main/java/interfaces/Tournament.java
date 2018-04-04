package interfaces;
import java.util.Collection;
import java.util.List;

import enums.Level;

/**
 * @author ideffx
 *
 */ 
public interface Tournament<T> {
	
	/**
	 * Use this method to start tournament after you add all participants
	 */
	void start();
	
	/**
	 * 
	 * @return True if tournament is started, false if not
	 */
	boolean isStarted();
	
	/**
	 * 
	 * @return True if tournament is finished, false if not
	 */
	boolean isFinished();
	
	/**
	 * Adds participant to tournament. Adding is only possible when tournament is not started.
	 * 
	 * @param t Participant of tournament
	 * @return true if participant has been added, false if not
	 */
	boolean addParticipant(T t);
	
	/**
	 * Adds participants to tournament. Adding is only possible when tournament is not started.
	 * 
	 * @param participants Participants container
	 * @return true if participant has been added, false if not
	 */
	boolean addParticipants(Collection<T> participants);
	
	/**
	 * Adds duel to tournament. Adding is only possible when tournament is not started.
	 * 
	 * @param duel Duel to add
	 * @return True if ok, false if error
	 */
	boolean addDuel(Duel<T> duel);
	
	/**
	 * Remove duel from tournament. Removing is only possible when tournament is not started.
	 * 
	 * @param duel Duel to remove
	 * @return true if duel has been removed, false if not
	 */
	boolean removeDuel(Duel<T> duel);
	
	/**
	 * Removing participant from tournament. Removing is only possible when tournament is not started.
	 * 
	 * @param t Participant of tournament.
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
	 * @param level Level of tournament bracket
	 * @return List of all duels
	 */
	List<Duel<T>> getDuels(Level level);
	
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
	Level getTournamentLevel();
	
	/**
	 * 
	 * @return Final duel
	 */
	Duel<T> getFinal();
	
	/**
	 * 
	 * @return Winner of tournament, null if tournament is not ended
	 */
	T getWinner();
	
}
