public class Operation extends ExpressionSymbolique {
	
	public Operation(ExpressionSymbolique fg, ExpressionSymbolique fd) {
		filsGauche = fg;
		filsDroit = fd;
		setEstOperationSymbolique(fg,fd);
		setEstFonction(fg,fd);
	}
	
	public void affiche(){
		System.out.print("(");
		filsGauche.affiche();
		System.out.print(" " + operateur + " ");
		filsDroit.affiche();
		System.out.print(")");
	}

	//Atributs

	public char getOperateur(){return operateur;}
    public ExpressionSymbolique getFilsGauche(){return filsGauche;}
    public ExpressionSymbolique getFilsDroit(){return filsDroit;}

    protected ExpressionSymbolique filsGauche;
    protected ExpressionSymbolique filsDroit;
    protected char operateur;
	
}
