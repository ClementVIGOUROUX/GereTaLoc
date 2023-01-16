package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Proprietaire;

public class RequeteUpdateProprietaire implements Requete<Proprietaire> {

	@Override
	public String requete() {
		return "update SAE_PROPRIETAIRE set NOM = ? , PRENOM = ? , EMAIL = ? , TEL = ?  where ID_PROP = ? ";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Proprietaire donnee) throws SQLException, ParseException {
		prSt.setString(1, donnee.getNom());
		prSt.setString(2, donnee.getPrenom());
		prSt.setString(3, donnee.getEmail());
		prSt.setString(4, donnee.getTelephone());
		prSt.setInt(5, donnee.getId_Prop());
		
	}

}
