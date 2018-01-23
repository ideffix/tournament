/**
 * 
 */
package implementation;

import java.util.Iterator;
import java.util.List;

import interfaces.Duel;
import interfaces.Tournament;

/**
 * @author ideff
 *
 */
public class DefaultTournament<T> implements Tournament<T> {

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	public boolean addParticipant(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addParticipants(Iterable<T> participants) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeParticipant(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getParticipantsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<T> getParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Duel<T>> getDuels() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Duel<T>> getDuels(int level) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Duel<T>> getDuels(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTournamentLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Duel<T> getFinal() {
		// TODO Auto-generated method stub
		return null;
	}

}
