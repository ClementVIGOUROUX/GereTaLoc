package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Diagnostics;
import modele.EtatdesLieux;

public class RequeteUpdateEDLRepertoire implements Requete<EtatdesLieux> {

	@Override
	public String requete() {
		return "update SAE_ETATDESLIEUX set REPERTOIRE = ? where ID_EDL = ?  ";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, EtatdesLieux donnee) throws SQLException, ParseException {
		prSt.setString(1, donnee.getRepertoire());
		prSt.setInt(2, donnee.getIdEDL());
		
	}

}
