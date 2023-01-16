package modele.dao.requetes;

import modele.Agence;

public class RequeteDeleteAgence extends RequeteSelectAgenceById implements Requete<Agence> {

	@Override
	public String requete() {
		return "delete from SAE_AGENCE where Numero_Siret = ? ";
	}


}
