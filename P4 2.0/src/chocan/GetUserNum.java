package chocan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Alex Seidel
// pulls up frame where operator can specify member/provider record that needs to be edited
public class GetUserNum 
extends JFrame 
implements ActionListener {
    private Container c;
    private JLabel numLabel, res;
    private JTextField num;
    private JButton submit, reset, back;
    private String numCheck = "\\d{9}";
    public boolean decision = true;
    public boolean provCheck = true;
    
	public GetUserNum() {
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
	
String getUserNum() {
	String numData = null;
	while (numData == null) {
		if (num.getText().length() == 9 && num.getText().matches(numCheck)) {
	        numData = num.getText();
	        res.setText("");
	        // setVisible(false);
	        // provider mode when decision = true, member mode when decision = false
	        if (decision && provCheck) {
	        	ValidateNumber validP = new ValidateNumber();
	        	validP.decision = true;
	        	if (validP.validateNumber(numData)) {
	        		setVisible(false);
		        	EditProviderRecord editP = new EditProviderRecord();
			        editP.userNumber = numData; 
	        	}
	        	else {
	        		res.setText("Number does not exist.");
	        	}

	        }
	        else if (decision && !provCheck) {
	        	ValidateNumber validP = new ValidateNumber();
	        	validP.decision = true;
	        	if (validP.validateNumber(numData)) {
	        		setVisible(false);
	        		ProviderGUI f = new ProviderGUI();
	        	}
	        	else {
	        		res.setText("Provider does not exist.");
	        	}
	        }
	        else if (!decision && provCheck){
	        	ValidateNumber validM = new ValidateNumber();
	        	validM.decision = false;
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
        	getUserNum();
            
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            num.setText(def);
        }
        else if (e.getSource() == back && decision && provCheck) {
        	setVisible(false);
        	OperatorGUI mGUI = new OperatorGUI();
        }
        else if (e.getSource() == back && !decision && provCheck) {
        	setVisible(false);
        	OperatorGUI mGUI = new OperatorGUI();
        }
        else if (e.getSource() == back && decision && !provCheck) {
        	setVisible(false);
        	TerminalGUI f = new TerminalGUI();
        }
    }
}

class GetNum {
	public static void main(String[] args) throws Exception {
		GetUserNum f = new GetUserNum();
	}

}




