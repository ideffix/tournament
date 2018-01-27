/**
 * 
 */
package implementation;

import java.util.Iterator;
import java.util.List;

import enums.Level;
import interfaces.Duel;
import interfaces.Tournament;

/**
 * @author ideff
 *
 */
public class DefaultTournament<T> implements Tournament<T> {

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addParticipant(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addParticipants(Iterable<T> participants) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addParticipants(T[] participants) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDuel(Duel<T> duel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDuel(Duel<T> duel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeParticipant(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getParticipantsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> getParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Duel<T>> getDuels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Duel<T>> getDuels(int level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Duel<T>> getDuels(Level level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Duel<T>> getDuels(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTournamentLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Duel<T> getFinal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
