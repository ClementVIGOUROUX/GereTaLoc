package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modele.dao.CictOracleDataSource;
import vue.Accueil;
import vue.Connexion;


public class GestionConnexion implements ActionListener, KeyListener {
	
	private Connexion connexion;
	//private Accueil accueil ;
	private  final String nomConnexion = "";
	private  final String motDePasse = "";
	

	public GestionConnexion(Connexion cn) {
		this.connexion = cn ;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			connexion.dispose();
			break;
		case("Connecter"):
			Accueil accueil= (Accueil) this.connexion.getTopLevelAncestor();
			String login = this.connexion.getValeurChLogin();
			String mdp  = new String(this.connexion.getValeurPasswordField());
			
			if (login.equals(nomConnexion) && mdp.equals(motDePasse)) {
				try {
					CictOracleDataSource.creerAcces("VGC4458A", "$iutinfo");
					JOptionPane.showMessageDialog(connexion,"Connexion reussie", "Information", JOptionPane.INFORMATION_MESSAGE);
					accueil.setEstConnecte(true);
					accueil.activerItems(true);
					
					connexion.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			//RAJOUTER POUR SAVOIR LID AFIN DE LUTILISER DANS LE FINDBYID DANS GESTION ACCUEIL MES INFORMATIONS
			} else if (login.equals(nomConnexion)) {
				JOptionPane.showMessageDialog(connexion,"Mot de passe incorrect", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (mdp.equals(motDePasse)) {
				JOptionPane.showMessageDialog(connexion,"Login incorrect", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(connexion,"Login et mot de passe incorrect", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break ;
			
		
		

		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			System.out.println("Touche Entrée Pressé !!!");
			Accueil accueil= (Accueil) this.connexion.getTopLevelAncestor();
			String login = this.connexion.getValeurChLogin();
			String mdp  = new String(this.connexion.getValeurPasswordField());
			
			if (login.equals(nomConnexion) && mdp.equals(motDePasse)) {
				try {
					CictOracleDataSource.creerAcces("VGC4458A", "$iutinfo");
					JOptionPane.showMessageDialog(connexion,"Connexion réussie", "Information", JOptionPane.INFORMATION_MESSAGE);
					accueil.setEstConnecte(true);
					accueil.activerItems(true);
					
					connexion.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			//RAJOUTER POUR SAVOIR LID AFIN DE LUTILISER DANS LE FINDBYID DANS GESTION ACCUEIL MES INFORMATIONS
			} else if (login.equals(nomConnexion)) {
				JOptionPane.showMessageDialog(connexion,"Mot de passe incorrect", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (mdp.equals(motDePasse)) {
				JOptionPane.showMessageDialog(connexion,"Login incorrect", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(connexion,"Login et mot de passe incorrect", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}


	

