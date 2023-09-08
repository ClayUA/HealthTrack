package chocan;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.util.Arrays;
import java.io.*;
//Imports all used classes
public class Record{
	public void record() {
		//starts position at 0 and reads through .txt file of data and fills it into data[]
		
		
		String line = "";
		String data[];
			
			
		
			try (FileReader fr = new FileReader("src/chocan/members.txt"); BufferedReader br = new BufferedReader(fr)) {
			    
			    while ((line = br.readLine()) != null) {
			    	data = line.split(",");
			    	String member_name = data[1];
					String member_number = data[0];
					String member_street_address = data[2];
					String member_city = data[3];
					String member_state = data[4];
					String member_ZIP = data[5];
					
					FileWriter file = new FileWriter(String.format("src/chocan/m-%s.txt", member_name));
					file.write("member name: ");
					file.write(member_name);
					file.write("\n");
					file.write("member number: "); 
					file.write(member_number);
					file.write("\n");
					file.write("member street address: ");
					file.write(member_street_address);
					file.write("\n");
					file.write("member city: ");
					file.write(member_city);
					file.write("\n");
					file.write("member state: ");
					file.write(member_state);
					file.write("\n");
					file.write("member ZIP: ");
					file.write(member_ZIP);
					file.write("\n");
					file.write("\n\n\n----------------------------------------------------\n\n");
					
					try (FileReader fr2 = new FileReader("src/chocan/servicesprovided.txt"); BufferedReader br2 = new BufferedReader(fr2)) {
							while ((line = br2.readLine()) != null) {
								data = line.split(",");
						    	String memNum = data[0];
								String provNum = data[1];
								String serviceDate = data[2];
								
								String serviceID = data[4];
								
								String provider_name = "";
								String service_name = "";
					
								if(member_number.equals(memNum)) {
									try (FileReader fr3 = new FileReader("src/chocan/providers.txt"); BufferedReader br3 = new BufferedReader(fr3)) {
									    while ((line = br3.readLine()) != null) {
									    	data = line.split(",");
									    	if(data[0].equals(provNum)) {
									    		provider_name = data[1];
									    	}
									    }
									    
								}try (FileReader fr3 = new FileReader("src/chocan/directory.txt"); BufferedReader br3 = new BufferedReader(fr3)) {
								    while ((line = br3.readLine()) != null) {
								    	data = line.split(",");
								    	if(data[0].equals(serviceID)) {
								    		service_name = (data[1]);
								    	}
								    }
							}
								file.write("Date of Service : ");
								file.write(serviceDate);
								file.write("\n");
								file.write("Provider Name : ");
								file.write(provider_name);
								file.write("\n");
								file.write("Service Name : ");
								file.write(service_name);
								file.write("\n");
								
								
					    }
					}
					    
			    }
					file.close();}
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
