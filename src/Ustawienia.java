import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ustawienia  extends JFrame implements ActionListener{

	JLabel lZmianaTekstu,lObecnyTekst,test;
	JButton bZmien;
	
	static NotatnikMain notatnik = new NotatnikMain();
	static Ustawienia ustawienia = new Ustawienia ();
	
	public String nowyTekst ;
	
	public Ustawienia(){
		
		setSize (400,400);
		setTitle ("Ustawienia");
		setLayout(null);
		setLocation(680,300);
		
		String aktualnyTekst = notatnik.lNaglowek.getText();
		
		lZmianaTekstu = new JLabel();
			
			lZmianaTekstu.setText("Zmiana wyœwietlanego tekstu");
			lZmianaTekstu.setFont(new Font("Sans Serif",Font.BOLD,18));
			lZmianaTekstu.setBounds(2, 20, 300, 20);
			
		lObecnyTekst = new JLabel();
			
			lObecnyTekst.setText("Obecny tekst "+aktualnyTekst);
			lObecnyTekst.setFont(new Font("Sans Serif",Font.PLAIN,13));
			lObecnyTekst.setBounds(2, 45, 500, 20);
		
		bZmien = new JButton("Zmieñ");
			
			bZmien.setBounds(275, 20, 100, 30);
			bZmien.addActionListener(this);
	
		test = new JLabel();
		
			test.setBounds(250, 100, 100, 20);
			test.setText("Tu jestem!");
			
			add(lZmianaTekstu);
			add(lObecnyTekst);
			add(bZmien);
			add(test);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
		
				if(zrodlo == bZmien){
					String nowyTekst = JOptionPane.showInputDialog("Wpisz nowy naglówek: ");
					
					test.setText(nowyTekst);
					notatnik.lNaglowek.setText(nowyTekst);
				}
		
	}
}
