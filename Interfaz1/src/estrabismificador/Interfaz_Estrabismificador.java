package estrabismificador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import java.awt.GridLayout;

import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;

import java.awt.Component;

import javax.swing.DefaultComboBoxModel;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Box;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_Estrabismificador extends JFrame {

	private JPanel contentPane;
	private JToolBar toolBar;
	private JTable table;
	private JLabel lblAnswer;
	private ButtonGroup bGroup;	//crear grupo de botones para exclusividad

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Estrabismificador frame = new Interfaz_Estrabismificador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz_Estrabismificador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 416);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_3 = new JMenu("New menu");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save");
		mnNewMenu_3.add(mntmSaveAs);
		
		JMenuItem mntmSavepdf = new JMenuItem("Save .pdf");
		mnNewMenu_3.add(mntmSavepdf);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnNewMenu.add(mntmClose);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnNewMenu_1.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnNewMenu_1.add(mntmPaste);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnNewMenu_2.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		panel.add(toolBar);
		
		JLabel lblNewLabel = new JLabel("Games");
		lblNewLabel.setIcon(new ImageIcon(Interfaz_Estrabismificador.class.getResource("/Iconos/Controller.png")));
		toolBar.add(lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(30);
		toolBar.add(verticalStrut);
		
		JLabel lblNewLabel_1 = new JLabel("Movies");
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz_Estrabismificador.class.getResource("/Iconos/Digital.png")));
		toolBar.add(lblNewLabel_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(30);
		toolBar.add(verticalStrut_1);
		
		JLabel lblNewLabel_2 = new JLabel("Music");
		lblNewLabel_2.setIcon(new ImageIcon(Interfaz_Estrabismificador.class.getResource("/Iconos/Music-note.png")));
		toolBar.add(lblNewLabel_2);
		
		Component verticalStrut_3 = Box.createVerticalStrut(30);
		toolBar.add(verticalStrut_3);
		
		JLabel lblNewLabel_3 = new JLabel("Settings");
		lblNewLabel_3.setIcon(new ImageIcon(Interfaz_Estrabismificador.class.getResource("/Iconos/Preferences.png")));
		toolBar.add(lblNewLabel_3);
		
		Component verticalStrut_2 = Box.createVerticalStrut(30);
		toolBar.add(verticalStrut_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
	
		
		table = new JTable();
		panel_3.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"John",null, null, null},
				{null, null, null, null},
				{"ae", null, null, "pepa"},
				{null, "Victor", null, null},
				{null, null, "Manolito", null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		final JLabel lblAnswer = new JLabel("Answer");
		panel_4.add(lblAnswer);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(4, 0, 0, 0));
		
		//creamos ButtonGroup instanciado arriba

				ButtonGroup bGroup = new ButtonGroup();

				//poner borde al panel

				TitledBorder title;

				title = BorderFactory.createTitledBorder("Choose an option");

				panel_5.setBorder(title);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mami");
		panel_5.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Papi");
		panel_5.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Jander");
		panel_5.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Dander");
		panel_5.add(rdbtnNewRadioButton_3);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumSize(new Dimension(40000, 32767));
		comboBox.setMaximumRowCount(12);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"one", "two", "three"}));
		panel_6.add(comboBox, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
	
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "Do you want to close this windows?";
				String cadena = "Goodbye !!!";
				Component frame = null;
				//si digo yes cerrara la apliacion
				int answer = JOptionPane.showConfirmDialog(frame, message);
				if (answer == JOptionPane.YES_OPTION) {
					int respuesta = JOptionPane.showConfirmDialog(frame, cadena);
					System.exit(answer);
					//si digo no me mostrará escribirá un mensaje en otra area
				}else if (answer == JOptionPane.NO_OPTION){
					lblAnswer.setText("Go on¡¡¡ Please look at more options");
				}
			}
		});
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_7.add(horizontalGlue);
		btnNewButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_7.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_7.add(btnNewButton_1);
	}

}
