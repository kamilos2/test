package Gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class exempleWindow extends JFrame {
	DefaultComboBoxModel mdc = new DefaultComboBoxModel();

	JComboBox jComboBox2 = new JComboBox();
	JComboBox jComboBox1 = new JComboBox();
	JTextArea jTextArea1 = new JTextArea();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();

	// Construire le cadre
	public exempleWindow() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Initialiser le composant
	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(343, 253));
		this.setTitle("Listes déroulantes en Java/Swing");
		jTextArea1.setBounds(new Rectangle(180, 15, 127, 101));
		jButton1.setText("jButton1");
		jButton1.setBounds(new Rectangle(24, 142, 272, 28));

		// Ecouteur de jButton1 en classe anonyme :
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1_actionPerformed(e);
			}
		});

		jComboBox2.setBounds(new Rectangle(21, 92, 130, 25));
		jComboBox1.setBounds(new Rectangle(19, 36, 129, 23));
		jComboBox1.setModel(mdc); // la première liste déroulante est dirigée
									// par son modèle MVC
		jButton2.setText("jButton2");
		jButton2.setBounds(new Rectangle(23, 184, 274, 30));

		// Ecouteur de jButton2 en classe anonyme :
		jButton2.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jButton2_actionPerformed(e);
			}
		});

		this.getContentPane().add(jComboBox1, null);
		this.getContentPane().add(jComboBox2, null);
		this.getContentPane().add(jTextArea1, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jButton1, null);

		// Le modèle MVC de la première liste déroulante :
		mdc.addElement("un_1");
		mdc.addElement("deux_1");
		mdc.addElement("trois_1");
		mdc.addElement("quatre_1");

		// La seconde liste déroulante est chargée directement :
		jComboBox2.addItem("un_2");
		jComboBox2.addItem("deux_2");
		jComboBox2.addItem("trois_2");
		jComboBox2.addItem("quatre_2");

		this.setVisible(true);

		/*
		 * addWindowListener(new WindowAdapter() { public void
		 * windowClosing(WindowEvent e) { System.exit(0); } } );
		 */

	}

	// Remplacé (surchargé) pour pouvoir quitter lors de System Close
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}

	void jButton1_actionPerformed(ActionEvent e) {
		jTextArea1.append((String) jComboBox1.getSelectedItem() + "\n");
	}

	void jButton2_actionPerformed(ActionEvent e) {
		jTextArea1.append((String) jComboBox2.getSelectedItem() + "\n");
	}

	public static void main(String[] args) {

		exempleWindow fen3 = new exempleWindow();

	}
}