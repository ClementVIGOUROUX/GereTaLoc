package modele.dao.requetes;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.ParseException;

import modele.Paiement;

public class RequeteSelectPaiementByLogement implements Requete<Paiement>{

	@Override
	public String requete() {
		return "select p.* from SAE_PAIEMENT p, SAE_BAIL b where p.ID_BAIL = b.ID_BAIL AND b.numero_l = ? AND b.id_immeuble = ? ORDER BY DATE_P DESC";
		
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);
		
	}


	@Override
	public void parametresT(PreparedStatement prSt, Paiement donnee) throws SQLException, ParseException {
		
	}

}
