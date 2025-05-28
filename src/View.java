import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
public class View extends JFrame implements ActionListener{
	JComboBox<String> cbempid;
	String viewID;

	private enum Actions{
		VIEW;
	}
	View(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Employee List");
		
		//window size
		setSize(600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		//to show the the txt"Employee ID:"
		JLabel showID = new JLabel("Employee ID:");
		showID.setBounds(20,30, 200,30);
		showID.setFont(new Font("Serif", Font.BOLD, 18));
		add(showID);

		// created the drop-down menu from the idlist.txt file
		ArrayList<String> ID = new ArrayList<>();
		try(BufferedReader read = new BufferedReader(new FileReader("idlist.txt"))){
			String input;
			while((input = read.readLine()) != null){
				ID.add(input);
			}
		}catch(IOException ex){
			
		}
		String[] empid = ID.toArray(new String[0]);
        cbempid = new JComboBox<>(empid);
        cbempid.setBounds(135, 30, 200, 30);
        cbempid.setFont(new Font("Serif", Font.PLAIN, 14));
        cbempid.setBackground(Color.WHITE);
        cbempid.setLayout(null); 
        cbempid.setBorder(new LineBorder(Color.BLACK));
        cbempid.setVisible(true);
        add(cbempid);

		//view button
		JButton viewEmp = new JButton("View");
		viewEmp.setFont(new Font("Serif", Font.BOLD, 16));
		viewEmp.setForeground(Color.white);
		viewEmp.setBorder(null);
		viewEmp.setBackground(Color.gray);
		viewEmp.setBounds(350, 30, 200, 30);
		viewEmp.setActionCommand(Actions.VIEW.name());
		viewEmp.addActionListener(this);
		add(viewEmp);
		
		//main menu button
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.setFont(new Font("Serif", Font.BOLD, 16));
		mainMenu.setForeground(Color.white);
		mainMenu.setBorder(null);
		mainMenu.setBackground(Color.gray);
		mainMenu.setBounds(350, 100, 200, 30);
		mainMenu.addActionListener(this);
		add(mainMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == Actions.VIEW.name()){
			viewID = (String)cbempid.getSelectedItem();
			//view id has the selected Employee id number

			String viewFile = "UAP"+viewID+".txt";//this is the file name


			//read the selected file and store them in an array
			LinkedList<String> list = new LinkedList<>();
			try(BufferedReader bufRead = new BufferedReader(new FileReader(viewFile))){
				String temp;

				while ((temp = bufRead.readLine())!=null) {
					list.add(temp);
				}
			}catch(IOException ex){
				System.out.println("Error");
			}
			//the array list has the data
			String jString ="Name : " + list.get(0) + '\n' +
							"Salary: " + list.get(1) + '\n' +
							"Address: " + list.get(2)+ '\n' +
							"Phone Number: " + list.get(3) + '\n'+
							"Mail Address: " + list.get(4) +'\n'+
							"Blood Group: " + list.get(5) + '\n' +
							"Graduation SubjectL: "  + list.get(6) + '\n' +
							"Designation: " + list.get(7) + '\n' +
							"Department: " + list.get(8) + '\n'
							;
			JOptionPane.showMessageDialog(null, jString );

			System.out.println(list);

		}
		else{
			System.out.println("exit");
			setVisible(false);
		}
		
	}

}
