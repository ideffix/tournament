package interfaces;
import java.util.Collection;
import java.util.List;

import enums.Level;

/**
 * @author ideff
 *
 */
public interface Duel<T> {

	/**
	 * 
	 * @param t Duel winner
	 */
	void setWinner(T t);
	
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
	 * @param participants to set
	 */
	void setParticipants(List<T> participants);
	
	/**
	 * 
	 * Adds participant to duel. Duel can contains only 2 participants.
	 * 
	 * @param t Participant to add
	 * @return True if ok, false if error
	 */
	boolean addParticipant(T t);
	
	/**
	 * Adds participants to duel. Duel can contains only 2 participants.
	 * 
	 * @param iterator Collection of participants
	 * @return True if ok, false if error
	 */
	boolean addParticipants(Collection<T> iterator);
	
	/**
	 * Removing participant from duel, using equals() method.
	 * 
	 * @param t Participant to remove
	 * @return True if ok, false if error
	 */
	boolean removeParticipant(T t);
	
	/**
	 * 
	 * @return Left node duel, null if absent
	 */
	Duel<T> getLeftNodeDuel();
	
	/**
	 * 
	 * @return Right node duel, null if absent
	 */
	Duel<T> getRightNodeDuel();
	
	/**
	 * 
	 * @param t Duel to set
	 */
	public void setLeftNodeDuel(Duel<T> t);
	
	/**
	 * 
	 * @param t Duel to set
	 */
	public void setRightNodeDuel(Duel<T> t);
	
	/**
	 * 
	 * @return Winner duel, null if current duel is final
	 */
	Duel<T> getWinnerDuel();
	
	/**
	 * 
	 * @return Level of tournament
	 */
	Level getLevel();
	
	/**
	 * 
	 * @return id of duel
	 */
	Long getId();
	
	/**
	 * 
	 * @param id to set
	 */
	void setId(Long id);
	
	/**
	 * 
	 * @return metadata of duel
	 */
	String getMetadata();
	
	/**
	 * 
	 * @param metadata to set
	 */
	void setMetadata(String metadata);
	
}
