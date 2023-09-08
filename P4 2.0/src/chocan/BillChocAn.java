package chocan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.channels.MembershipKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

	// Aniyah Curry
	// pulls up frame where operator can input member/provider record info for add function

	public class BillChocAn 
	extends JFrame 
	implements ActionListener {
	    private Container c;
	    private JLabel provLabel, memLabel, dateLabel, codeLabel, commentsLabel, res;
	    private JTextField provNum, memNum, serviceDate, serviceCode, comments;
	    private JButton submit, reset, back;
	    private String numCheck = "\\d{9}";
	    private String dateCheck = "\\d{2}-\\d{2}-\\d{4}";
	    private String codeCheck = "\\d{6}";
	
	    
	    

		
		private static void appendUsingPrintWriter(String filePath, String text) {
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
		
		public BillChocAn() {
		    setTitle("Bill Chocan");
		    setBounds(300, 300, 550, 450);
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		    setResizable(false);
		    
		    c = getContentPane();
	        c.setLayout(null);
	        
	        memLabel = new JLabel("Member Number");
	        memLabel.setSize(300, 30);
	        memLabel.setLocation(100, 80);
	        c.add(memLabel);
	        
	        memNum = new JTextField(25);
	        memNum.setSize(250, 30);
	        memNum.setLocation(210, 80);
	        c.add(memNum);
	        
	        provLabel = new JLabel("Provider Number");
	        provLabel.setSize(300, 30);
	        provLabel.setLocation(100, 120);
	        c.add(provLabel);
	        
	        provNum = new JTextField(9);
	        provNum.setSize(250, 30);
	        provNum.setLocation(210, 120);
	        c.add(provNum);
	        
	        dateLabel = new JLabel("Service Date");
	        dateLabel.setSize(300, 30);
	        dateLabel.setLocation(100, 160);
	        c.add(dateLabel);
	        
	        serviceDate = new JTextField(25);
	        serviceDate.setSize(250, 30);
	        serviceDate.setLocation(210, 160);
	        c.add(serviceDate);
	        
	        codeLabel = new JLabel("Service Code");
	        codeLabel.setSize(300, 30);
	        codeLabel.setLocation(100, 200);
	        c.add(codeLabel);
	        
	        serviceCode = new JTextField(5);
	        serviceCode.setSize(250, 30);
	        serviceCode.setLocation(210, 200);
	        c.add(serviceCode);
	        
	        commentsLabel = new JLabel("Comments");
	        commentsLabel.setSize(300, 30);
	        commentsLabel.setLocation(100, 240);
	        c.add(commentsLabel);
	        
	        comments = new JTextField(5);
	        comments.setSize(250, 70);
	        comments.setLocation(210, 240);
	        c.add(comments);
	        
	        
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
	        res.setFont(new Font("Arial", Font.PLAIN, 13));
	        res.setSize(500, 25);
	        res.setLocation(100, 400);
	        c.add(res);

	        
	        setVisible(true);
		}

	    public void actionPerformed(ActionEvent e)
	    {
	        if (e.getSource() == submit) {
	            if (((memNum.getText().length() == 9) && memNum.getText().matches(numCheck))
	            	&& ((provNum.getText().length() == 9) && provNum.getText().matches(numCheck)) && (serviceDate.getText().matches(dateCheck)) 
	            	&& ((serviceCode.getText().length() == 6) && serviceCode.getText().matches(codeCheck))) {
		            	// String filePath = "members.txt";
		                String provNumData, memNumData, dateData, commentData, codeData, fullString;
		                String filePath = "src/chocan/servicesprovided.txt";
		                DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		                Date date = new Date();
		                ValidateNumber validMemNum = new ValidateNumber();
		                validMemNum.decision = false;
		                ValidateNumber validProvNum = new ValidateNumber();
		                validProvNum.decision = true;
		                ServiceCodeLookup validC = new ServiceCodeLookup();
		                codeData = serviceCode.getText();
	                    provNumData = provNum.getText();
	                    memNumData = memNum.getText();
	                    if (validMemNum.validateNumber(memNumData) && validProvNum.validateNumber(provNumData) && validC.validateCode(codeData)) {
		                    dateData = serviceDate.getText();
		                    commentData = comments.getText();
		                    fullString = memNumData + "," + provNumData + "," + dateData + "," + dateFormat.format(date) + "," + codeData + "," + commentData;
		                    appendUsingPrintWriter(filePath, fullString);
		                 
		                    res.setText("Service Added!");
	                    }
	                    else {
	                    	res.setText("Please ensure provider/member number and service code are valid.");
	                    }
	                    
	            }
	            else {
	                res.setText("Please correct form");
	            }
	        }
	 
	        else if (e.getSource() == reset) {
	            String def = "";
	            memNum.setText(def);
	            provNum.setText(def);
	            serviceDate.setText(def);
	            comments.setText(def);
	            serviceCode.setText(def);
	            res.setText(def);
	        }
	        else if (e.getSource() == back) {
	        	setVisible(false);
	        	ProviderGUI mGUI = new ProviderGUI();
	        }
	    }
	}

	class Bill {
		public static void main(String[] args) throws Exception {
			BillChocAn f = new BillChocAn();
		}

}