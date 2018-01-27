package implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import enums.Level;
import interfaces.Duel;
import interfaces.Tournament;

/**
 * <p>
 * Created on Jan 26, 2018
 *
 * @author IdeFFiX
 */

public class DefaultTournamentTest {

	Tournament<String> tournament;

	@Before
	public void setUp() {
		tournament = new DefaultTournament<>();
	}

	@Test
	public void shouldBeStarted() {
		// given
		// when
		tournament.start();
		// then
		assertTrue(tournament.isStarted());
	}

	@Test
	public void shouldNotBeStarted() {
		// given
		// when
		// then
		assertFalse(tournament.isStarted());
	}

	@Test
	public void shouldBeFinished() {
		// given
		String[] participants = { "p1", "p2" };
		tournament.addParticipants(participants);
		tournament.start();
		// when
		Duel<String> tFinal = tournament.getFinal();
		tFinal.setWinner(tFinal.getParticipants().get(0));
		// then
		assertTrue(tournament.isFinished());
	}

	@Test
	public void shouldNotBeFinished() {
		// given
		String[] participants = { "p1", "p2" };
		tournament.addParticipants(participants);
		// when
		tournament.start();
		// then
		assertFalse(tournament.isFinished());
	}

	@Test
	public void shouldAddParticipant() {
		// given
		String p1 = "p1";
		// when
		boolean result = tournament.addParticipant(p1);
		// then
		assertTrue(result);
		assertTrue(tournament.getParticipants().contains(p1));
	}

	@Test
	public void shouldAddParticipantsArray() {
		// given
		String[] participants = { "p1", "p2" };
		// when
		boolean result = tournament.addParticipants(participants);
		// then
		assertTrue(result);
		assertTrue(tournament.getParticipants().containsAll(Arrays.asList(participants)));
	}

	@Test
	public void shouldAddParticipantsIterable() {
		// given
		String p1 = "p1";
		String p2 = "p2";
		List<String> participants = new ArrayList<>();
		participants.add(p1);
		participants.add(p2);
		// when
		boolean result = tournament.addParticipants(participants);
		// then
		assertTrue(result);
		assertTrue(tournament.getParticipants().contains(p1));
		assertTrue(tournament.getParticipants().contains(p2));
	}

	@Test
	public void shouldNotAddTheSameParticipantsOneByOne() {
		String p1 = "p1";
		String p2 = p1;
		// when
		boolean p1Result = tournament.addParticipant(p1);
		boolean p2Result = tournament.addParticipant(p2);
		// then
		assertTrue(p1Result);
		assertFalse(p2Result);
		assertTrue(tournament.getParticipants().contains(p1));
		assertEquals(tournament.getParticipantsCount(), 1);
	}

	@Test
	public void shouldNotAddTheSameParticipantsArray() {
		String p1 = "p1";
		String p2 = p1;
		String[] participants = { p1, p2 };
		// when
		boolean result = tournament.addParticipants(participants);
		// then
		assertFalse(result);
		assertTrue(tournament.getParticipants().contains(p1));
		assertEquals(tournament.getParticipantsCount(), 1);
	}

	@Test
	public void shouldNotAddTheSameParticipantsIterable() {
		String p1 = "p1";
		String p2 = p1;
		List<String> participants = new ArrayList<>();
		participants.add(p1);
		participants.add(p2);
		// when
		boolean result = tournament.addParticipants(participants);
		// then
		assertFalse(result);
		assertTrue(tournament.getParticipants().contains(p1));
		assertEquals(tournament.getParticipantsCount(), 1);
	}

	@Test
	public void shouldAddDuel() {
		// given
		Duel<String> duel = new DefaultDuel<>();
		duel.addParticipant("p1");
		duel.addParticipant("p2");
		// when
		boolean result = tournament.addDuel(duel);
		// then
		assertTrue(result);
		assertTrue(tournament.getDuels().contains(duel));
	}

	@Test
	public void shouldNotAddDuel() {
		// given
		Duel<String> duel = null;
		// when
		boolean result = tournament.addDuel(duel);
		// then
		assertFalse(result);
	}

	@Test
	public void shouldRemoveDuel() {
		// given
		Duel<String> duel = new DefaultDuel<>();
		duel.addParticipant("p1");
		duel.addParticipant("p2");
		tournament.addDuel(duel);
		// when
		boolean result = tournament.removeDuel(duel);
		// then
		assertTrue(result);
		assertFalse(tournament.getDuels().contains(duel));
	}

	@Test
	public void shouldNotRemoveDuel() {
		// given
		Duel<String> addedDuel = new DefaultDuel<>();
		Duel<String> notAddedDuel = new DefaultDuel<>();
		tournament.addDuel(addedDuel);
		// when
		boolean result = tournament.removeDuel(notAddedDuel);
		// then
		assertFalse(result);
		assertTrue(tournament.getDuels().contains(addedDuel));
		assertFalse(tournament.getDuels().contains(notAddedDuel));
	}

	@Test
	public void shouldRemoveParticipant() {
		String p1 = "p1";
		String p2 = "p2";
		String[] participants = { p1, p2 };
		tournament.addParticipants(participants);
		// when
		boolean result = tournament.removeParticipant(p1);
		// then
		assertTrue(result);
		assertFalse(tournament.getParticipants().contains(p1));
		assertTrue(tournament.getParticipants().contains(p2));
	}

	@Test
	public void shouldNotRemoveParticipant() {
		String p1 = "p1";
		String p2 = "p2";
		String[] participants = { p1, p2 };
		tournament.addParticipants(participants);
		// when
		boolean result = tournament.removeParticipant(null);
		// then
		assertFalse(result);
		assertTrue(tournament.getParticipants().contains(p1));
		assertTrue(tournament.getParticipants().contains(p2));
	}

	@Test
	public void shouldReturnParticipantsCount() {
		String p1 = "p1";
		String p2 = "p2";
		String[] participants = { p1, p2 };
		tournament.addParticipants(participants);
		// when
		int count = tournament.getParticipantsCount();
		// then
		assertEquals(2, count);
	}

	@Test
	public void shouldReturnParticipantsList() {
		String p1 = "p1";
		String p2 = "p2";
		String[] participants = { p1, p2 };
		tournament.addParticipants(participants);
		// when
		List<String> participantsList = tournament.getParticipants();
		// then
		assertEquals(2, participantsList.size());
	}
	
	@Test
	public void shouldGetDuels() {
		// given
		String[] participants = { "p1", "p2", "p3", "p4" };
		tournament.addParticipants(participants);
		tournament.start();
		// when
		List<Duel<String>> duels = tournament.getDuels();
		// then
		assertEquals(3, duels);
	}
	
	@Test
	public void shouldGetDuelsOnSpecificLevelUsingEnum() {
		// given
		String[] participants = { "p1", "p2", "p3", "p4" };
		tournament.addParticipants(participants);
		tournament.start();
		// when
		List<Duel<String>> duels = tournament.getDuels(Level.SEMI_FINAL);
		// then
		assertEquals(2, duels.size());
	}
	
	@Test
	public void shouldGetDuelsOnSpecificLevelUsingInt() {
		// given
		String[] participants = { "p1", "p2", "p3", "p4" };
		tournament.addParticipants(participants);
		tournament.start();
		// when
		List<Duel<String>> duels = tournament.getDuels(2);
		// then
		assertEquals(2, duels.size());
	}
	
	@Test
	public void shouldReturnEmptyListOfDuels() {
		// given
		String[] participants = { "p1", "p2", "p3", "p4" };
		tournament.addParticipants(participants);
		tournament.start();
		// when
		List<Duel<String>> duels = tournament.getDuels(Level.QUARTEL_FINAL);
		// then
		assertEquals(0, duels.size());
	}
	
	@Test
	public void shouldReturnAllDuelsAssossiatedWithParticipant() {
		// given
		String p1 = "p1";
		String p2 = "p2";
		String p3 = "p3";
		String p4 = "p4";
		String[] participants = { p1, p2, p3, p4 };
		tournament.addParticipants(participants);
		tournament.start();
		List<Duel<String>> semiFinalDuels = tournament.getDuels(Level.SEMI_FINAL);
		String winnerFromFirstMatch = semiFinalDuels.get(0).getParticipants().get(0);
		semiFinalDuels.get(0).setWinner(winnerFromFirstMatch);
		// when
		List<Duel<String>> winnerDuels = tournament.getDuels(winnerFromFirstMatch);
		// then
		assertEquals(2, winnerDuels.size());
	}
	
	@Test
	public void shouldReturnEmptyListWithDuelsWhenOther() {
		// given
		String[] participants = { "p1", "p2", "p3", "p4" };
		String notParticipant = "not";
		tournament.addParticipants(participants);
		tournament.start();
		// when
		List<Duel<String>> duels = tournament.getDuels(notParticipant);
		// then
		assertEquals(0, duels.size());	
	}
	
	@Test
	public void shouldReturn0TournamentLevelWhenTournamentIsEmpty() {
		// given
		tournament.start();
		// when
		int tournamentLevel = tournament.getTournamentLevel();
		// then
		assertEquals(0, tournamentLevel);	
	}
	
	@Test
	public void shouldReturn1TournamentLevelWhenTournament2Participants() {
		// given
		String[] participants = { "p1", "p2" };
		tournament.addParticipants(participants);
		tournament.start();
		// when
		int tournamentLevel = tournament.getTournamentLevel();
		// then
		assertEquals(1, tournamentLevel);	
	}
	
	@Test
	public void shouldReturn2TournamentLevelWhenTournament3Participants() {
		// given
		String[] participants = { "p1", "p2" };
		tournament.addParticipants(participants);
		tournament.start();
		// when
		int tournamentLevel = tournament.getTournamentLevel();
		// then
		assertEquals(2, tournamentLevel);	
	}
	
	@Test
	public void shouldReturn1TournamentLevelWhenTournament4Participants() {
		// given
		String[] participants = { "p1", "p2" };
		tournament.addParticipants(participants);
		tournament.start();
		// when
		int tournamentLevel = tournament.getTournamentLevel();
		// then
		assertEquals(2, tournamentLevel);	
	}
	
	@Test
	public void shouldReturn3TournamentLevelWhenTournament5Participants() {
		// given
		String[] participants = new String[5];
		for (int i = 0; i < 5; i++) {
			participants[i] = new String();
		}
		tournament.addParticipants(participants);
		tournament.start();
		// when
		int tournamentLevel = tournament.getTournamentLevel();
		// then
		assertEquals(3, tournamentLevel);	
	}
	
	@Test
	public void shouldReturn3TournamentLevelWhenTournament8Participants() {
		// given
		String[] participants = new String[8];
		for (int i = 0; i < 8; i++) {
			participants[i] = new String();
		}
		tournament.addParticipants(participants);
		tournament.start();
		// when
		int tournamentLevel = tournament.getTournamentLevel();
		// then
		assertEquals(3, tournamentLevel);	
	}
	
	@Test
	public void shouldReturn4TournamentLevelWhenTournament9Participants() {
		// given
		String[] participants = new String[9];
		for (int i = 0; i < 9; i++) {
			participants[i] = new String();
		}
		tournament.addParticipants(participants);
		tournament.start();
		// when
		int tournamentLevel = tournament.getTournamentLevel();
		// then
		assertEquals(3, tournamentLevel);	
	}
	
	@Test
	public void shouldReturnFinalDuel() {
		// given
		String[] participants = { "p1", "p2" };
		tournament.addParticipants(participants);
		tournament.start();
		// when
		Duel<String> tFinal = tournament.getFinal();
		// then
		assertTrue(tFinal.getParticipants().contains(participants[0]));
		assertTrue(tFinal.getParticipants().contains(participants[1]));
	}
	
	@Test
	public void shouldReturnWinnerOfTournament() {
		// given
		String p1 = "p1";
		String p2 = "p2";
		String[] participants = { p1, p2 };
		tournament.addParticipants(participants);
		tournament.getFinal().setWinner(p1);
		// when
		String winner = tournament.getWinner();
		// then
		assertSame(p1, winner);	
	}
	
	@Test
	public void shouldNotReturnWinnerOfTournament() {
		// given
		String p1 = "p1";
		String p2 = "p2";
		String[] participants = { p1, p2 };
		tournament.addParticipants(participants);
		// when
		String winner = tournament.getWinner();
		// then
		assertNull(winner);
	}

}
