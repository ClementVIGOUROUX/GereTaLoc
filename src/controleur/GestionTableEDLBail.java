package controleur;

import java.io.File;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.EtatdesLieux;
import modele.dao.DaoEtatdesLieux;
import modele.dao.Iterateur;
import vue.MesLocation;

public class GestionTableEDLBail implements ListSelectionListener {

	private MesLocation mesLocation;
	private DaoEtatdesLieux daoEDL;
	private static EtatdesLieux edl;
	public static File fileEDL;
	
	public GestionTableEDLBail(MesLocation mesLocation) {
		this.mesLocation = mesLocation ;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		this.daoEDL = new DaoEtatdesLieux();
		
		int index = this.mesLocation.getTableetat().getSelectedRow();
		
		Iterateur<EtatdesLieux> iterateurEDL = null;
		try {
			iterateurEDL = daoEDL.findByLogementImmeubleIterateur(GestionTableBail.numeroLogement, String.valueOf(GestionTableBail.idImmeuble));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		List<EtatdesLieux> ledl = new LinkedList<EtatdesLieux>() ;
		
		while (iterateurEDL.hasNext()) {
			ledl.add(iterateurEDL.next());
		}
		
		edl = ledl.get(index);
		
		if (edl.getRepertoire() != null) {
			this.mesLocation.getBtnAjouter().setEnabled(true);
			this.mesLocation.getBtnTelecharger().setEnabled(true);
			GestionTableEDLBail.setFileEDL(new File(edl.getRepertoire()));
		} else {
			this.mesLocation.getBtnAjouter().setEnabled(true);
			this.mesLocation.getBtnTelecharger().setEnabled(false);
		}
		
		System.out.println(edl);
		
	}

	public static EtatdesLieux getEdl() {
		return edl;
	}

	public static File getFileEDL() {
		return fileEDL;
	}

	public static void setEdl(EtatdesLieux edl) {
		GestionTableEDLBail.edl = edl;
	}

	public static void setFileEDL(File fileEDL) {
		GestionTableEDLBail.fileEDL = fileEDL;
	}


	
	
}
