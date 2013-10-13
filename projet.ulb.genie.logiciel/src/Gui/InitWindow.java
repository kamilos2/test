package Gui;

import javax.swing.*;

import java.awt.*;

public class InitWindow {
	public InitWindow() {
		DefaultComboBoxModel mdc = new DefaultComboBoxModel();
		// Le modèle MVC de la première liste déroulante :
		mdc.addElement("un_1");
		mdc.addElement("deux_1");
		mdc.addElement("trois_1");
		mdc.addElement("quatre_1");

		JComboBox jComboBox1 = new JComboBox();
		jComboBox1.setModel(mdc); // la première liste déroulante est dirigée
									// par son modèle MVC

		// Les zones de Textes
		JTextField txtNom = new JTextField(10);// etirement du champs
		JTextField txtAdresse = new JTextField();
		JTextField txtVille = new JTextField();
		JTextField txtPays = new JTextField();
		JTextField txtEmail = new JTextField();

		// Création des labels avec mnémoniques
		JLabel lblNom = new JLabel("Nom Complet");
		lblNom.setDisplayedMnemonic('N'); // Définir le mnémonique
		lblNom.setLabelFor(txtNom); // Définir le composant qui es labelé

		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setDisplayedMnemonic('s');
		lblAdresse.setDisplayedMnemonicIndex(5);
		lblAdresse.setLabelFor(txtAdresse);

		JLabel lblVille = new JLabel("Ville");
		lblVille.setDisplayedMnemonic('V');
		lblVille.setLabelFor(txtVille);

		JLabel lblPays = new JLabel("Pays");
		lblPays.setDisplayedMnemonic('P');
		lblPays.setLabelFor(txtPays);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setDisplayedMnemonic('E');
		lblEmail.setLabelFor(txtEmail);

		JLabel lblCours = new JLabel("Cours");
		lblCours.setDisplayedMnemonic('C');
		lblCours.setLabelFor(jComboBox1);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(10, 1, 5, 2));
		p.add(lblNom);
		p.add(txtNom);
		p.add(lblAdresse);
		p.add(txtAdresse);
		p.add(lblVille);
		p.add(txtVille);
		p.add(lblPays);
		p.add(txtPays);
		p.add(lblEmail);
		p.add(txtEmail);
		p.add(lblCours);
		p.add(jComboBox1);

		JFrame f = new JFrame("Création des formulaires en java");
		f.setContentPane(p);
		f.pack();
		f.setVisible(true);
		f.setAlwaysOnTop(true);
		f.setLocationRelativeTo(null); //centrée

	}
}
