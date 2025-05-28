import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JPanel implements ActionListener{

	//setting actions
	private enum Actions{
		ADD,
		REMOVE,
		UPDATE,
		VIEW
	}
	
	//WINDDOW
	public int frame_width = 1200; //16:9
	public int frame_height = 675;
	
	//HEADING 
	public int title_width = 800;
	public int title_height = 70;
	public int title_X = ((frame_width-title_width)/2) + 10;
	public int title_Y = (frame_height-title_height)/3;
	
    private String text;

    public Window(String text) {
        this.text = text;
        setPreferredSize(new Dimension(1200, 675));
    }

 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //gradient colors and direction
        Point start = new Point(0, 0);
        Point end = new Point(0, getHeight());
        Color color1 = new Color(134, 70, 156); //Purple
        Color color2 = new Color(216, 98, 188); // yellow
        GradientPaint gradient = new GradientPaint(start, color1, end, color2, true);

        // Set the gradient paint for the background
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        //heading configuration
        JLabel heading = new JLabel("Employee Management System");// Adjust font size as needed
        heading.setFont(new Font("Serif", Font.BOLD, 58));
        heading.setForeground(new Color(255, 215, 0));
        heading.setBounds(title_X, title_Y, title_width, title_height);
        add(heading);
        
        //>>button configuration<<
        //add button
        JButton addemp = new JButton("Add Employee");
        addemp.setFont(new Font("Arial", Font.PLAIN, 16));
        addemp.setForeground(new Color(0, 0, 0));
        addemp.setBorder(null);
        addemp.setBackground(Color.WHITE);
        addemp.addActionListener(this);
        addemp.setActionCommand(Actions.ADD.name());
        addemp.setBounds(430, 337, 150, 50);
        add(addemp);
        
        //remove button
        JButton rememp = new JButton("Remove Employee");
        rememp.setFont(new Font("Arial", Font.PLAIN, 16));
        rememp.setForeground(new Color(0, 0, 0));
        rememp.setBorder(null);
        rememp.setBackground(Color.WHITE);
        rememp.addActionListener(this);
        rememp.setActionCommand(Actions.REMOVE.name());
        rememp.setBounds(630, 337, 150, 50);
        add(rememp);
        
        //view button
        JButton view = new JButton("View List");
        view.setFont(new Font("Arial", Font.PLAIN, 16));
        view.setForeground(new Color(0, 0, 0));
        view.setBorder(null);
        view.setBackground(Color.WHITE);
        view.addActionListener(this);
        view.setActionCommand(Actions.VIEW.name());
        view.setBounds(430, 437, 150, 50);
        add(view);
        
        //update button
        JButton update = new JButton("Update");
        update.setFont(new Font("Arial", Font.PLAIN, 16));
        update.setForeground(new Color(0, 0, 0));
        update.setBorder(null);
        update.setBackground(Color.WHITE);
        update.addActionListener(this);
        update.setActionCommand(Actions.UPDATE.name());
        update.setBounds(630, 437, 150, 50);
        add(update);
        
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
    	
    	if (e.getActionCommand() == Actions.ADD.name()) {
    		new AddEmployee();//add employee menu
		    } 
		else if (e.getActionCommand() == Actions.REMOVE.name()) {
			new RemoveEmployee();//remove employee menu
		    }
		else if (e.getActionCommand() == Actions.UPDATE.name()) {
			new Update();
		    }
		else if (e.getActionCommand() == Actions.VIEW.name()) {
			new View();
		    }
	}
}