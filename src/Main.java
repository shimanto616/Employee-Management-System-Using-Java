import javax.swing.*;
public class Main {
	
	public static void main(String[] args) {
		
		//shows the main menu window
        JFrame frame = new JFrame("EMS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Window panel = new Window("Employee Management System");
        frame.getContentPane().add(panel);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
	}
}
