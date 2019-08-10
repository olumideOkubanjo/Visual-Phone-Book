package PhoneBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VisualPhoneBook {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualPhoneBook window = new VisualPhoneBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VisualPhoneBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public JFrame getFrame() {
		return frame;
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 404, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton listPeople = new JButton("Add Person");
		listPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicked Add Person");
				
				// Show Add Person Form
				frame.dispose();//Hides the window
				AddPerson addP = new AddPerson();
				addP.setVisible(true);
			}
		});
		
		JLabel title = new JLabel("Visual PhoneBook");
		title.setBackground(new Color(0, 0, 0));
		title.setForeground(new Color(0, 0, 0));
		title.setFont(new Font("Stencil", Font.PLAIN, 32));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(title);
		listPeople.setForeground(new Color(165, 42, 42));
		listPeople.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		listPeople.setBackground(Color.ORANGE);
		listPeople.setToolTipText("Click to Add New Person");
		frame.getContentPane().add(listPeople);
		
		JButton viewPeople = new JButton("View People In Phone Book");
		viewPeople.setForeground(Color.BLUE);
		viewPeople.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		viewPeople.setBackground(Color.CYAN);
		viewPeople.setToolTipText("Click to View the PhoneBook");
		viewPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Click View People ");
				
				//Show List People Page
				frame.dispose();
				ViewPeople viewP;
				try {
					viewP = new ViewPeople();
					viewP.setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				
				PhoneBook pb = new PhoneBook();
				try {
					pb.loadPhoneBook();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(viewPeople);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{viewPeople}));
	}
}
