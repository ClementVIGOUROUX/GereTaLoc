package modele.dao.requetes;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Bail;

public class RequeteUpdateBailDateFin implements Requete<Bail> {

	@Override
	public String requete() {
		return "update SAE_BAIL set DATE_FIN = ? WHERE ID_BAIL = ? " ;
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt,Bail donnee) throws SQLException, ParseException {
		prSt.setDate(1, Date.valueOf(donnee.getDateDebut()));
		prSt.setInt(2, donnee.getIdBail());
	}

}
