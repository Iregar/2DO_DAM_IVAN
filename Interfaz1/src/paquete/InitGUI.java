package paquete;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class InitGUI extends JFrame {

	private JPanel contentPane;
	JTextPane PanelTexto = new JTextPane();
	
	JCheckBox Gafas,barbita,tupe,cuello;
	
	JTextArea txtrAr;
	
	
	
	/*
	 *me creo un metodo para hacer los if
	 * 
	 */
 
	 
	 public String elementoSelecionado (){
		 
		 String text = "";
		 if (Gafas.isSelected())
			{
				text += "gafitas";
			}
			
		if (barbita.isSelected())
			{
			text += "barbita";
			}
		if (tupe.isSelected())
		{
		text += "vaya tupeee";
		}
		
		if (cuello.isSelected())
		{
		text += "tiene cuello";
		}
		return text;
		 
	 }
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			System.out.println("Error setting native LAF: " + e);
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitGUI frame = new InitGUI();
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
	public InitGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File\n");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Copy");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Paste");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		Gafas = new JCheckBox("Gafas Pasta");
		panel_5.add(Gafas);
		
		barbita = new JCheckBox("Barbita");
		panel_5.add(barbita);
		
		tupe = new JCheckBox("Tupe");
		panel_5.add(tupe);
		
		cuello = new JCheckBox("Boton cuello");
		panel_5.add(cuello);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_6.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		JRadioButton hombre = new JRadioButton("Hombre");
		panel_9.add(hombre);
		
		JRadioButton mujer = new JRadioButton("Mujer");
		panel_9.add(mujer);
		
		JRadioButton otros = new JRadioButton("Otros");
		panel_9.add(otros);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("");
		
		//me creo un listener para que cuando pinchas en el boton hago algo (on click en .net)
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//llamo a mi metodo y uso los gettes y settes para rellenar PanelTexto y txtarea
				PanelTexto.setText(elementoSelecionado()+ "\n" + txtrAr.getText());
			
				
			}
		});
		panel_8.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(InitGUI.class.getResource("/Iconos/Annoying-Hipster.png")));
		btnNewButton.setMargin(new Insets(0,0,0,0));
		
		//boton del icono mujer que borrara todo el texto
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//le digo que el area Panel texto se ajuste a vacio con setText" "
				PanelTexto.setText("");
			}
		});
		button.setIcon(new ImageIcon(InitGUI.class.getResource("/Iconos/Female-User.png")));
		button.setMargin(new Insets(0,0,0,0));
		button.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_8.add(button);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabbedPane);
		
		JTextArea txtrHibster = new JTextArea();
		txtrHibster.setText("Hipster");
		tabbedPane.addTab("Hipster", null, txtrHibster, null);
		
		JTextArea txtrNoHibster = new JTextArea();
		txtrNoHibster.setText("No Hipster");
		tabbedPane.addTab("No Hipster", null, txtrNoHibster, null);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(10,50,400,400);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_7.add(scrollPane);
		
		txtrAr = new JTextArea();
		txtrAr.setRows(6);
		scrollPane.setViewportView(txtrAr);
		//txtrAr.setBounds(10,10,200,400);
		txtrAr.setText("Area de texto Scrollable");
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		PanelTexto = new JTextPane();
		PanelTexto.setBackground(new Color(255, 250, 240));
		panel_4.add(PanelTexto);
	}
}
