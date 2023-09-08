package chocan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OperatorGUI
extends JFrame 
implements ActionListener {
    private Container c;
    private JLabel title, title2;
    private JButton pAdd, pRemove, pEdit, mAdd, mRemove, mEdit, back;
	
	public OperatorGUI() {
	    setTitle("Operator Terminal");
	    setBounds(300, 300, 600, 380);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Welcome to the Operator Terminal");
        title.setSize(600, 600);
        title.setLocation(200, -250);
        c.add(title);
        
        title2 = new JLabel("Choose an action.");
        title2.setSize(600, 600);
        title2.setLocation(250, -200);
        c.add(title2);
        
        pAdd = new JButton("Add Provider");
        pAdd.setSize(100, 20);
        pAdd.setLocation(80, 150);
        pAdd.addActionListener(this);
        c.add(pAdd);
        
        pEdit = new JButton("Edit Provider");
        pEdit.setSize(100, 20);
        pEdit.setLocation(250, 150);
        pEdit.addActionListener(this);
        c.add(pEdit);
        
        pRemove = new JButton("Remove Provider");
        pRemove.setSize(120, 20);
        pRemove.setLocation(400, 150);
        pRemove.addActionListener(this);
        c.add(pRemove);
        
        mAdd = new JButton("Add Member");
        mAdd.setSize(100, 20);
        mAdd.setLocation(80, 200);
        mAdd.addActionListener(this);
        c.add(mAdd);
        
        mEdit = new JButton("Edit Member");
        mEdit.setSize(100, 20);
        mEdit.setLocation(250, 200);
        mEdit.addActionListener(this);
        c.add(mEdit);
        
        mRemove = new JButton("Remove Member");
        mRemove.setSize(120, 20);
        mRemove.setLocation(400, 200);
        mRemove.addActionListener(this);
        c.add(mRemove);
        
        back = new JButton("Back");
        back.setSize(100, 20);
        back.setLocation(250, 300);
        back.addActionListener(this);
        c.add(back);
        
        
        
        setVisible(true);
	}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pAdd) {
        	setVisible(false);
    		AddProviderRecord addM = new AddProviderRecord();
   
        }
 
    	else if (e.getSource() == pEdit) {
    		setVisible(false);
    		GetUserNum getNum = new GetUserNum();
    		getNum.decision = true;
        
    	}
    	else if (e.getSource() == pRemove) {
    		setVisible(false);
    		DeleteProviderRecord addM = new DeleteProviderRecord();
        }
    	else if (e.getSource() == mAdd) {
    		setVisible(false);
    		AddMemberRecord addM = new AddMemberRecord();
            
    	}
    	else if (e.getSource() == mEdit) {
    		setVisible(false);
    		GetUserNum getNum = new GetUserNum();
    		getNum.decision = false;
        	
        }
    	else if (e.getSource() == mRemove) {
    		setVisible(false);
    		DeleteMemberRecord addM = new DeleteMemberRecord();
            
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



