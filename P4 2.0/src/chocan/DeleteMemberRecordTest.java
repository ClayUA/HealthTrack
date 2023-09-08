package chocan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Aniyah Curry
class DeleteMemberRecordTest {
	DeleteMemberRecord delete;
	String file = "src/chocan/members.txt";
	String number;
	String delimiter = ",";
	int position = 0;

	@BeforeEach
	void setUp() throws Exception {
		delete = new DeleteMemberRecord();
	}

	@Test
	void testIncorrect_1() {
		// member does not exist, does not get deleted
		number = "837463726";
		delete.deleteRecord(file, number, position, delimiter);
	}
	
	@Test
	void testIncorrect_2() {
		// wrong length, all integers, does not get deleted
		number = "7365831";
		delete.deleteRecord(file, number, position, delimiter);
	}
	
	@Test
	void testIncorrect_3() {
		// wrong length, not all integers, does not get deleted
		number = "53td";
		delete.deleteRecord(file, number, position, delimiter);
	}
	
	@Test
	void testCorrect() {
		// member exists, gets deleted
		number = "999999999";
		delete.deleteRecord(file, number, position, delimiter);
	}


}
