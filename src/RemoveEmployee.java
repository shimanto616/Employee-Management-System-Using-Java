import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class RemoveEmployee extends JFrame implements ActionListener{
	
	String empid;
	JComboBox<String> cbempid;
	
	//setting actions
	private enum Actions{
		REMOVE,
		DONE
	}
	
	RemoveEmployee(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Remove Employee");
		
		//window size
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		//JLabels
		//id
		JLabel empid = new JLabel("Employee ID:");
		empid.setBounds(50, 80, 110, 30);
		empid.setFont(new Font("Serif", Font.BOLD, 18));
		add(empid);
		
		//drop-down
		ArrayList<String> ID = new ArrayList<>();
		try(BufferedReader read = new BufferedReader(new FileReader("idlist.txt"))){
			String input;
			while((input = read.readLine()) != null){
				ID.add(input);
			}
		}catch(IOException ex){
			
		}

		String[] options = ID.toArray(new String[0]);
		
        cbempid = new JComboBox<>(options);
        cbempid.setBounds(180, 80, 110, 30);
        cbempid.setFont(new Font("Serif", Font.PLAIN, 14));
        cbempid.setBackground(Color.WHITE);
        cbempid.setLayout(null); 
        cbempid.setBorder(new LineBorder(Color.BLACK));
        cbempid.setVisible(true);
        add(cbempid);

		
		
        //>>BUTTONS<<
        //remove
        JButton rmv = new JButton("Remove");
        rmv.setFont(new Font("Arial", Font.PLAIN, 16));
        rmv.setForeground(new Color(255, 215, 0));
        rmv.setBorder(null);
        rmv.setBackground(Color.gray);
        rmv.setBounds(125, 150, 150, 30);
        rmv.setActionCommand(Actions.REMOVE.name());
        rmv.addActionListener(this);
        add(rmv);
        
        //done
        JButton done = new JButton("Done");
		done.setFont(new Font("Arial", Font.PLAIN, 16));
		done.setForeground(new Color(255, 215, 0));
		done.setBorder(null);
		done.setBackground(Color.gray);
		done.setBounds(220, 300, 150, 30);
		done.setActionCommand(Actions.DONE.name());
		done.addActionListener(this);
        add(done);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == Actions.REMOVE.name()) {
		      empid = (String)cbempid.getSelectedItem();

			  
		File file = new File("UAP" + empid + ".txt");
		if(file.exists()){
			if(file.delete()){
				System.out.println("success");
			}
			else{
				System.out.println("failed");
			}
		}else{
			System.out.println("notfound");
		}


		//update the id list
		//delete 
		ArrayList<String> ID2 = new ArrayList<>();
		try(BufferedReader read = new BufferedReader(new FileReader("idlist.txt"))){
			String input2;
			while((input2 = read.readLine()) != null){
				if(input2.equals(empid)){
					continue;
				}
				else{
					ID2.add(input2);
				}
			}
		}catch(IOException ex){
			System.out.println("Error");
		}

		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("idlist.txt"));

			for(String upin : ID2){
				writer.write(upin + '\n');
			}
			writer.close();
		}catch(IOException ex){
			System.out.println("error");
		}
  
		     
		    } 
		else if (e.getActionCommand() == Actions.DONE.name()) {
		      setVisible(false);
		    }
	}

}
