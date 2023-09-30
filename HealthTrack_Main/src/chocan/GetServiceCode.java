package chocan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Aniyah Curry
/**
 * GetServiceCode class. Generates a frame where user can input a service code.
 * @author Aniyah
 *
 */
public class GetServiceCode 
extends JFrame 
implements ActionListener {
    private Container c;
    public JLabel numLabel, res;
    public JTextField num;
    private JButton submit, reset, back;
    public String numData;
    /**
     * decision indicates which "mode" the method must act in: member (false) or provider (true) "mode"
     */
    public boolean decision = true;
    private String numCheck = "\\d{6}";
    public String code;
    /**
     * Generates a frame where user can input a service code. Code return if valid.
     */
	public GetServiceCode() {
	    setTitle("Enter Service Code");
	    setBounds(300, 300, 550, 200);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    c = getContentPane();
        c.setLayout(null);
       
        numLabel = new JLabel("Service Code");
        numLabel.setSize(300, 30);
        numLabel.setLocation(80, 50);
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
	
/**
 * 
 * @return returns the service code that is entered if valid (6 integers).
 */
String getServiceCode() {
	numData = null;
	while (numData == null) {
		if (num.getText().length() == 6 && num.getText().matches(numCheck)) {
	        numData = num.getText();
	        res.setText("");
	        // setVisible(false)
	        ServiceCodeLookup validC = new ServiceCodeLookup();
        	if (validC.validateCode(numData)) {
        		code = numData;
	        	res.setText("Service:" + validC.serviceName + ", Price:" + validC.price);
        	}
        	else {
        		code = null;
        		res.setText("This service code does not exist.");
        	}
	        
	    }
	    else {
	    	code = null;
	        res.setText("Please enter a valid code (6 integers).");
	        break;
	    }
	}
	
	return code;
}

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit) {
        	getServiceCode();
            
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            num.setText(def);
        }
        else if (e.getSource() == back) {
        	setVisible(false);
        	ProviderGUI mGUI = new ProviderGUI();
        }
    }
}

class GetCode {
	public static void main(String[] args) throws Exception {
		GetServiceCode f = new GetServiceCode();
	}

}




