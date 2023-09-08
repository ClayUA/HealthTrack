package chocan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

// Chandler Norman
// Checks whether number is valid (exists) or not.
public class ServiceCodeLookup {
	public boolean decision = true;
	public String code, serviceName, price;

	boolean validateCode(String number) {
		boolean valid = false;
		
		int newPosition = 0;
		String tempFile = "temp.txt";
		/*
		File oldFile = new File("src/chocan/directory.txt");
		File newFile = new File(tempFile);
		*/
		
		String currentLine;
		String data[];
		
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader("src/chocan/directory.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while ((currentLine = br.readLine()) != null) {
				data = currentLine.split(",");
				if (data[newPosition].equalsIgnoreCase(number)) {
					code = data[0];
					serviceName = data[1];
					price = data[2];
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
		
		
		return valid;
		
	}
	
}

class ValidateCode {
	public static void main(String[] args) throws Exception {
		ServiceCodeLookup f = new ServiceCodeLookup();
	}

}