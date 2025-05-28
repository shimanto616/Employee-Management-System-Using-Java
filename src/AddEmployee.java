import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class AddEmployee extends JFrame implements ActionListener{
	
	JTextField tfempname,tfsalary,tfaddress,tfphone,tfmail;
	JComboBox<String> bgrpcomboBox,subComboBox,desComboBox,depComboBox;

	//temporary variables
	int exceptionCounter;
	String name;
	String salary;
	String address;
	String phone;
	String mail;
	String bloodGroup;
	String graduationSub;
	String designation;
	String department;
	Random rnd = new Random();
	public int employeeID = rnd.nextInt(999999);

	//validation method class to access the method to check valid input 
	ValidationMethods isValid = new ValidationMethods();


	
	
	AddEmployee(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Add Employee");
		
		//window size
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		
				//1.Employee name [exception]
		JLabel lblempname = new JLabel("Employee name:");
		lblempname.setBounds(50, 30, 200, 30);
		lblempname.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblempname);
		
				//3. Salary [exception]
		JLabel lblsalary = new JLabel("Salary:");
		lblsalary.setBounds(50, 80, 200, 30);
		lblsalary.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblsalary);
		
				//4. Address
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(50, 130, 200, 30);
		lblAddress.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblAddress);
		
				//5. Phone number [exception]
		JLabel lblphone = new JLabel("Phone:");
		lblphone.setBounds(50, 180, 200, 30);
		lblphone.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblphone);
		
				//6. Mail
		JLabel lblmail = new JLabel("Mail Address:");
		lblmail.setBounds(50, 230, 200, 30);
		lblmail.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblmail);
		
				//8. Blood group —[drop down]
		JLabel lblbgrp = new JLabel("Blood Group:");
		lblbgrp.setBounds(50, 280, 200, 30);
		lblbgrp.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblbgrp);
		
				//9. Graduation subject
		JLabel lblgsub = new JLabel("Graduation Sub:");
		lblgsub.setBounds(50, 330, 200, 30);
		lblgsub.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblgsub);

				//7. Designation [drop-down]
		JLabel lbldes = new JLabel("Designation:");
		lbldes.setBounds(50, 380, 200, 30);
		lbldes.setFont(new Font("Serif", Font.BOLD, 18));
		add(lbldes);
				
				//. department
		JLabel lbldep = new JLabel("Department:");
		lbldep.setBounds(50, 430, 200, 30);
		lbldep.setFont(new Font("Serif", Font.BOLD, 18));
		add(lbldep);
		
				//11. Employee ID [pre-defined]
		JLabel lblempid = new JLabel("Employee ID:");
		lblempid.setBounds(50, 480, 200, 30);
		lblempid.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblempid);
		JLabel lblid = new JLabel(""+employeeID);//add employeeID  here
		lblid.setBounds(200, 480, 200, 30);
		lblid.setFont(new Font("Serif", Font.BOLD, 18));
		add(lblid);
		
		//MAKE SURE YOU PASSED THIS EMPLOYEE-ID 
		
		
				// TEXT FIELDS --->input

		//emp name
		tfempname = new JTextField();
		tfempname.setBounds(270, 30, 200, 30);
		tfempname.setFont(new Font("Serif", Font.PLAIN, 16));
		tfempname.setBorder(new LineBorder(Color.BLACK));
		add(tfempname);
		


		
		
		//salary
		tfsalary = new JTextField();
		tfsalary.setBounds(270, 80, 200, 30);
		tfsalary.setFont(new Font("Serif", Font.PLAIN, 16));
		tfsalary.setBorder(new LineBorder(Color.BLACK));
		add(tfsalary);
		
	

		
		//address
		tfaddress = new JTextField();
		tfaddress.setBounds(270, 130, 200, 30);
		tfaddress.setFont(new Font("Serif", Font.PLAIN, 16));
		tfaddress.setBorder(new LineBorder(Color.BLACK));
		add(tfaddress);
		
		//phone
		tfphone = new JTextField();
		tfphone.setBounds(270, 180, 200, 30);
		tfphone.setFont(new Font("Serif", Font.PLAIN, 16));
		tfphone.setBorder(new LineBorder(Color.BLACK));
		add(tfphone);
		
	
		
		
		
		//mail
		tfmail = new JTextField();
		tfmail.setBounds(270, 230, 200, 30);
		tfmail.setFont(new Font("Serif", Font.PLAIN, 16));
		tfmail.setBorder(new LineBorder(Color.BLACK));
		add(tfmail);

		
		
		//blood group
		//JFrame drop = new JFrame();
		String[] options = {" ", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}; 
        bgrpcomboBox = new JComboBox<>(options);
        bgrpcomboBox .setBounds(270, 280, 200, 30);
        bgrpcomboBox .setFont(new Font("Serif", Font.PLAIN, 14));
        bgrpcomboBox .setBackground(Color.WHITE);
        bgrpcomboBox .setLayout(null); 
        bgrpcomboBox .setBorder(new LineBorder(Color.BLACK));
        bgrpcomboBox .setVisible(true);
        add(bgrpcomboBox);
       
		
		//graduation sub
		String[] subjects = {" ", "CSE", "Software Engineering", "Network Analysis", "BBA", "CA"}; 
        subComboBox = new JComboBox<>(subjects);
        subComboBox.setBounds(270, 330, 200, 30);
        subComboBox.setFont(new Font("Serif", Font.PLAIN, 14));
        subComboBox.setBackground(Color.WHITE);
        subComboBox.setLayout(null); 
        subComboBox.setBorder(new LineBorder(Color.BLACK));
        subComboBox.setVisible(true);
        add(subComboBox);
       
		
		//designation
		String[] positions = {" ", "CEO", "Manager", "Project Manager", "Marketing Manager", "HR", "Senior Developer", "Junior Developer", "Staff"}; 
        desComboBox = new JComboBox<>(positions);
        desComboBox.setBounds(270, 380, 200, 30);
        desComboBox.setFont(new Font("Serif", Font.PLAIN, 14));
        desComboBox.setBackground(Color.WHITE);
        desComboBox.setLayout(null); 
        desComboBox.setBorder(new LineBorder(Color.BLACK));
        desComboBox.setVisible(true);
        add(desComboBox);
		
		//department
		String[] departments = {" ", "Software Development", "Networking", "IT", "Marketing"}; 
        depComboBox = new JComboBox<>(departments);
        depComboBox.setBounds(270, 430, 200, 30);
        depComboBox.setFont(new Font("Serif", Font.PLAIN, 14));
        depComboBox.setBackground(Color.WHITE);
        depComboBox.setLayout(null); 
        depComboBox.setBorder(new LineBorder(Color.BLACK));
        depComboBox.setVisible(true);
        add(depComboBox);
        
		//button
		JButton done = new JButton("Done");
		done.setFont(new Font("Arial", Font.PLAIN, 16));
		done.setForeground(new Color(255, 215, 0));
		done.setBorder(null);
		done.setBackground(Color.gray);
		done.setBounds(520, 510, 200, 30);
		done.addActionListener(this);
        add(done);
		
	}

	
	
	public void actionPerformed(ActionEvent e) {

		ValidationMethods check = new ValidationMethods();
		

		boolean allOkay[]= {true,true,true, true};// to confirm if all the inputs are valid ; if valid then we will create a file 

		//for name checking exception
		try{
			name = tfempname.getText();
			if(check.checkName(name)== false){
				allOkay[0] = false;
				throw new myException();
			}
		}
		catch(myException ex){
			ex.exName();
			exceptionCounter++;//counts if there is an exception or not
		};

		//checking exception for salary
		try{

			salary = tfsalary.getText();
			if(check.checkSalary(salary)== false){
				allOkay[1] = false;
				throw new myException();
			}
		}catch(myException ex){
			ex.exSalary();
			exceptionCounter++;
		}
		
		address = tfaddress.getText();

		//checking exception for phone number
		
		try{
			phone = tfphone.getText();
			if(check.checkPhonenumber(phone)==false){
				allOkay[2] = false;
				throw new myException();
			}
		}
		catch(myException ex){
			ex.exPhoneNumber();
			exceptionCounter++;
		}
		
		
		//checking exception fo r mail address
		
		try{
			mail = tfmail.getText();
			if(check.checkEmail(mail)== false){
				allOkay[3] = false;
				throw new myException();
			}
		}catch(myException ex){
			ex.exEmail();
			exceptionCounter++;
		}


		bloodGroup = (String)bgrpcomboBox.getSelectedItem();
		graduationSub = (String)subComboBox.getSelectedItem();
        designation = (String)desComboBox.getSelectedItem();
        department = (String)depComboBox.getSelectedItem();
         
        //exception handling here

		boolean finalCheck = true;

		for(Boolean bool : allOkay){
			if(bool == false){
				finalCheck = false;
				break;
			}
		}

		

		if(finalCheck){
			Employee emp = new Employee(name, salary, address, phone, mail, bloodGroup, graduationSub, designation, department, employeeID);

			
			System.out.println(emp);
			
			//add the employee id inside the idlist.txt file to keep a record of emp id
			String fileName = "idlist.txt";
			String empid = String.valueOf(emp.employeeID);// int -> string

			try{
				FileWriter fwriter = new FileWriter(fileName, true);
				BufferedWriter bwriter = new BufferedWriter(fwriter);

				bwriter.write(empid);
				bwriter.write('\n');
				bwriter.close();
			}catch(IOException ex){
				System.out.println("error");
			}


			// now we will create a text file to store the employee data
			try{

				File f = new File("UAP"+empid+".txt");
					if(f.createNewFile()){
						FileWriter mywrite = new FileWriter("UAP" + empid  + ".txt");
						
						mywrite.write(
							 emp.name +'\n' +
							 emp.salary +'\n'+
							 emp.address +'\n'+
							 emp.phoneNumber +'\n'+
							 emp.email +'\n'+
							 emp.bloodGroup +'\n'+
							 emp.graduationSubject+'\n'+
							 emp.designation +'\n'+
							 emp.department+'\n'+
							 emp.employeeID +'\n'
						);

						mywrite.close();
					}
					else{
						throw new myException();
					}
				
			}catch(myException ex){
				ex.exID();
				exceptionCounter++;
			}
			catch(IOException ex){
				System.out.println(ex);
			}

			
			
		}

         
		if(exceptionCounter==0) {
			setVisible(false);//closes the window if there's no exception
		}
		exceptionCounter=0;
	}
	

}
