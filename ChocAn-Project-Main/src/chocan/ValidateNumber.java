package chocan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

// Aniyah Curry

/**
 * ValidateNumber class. Verifies whether a member/provider number is valid or not
 * @author aniyahcurry
 */
public class ValidateNumber {
	
	// decision = true (provider file used)
	// decision = false (member file used)
	/**
	 * decision indicates which "mode" the method must act in (aka which file is checked): member (false) or provider (true) "mode"
	 */
	public boolean decision = true;
	public boolean valid;

	/**
	 * Checks if number is valid (exists) or not 
	 * @param number member/provider number provided as input by the user
	 * @return returns true or false based on whether the number exists in the corresponding file
	 */
	boolean validateNumber(String number) {
		
		if (decision) {
			int newPosition = 0;
			String tempFile = "temp.txt";
			/*
			File oldFile = new File("src/chocan/providers.txt");
			File newFile = new File(tempFile);
			*/
			
			String currentLine;
			String data[];
			
			try {
				FileWriter fw = new FileWriter(tempFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				FileReader fr = new FileReader("src/chocan/providers.txt");
				BufferedReader br = new BufferedReader(fr);
				
				while ((currentLine = br.readLine()) != null) {
					data = currentLine.split(",");
					if (data[newPosition].equalsIgnoreCase(number)) {
						valid = true;
						break;
					}
					else {
						valid = false;
					}
				}
				
				pw.flush();
				pw.close();
				fr.close();
				br.close();
				bw.close();
				fw.close();
				
				/*oldFile.delete();
				File update = new File("src/chocan/providers.txt");
				newFile.renameTo(update);
				*/
				
			} catch (Exception e) {
				
			} 
		}
		else {
			int newPosition = 0;
			String tempFile = "temp.txt";
			/*
			File oldFile = new File("src/chocan/members.txt");
			File newFile = new File(tempFile);
			*/
			
			String currentLine;
			String data[];
			
			
			
			
			try {
				FileWriter fw = new FileWriter(tempFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				FileReader fr = new FileReader("src/chocan/members.txt");
				BufferedReader br = new BufferedReader(fr);
				
				while ((currentLine = br.readLine()) != null) {
					data = currentLine.split(",");
					if (data[newPosition].equalsIgnoreCase(number)) {
						valid = true;
						break;
					}
					else {
						valid = false;
					}
				}
				
				pw.flush();
				pw.close();
				fr.close();
				br.close();
				bw.close();
				fw.close();
				
				/*
				oldFile.delete();
				File update = new File("src/chocan/members.txt");
				newFile.renameTo(update);
				*/
				
			} catch (Exception e) {
				
			} 
		}
		
		
		return valid;
		
	}
	
}

class Validate {
	public static void main(String[] args) throws Exception {
		ValidateNumber f = new ValidateNumber();
	}

}