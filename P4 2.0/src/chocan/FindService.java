package chocan;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FindService 
extends JFrame 
implements ActionListener {
    private Container c;
    private JLabel numLabel, res;
    private JTextField num;
    private JButton submit, reset, back;
    private String numCheck = "\\d{9}";
    public boolean decision = true;
	public String name, id, address, city, state, zip;
	public String serviceName, serviceID, servicePrice, foundService;
	public String mName;
	public String pName, pID;
	public String serviceDate, currDT, comments; 
	private String provFile, memFile, dirFile, serviceFile;
	
	
	
	public static void appendUsingPrintWriter(String filePath, String text) {
		File file = new File(filePath); 
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String accessRecord(String filePath, String number) {
		String fullString = "";
		String tempFile = "temp.txt";
		provFile = "src/chocan/providers.txt";
		memFile = "src/chocan/members.txt";
		dirFile = "src/chocan/directory.txt";
		serviceFile = "src/chocan/servicesprovided.txt";
		File oldFile = new File(filePath);
		File newFile = new File(tempFile);
		
		String currentLine;
		

		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			
			if ((filePath == provFile) || (filePath == memFile)) {
				String data[];
				if (!decision) {
					while ((currentLine = br.readLine()) != null) {
						data = currentLine.split(",");
						if (data[0].equalsIgnoreCase(number)) {
							id = data[0];
							name = data[1];
							address = data[2];
							city = data[3];
							state = data[4];
							zip = data[5];
							pw.flush();
							pw.close();
							fr.close();
							br.close();
							bw.close();
							fw.close();
							FindService p = new FindService();
							p.decision = false;
							
							fullString = "Name: " + name + "\n" + "ID Number: " + id + "\n" + "Address: " + address 
										+ "\n" + "City: " + city + "\n" + "State: " + state + "\n" + "Zip Code: " + zip + "\n"
										+ "---------------------------" + "\n" + p.accessRecord(serviceFile, data[0]);
							

							
							return fullString;
							
						}
					}
				}
			}
			else if (filePath == serviceFile) {
				String data[];
				setVisible(false);
				if (!decision) {
					while ((currentLine = br.readLine()) != null) {
						data = currentLine.split(",");
						if (data[0].equalsIgnoreCase(number)) {
							serviceDate = data[2];
							currDT = data[3];
							comments = data[5];
							serviceID = data[4];
							
							pw.flush();
							pw.close();
							fr.close();
							br.close();
							bw.close();
							fw.close();
							
							FindService p = new FindService();
							p.decision = false;
							p.accessRecord(provFile, data[1]); 
							pName = p.name;
							
							pw.flush();
							pw.close();
							fr.close();
							br.close();
							bw.close();
							fw.close();
							
							FindService s = new FindService();
							s.decision = false;
							
							fullString = "Provider Name: " + pName + "\n" + "Service Date: " + serviceDate + "\n";
							
							return fullString;
						}
					}
				}
				
				
			}
			else if (filePath == dirFile) {
				String data[];
				setVisible(false);
				if (!decision) {
					while ((currentLine = br.readLine()) != null) {
						data = currentLine.split(",");
						if (data[0].equalsIgnoreCase(number)) {
							serviceID = data[0];
							serviceName = data[1];
							servicePrice = data[2];
							
							fullString = "Service Name: " + serviceName + "\n" /* + "Service Code: " + serviceID + "\n" + "Price: " 
									+ servicePrice + "\n" */;
							
							pw.flush();
							pw.close();
							fr.close();
							br.close();
							bw.close();
							fw.close();
							
							return fullString;
							
						}
					}
				}
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
		
			
		} catch (Exception e) {
			
		} 
		return fullString;
	}
	
	public FindService() {
	    setTitle("Enter Number");
	    setBounds(300, 300, 550, 200);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    c = getContentPane();
        c.setLayout(null);
       
        numLabel = new JLabel("Member/Provider Number");
        numLabel.setSize(300, 30);
        numLabel.setLocation(75, 50);
        c.add(numLabel);
        
        num = new JTextField(9);
        num.setSize(250, 30);
        num.setLocation(240, 50);
        c.add(num);
        
        submit = new JButton("Submit");
        submit.setSize(100, 20);
        submit.setLocation(115, 120);
        submit.addActionListener(this);
        c.add(submit);
        
        reset = new JButton("Reset");
        reset.setSize(100, 20);
        reset.setLocation(240, 120);
        reset.addActionListener(this);
        c.add(reset);
        
        back = new JButton("Back");
        back.setSize(120, 20);
        back.setLocation(355, 120);
        back.addActionListener(this);
        c.add(back);
        
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 14));
        res.setSize(500, 25);
        res.setLocation(100, 85);
        c.add(res);

        
        setVisible(true);
	}
	
	String findService() {
		String numData = null;
		while (numData == null) {
			if (num.getText().length() == 9 && num.getText().matches(numCheck)) {
		        numData = num.getText();
		        res.setText("");
		        // setVisible(false);
		        // provider mode when decision = true, member mode when decision = false
		        if (!decision) {
		        	ValidateNumber validP = new ValidateNumber();
		        	validP.decision = false;
		        	if (validP.validateNumber(numData)) {
			        	FindService f = new FindService();
			        	f.decision = false;
			        	FindService s = new FindService();
			        	s.decision = false;
			        	FindService d = new FindService();
			        	d.decision = false;
				        appendUsingPrintWriter("src/chocan/test.txt", f.accessRecord(memFile, numData));
				        appendUsingPrintWriter("src/chocan/test.txt", s.accessRecord(serviceFile, numData));
				        appendUsingPrintWriter("src/chocan/test.txt", d.accessRecord(dirFile, s.serviceID));
		        	}
		        	else {
		        		res.setText("Number does not exist.");
		        	}

		        }
		        else {
		        	ValidateNumber validM = new ValidateNumber();
		        	validM.decision = true;
		        	if (validM.validateNumber(numData)) {
		        		setVisible(false);
		        		EditMemberRecord editM = new EditMemberRecord();
				        editM.userNumber = numData; 
		        	}
		        	else {
		        		res.setText("Number does not exist.");
		        	}
		        	
		        }
		        
		    }
		    else {
		        res.setText("Please correct form");
		        break;
		    }
		}
		
		return numData;
	}

	
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit) {
        	setVisible(false);
        	findService();
            
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            num.setText(def);
        }
        else if (e.getSource() == back) {
        	setVisible(false);
        	ManagerGUI mGUI = new ManagerGUI();
        }
 


	

		
		
		
	}

}