package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Proprietaire;
import modele.Revision;

public class RequeteUpdateRevision implements Requete<Revision> {

	@Override
	public String requete() {
		return "update SAE_REVISION set IRL = ? WHERE ID_REVISION = ? " ;
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt,Revision donnee) throws SQLException, ParseException {
		prSt.setFloat(1, donnee.getIrl());
		prSt.setInt(2, donnee.getIdRevision());
	}

}
