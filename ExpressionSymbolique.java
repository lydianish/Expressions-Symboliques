public class ExpressionSymbolique {
	
	public void affiche() {
	}
		
	public ExpressionSymbolique simplifie() {
		return null;
	}

	public ExpressionSymbolique derive( Variable x) {
		return null;
	}

	//Attributs

	protected void setEstOperationSymbolique(ExpressionSymbolique g,ExpressionSymbolique d){
		estOperationSymbolique = (g.estOperationSymbolique || g.estConstanteSymbolique || g.estVariable)
								|| (d.estOperationSymbolique || d.estConstanteSymbolique || d.estVariable);
	}

	protected void setEstFonction(ExpressionSymbolique g,ExpressionSymbolique d){
		estFonction = g.estFonction || d.estFonction;
	}

	protected boolean estEntier = false;
	protected boolean estRationnel = false;
	protected boolean estConstanteSymbolique = false;
	protected boolean estVariable = false;
	protected boolean estOperationSymbolique = false;
	protected boolean estFonction = false;

}


