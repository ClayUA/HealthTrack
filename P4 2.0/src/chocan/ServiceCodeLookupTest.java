package chocan;
//Alex Seidel
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServiceCodeLookupTest {
	
	ServiceCodeLookup tester;

	@BeforeEach
	void setUp() throws Exception {
		tester = new ServiceCodeLookup();
	}

	@Test
	void test1() {
		//valid number, should run
		String number = "888888";
		tester.validateCode(number);
	}
	
	@Test
	void test2() {
		//code does not exist
		String number = "987675";
		tester.validateCode(number);
	}
	
	@Test
	void test3() {
		//code is wrong length
		String number = "9";
		tester.validateCode(number);
	}

}
