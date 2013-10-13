package Gui;

/*
 affiche ... si masqué
 final JTable table = new JTable(rows, headers);

 frame.add(scrollPane, BorderLayout.CENTER);
 JScrollPane scrollPane = new JScrollPane(table);
 scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, new JButton("..."))
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	final JTable table = new JTable();
	
	String[] columnTitles = { "Article", "Auteur", "Date de publication",
			"Format" };
	

	public MainWindow() {

		JButton jButton1 = new JButton("Ajouter un fichier");

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1_actionPerformed(e);
			}
		});


		Object[][] rowData = { { "11", "12", "13", "14" },
				{ "21", "22", "23", "24" }, { "31", "32", "33", "34" },
				{ "41", "42", "44", "44" } };


		DefaultTableModel model = new DefaultTableModel(rowData, columnTitles) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// Only the third column
				return column == 3; // ou false pour tous
			}
		};
		
		table.setModel(model);
		table.setShowGrid(false);// vire le qaudrillage
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // selec tt la ligne

		// Voir si possible avec ligne au lieu de cell
		// TODO catch changement sur une ligne
		ListSelectionModel cellSelectionModel = table.getSelectionModel();

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {

				String selectedData = null;
				int[] selectedRow = table.getSelectedRows();
				int[] selectedColumns = table.getSelectedColumns();
				selectedData = "";
				for (int i = 0; i < selectedRow.length; i++) {
					for (int j = 0; j < selectedColumns.length; j++) {
						try {
							selectedData = (String) table.getValueAt(
									selectedRow[i], selectedColumns[j]);
						} catch (Exception ex) {}
					}
				}
				System.out.println("Selected: " + selectedData);
				
			}
		});

		JPanel southPanel = new JPanel();
		southPanel.add(jButton1);

		this.setTitle("Table");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new JScrollPane(table));// scrollable
		this.add(southPanel, BorderLayout.SOUTH);
		this.setSize(500, 200);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // fenêtre centrée

	}


	void jButton1_actionPerformed(ActionEvent e) {

		String first =  JOptionPane.showInputDialog("Article ?");
		String second = JOptionPane.showInputDialog("Auteur ?");

		Object[] add = {first, second, "C", "D" };

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		model.addRow(add);

		// REMOVe

		// if (table.getSelectedRow() >=0)
		/*
		 * //model.removeRow(table.getSelectedRow());
		 * 
		 * 
		 * //EDIT (alternatif) /* if (table.getSelectedRow() >=0)
		 * data[table.getSelectedRow()][0] = "Edit"; ... table.setModel(new
		 * DefaultTableModel(data,columnTitles));
		 */

	}
	
	public static void main(String args[]) {

		MainWindow matable = new MainWindow();

	}
}
