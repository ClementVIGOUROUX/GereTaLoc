package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Immeuble;

public class RequeteSelectImmeubleById implements Requete<Immeuble> {

	@Override
	public String requete() {
		return "select * from SAE_IMMEUBLE where ID_IMMEUBLE = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1,id[0]);
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Immeuble donnee) throws SQLException, ParseException {
		prSt.setInt(1, donnee.getIdImmeuble());
		
	}

}
