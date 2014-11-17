package paquete;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class GardenCare extends JFrame {

	private JPanel contentPane;
	private JPanel panel1;
	//private JOptionPane frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GardenCare frame = new GardenCare();
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
	public GardenCare() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		panel1 = new JPanel();
		contentPane.add(panel1);
		
		JToolBar toolBar = new JToolBar();
		panel1.add(toolBar);
		
		JLabel lblNewLabel = new JLabel("Perfect Sun");
		lblNewLabel.setIcon(new ImageIcon(GardenCare.class.getResource("/Iconos/Sunshine.png")));
		toolBar.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cloudly");
		lblNewLabel_1.setIcon(new ImageIcon(GardenCare.class.getResource("/Iconos/Cloudy.png")));
		toolBar.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rains");
		lblNewLabel_2.setIcon(new ImageIcon(GardenCare.class.getResource("/Iconos/Cloud-Download.png")));
		toolBar.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Windy");
		lblNewLabel_3.setIcon(new ImageIcon(GardenCare.class.getResource("/Iconos/Refresh.png")));
		toolBar.add(lblNewLabel_3);
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		
		JPanel panel2_1 = new JPanel();
		panel2.add(panel2_1);
		panel2_1.setLayout(new GridLayout(1, 0, 0, 0));
		String [] datos = {"Weather","Petrol","Milk"};
		JList list = new JList(datos);
		list.setBackground(Color.GRAY);
		list.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel2_1.add(list);
		
		JButton btnNewButton = new JButton("");
		panel2.add(btnNewButton);
		
		//me creo oun escuchador para lanzar un evento
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			// JoptionPane para lanzar un msgbox 
			 String message = "Are you 100% sure?";
			 Component frame = null;
			int answer = JOptionPane.showConfirmDialog(frame, message);
			 if (answer == JOptionPane.YES_OPTION) {
			 // User clicked YES. 
			 } else if (answer == JOptionPane.NO_OPTION) {
			 // User clicked NO.
		}
		}
		});
		btnNewButton.setIcon(new ImageIcon(GardenCare.class.getResource("/Iconos/Water-Drop@Low.png")));
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		
		
		JPanel panel3 = new JPanel();
		contentPane.add(panel3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel3.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSlider slider = new JSlider();
		slider.setToolTipText("Indicador");
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		panel.add(slider);
		slider.setValue(25);
		
		JPanel panel4 = new JPanel();
		contentPane.add(panel4);
		
		JPanel panel_1 = new JPanel();
		panel4.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_4.setIcon(new ImageIcon(GardenCare.class.getResource("/Iconos/hierba-footer.png")));
		panel_1.add(lblNewLabel_4);
	}

}
