package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import modele.Logement;

public class RequeteSelectLogementSansBail implements Requete<Logement> {
	

		@Override
		public String requete() {
			return "SELECT L.* FROM vgc4458a.SAE_LOGEMENT L "
					+ "WHERE ID_IMMEUBLE = ? "
					+ "MINUS "
					+ "SELECT L.* FROM vgc4458a.sae_IMMEUBLE I, vgc4458a.sae_LOGEMENT L, vgc4458a.sae_BAIL B, vgc4458a.sae_SIGNER S "
					+ "WHERE B.NUMERO_L = L.NUMERO_L "
					+ "AND B.ID_IMMEUBLE = ? "
					+ "AND B.ID_BAIL = S.ID_BAIL ";
		}
		
		@Override
		public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
			prSt.setString(1, id[0]);
			prSt.setString(2, id[1]);
		}
		
		

		@Override
		public void parametresT(PreparedStatement prSt, Logement donnee) throws SQLException, ParseException {
			prSt.setInt(1,donnee.getImmeuble().getIdImmeuble());
			prSt.setInt(2,donnee.getImmeuble().getIdImmeuble());
		}
		


}





