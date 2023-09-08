//COMMENTS BY MASON BERGER

package chocan;
import javax.swing.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.util.Arrays;
// Import the FileWriter class
import java.io.*;
//Imports all used classes
public class RecordProvider{
	public void record() {
		
		//starts position at 0 and reads through .txt file of data and fills it into data[]
	//	int newPosition = 0;
		String line = "";
		String data[];
			
			 
		
			try (FileReader fr = new FileReader("src/chocan/providers.txt"); BufferedReader br = new BufferedReader(fr)) {

			    while ((line = br.readLine()) != null) {
			    	
			    	data = line.split(",");
			    	String provider_name = data[1];
					String provider_number = data[0];
					String provider_street_address = data[2];
					String provider_city = data[3];
					String provider_state = data[4];
					String provider_ZIP = data[5];
					
					FileWriter file = new FileWriter(String.format("src/chocan/p-%s.txt", provider_number));
					
					file.write("provider name: ");
					file.write(provider_name);
					file.write("\n");
					file.write("provider number: "); 
					file.write(provider_number);
					file.write("\n");
					file.write("provider street address: ");
					file.write(provider_street_address);
					file.write("\n");
					file.write("provider city: ");
					file.write(provider_city);
					file.write("\n");
					file.write("provider state: ");
					file.write(provider_state);
					file.write("\n");
					file.write("provider ZIP: ");
					file.write(provider_ZIP);
					file.write("\n\n\n----------------------------------------------------\n\n");
					double totalCost = 0;
					int count = 0;
					try (FileReader fr2 = new FileReader("src/chocan/servicesprovided.txt"); BufferedReader br2 = new BufferedReader(fr2)) {
					    while ((line = br2.readLine()) != null) {
					    	
					    	data = line.split(",");
					    	String memNum = data[0];
							String provNum = data[1];
							String serviceDate = data[2];
							String dateRecorded = data[3];
							String serviceID = data[4];
							String comment =data.length>=6? data[5]:"";
							String member_name ="";
							double serviceFee =0;
							if(provNum.equals(provider_number)) {
								try (FileReader fr3 = new FileReader("src/chocan/members.txt"); BufferedReader br3 = new BufferedReader(fr3)) {
								    while ((line = br3.readLine()) != null) {
								    	data = line.split(",");
								    	if(data[0].equals(memNum)) {
								    		member_name = data[1];
								    	}
								    }
							}try (FileReader fr3 = new FileReader("src/chocan/directory.txt"); BufferedReader br3 = new BufferedReader(fr3)) {
							    while ((line = br3.readLine()) != null) {
							    	data = line.split(",");
							    	if(data[0].equals(serviceID)) {
							    		serviceFee = Double.parseDouble(data[2].trim().substring(1));
							    	}
							    }
						}
							file.write("service date: ");
							file.write(serviceDate);
							file.write("\n");
							file.write("date recorded: ");
							file.write(dateRecorded);
							file.write("\n");
							file.write("member name: ");
							file.write(member_name);
							file.write("\n");
							file.write("member number: ");
							file.write(memNum);
							file.write("\n");
							file.write("service ID: ");
							file.write(serviceID);
							file.write("\n");
							file.write("service fee: ");
							file.write(String.format("$%.2f",serviceFee));
							file.write("\n");
							file.write("\n");
							count++;
							totalCost+= serviceFee;
							}
							}
					    }
					file.write("Total Fees : ");
					file.write(String.format("$%.2f",totalCost));
					file.write("\n");
					file.write("number of consultations : ");
					file.write(String.format("%d", count));
					file.write("\n");
					file.close();
					
			    }
			}
			//sets each respective member item with the items in the data[] array
 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		
		//prints and formats info into the file report.txt 

		

	
	//pull from BillChocAn to get record of services 
	}
	

}
