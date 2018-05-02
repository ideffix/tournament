package starter;

import java.util.List;

import org.apache.commons.collections4.ListUtils;

import enums.Level;
import implementation.DefaultDuel;
import implementation.DefaultTournament;
import interfaces.Duel;
import math.MathUtils;

/**
 * <p>
 * Created on Jan 30, 2018 
 *
 * @author IdeFFiX
 */

public class TournamentStarter<T> {
	
	private DefaultTournament<T> tournament;

	public TournamentStarter(DefaultTournament<T> tournament) {
		this.tournament = tournament;
	}
	
	public void start() {
		tournament.setTournamentLevel(getTournamentLevel());
		tournament.setFinal(createDuel(tournament.getParticipants(), 1));
		tournament.setStarted(true);
		setWinnersIfOnlyOneParticipant();
	}

	private DefaultDuel<T> createDuel(List<T> participants, int level) {
		if (participants.isEmpty()) {
			return null;
		} else if (level == tournament.getTournamentLevel().getLevel()) {
			DefaultDuel<T> duel = new DefaultDuel<>();
			duel.addParticipant(participants.get(0));
			if (participants.size() == 2) {
				duel.addParticipant(participants.get(1));
			}
			duel.setLevel(Level.getLevel(level));
			tournament.addDuel(duel);
			return duel;
		}
		List<List<T>> splitted = ListUtils.partition(participants, (int) Math.ceil((double) participants.size() / 2));
		DefaultDuel<T> duel = new DefaultDuel<>();
		DefaultDuel<T> leftDuel = createDuel(splitted.get(0), level + 1);
		DefaultDuel<T> rightDuel = createDuel(splitted.get(1), level + 1);
		leftDuel.setWinnerDuel(duel);
		rightDuel.setWinnerDuel(duel);
		duel.setLeftNodeDuel(leftDuel);
		duel.setRightNodeDuel(rightDuel);
		duel.setLevel(Level.getLevel(level));
		tournament.addDuel(duel);
		return duel;
	}
	
	private void setWinnersIfOnlyOneParticipant() {
		for (Duel<T> duel : tournament.getDuels(tournament.getTournamentLevel())) {
			if (duel.getParticipants().size() != 2) {
				duel.setWinner(duel.getParticipants().get(0));
			}
		}
	}
	
	private Level getTournamentLevel() {
		if (tournament.getParticipantsCount() == 0) {
			return Level.ZERO;
		}
		return Level.getLevel((int) Math.ceil(MathUtils.log(tournament.getParticipantsCount(), 2)));
	}

}
