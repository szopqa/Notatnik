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
	
	public Ustawienia(){
		
		setVisible(true);
		setSize(400, 400);
		setTitle("Opcje");
		setLayout(null);
		setLocation(680,300);
		
		NotatnikMain notatnik = new NotatnikMain();
		String aktualnyTekst = notatnik.lNaglowek.getText();
		
		lZmianaTekstu = new JLabel();
		
		lZmianaTekstu.setText("Zmiana wyswtetlanego tekstu");
		lZmianaTekstu.setFont(new Font("SansSerif",Font.BOLD,18));
		lZmianaTekstu.setBounds(2,20,300,20);
		
		lObecnyTekst = new JLabel();
		lObecnyTekst.setText("Obecny tekst: "+aktualnyTekst);
		lObecnyTekst.setFont(new Font("SansSerif",Font.PLAIN,13));
		lObecnyTekst.setBounds(2,70,500,20);
		
		tNowyTekst = new JTextField("Wpisz nowy tekst");
		tNowyTekst.setBounds(2,42,250,30);
		
		bUstaw = new JButton("Ustaw");
		bUstaw.setBounds(265, 42,100,30);
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
		
				if (zrodlo == bUstaw){
						String nowyTytul = objUstawienia.tNowyTekst.getText();
						objNotatnik.lNaglowek.setText(nowyTytul);
						//JOptionPane.showMessageDialog(this,nowyTytul);
				}
		
	}
}
