import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ustawienia  extends JFrame implements ActionListener{

	JLabel lZmianaTekstu,lObecnyTekst;
	JTextField tNowyTekst;
	JButton bUstaw;
	
	static NotatnikMain notatnik = new NotatnikMain();
	
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
			lObecnyTekst.setBounds(2, 70, 500, 20);
		
		tNowyTekst = new JTextField("Wpisz nowy tekst");
			
			tNowyTekst.setBounds(2, 42, 250, 30);
			tNowyTekst.addActionListener(this);
			
		bUstaw = new JButton("Ustaw");
			
			bUstaw.setBounds(265, 42, 100, 30);
			bUstaw.addActionListener(this);
			
			add(lZmianaTekstu);
			add(lObecnyTekst);
			add(tNowyTekst);
			add(bUstaw);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
		NotatnikMain objNotatnik = new NotatnikMain();
		Ustawienia objUstawienia = new Ustawienia();
		
				//if (zrodlo == )
	}
}
