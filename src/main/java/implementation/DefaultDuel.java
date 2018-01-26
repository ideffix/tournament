/**
 * 
 */
package implementation;

import java.util.List;

import interfaces.Duel;

/**
 * @author ideff
 *
 */
public class DefaultDuel<T> implements Duel<T>{

	@Override
	public void setWinner(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addParticipant(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addParticipants(Iterable<T> iterator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addParticipants(T[] t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeParticipant(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Duel<T> getLeftNodeDuel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Duel<T> getRightNodeDuel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLeftNodeDuel(Duel<T> t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRightNodeDuel(Duel<T> t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Duel<T> getWinnerDuel() {
		// TODO Auto-generated method stub
		return null;
	}

}
