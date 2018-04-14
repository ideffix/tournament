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
import interfaces.Tournament;
import starter.TournamentStarter;

/**
 * @author ideff
 *
 */
public class DefaultTournament<T> implements Tournament<T> {
	
	private boolean started;
	
	private List<T> participants = new ArrayList<>();
	
	private List<Duel<T>> duels = new ArrayList<>();
	
	private TournamentStarter<T> starter = new TournamentStarter<>(this);
	
	private Duel<T> tournamentFinal;
	
	private Level level = Level.ZERO;

	@Override
	public void start() {
		starter.start();
	}

	@Override
	public boolean isStarted() {
		return started;
	}

	@Override
	public boolean isFinished() {
		if (getFinal() == null) {
			return false;
		}
		return getFinal().getWinner() != null;
	}

	@Override
	public boolean addParticipant(T t) {
		if (validate(t)) {
			return participants.add(t);
		}
		return false;
	}	

	@Override
	public boolean addParticipants(Collection<T> participants) {
		if (validate(participants)) {
			return this.participants.addAll(participants);
		}
		return false;
	}
	
	private boolean validate(Collection<T> collection) {
		return !isStarted() && validateInputCollection(collection) && validateWithExistingParticipants(collection);
	}
	
	private boolean validate(T participant) {
		return !isStarted() && !participants.contains(participant);
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
	public boolean addDuel(Duel<T> duel) {
		if (duel == null || isStarted() || duels.contains(duel)) {
			return false;
		}
		return duels.add(duel);
	}

	@Override
	public boolean removeDuel(Duel<T> duel) {
		if (isStarted()) {
			return false;
		}
		return duels.remove(duel);
	}

	@Override
	public boolean removeParticipant(T t) {
		if (isStarted()) {
			return false;
		}
		return participants.remove(t);
	}

	@Override
	public int getParticipantsCount() {
		return participants.size();
	}

	@Override
	public List<T> getParticipants() {
		return participants;
	}

	@Override
	public List<Duel<T>> getDuels() {
		return duels;
	}

	@Override
	public List<Duel<T>> getDuels(int level) {
		return getDuels(Level.getLevel(level));
	}

	@Override
	public List<Duel<T>> getDuels(Level level) {
		return duels.stream()
				.filter(l -> level.equals(l.getLevel()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Duel<T>> getDuels(T t) {
		return duels.stream()
				.filter(duel -> duel.getParticipants().contains(t))
				.collect(Collectors.toList());
	}

	@Override
	public Level getTournamentLevel() {
		return level;
	}

	@Override
	public Duel<T> getFinal() {
		return tournamentFinal;
	}

	@Override
	public T getWinner() {
		return getFinal() == null ? null : getFinal().getWinner(); 
	}

	public void setTournamentLevel(int level) {
		this.level = Level.getLevel(level);
	}

	public void setTournamentLevel(Level level) {
		this.level = level;	
	}

	public void setFinal(Duel<T> tFinal) {
		this.tournamentFinal = tFinal;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	@Override
	public void setParticipants(List<T> participants) {
		this.participants = participants;	
	}

}
