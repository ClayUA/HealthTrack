package chocan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerGUI
extends JFrame 
implements ActionListener {
    private Container c;
    private JLabel title, title2;
    private JButton pReport, mReport, eReport, sReport, back;
	
	public ManagerGUI() {
	    setTitle("Manager Terminal");
	    setBounds(300, 300, 600, 350);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Welcome to the Manager Terminal");
        title.setSize(600, 600);
        title.setLocation(200, -250);
        c.add(title);
        
        title2 = new JLabel("Choose an action.");
        title2.setSize(600, 600);
        title2.setLocation(250, -200);
        c.add(title2);
        
        pReport = new JButton("Request Provider Report");
        pReport.setSize(180, 20);
        pReport.setLocation(100, 150);
        pReport.addActionListener(this);
        c.add(pReport);
        
        mReport = new JButton("Request Member Report");
        mReport.setSize(180, 20);
        mReport.setLocation(340, 150);
        mReport.addActionListener(this);
        c.add(mReport);
        
        sReport = new JButton("Request Summary Report");
        sReport.setSize(180, 20);
        sReport.setLocation(210, 200);
        sReport.addActionListener(this);
        c.add(sReport);
        
        back = new JButton("Back");
        back.setSize(120, 20);
        back.setLocation(250, 280);
        back.addActionListener(this);
        c.add(back);
        
        setVisible(true);
	}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pReport) {
        	RecordProvider r = new RecordProvider();
        	r.record();
        }
 
    	if (e.getSource() == mReport) {
    		Record r = new Record();
    		r.record();
    		// FindService f = new FindService();
    		// f.decision = false;
        
    	}
    	else if (e.getSource() == sReport) {
            SummaryReport s = new SummaryReport();
            s.record();
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



