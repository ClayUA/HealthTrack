package chocan;
//Mason Berger AUTHOR!!
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EditMemberRecordTest {
	EditMemberRecord edit;
	String filePath, name, num, address, city, state, zip;

	@BeforeEach
	void setUp() throws Exception {
		edit = new EditMemberRecord();
	}

	@Test
	void test() {
		filePath = "src/chocan/members.txt";
		name = "John";
		num = "32323";
		address = "333 Holly Lane";
		city = "Birmingham";
		state = "AL";
		zip = "35214";
		edit.editRecord(filePath, num, name, address, city, state, zip);
	}
	@Test
	void test2() {
		filePath = "src/chocan/members.txt";
		name = "Mason";
		num = "35223";
		address = "3805 North Woodridge Road";
		city = "Birmingham";
		state = "AL";
		zip = "35223";
		edit.editRecord(filePath, num, name, address, city, state, zip);
	}
	@Test
	void test3() {
		filePath = "src/chocan/members.txt";
		name = "Bob";
		num = "158123";
		address = "ABC road";
		city = "Jacksonville";
		state = "AL";
		zip = "12345";
		edit.editRecord(filePath, num, name, address, city, state, zip);
	}
}

