package schedulER_eclipse;
	
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javafx.scene.paint.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginGUI {
	
	//the main can be moved between classes, just here for testing reasons
		public static void main(String[] args) {
			
			new loginGUI();
			
		}
		
		public loginGUI() {{
			JFrame guiFrame = new JFrame();
			
			//make sure the program exits when the frame closes
			guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			guiFrame.setTitle("SchedulER");
			guiFrame.setSize(500,150);
			
			//guiFrame.setBackground(00000F);
			
			//This will center the JFrame in the middle of the screen
			guiFrame.setLocationRelativeTo(null);
			
			//Options for the JComboBox
			String[] majorOptions = {"Computer Science", "Computer Engineering", "Software Engineering"
			,"Mechanical Engineering", "Aerospace Engineering", "Cyber Security Engineering", "Electrical Engineering"};
			
			
			/**************************************************
			 * 
			 * FIRST PANEL - 
			 * 
			 * login and password, button to submit, button to switch to create user
			 * 
			 */
			
			//The first JPanel contains a JLabel and JCombobox
			final JPanel loginPanel = new JPanel();
			loginPanel.setLayout(new GridLayout(3,2));
			JLabel usernameLbl = new JLabel("Username:");
			JTextField usernameInput = new JTextField(10);
			JLabel passwordLbl = new JLabel("Password:");
			JPasswordField passwordInput = new JPasswordField(10);
			JButton submitLogin = new JButton("Submit");
			
			usernameLbl.setHorizontalAlignment(JLabel.CENTER);
			passwordLbl.setHorizontalAlignment(JLabel.CENTER);

			loginPanel.add(usernameLbl);
			loginPanel.add(usernameInput);
			loginPanel.add(passwordLbl);
			loginPanel.add(passwordInput);
			loginPanel.add(submitLogin);
			
			
			
			/**************************************************
			 * 
			 * SECOND PANEL - 
			 * 
			 * login and password, major selection, button to submit, button to switch to create user
			 * 
			 */
			
			final JPanel createPanel = new JPanel();
			createPanel.setLayout(new GridLayout(4, 2, 10, 0));
			//createPanel.setLayout(new MigLayout("ins 15"));

			createPanel.setVisible(false);
			
			JLabel usernameCreateLbl = new JLabel("Create Username:");
			JTextField usernameCreateInput = new JTextField(10);
			JLabel passwordCreateLbl = new JLabel("Create Password:");
			JTextField passwordCreateInput = new JTextField(10);
			JButton submitCreateLogin = new JButton("Submit");
			JLabel majorsLbl = new JLabel("Select Your Major:");
			JComboBox majorSelect = new JComboBox(majorOptions);
			
			//usernameCreateInput.setSize(0, 0);
						
			createPanel.add(usernameCreateLbl);
			createPanel.add(usernameCreateInput);
			createPanel.add(passwordCreateLbl);
			createPanel.add(passwordCreateInput);
			createPanel.add(majorsLbl);
			createPanel.add(majorSelect);
			createPanel.add(submitCreateLogin);
			
			//submitCreateLogin.setHorizontalAlignment(JButton.CENTER);

			
			//Button to switch between panels
			JButton loginCreateBut = new JButton( "Login/Create Account");
			
			
			/**************************************************
			 * 
			 * EVENT HANDLERS - 
			 * 
			 * edit effects of buttons
			 * 
			 */
			
			//The ActionListener class is used to handle the event that happens when the user clicks the button.
			loginCreateBut.addActionListener(new ActionListener()
			{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				//When the login/create button is pressed the setVisible value of the loginPanel and majorPanel is switched from true to value or vice versa.
				createPanel.setVisible(!createPanel.isVisible());
				loginPanel.setVisible(!loginPanel.isVisible());
				System.out.println("Login/Create user panel switch.");
			}
			});
			
			majorSelect.addActionListener (new ActionListener () {
				public void actionPerformed(ActionEvent mSelect) {
					
					//prints selected item - can pass string of major selected
					System.out.println(majorSelect.getSelectedItem());				
			}
			});
			
			submitLogin.addActionListener (new ActionListener () {
				public void actionPerformed(ActionEvent sLogin) {
					
					//checks input - prints message if input is incorrectly submitted (nothing put in)
					if(usernameInput.getText().length() == 0) {
						//no user name input
						System.out.println("no user input");
					}
					if(passwordInput.getText().length() == 0) {
						//no password input
						System.out.println("no pass input");
					}
							
					//prints inputed text from username and password - will take these text inputs and check them against valid accounts
					System.out.println(usernameInput.getText());
					System.out.println(passwordInput.getText());
			}
			});
			
			//The JFrame uses the BorderLayout layout manager.
			//Put the two JPanels and JButton in different areas.
			guiFrame.add(loginPanel, BorderLayout.NORTH);
			guiFrame.add(createPanel, BorderLayout.EAST);
			guiFrame.add(loginCreateBut,BorderLayout.SOUTH);
			
			//make sure the JFrame is visible
			guiFrame.setVisible(true);
		}
}
		
}