package chocan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// Aniyah Curry
class GetServiceCodeTest {
	GetServiceCode getCode;
	String number;

	@BeforeEach
	void setUp() throws Exception {
		getCode = new GetServiceCode();
	}

	@Test
	void testIncorrect_1() {
		// code not valid, does not exist
		number = "7y36";
		getCode.num.setText(number);
		assertFalse(getCode.code == number);
	}
	
	@Test
	void testIncorrect_2() {
		// code valid, does not exist
		number = "887465";
		getCode.num.setText(number);
		assertFalse(getCode.code == number);
	}
	
	
	@Test
	void testCorrect() {
		// code valid, exists
		number = "888888";
		getCode.num.setText(number);
		assertTrue(getCode.code == getCode.numData);
		
	}
	

}
