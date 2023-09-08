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
public class SummaryReport{
	public void record() {
		
		//starts position at 0 and reads through .txt file of data and fills it into data[]
	//	int newPosition = 0;
		String line = "";
		String data[];
		System.out.println("hello");	
			 
		
			try (FileReader fr = new FileReader("src/chocan/providers.txt"); BufferedReader br = new BufferedReader(fr)) {
				FileWriter file = new FileWriter("src/chocan/summaryReport.txt");
				int totalProviders = 0;
				int totalConsults = 0;
				double totalFee = 0;
			    while ((line = br.readLine()) != null) {
			    	
			    	data = line.split(",");
					String provider_number = data[0];
					
					
					double totalCost = 0;
					int count = 0;
					try (FileReader fr2 = new FileReader("src/chocan/servicesprovided.txt"); BufferedReader br2 = new BufferedReader(fr2)) {
					    while ((line = br2.readLine()) != null) {
					    	
					    	data = line.split(",");
							String provNum = data[1];
							String serviceID = data[4];
							double serviceFee =0;
							if(provNum.equals(provider_number)) {
								
							try (FileReader fr3 = new FileReader("src/chocan/directory.txt"); BufferedReader br3 = new BufferedReader(fr3)) {
							    while ((line = br3.readLine()) != null) {
							    	data = line.split(",");
							    	if(data[0].equals(serviceID)) {
							    		serviceFee = Double.parseDouble(data[2].trim().substring(1));
							    	}
							    }
						}
							
							count++;
							totalCost+= serviceFee;
							
							}
							}
					    }
					if(count== 0) {continue;}
					file.write("provider number: "); 
					file.write(provider_number);
					file.write("\n");
					file.write("Total Fees : ");
					file.write(String.format("$%.2f",totalCost));
					file.write("\n");
					file.write("number of consultations : ");
					file.write(String.format("%d", count));
					file.write("\n\n");
					totalProviders++;
					totalConsults+= count;
					totalFee+= totalCost;
					
					
					
			    }
			    file.write("Total Number of Providers : ");
			    file.write(String.format("%d\n", totalProviders));
			    file.write(String.format("Total Number of Consultations : %d\n", totalConsults));
			    file.write(String.format("Total Fee : $%.2f\n", totalFee));
			    file.close();
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
