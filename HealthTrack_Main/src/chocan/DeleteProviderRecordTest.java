package chocan;
//Alex Seidel 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteProviderRecordTest {
	DeleteProviderRecord delete;
	String file = "src/chocan/providers.txt";
	String number;
	String delimiter = ",";
	int position = 0;

	@BeforeEach
	void setUp() throws Exception {
		delete = new DeleteProviderRecord();
	}

	@Test
	void test1() {
		// provider does not exist, does not get deleted
		number = "987654321";
		delete.deleteRecord(file, number, position, delimiter);
	}
	
	@Test
	void test2() {
		// wrong length, all integers, does not get deleted
		number = "99987";
		delete.deleteRecord(file, number, position, delimiter);
	}
	
	@Test
	void test3() {
		// wrong length, not all integers, does not get deleted
		number = "765tgh";
		delete.deleteRecord(file, number, position, delimiter);
	}
	
	@Test
	void test4() {
		// member exists, gets deleted
		number = "777373737";
		delete.deleteRecord(file, number, position, delimiter);
	}

}
