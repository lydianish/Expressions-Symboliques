public class ConstanteEntiere extends ExpressionSymbolique {
	

	public ConstanteEntiere(int n) {
		this.n = n;
		estEntier = true;
	}
	
	public void affiche() {
		if (n<0)
			System.out.print("("+n+")");
		else
			System.out.print(n);
	}
	
	public ExpressionSymbolique simplifie() {
		return this;
	}

	public ExpressionSymbolique derive( Variable x) {return new ConstanteEntiere(0);}

	//Attributs

	public int getN() {
		return n;
	}
	private int n;
}
