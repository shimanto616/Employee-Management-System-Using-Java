import javax.accessibility.Accessible;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

class myoptionpane extends JComponent implements Accessible{
   
    
    final public void nameException(){
      JOptionPane.showMessageDialog(null,"Name cannot contain any numbers or special characters");
    }

   final public void salaryException(){
    	JOptionPane.showMessageDialog(null, "Salary has to be between 10000 and 100000");
    }

   final public void phonenumberException(){
    	JOptionPane.showMessageDialog(null, "Invalid Phone Number, Length should be 11 digits");
    }

     final public void emailException(){
    	JOptionPane.showMessageDialog(null, "Invalid Email try again");
    }

    final public void idException(){
        JOptionPane.showMessageDialog(null, "this id is alreay exist. Try again");
    }
}

class myException extends Exception{

   

    //exception methods. if the methdos from the ValidationMethods return invlid input for the employee class then
    // we will use these exceptions
	void exName(){
        myoptionpane op = new myoptionpane();
        op.nameException();
    }

    void exSalary(){
        myoptionpane op = new myoptionpane();
        op.salaryException();
    }

    void exPhoneNumber(){
        myoptionpane op = new myoptionpane();
        op.phonenumberException();
        
    }

    void exEmail(){
        myoptionpane op = new myoptionpane();
        op.emailException();
    }

    void exID(){
        myoptionpane op = new myoptionpane();
        op.idException();
    }

}