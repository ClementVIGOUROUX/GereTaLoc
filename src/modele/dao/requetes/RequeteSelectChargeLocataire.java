package modele.dao.requetes;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.ParseException;

import modele.Charge;

public class RequeteSelectChargeLocataire implements Requete<Charge>{
	
	

	@Override
	public String requete() {
		return "SELECT C.* FROM sae_locataire l, sae_signer s, sae_bail b,sae_charge c WHERE l.id_loc = s.id_loc AND S.ID_BAIL = B.ID_BAIL AND C.ID_BAIL = B.ID_BAIL AND L.ID_LOC = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}



	@Override
	public void parametresT(PreparedStatement prSt, Charge donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
