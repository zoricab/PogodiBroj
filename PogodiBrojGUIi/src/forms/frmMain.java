package forms;


import javax.swing.JFrame;
import javax.swing.JTextField;

import classes.PogodiBroj;
import enums.Stanje;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class frmMain {

	public JFrame frame;
	private JTextField unosGranice;
	private JTextField unosBroja;
	private JButton btnUnesiBroj;
	private JButton btnGranica;
	private JLabel brDozvoljenihGr;
	private JLabel trenStanje;
	protected PogodiBroj broj;
	private JLabel brojTrenGreski;


	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
		this.broj = new PogodiBroj();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		unosGranice = new JTextField();
		unosGranice.setBounds(49, 39, 86, 20);
		frame.getContentPane().add(unosGranice);
		unosGranice.setColumns(10);
		
		btnGranica = new JButton("Unesi granicu");
		btnGranica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//try{
				//broj.setGornjaGr(unosGranice.getText().length());
				int gornjaGranica = Integer.parseInt(unosGranice.getText());
				broj.setGornjaGr(gornjaGranica);
				brDozvoljenihGr.setText(String.valueOf(broj.getBrDozGreski()));
				brojTrenGreski.setText(String.valueOf(broj.getBrTrenGreski()));
				//}
				
				//catch (Exception ex)
				//{
					
				//}
				
			}
		});
		btnGranica.setBounds(176, 38, 89, 23);
		frame.getContentPane().add(btnGranica);
		
		unosBroja = new JTextField();
		unosBroja.setBounds(49, 97, 86, 20);
		frame.getContentPane().add(unosBroja);
		unosBroja.setColumns(10);
		
		btnUnesiBroj = new JButton("Unesi broj");
		btnUnesiBroj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int brojUnosa = Integer.parseInt(unosBroja.getText());
				broj.Validacija(brojUnosa);
				
				//broj.setUneseniBr(unosBroja.getText().length());
				brojTrenGreski.setText(String.valueOf(broj.getBrTrenGreski()));
				trenStanje.setText(String.valueOf(broj.getStanje()));
			
				try{
				if(broj.isTerminirajProgram()){
					
					if(broj.getStanje() == Stanje.sPogodjen)
						JOptionPane.showMessageDialog(null, "Trazeni br je" + String.valueOf(broj.getTrazeniBr()), "Pogodili ste br", JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, String.valueOf(broj.getTrazeniBr()), "Trazeni br je", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);								
					}
				}	
				catch (Exception ex){
					
				}
			}
		});
		btnUnesiBroj.setBounds(176, 96, 89, 23);
		frame.getContentPane().add(btnUnesiBroj);
		
		JLabel lblBrDozGreski = new JLabel("Br doz greski:");
		lblBrDozGreski.setBounds(49, 164, 86, 14);
		frame.getContentPane().add(lblBrDozGreski);
		
		brDozvoljenihGr = new JLabel("");
		brDozvoljenihGr.setBounds(191, 164, 46, 14);
		frame.getContentPane().add(brDozvoljenihGr);
		
		JLabel lblStanje = new JLabel("Stanje:");
		lblStanje.setBounds(49, 214, 46, 14);
		frame.getContentPane().add(lblStanje);
		
		trenStanje = new JLabel("");
		trenStanje.setBounds(176, 204, 46, 14);
		frame.getContentPane().add(trenStanje);
		
		JLabel lblNewLabel = new JLabel("Broj trenutnih gresaka");
		lblNewLabel.setBounds(20, 189, 115, 14);
		frame.getContentPane().add(lblNewLabel);
		
		brojTrenGreski = new JLabel("");
		brojTrenGreski.setBounds(191, 189, 46, 14);
		frame.getContentPane().add(brojTrenGreski);
	}
}
