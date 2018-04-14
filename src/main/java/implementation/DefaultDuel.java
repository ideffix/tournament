/**
 * 
 */
package implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import enums.Level;
import interfaces.Duel;

/**
 * @author ideff
 *
 */
public class DefaultDuel<T> implements Duel<T> {
	
	private T winner;
	
	private List<T> participants = new ArrayList<>();
	
	private Duel<T> leftDuelNode;
	
	private Duel<T> rightDuelNode;
	
	private Duel<T> winnerDuel;
	
	private Level level = Level.ZERO;
	
	private Long id;

	@Override
	public void setWinner(T t) {
		winner = t;
		if (winnerDuel != null) {
			winnerDuel.addParticipant(t);
		}
	}

	@Override
	public T getWinner() {
		return winner;
	}

	@Override
	public List<T> getParticipants() {
		return participants;
	}

	@Override
	public boolean addParticipant(T t) {
		if (participants.size() >= 2 || participants.contains(t)) {
			return false;
		} else {
			return participants.add(t);
		}
	}

	@Override
	public boolean addParticipants(Collection<T> collection) {
		if (validate(collection)) {
			return participants.addAll(collection);
		} else {
			return false;
		}
	}

	private boolean validate(Collection<T> collection) {
		return validateInputCollection(collection) && validateWithExistingParticipants(collection);
	}

	private boolean validateInputCollection(Collection<T> collection) {
		Set<T> copy = new HashSet<>(collection);
		return copy.size() == collection.size();
	}

	private boolean validateWithExistingParticipants(Collection<T> collection) {
		Set<T> collect = Stream.concat(participants.stream(), collection.stream()).collect(Collectors.toSet());
		return collect.size() == participants.size() + collection.size();
	}

	@Override
	public boolean removeParticipant(T t) {
		return participants.remove(t);
	}

	@Override
	public Duel<T> getLeftNodeDuel() {
		return leftDuelNode;
	}

	@Override
	public Duel<T> getRightNodeDuel() {
		return rightDuelNode;
	}

	@Override
	public void setLeftNodeDuel(Duel<T> t) {
		leftDuelNode = t;
	}

	@Override
	public void setRightNodeDuel(Duel<T> t) {
		rightDuelNode = t;
	}

	@Override
	public Duel<T> getWinnerDuel() {
		return winnerDuel;
	}

	public void setWinnerDuel(Duel<T> duel) {
		winnerDuel = duel;
	}

	@Override
	public Level getLevel() {
		return level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public void setParticipants(List<T> participants) {
		this.participants = participants;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
