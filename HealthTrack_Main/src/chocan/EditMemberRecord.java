package chocan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

// Aniyah Curry
// pulls up frames where operator can input member/provider info for edit function

public class EditMemberRecord 
extends JFrame 
implements ActionListener {
    private Container d;
    private JLabel nameLabel, numLabel, addressLabel, cityLabel, stateLabel, zipLabel, res;
    private JTextField name, num, address, city, state, zip;
    private JButton submit, reset, back;
    private static Scanner x;
    public static String userNumber;
    private String numCheck = "\\d{9}";

	
	public static void editRecord(String filePath, String newNum, String newName, String newAddress,
	String newCity, String newState, String newZip) {
		String tempFile = "temp.txt";
		File oldFile = new File(filePath);
		File newFile = new File(tempFile);
		
		String ID = "";
		String name = "";
		String address = "";
		String city = "";
		String state = "";
		String zip = "";
		
		
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File(filePath));
			x.useDelimiter("[,\n]");
		
			while (x.hasNext()) {
				ID = x.next();
				name = x.next();
				address = x.next();
				city = x.next();
				state = x.next();
				zip = x.next();
				if (ID.equals(userNumber)) {
					pw.println(newNum + "," + newName + "," + newAddress + "," + newCity + "," + newState + "," + newZip);
				}
				else {
					pw.println(ID + "," + name + "," + address + "," + city + "," + state + "," + zip);
				}
			
			}
			// GetUserNum getNum = new GetUserNum();
			// getNum.decision = false;
			x.close();
			pw.flush();
			pw.close();
			
			oldFile.delete();
			File update = new File(filePath);
			newFile.renameTo(update);
			
		} catch (Exception e) {
			System.out.println("Error");
		} 
	}
	
	public EditMemberRecord() {        
        setTitle("Edit Member");
	    setBounds(300, 300, 550, 450);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    d = getContentPane();
        d.setLayout(null);
        
        nameLabel = new JLabel("Name");
        nameLabel.setSize(300, 30);
        nameLabel.setLocation(100, 80);
        d.add(nameLabel);
        
        name = new JTextField(25);
        name.setSize(250, 30);
        name.setLocation(210, 80);
        d.add(name);
        
        numLabel = new JLabel("Member Number");
        numLabel.setSize(300, 30);
        numLabel.setLocation(100, 120);
        d.add(numLabel);
        
        num = new JTextField(9);
        num.setSize(250, 30);
        num.setLocation(210, 120);
        d.add(num);
        
        addressLabel = new JLabel("Address");
        addressLabel.setSize(300, 30);
        addressLabel.setLocation(100, 160);
        d.add(addressLabel);
        
        address = new JTextField(25);
        address.setSize(250, 30);
        address.setLocation(210, 160);
        d.add(address);
        
        cityLabel = new JLabel("City");
        cityLabel.setSize(300, 30);
        cityLabel.setLocation(100, 200);
        d.add(cityLabel);
        
        city = new JTextField(14);
        city.setSize(250, 30);
        city.setLocation(210, 200);
        d.add(city);
	    
        stateLabel = new JLabel("State");
        stateLabel.setSize(300, 30);
        stateLabel.setLocation(100, 240);
        d.add(stateLabel);
        
        state = new JTextField(2);
        state.setSize(250, 30);
        state.setLocation(210, 240);
        d.add(state);
        
        zipLabel = new JLabel("Zip Code");
        zipLabel.setSize(300, 30);
        zipLabel.setLocation(100, 280);
        d.add(zipLabel);
        
        zip = new JTextField(5);
        zip.setSize(250, 30);
        zip.setLocation(210, 280);
        d.add(zip);
        
        submit = new JButton("Submit");
        submit.setSize(100, 20);
        submit.setLocation(115, 360);
        submit.addActionListener(this);
        d.add(submit);
        
        reset = new JButton("Reset");
        reset.setSize(100, 20);
        reset.setLocation(240, 360);
        reset.addActionListener(this);
        d.add(reset);
        
        back = new JButton("Back");
        back.setSize(120, 20);
        back.setLocation(355, 360);
        back.addActionListener(this);
        d.add(back);
        
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 400);
        d.add(res);

        
        setVisible(true);
        
	}

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit) {
            if (num.getText().length() == 9 && num.getText().matches(numCheck)) {
            	String filePath = "src/chocan/members.txt";
                String numData, nameData, addressData, cityData, stateData, zipData;
                numData = num.getText();
                nameData = name.getText();
                addressData = address.getText();
                cityData = city.getText();
                stateData = state.getText();
                zipData = zip.getText();
                
                editRecord(filePath, numData, nameData, addressData, cityData, stateData, zipData);
                res.setText("Member Edited!");
            }
            else {
                res.setText("Please correct form");
            }
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            num.setText(def);
        }
        else if (e.getSource() == back) {
        	setVisible(false);
        	OperatorGUI mGUI = new OperatorGUI();
        }
    }
}

class EditM {
	public static void main(String[] args) throws Exception {
        EditMemberRecord f = new EditMemberRecord();
	}

}




