package implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import interfaces.Duel;

/**
 * <p>
 * Created on Jan 25, 2018 
 *
 * @author IdeFFiX
 */

public class DefaultDuelTest {
	
	Duel<String> duel;
	
	@Before
	public void setUp() {
		duel = new DefaultDuel<>();
	}
	
	@Test
	public void shouldReturnWinner() {
		// given
		String winner = "Winner";
		// when
		duel.setWinner(winner);
		// then
		assertSame(winner, duel.getWinner());
	}
	
	@Test
	public void shouldReturnNull() {
		// given
		// when
		// then
		assertNull(duel.getWinner());
	}
	
	@Test
	public void shouldSuccessfullyAddParticipantOneByOne() {
		// given
		String p1 = "p1";
		String p2 = "p2";
		// when
		boolean p1Result = duel.addParticipant(p1);
		boolean p2Result = duel.addParticipant(p2);
		// then
		assertTrue(p1Result);
		assertTrue(p2Result);
	}
	
	@Test
	public void shouldFailWhenAddingTooMuchParticipantsOneByOne() {
		// given
		String p1 = "p1";
		String p2 = "p2";
		String p3 = "p3";
		String p4 = "p4";
		// when
		boolean p1Result = duel.addParticipant(p1);
		boolean p2Result = duel.addParticipant(p2);
		boolean p3Result = duel.addParticipant(p3);
		boolean p4Result = duel.addParticipant(p4);
		// then
		assertTrue(p1Result);
		assertTrue(p2Result);
		assertFalse(p3Result);
		assertFalse(p4Result);
	}
	
	@Test
	public void shouldFailWhenAddingTheSameParticipantOneByOne() {
		// given
		String p1 = "p1";
		String p1RefCoppy = p1;
		// when
		boolean p1Result = duel.addParticipant(p1);
		boolean p1RefCoppyResult = duel.addParticipant(p1RefCoppy);
		// then
		assertTrue(p1Result);
		assertFalse(p1RefCoppyResult);
		
	}
	
	@Test
	public void shouldSuccessfullyAddArrayOfParticipants() {
		// given
		String[] participants = {"p1", "p2"};
		// when
		boolean result = duel.addParticipants(participants);
		// then
		assertTrue(result);
	}
	
	@Test
	public void shouldFailAddingArrayOfParticipants() {
		// given
		String[] participants = {"p1", "p2", "p3"};
		// when
		boolean result = duel.addParticipants(participants);
		// then
		assertTrue(result);
	}
	
	@Test 
	public void shouldFailAddingArrayOfTheSameParticipants() {
		// given
		String p1 = "p1";
		String p2 = p1;
		String[] participants = {p1 ,p2};
		// when
		boolean result = duel.addParticipants(participants);
		// then
		assertFalse(result);
	}
	
	@Test
	public void shouldSuccessfullyAddCollectionOfParticipants() {
		// given
		List<String> participants = new ArrayList<>();
		participants.add("p1");
		participants.add("p2");
		// when
		boolean result = duel.addParticipants(participants);
		// then
		assertTrue(result);
	}
	
	@Test
	public void shouldFailAddingCollectionOfParticipants() {
		// given
		List<String> participants = new ArrayList<>();
		participants.add("p1");
		participants.add("p2");
		participants.add("p3");
		// when
		boolean result = duel.addParticipants(participants);
		// then
		assertTrue(result);
	}
	
	@Test 
	public void shouldFailAddingCollectionOfTheSameParticipants() {
		// given
		String p1 = "p1";
		String p2 = p1;
		List<String> participants = new ArrayList<>();
		participants.add(p1);
		participants.add(p2);
		// when
		boolean result = duel.addParticipants(participants);
		// then
		assertFalse(result);
	}
	
	@Test
	public void shouldRemoveParticipant() {
		// given
		String p1 = "p1";
		String p2 = "p2";
		String[] participants = {p1, p2};
		duel.addParticipants(participants);
		// when
		boolean result = duel.removeParticipant(p1);
		// then
		assertTrue(result);
		assertFalse(duel.getParticipants().contains(p1));		
	}
	
	@Test
	public void shouldNotRemoveParticipant() {
		// given
		String p1 = "p1";
		String p2 = "p2";
		String p3 = "p3";
		String[] participants = {p1, p2};
		duel.addParticipants(participants);
		// when
		boolean result = duel.removeParticipant(p3);
		// then
		assertFalse(result);		
	}

}
