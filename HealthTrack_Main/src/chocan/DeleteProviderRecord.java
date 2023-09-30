package chocan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

// Alex Seidel
// pulls up frame where operator can input member/provider record info for delete function

public class DeleteProviderRecord 
extends JFrame 
implements ActionListener {
    private Container c;
    private JLabel numLabel, res;
    private JTextField num;
    private JButton delete, reset, back;
    private String numCheck = "\\d{9}";
    
	
	public static void deleteRecord(String filePath, String number, int position, String delimiter) {
		int newPosition = position - 1;
		String tempFile = "temp.txt";
		File oldFile = new File(filePath);
		File newFile = new File(tempFile);
		
		String currentLine;
		String data[];
		
		
		
		
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			
			while ((currentLine = br.readLine()) != null) {
				data = currentLine.split(delimiter);
				if (!(data[newPosition].equalsIgnoreCase(number))) {
					pw.println(currentLine);
				}
			}
			
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			
			oldFile.delete();
			File update = new File(filePath);
			newFile.renameTo(update);
			
		} catch (Exception e) {
			
		} 
	}
	
	public DeleteProviderRecord() {
	    setTitle("Delete Provider");
	    setBounds(300, 300, 550, 200);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    c = getContentPane();
        c.setLayout(null);
       
        numLabel = new JLabel("Provider Number");
        numLabel.setSize(300, 30);
        numLabel.setLocation(100, 50);
        c.add(numLabel);
        
        num = new JTextField(9);
        num.setSize(250, 30);
        num.setLocation(210, 50);
        c.add(num);
        
        delete = new JButton("Delete");
        delete.setSize(100, 20);
        delete.setLocation(115, 120);
        delete.addActionListener(this);
        c.add(delete);
        
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

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == delete) {
            if (num.getText().length() == 9 && num.getText().matches(numCheck)) {
            	String filePath = "src/chocan/providers.txt";
            	ValidateNumber validNum = new ValidateNumber();
                validNum.decision = true;
                String numData;
                numData = num.getText();
                if (validNum.validateNumber(numData)) {
                	deleteRecord(filePath, numData, 1, ",");
                 
                	res.setText("Provider Removed!");
                }
                else {
                	res.setText("Provider does not exist.");
                }
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

class DeleteP {
	public static void main(String[] args) throws Exception {
		DeleteProviderRecord f = new DeleteProviderRecord();
	}

}




