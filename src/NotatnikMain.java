
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class NotatnikMain extends JFrame implements ActionListener{
	
	JMenuBar menuBar;
	JMenu mMenuPlik, mMenuNarzedzia, mMenuPomoc;
	JMenuItem MIotworz, MIzapisz, MIwyjscie,MIkonwerter,MIustawienia,
				MIOprogramie,pmKopiuj,pmWklej,pmDolacz;
	JLabel lNaglowek;
	JCheckBox chOpcja;
	JTextArea notatnik;
	JScrollPane scrollpane;
	JTextField tSzukamy;
	JButton bSzukaj,bWybierzKolor;
	JPopupMenu popup;
	JOptionPane info;
	JComboBox comboRozmiar;
		JMenu pmZmienKolor;
		JMenuItem czarny, niebieski,zolty,zielony,rozowy;
			
	String skopiowanyTekst;
	
		public NotatnikMain(){
			
			setSize(800,800);
			setTitle("Notatnik versia 1.0");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
			setLocation(490,100);
	
			lNaglowek = new JLabel("Notatnik wersja 1.0");
			lNaglowek.setBounds(50,20,200,20);
			lNaglowek.setFont(new Font("Serif",Font.BOLD,20));
			add(lNaglowek);
			
//-------------------------MUNU BAR-------------------------------------------
			
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
				mMenuPlik = new JMenu("Plik");
				
						menuBar.add(mMenuPlik); // Dodatnie zakladki plik do menu bar
				
						MIotworz = new JMenuItem("Otwórz",'O');
							MIotworz.addActionListener(this);
						MIzapisz = new JMenuItem("Zapisz",'Z');
							MIzapisz.addActionListener(this);
						MIwyjscie = new JMenuItem("Wyjœcie");
						MIwyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X")); //Dodanie skrótu klawiszowego
							MIwyjscie.addActionListener(this);
						
						mMenuPlik.add(MIotworz);
						mMenuPlik.add(MIzapisz);
						mMenuPlik.addSeparator(); // Dodanie separatora
						mMenuPlik.add(MIwyjscie);
						
				mMenuNarzedzia = new JMenu("Narzedzia");
						
						menuBar.add(mMenuNarzedzia); // Dodatnie opcji do menu bar
			
						MIkonwerter = new JMenuItem("Konwerter");
						MIkonwerter.setEnabled(false);
							MIkonwerter.addActionListener(this);
						chOpcja = new JCheckBox("Opcja 2");
							chOpcja.addActionListener(this);
						MIustawienia = new JMenuItem("Ustawienia");
							MIustawienia.addActionListener(this);
								
						mMenuNarzedzia.add(MIkonwerter);
						mMenuNarzedzia.add(chOpcja);
						mMenuNarzedzia.add(MIustawienia);
						
				menuBar.add(Box.createHorizontalGlue()); // przeniesienie "pomoc" na prawo
				
				mMenuPomoc = new JMenu("Pomoc");
						menuBar.add(mMenuPomoc);
						
						MIOprogramie = new JMenuItem("O programie");
							MIOprogramie.addActionListener(this);
						
						mMenuPomoc.add(MIOprogramie);

//---------------------------NOTATNIK------------------------------------
				notatnik = new JTextArea();
				
				scrollpane = new JScrollPane(notatnik);
				scrollpane.setBounds(50, 50, 680, 640);
				add(scrollpane); 
				
				tSzukamy = new JTextField();
				tSzukamy.setBounds(580, 20, 150, 20);
				add(tSzukamy);
				
				bSzukaj = new JButton("Szukaj");
				bSzukaj.setBounds(480, 20, 90, 20);
				bSzukaj.addActionListener(this);
				add(bSzukaj);

		
//-----------------------------POPUP-MENU-----------------------------------
			popup = new JPopupMenu();
			
			pmKopiuj = new JMenuItem("Kopiuj");
				pmKopiuj.addActionListener(this);
			pmWklej = new JMenuItem("Wklej");
				pmWklej.addActionListener(this);
			pmDolacz = new JMenuItem("Do³¹cz");
				pmDolacz.addActionListener(this);
			pmZmienKolor = new JMenu("Zmieñ kolor");
				
				czarny = new JMenuItem("Czarny");
					czarny.addActionListener(this);
				niebieski = new JMenuItem("Niebieski");
					niebieski.addActionListener(this);
				zolty = new JMenuItem("¯ó³ty");
					zolty.addActionListener(this);
				zielony = new JMenuItem("Zielony");
					zielony.addActionListener(this);
				rozowy = new JMenuItem("Ró¿owy");
					rozowy.addActionListener(this);
				
				pmZmienKolor.add(czarny);
				pmZmienKolor.add(niebieski);
				pmZmienKolor.add(zolty);
				pmZmienKolor.add(zielony);
				pmZmienKolor.add(rozowy);
				
				popup.add(pmKopiuj);
				popup.add(pmWklej);
				popup.add(pmDolacz);
				popup.add(pmZmienKolor);
				
			notatnik.setComponentPopupMenu(popup);
			
//---------------------------COMBO BOX -----------------
			comboRozmiar = new JComboBox();
			comboRozmiar.setBounds(220, 20,100,20);
			comboRozmiar.addItem("Zmieñ rozmiar");
			comboRozmiar.addItem("10");
			comboRozmiar.addItem("15");
			comboRozmiar.addItem("20");
			comboRozmiar.addItem("25");
			comboRozmiar.addItem("W³asny");
				comboRozmiar.addActionListener(this);
			add(comboRozmiar);
			
//------------------------WYBIERZ KOLOR -------------			
						
			bWybierzKolor = new JButton("Wybierz kolor");
			bWybierzKolor.setBounds(325, 20, 150, 20);
			bWybierzKolor.addActionListener(this);
			add(bWybierzKolor);
		}
	
@Override
		public void actionPerformed(ActionEvent a) {
			
			Object zrodlo = a.getSource();

//-----------------------------ZAK£ADKA PLIK----------------
			
			if(zrodlo == MIotworz){
					JFileChooser filechooser = new JFileChooser();
					
					if(filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
						File plik = filechooser.getSelectedFile();
						try{
							Scanner skaner = new Scanner(plik);
							while(skaner.hasNext()){
								notatnik.append(skaner.nextLine()+"\n");
							}
						
							JOptionPane.showMessageDialog(this,"Pomyœlnie otwarto plik!");
						
							skaner.close();
							
						}catch(FileNotFoundException e){
							e.printStackTrace();
						}
					}
		
			}
			
			else if(zrodlo == MIzapisz){
					JFileChooser filechooser = new JFileChooser();
					
					if(filechooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
						File plik = filechooser.getSelectedFile();
						
						try{
							PrintWriter pw = new PrintWriter(plik);
							Scanner skaner = new Scanner(notatnik.getText());
							
							while(skaner.hasNext()){
								pw.println(skaner.nextLine()+"\n");
								}
							
							JOptionPane.showMessageDialog(this,"Pomyœlnie zapisano plik!");
							
							skaner.close();
							pw.close();
							
						}catch(FileNotFoundException e){
							e.printStackTrace();
						}
					}
			}
			
			else if(zrodlo == MIwyjscie){
				
					int odpowiedz = JOptionPane.showConfirmDialog(this,"Czy na pewno chcesz wyjœæ?"
										,"Sure?",JOptionPane.YES_NO_OPTION);
					
					if(odpowiedz == JOptionPane.YES_OPTION){
						dispose();
					}
			}

//--------------------------------ZAK£ADKA NARZÊDZIA------------------			
			
			else if (zrodlo == MIustawienia){
					JFrame oknoOpcje = new JFrame();
					//oknoOpcje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					oknoOpcje.setVisible(true);
					oknoOpcje.setSize(400, 400);
					oknoOpcje.setTitle("Opcje");
					oknoOpcje.setLayout(null);
					oknoOpcje.setLocation(getLocation());
					//TODO 
			}
			
			else if (zrodlo == chOpcja){
				
					if(chOpcja.isSelected()){
						MIkonwerter.setEnabled(true);
					}
					
					else{
						MIkonwerter.setEnabled(false);
					}
				
			}
			
			else if (zrodlo == MIkonwerter){
				
				String sMetry = JOptionPane.showInputDialog("Podaj d³ugoœæ w metrach: ");
				double metry = Double.parseDouble(sMetry);
				double stopy = metry/0.3048;
				String sStopy = String.format("%.2f",stopy);
				JOptionPane.showMessageDialog(null,metry+ " metrów to "+stopy+" stóp");
				
				
			}
			
//-------------------------------ZAK£ADKA O PROGRAMIE-----------
			else if (zrodlo == MIOprogramie){
					JOptionPane.showMessageDialog(this,"Autor aplikacji : Micha³ Szopa\nWersja 1.0");
			}
		
//---------------------ZAKLADKA WYSZUKAJ---------------------
			else if (zrodlo == bSzukaj){
					String tekst = notatnik.getText();
					String szukane = tSzukamy.getText();
					String wystapienia = "";
					
					int i = 0;
					int index;
					int startIndex=0;
					
					while((index = tekst.indexOf(szukane,startIndex)) != -1){
						startIndex = index + szukane.length();
						i++;
						wystapienia = wystapienia + " " + (index+1);
					}
					
					JOptionPane.showMessageDialog(this,szukane +" wyst¹pi³o "+i+" razy, na pozycjach: "+ wystapienia);
			}
	
//----------------------------POPUP MENU-------------------------

			else if (zrodlo == pmKopiuj){
					skopiowanyTekst = notatnik.getSelectedText();
			}
			
			else if (zrodlo == pmWklej){
					notatnik.insert(skopiowanyTekst, notatnik.getCaretPosition()); //Wklejenie do miejsca znajdowania sie kursora
			}
			
			else if (zrodlo == pmDolacz){
					notatnik.append("\n" + skopiowanyTekst);
			}
			
					else if(zrodlo == czarny){
							String zaznaczonyTekst = notatnik.getSelectedText();
						//TODO
					}
					
					else if(zrodlo == niebieski){
						String zaznaczonyTekst = notatnik.getSelectedText();
						//TODO
					}
					
					else if(zrodlo == zolty){
						String zaznaczonyTekst = notatnik.getSelectedText();
						//TODO
					}
					
					else if(zrodlo == zielony){
						String zaznaczonyTekst = notatnik.getSelectedText();
						//TODO
					}
					
					else if(zrodlo == rozowy){
						String zaznaczonyTekst = notatnik.getSelectedText();
						//TODO
					}
			
//---------------------------COMBO BOX-----------------
			else if(zrodlo == comboRozmiar){
					//TODO
			}
			
			
			else if (zrodlo == bWybierzKolor){
					Color kolor = JColorChooser.showDialog(this,"Wybor koloru",Color.BLACK);
					
					notatnik.setForeground(kolor);
				}
			
			
}


public static void main (String[] args){
		
		NotatnikMain aplikacja = new NotatnikMain();
		aplikacja.setVisible(true);
		System.out.print("GHHHH");
	}
	
}