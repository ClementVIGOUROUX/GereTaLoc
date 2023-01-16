package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Proprietaire;

public class RequeteSelectProprietaireById implements Requete<Proprietaire>{

	@Override
	public String requete() {
		return "select * from SAE_PROPRIETAIRE where id_prop = ?";
	}
	
	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
	
	@Override
	public void parametresT(PreparedStatement prSt, Proprietaire donnee) throws SQLException, ParseException {
		prSt.setInt(1,donnee.getId_Prop());
	}

}
