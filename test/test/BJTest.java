package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.common.Dealer;
import com.skilldistillery.cards.common.Deck;

public class BJTest {
	Deck deck; 
	Dealer dealer;
	
	@Before
	public void setUp() {
		deck = new Deck();
		dealer = new Dealer();
	}
	
	@After
	public void tearDown() {
		deck = null;
		dealer = null;
	}
	
	
	@Test
	public void test_deal_card() {
		assertNotNull(deck.dealCard());
		
	}
	
	@Test
	public void text_check_deck_size() {
		deck.checkDeckSize();
		
		
		int expected = deck.checkDeckSize();
		int actual = 52;
		
		assertEquals(expected, actual);
	}
	
//	@Test
//	public void test_dealer_deal_card() {
//		assertNotNull(dealer.dealCard());
//		
//	}
	
	

}
//String input = null;
//String expected = "";
//String actual = newTranslate.translateWord(input);
//assertEquals(expected, actual);