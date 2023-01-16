package modele ;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Logement {
	
	private String numero ;
	//private int etage ; a voir
	private String surface ; //en m2
	private int nbPieces ;
	private boolean garage ;
	private String parking ; // si pas de place, mettre null
	private Proprietaire proprietaire ; //inutile de mettre dans le constructeur car tout le temps le meme
	private Immeuble immeuble ;
	private List<Bail> baux = new ArrayList<Bail>();
	private List<Diagnostics> listeDiagnostics ; //list ou collection ?
	private List<Revision> listeRevisions ;
	private List<Facture> listeFactures ;
	
	
	public Logement(String numero, String surface, int nbPieces, boolean garage, String parking, Immeuble immeuble, Bail bail) {
		super();
		this.numero = numero;
		this.surface = surface;
		this.nbPieces = nbPieces;
		this.garage = garage;
		this.parking = parking;
		this.immeuble = immeuble; 
		this.baux.add(bail);
	}




	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getSurface() {
		return surface;
	}


	public void setSurface(String surface) {
		this.surface = surface;
	}


	public int getNbPieces() {
		return nbPieces;
	}


	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}


	public boolean isGarage() {
		return garage;
	}


	public void setGarage(boolean garage) {
		this.garage = garage;
	}


	public String getParking() {
		return parking;
	}


	public void setParking(String parking) {
		this.parking = parking;
	}


	public Proprietaire getProprietaire() {
		return proprietaire;
	}


	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}


	public Immeuble getImmeuble() {
		return immeuble;
	}


	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}


	public List<Diagnostics> getListeDiagnostics() {
		return listeDiagnostics;
	}


	public void setListeDiagnostics(List<Diagnostics> listeDiagnostics) {
		this.listeDiagnostics = listeDiagnostics;
	}


	public List<Revision> getListeRevisions() {
		return listeRevisions;
	}


	public void setListeRevisions(List<Revision> listeRevisions) {
		this.listeRevisions = listeRevisions;
	}


	public List<Facture> getListeFactures() {
		return listeFactures;
	}


	public void setListeFactures(List<Facture> listeFactures) {
		this.listeFactures = listeFactures;
	}


	public Bail getBail() {
		return this.baux.get(this.baux.size() - 1);
	}


	public void setBail(Bail bail) {
		this.baux.add(bail);
	}


	@Override
	public int hashCode() {
		return Objects.hash(immeuble, numero);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Logement)) {
			return false;
		}
		Logement other = (Logement) obj;
		return Objects.equals(immeuble, other.immeuble) && Objects.equals(numero, other.numero);
	}




	@Override
	public String toString() {
		return "Logement N°" + this.numero + ", " + this.immeuble.getRue() + " à " +  this.immeuble.getVille().toUpperCase() ;
	}

	
	public String toStringIHM() {
		return "Logement [numero=" + numero + ", surface=" + surface + ", nbPieces=" + nbPieces + ", garage=" + garage
				+ ", parking=" + parking + ", proprietaire=" + proprietaire + ", immeuble=" + immeuble + ", baux="
				+ baux + "]";
	}

	
	
	
	
	
	
}