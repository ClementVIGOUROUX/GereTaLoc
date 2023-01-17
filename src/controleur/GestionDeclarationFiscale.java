package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.DeclarationFiscale;

public class GestionDeclarationFiscale implements ActionListener{
	
	private DeclarationFiscale df;
	
	public GestionDeclarationFiscale(DeclarationFiscale df) {
		this.df = df;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case("Quitter"):
				this.df.dispose();
				break;
		}
	}
	
	
}
