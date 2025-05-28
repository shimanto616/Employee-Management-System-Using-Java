import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Update extends JFrame implements ActionListener{
	
	JTextField tfphone,tfaddress,tfsalary;
	JLabel employeename;
	Boolean selection=false;
	
	//temporary  variables
	String id;
	String upname;
	String upsalary;
	String upaddress;
	String upphone;
	String updesignation;
	String empname;

	//final update check with boolean value
	boolean finalCheck = true;

	String[] update = new String[10];//to store update values
	
	//set actions
	private enum Actions{
		UPDATE,
		DONE,
		SELECT
	}
	JComboBox<String> cbempid,cbdes;
	
	Update(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Update");
		
		//window size
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		//1.Employee ID [exception]
		JLabel lblempid = new JLabel("Select employee ID:");
		lblempid.setBounds(50, 30, 200, 30);
		lblempid.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblempid);
		
		//1.Employee name [exception]
		JLabel lblempname = new JLabel("Employee name:");
		lblempname.setBounds(50, 80, 200, 30);
		lblempname.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblempname);

		//3. Salary [exception]
		JLabel lblsalary = new JLabel("Salary:");
		lblsalary.setBounds(50, 130, 200, 30);
		lblsalary.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblsalary);

		//4. Address
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(50, 180, 200, 30);
		lblAddress.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblAddress);

		//5. Phone number [exception]
		JLabel lblphone = new JLabel("Phone:");
		lblphone.setBounds(50, 230, 200, 30);
		lblphone.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblphone);

		//7. Designation [drop-down]
		JLabel lbldes = new JLabel("Designation:");
		lbldes.setBounds(50, 280, 200, 30);
		lbldes.setFont(new Font("Serif", Font.BOLD, 18));
		add(lbldes);
		
		//>>TEXT FIELDS<<
		// import the ids form the [ idlist.txt ] into the empid string array
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
        cbempid.setBounds(270, 30, 200, 30);
        cbempid.setFont(new Font("Serif", Font.PLAIN, 14));
        cbempid.setBackground(Color.WHITE);
        cbempid.setLayout(null); 
        cbempid.setBorder(new LineBorder(Color.BLACK));
        cbempid.setVisible(true);
        add(cbempid);
        
		
		//salary
		tfsalary = new JTextField();
		tfsalary.setBounds(270, 130, 200, 30);
		tfsalary.setFont(new Font("Serif", Font.PLAIN, 16));
		tfsalary.setBorder(new LineBorder(Color.BLACK));
		add(tfsalary);
		

		//address
		tfaddress = new JTextField();
		tfaddress.setBounds(270, 180, 200, 30);
		tfaddress.setFont(new Font("Serif", Font.PLAIN, 16));
		tfaddress.setBorder(new LineBorder(Color.BLACK));
		add(tfaddress);
		

		//phone
		tfphone = new JTextField();
		tfphone.setBounds(270, 230, 200, 30);
		tfphone.setFont(new Font("Serif", Font.PLAIN, 16));
		tfphone.setBorder(new LineBorder(Color.BLACK));
		add(tfphone);
		
		//designation
		String[] positions = {" ", "CEO", "Manager", "Project Manager", "Marketing Manager", "HR", "Senior Developer", "Junior Developer", "Staff"}; 
		cbdes = new JComboBox<>(positions);
		cbdes.setBounds(270, 280, 200, 30);
		cbdes.setFont(new Font("Serif", Font.PLAIN, 14));
		cbdes.setBackground(Color.WHITE);
		cbdes.setLayout(null); 
		cbdes.setBorder(new LineBorder(Color.BLACK));
		cbdes.setVisible(true);
		add(cbdes);
		

		//>>BUTTONS<<
		//select
		JButton select = new JButton("SELECT");
		select.setFont(new Font("Arial", Font.PLAIN, 16));
		select.setForeground(new Color(255, 215, 0));
		select.setBorder(null);
		select.setBackground(Color.gray);
		select.setBounds(490, 30, 200, 30);
		select.setActionCommand(Actions.SELECT.name());
		select.addActionListener(this);
		add(select);
		
		//update
		JButton update = new JButton("Update");
		update.setFont(new Font("Arial", Font.PLAIN, 16));
		update.setForeground(new Color(255, 215, 0));
		update.setBorder(null);
		update.setBackground(Color.gray);
		update.setBounds(300, 370, 200, 30);
		update.setActionCommand(Actions.UPDATE.name());
		update.addActionListener(this);
		add(update);
				
		//done
		JButton done = new JButton("Done");
		done.setFont(new Font("Arial", Font.PLAIN, 16));
		done.setForeground(new Color(255, 215, 0));
		done.setBorder(null);
		done.setBackground(Color.gray);
		done.setBounds(520, 510, 200, 30);
		done.setActionCommand(Actions.DONE.name());
		done.addActionListener(this);
		add(done);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == Actions.SELECT.name()) {
			selection=true;
			id = (String)cbempid.getSelectedItem();

			String fName = "UAP"+ id + ".txt";
			String showName = null ;
			
			try{
				BufferedReader nameRead = new BufferedReader(new FileReader(fName)) ;
				showName = nameRead.readLine();
				
				nameRead.close();
			}catch(IOException ex){
				System.out.println("error");
			}

			empname = showName; //STORE EMPLYEENAME HERE
			//emp name
	        employeename = new JLabel(""+empname);
	        employeename.setBounds(270, 80, 200, 30);
	        employeename.setFont(new Font("Serif", Font.BOLD, 18));
			add(employeename);
			
			repaint();
		}
		
		
		else if (e.getActionCommand() == Actions.UPDATE.name()) {
			if(selection==true) {
				
				//----->>UPDATE START<-----
				
				//update inputs
				upsalary = tfsalary.getText();
				upaddress = tfaddress.getText();
				upphone = tfphone.getText();
				updesignation = (String)cbdes.getSelectedItem();
				
				//need to code from here [get the file and rewrite it]
				ArrayList<String> previousData = new ArrayList<>();
				String fileName = "UAP"+id+".txt";

				try(BufferedReader bufRead = new BufferedReader(new FileReader(fileName))){
					String preDataSingle;

					while ((preDataSingle = bufRead.readLine())!=null) {
						previousData.add(preDataSingle);
					}
				}catch(IOException ex){
					System.out.println("Error");
				}

				
				int idx =0;
				for(String s: previousData){
					update[idx] = s;
					idx++;
				}
				

				ValidationMethods check = new ValidationMethods();
				boolean excheck[] = {true, true};
				
				try{
					if(check.checkSalary(upsalary)== false ){
						excheck[0] = false;
						throw new myException();
					}
					else{
						update[1] = upsalary;
					}
				}catch(myException ex){
					ex.exSalary();
				}

				update[2] = upaddress;
				update[7] = updesignation;

				try{
					if(check.checkPhonenumber(upphone)==false){
						excheck[1] = false;
						throw new myException();
					}
					else{
						update[3] = upphone;
					}
				}catch(myException ex){
					ex.exPhoneNumber();
				}

				

				for(boolean x : excheck){
					if(x == false){
						finalCheck = false;
						break;
					}
				}

				//need to store previous data in a string type arraylist
				//then re-input the updated value
				//rewrite the whole file with the new array list

				
				for(String test: update){
					System.out.println(test+'\t');
				}
				
				selection=false;//reset selection
			}
			else {
				JOptionPane.showMessageDialog(null, "Please Select an employee First", "Select Employee", 2, null);
			}
		 } 
				//----->>UPDATE END<-----
		
		else if (e.getActionCommand() == Actions.DONE.name()) {
			if(finalCheck==true) {
				
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter("UAP" + id + ".txt"));
					for(String upInof : update){
						writer.write(upInof);
						writer.write('\n');

					}
					writer.close();
				}catch(IOException ex){
					System.out.println("error");
				}

				setVisible(false);
			}
			
		   }
		
	}

}
