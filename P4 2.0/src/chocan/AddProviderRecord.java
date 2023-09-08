package chocan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.MembershipKey;

/** 
 * AddProviderRecord class. This generates a frame where operator can input member/provider record info 
 * for the Provider terrminal's add function.
 * @author Alex Seidel
 */

public class AddProviderRecord 
extends JFrame 
implements ActionListener {
    private Container c;
    private JLabel nameLabel, numLabel, addressLabel, cityLabel, stateLabel, zipLabel, res;
    private JTextField name, num, address, city, state, zip;
    private JButton submit, reset, back;
    private String numCheck = "\\d{9}";
    private String zipCheck = "\\d{5}";
    private String stateCheck = "[a-zA-Z]+";
    
    /**
	 * Appends a string to an indicated text file.
	 * @param filePath the file path of the file that is being added to
	 * @param text the information that is added to the .txt file
	 */
    
	public static void appendUsingPrintWriter(String filePath, String text) {
		File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor
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
	
	public AddProviderRecord() {
		/**
		 * Add Provider frame setup.
		 */
	    setTitle("Add Provider");
	    setBounds(300, 300, 550, 450);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    c = getContentPane();
        c.setLayout(null);
        
        nameLabel = new JLabel("Name");
        nameLabel.setSize(300, 30);
        nameLabel.setLocation(100, 80);
        c.add(nameLabel);
        
        name = new JTextField(25);
        name.setSize(250, 30);
        name.setLocation(210, 80);
        c.add(name);
        
        numLabel = new JLabel("Provider Number");
        numLabel.setSize(300, 30);
        numLabel.setLocation(100, 120);
        c.add(numLabel);
        
        num = new JTextField(9);
        num.setSize(250, 30);
        num.setLocation(210, 120);
        c.add(num);
        
        addressLabel = new JLabel("Address");
        addressLabel.setSize(300, 30);
        addressLabel.setLocation(100, 160);
        c.add(addressLabel);
        
        address = new JTextField(25);
        address.setSize(250, 30);
        address.setLocation(210, 160);
        c.add(address);
        
        cityLabel = new JLabel("City");
        cityLabel.setSize(300, 30);
        cityLabel.setLocation(100, 200);
        c.add(cityLabel);
        
        city = new JTextField(14);
        city.setSize(250, 30);
        city.setLocation(210, 200);
        c.add(city);
	    
        stateLabel = new JLabel("State");
        stateLabel.setSize(300, 30);
        stateLabel.setLocation(100, 240);
        c.add(stateLabel);
        
        state = new JTextField(2);
        state.setSize(250, 30);
        state.setLocation(210, 240);
        c.add(state);
        
        zipLabel = new JLabel("Zip Code");
        zipLabel.setSize(300, 30);
        zipLabel.setLocation(100, 280);
        c.add(zipLabel);
        
        zip = new JTextField(5);
        zip.setSize(250, 30);
        zip.setLocation(210, 280);
        c.add(zip);
        
        submit = new JButton("Submit");
        submit.setSize(100, 20);
        submit.setLocation(115, 360);
        submit.addActionListener(this);
        c.add(submit);
        
        reset = new JButton("Reset");
        reset.setSize(100, 20);
        reset.setLocation(240, 360);
        reset.addActionListener(this);
        c.add(reset);
        
        back = new JButton("Back");
        back.setSize(120, 20);
        back.setLocation(355, 360);
        back.addActionListener(this);
        c.add(back);
        
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 400);
        c.add(res);

        
        setVisible(true);
	}

	/**
	 * Implements the needed set of instructions for when a certain button is clicked.
	 */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit) {
            if ((name.getText().length() > 0 && name.getText().length() <= 25) && (num.getText().length() == 9 && num.getText().matches(numCheck)) 
            	&& (address.getText().length() > 0 && address.getText().length() <= 25) && (city.getText().length() > 0 && city.getText().length() <= 14)
            	&& (state.getText().length() == 2 && state.getText().matches(stateCheck)) && (zip.getText().length() == 5 && zip.getText().matches(zipCheck))) {
            	String filePath = "src/chocan/providers.txt";
            	ValidateNumber validNum = new ValidateNumber();
                validNum.decision = true;
                String nameData, numData, addressData, cityData, stateData, zipData, fullString;
                    nameData = name.getText();
                    numData = num.getText();
                    if (!validNum.validateNumber(numData)) {
	                    addressData = address.getText();
	                    cityData = city.getText();
	                    stateData = state.getText();
	                    zipData = zip.getText();
	                    fullString = numData + "," + nameData + "," + addressData + "," + cityData + "," + stateData + "," + zipData;
	                    appendUsingPrintWriter(filePath, fullString);
	                    res.setText("Provider Added!");
	                    String def = "";
	                    name.setText(def);
	                    num.setText(def);
	                    address.setText(def);
	                    city.setText(def);
	                    state.setText(def);
	                    zip.setText(def);
                    }
                    else {
                    	res.setText("Number already in use.");
                    }
            }
            else {
                res.setText("Please correct form");
            }
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            name.setText(def);
            num.setText(def);
            address.setText(def);
            city.setText(def);
            state.setText(def);
            zip.setText(def);
            res.setText(def);
        }
        else if (e.getSource() == back) {
        	setVisible(false);
        	OperatorGUI oGUI = new OperatorGUI();
        }
    }
}

class AddP {
	public static void main(String[] args) throws Exception {
		AddProviderRecord f = new AddProviderRecord();
	}

}




