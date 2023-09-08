package chocan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * TelminalGUI class. Calls main menu (ChocAn Terminal).
 * @author aniyahcurry
 *
 */
public class TerminalGUI 
extends JFrame 
implements ActionListener {
    private Container c;
    private JLabel title, title2;
    private JButton pButton, oButton, mButton;
    
    // !add functional back buttons to all frames for easy navigation!
	/**
	 * Calls main ChocAn terminal and provides options for 3 user terminals (provider, operator, manager).
	 */
	public TerminalGUI() {
	    setTitle("ChocAn Terminal");
	    setBounds(300, 300, 600, 250);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Welcome to the ChocAn Terminal");
        title.setSize(600, 600);
        title.setLocation(200, -250);
        c.add(title);
        
        title2 = new JLabel("Select a terminal.");
        title2.setSize(600, 600);
        title2.setLocation(250, -200);
        c.add(title2);
        
        pButton = new JButton("Provider");
        pButton.setSize(100, 20);
        pButton.setLocation(100, 150);
        pButton.addActionListener(this);
        c.add(pButton);
        
        oButton = new JButton("Operator");
        oButton.setSize(100, 20);
        oButton.setLocation(250, 150);
        oButton.addActionListener(this);
        c.add(oButton);
        
        mButton = new JButton("Manager");
        mButton.setSize(100, 20);
        mButton.setLocation(400, 150);
        mButton.addActionListener(this);
        c.add(mButton);
        
        setVisible(true);
	}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pButton) {
        	setVisible(false);
        	GetUserNum f = new GetUserNum();
        	f.provCheck = false;
        	
        	// ProviderGUI pGUI = new ProviderGUI();
        	/* ProviderGUI needs...
        	 * Bill ChocAn: 
        	 	- key in member number + validate member number
        	 	  [number must be from members.txt file to be validated (?)]
        	 	- prompt for date of service (MM-DD-YYYY) and store input
        	 	  [check for date validity (?)]
        	 	- look up service code + validate code (display code to user and prompt y/n)
        	 	  [code must be from directory.txt to be validated (?)]
        	 	- generate service report [create new file containing relevant info (?)]
        	 	- software looks up specific service fee and displays it on screen for 
        	 	  confirmation
        	 * Request Software Product:
        	 	- call provider directory class for access to directory.txt file
        	 * Provide Service(s):
        	  	- key in + verify member number
        	  	  [number must be from members.txt file to be validated (?)]
        	  	- member number not valid if specific member has fees or if number
        	  	  does not exist
        	 */
        }
 
    	else if (e.getSource() == oButton) {
    		setVisible(false);
    		OperatorGUI mGUI = new OperatorGUI();
        	/* OperatorGUI needs...
        	 * Edit Member/Provider: 
        	 	- prompt for member/provider number
        	 	- edit member/provider frame is called to collect data input
        	 	- corresponding member/provider info is updated
        	 * Add Member/Provider: 
        	 	- add member/provider frame is called to collect data input
        	 	- member/provider info is added
        	 * Remove Member/Provider: 
        	 	- prompt for member/provider number
        	 	- corresponding member/provider info is removed
        	 	
        	 	!REMEMBER TO KEEP REQUIRED REPORT/RECORD INCLUSIONS IN MIND!
        	 */
        
    	}
    	else if (e.getSource() == mButton) {
    		setVisible(false);
    		ManagerGUI mGUI = new ManagerGUI();
    		/* ManagerGUI needs...
        	 * Request Member/Provider Report: 
        	 	- prompt for member/provider number
        	 	- generate + download/provide access to report
        	 * Request Summary Report: 
        	 	- generate + download/provide access to report
        	 * Request EFT Record:
        	 	- tbh idk what the data for this would actually be BUT...
        	 	- generate + download/provide access to report
        	 
        	 	!REMEMBER TO KEEP REQUIRED REPORT/RECORD INCLUSIONS IN MIND!
        	 */
        	
        }
    }
}

class Start {
	public static void main(String[] args) throws Exception {
		TerminalGUI f = new TerminalGUI();
	}

}




