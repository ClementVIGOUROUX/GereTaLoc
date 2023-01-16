package modele.dao.requetes;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.ParseException;

import modele.Revision;

public class RequeteSelectRevisionById implements Requete<Revision>{

	@Override
	public String requete() {
		return "select * from SAE_BAIL where id_revision = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}



	@Override
	public void parametresT(PreparedStatement prSt, Revision donnee) throws SQLException, ParseException {
		prSt.setInt(1, donnee.getIdRevision());
		
	}

}
