package chocan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProviderGUI
extends JFrame 
implements ActionListener {
    private Container c;
    private JLabel title, title2;
    private JButton billChocan, rSoftware, back;
	
	public ProviderGUI() {
	    setTitle("Provider Terminal");
	    setBounds(300, 300, 600, 280);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Welcome to the Provider Terminal");
        title.setSize(600, 600);
        title.setLocation(200, -250);
        c.add(title);
        
        title2 = new JLabel("Choose an action.");
        title2.setSize(600, 600);
        title2.setLocation(250, -200);
        c.add(title2);
        
        billChocan = new JButton("Bill ChocAn");
        billChocan.setSize(120, 20);
        billChocan.setLocation(150, 150);
        billChocan.addActionListener(this);
        c.add(billChocan);
        
        rSoftware = new JButton("Provider Directory");
        rSoftware.setSize(160, 20);
        rSoftware.setLocation(290, 150);
        rSoftware.addActionListener(this);
        c.add(rSoftware);
        
        back = new JButton("Back");
        back.setSize(80, 20);
        back.setLocation(260, 200);
        back.addActionListener(this);
        c.add(back);
        
        setVisible(true);
	}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == billChocan) {
        	setVisible(false);
        	BillChocAn b = new BillChocAn();
        }
 
    	else if (e.getSource() == rSoftware) {
    		setVisible(false);
    		GetServiceCode g = new GetServiceCode();
        
    	}
    	else if (e.getSource() == back) {
    		setVisible(false);
    		TerminalGUI f = new TerminalGUI();
    	}
    }
}

/*
class Begin {
	public static void main(String[] args) throws Exception {
		ProviderGUI f = new ProviderGUI();
	}

}
*/



