package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import modele.Immeuble;
import modele.Logement;
import modele.dao.DaoLogement;
import vue.AjouterBail;

public class GestionComboLogements implements ActionListener {

	private AjouterBail ajouterBail;
	private DaoLogement daoLogement;
	
	public GestionComboLogements(AjouterBail ajouterBail) {
		this.ajouterBail = ajouterBail ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		daoLogement = new DaoLogement();
		JComboBox<Logement> comboBox = ajouterBail.getComboLogement();
		
		Immeuble immeuble = (Immeuble) ajouterBail.getComboImmeuble().getSelectedItem();
		
		List<Logement> ll = null;
		try {
			ll = daoLogement.findListLogementSansBail(Integer.toString(immeuble.getIdImmeuble()), Integer.toString(immeuble.getIdImmeuble()));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		DefaultComboBoxModel<Logement> dme = new DefaultComboBoxModel<Logement>();
		for (Logement l : ll) {
			dme.addElement(l);
		}
			comboBox.setModel(dme);
	}
		
		
}


