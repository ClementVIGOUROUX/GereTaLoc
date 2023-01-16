package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modele.Proprietaire;
import modele.dao.DaoProprietaire;
import vue.InformationProp;

public class GestionInfoProp implements ActionListener {

	private InformationProp informationProp ;
	private DaoProprietaire daoProp ;
	private boolean isModifiable ;
	
	public GestionInfoProp(InformationProp iprop) {
		this.informationProp = iprop ;
		this.daoProp = new DaoProprietaire() ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			informationProp.dispose();
			break;
		case("Valider"):
			Proprietaire prop = new Proprietaire(1,this.informationProp.getTnom(), this.informationProp.getTprenom(), this.informationProp.getTmail(), this.informationProp.getTnum());
			try {
				this.daoProp.update(prop);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			informationProp.dispose();
			break;
		case("Modifier"):
			isModifiable = informationProp.getCheckm().isSelected();
			if (isModifiable) {
				informationProp.activerModif(true);
			} else {
				informationProp.activerModif(false);
			}
			
		}
	}
}
