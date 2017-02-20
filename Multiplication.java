public class Multiplication extends Operation {
	
	public Multiplication(ExpressionSymbolique fg, ExpressionSymbolique fd) {
		super(fg,fd);
		operateur = '*';
	}

	public void affiche(){
		if (filsGauche.estEntier && (filsDroit.estOperationSymbolique||filsDroit.estFonction)){
			ConstanteEntiere g = (ConstanteEntiere) filsGauche;
			if (g.getN()==(-1)){
				System.out.print("(- ");
				filsDroit.affiche();
				System.out.print(")");
			}
			else
				super.affiche();
		}
		else{
			if ((filsGauche.estOperationSymbolique||filsGauche.estFonction) && filsDroit.estEntier){
				ConstanteEntiere d = (ConstanteEntiere) filsDroit;
				if (d.getN()==(-1)){
					System.out.print("(- ");
					filsGauche.affiche();
					System.out.print(")");
				}
				else
					super.affiche();
			}
			else
				super.affiche();
		}
	}

	public ExpressionSymbolique derive(Variable x) {
		return new Addition(new Multiplication(filsGauche.derive(x),filsDroit),
							new Multiplication(filsGauche,filsDroit.derive(x)));
	}

	public ExpressionSymbolique simplifie(){
		 ExpressionSymbolique g = filsGauche.simplifie();
		 ExpressionSymbolique d = filsDroit.simplifie();
		//element absorbant 0 et element neutre 1
		if (g.estEntier) {
			ConstanteEntiere g1 = (ConstanteEntiere) g;
			if (g1.getN()==0)
				return new ConstanteEntiere(0);
			if (g1.getN()==1)
				return d;
		}
		if (d.estEntier) {
			ConstanteEntiere d1 = (ConstanteEntiere) d;
			if (d1.getN()==0)
				return new ConstanteEntiere(0);
			if (d1.getN()==1)
				return g;
		}

		 if (g.estEntier && d.estEntier)
		 	return mult((ConstanteEntiere) g,(ConstanteEntiere) d);
		 	
		 if (g.estRationnel && d.estRationnel)
			return mult((ConstanteRationnelle) g,(ConstanteRationnelle) d);
				
		 if (g.estEntier && d.estRationnel)
			return mult((ConstanteEntiere) g,(ConstanteRationnelle) d);
		 
		 if (g.estRationnel && d.estEntier)
		 	return mult((ConstanteRationnelle) g,(ConstanteEntiere) d);

		 return new Multiplication(g,d);
	}
	
	
	private static ExpressionSymbolique mult(ConstanteEntiere a, ConstanteEntiere b) {
		return new ConstanteEntiere(a.getN()*b.getN());
	}
	private static ExpressionSymbolique mult(ConstanteRationnelle a, ConstanteRationnelle b) {
		ConstanteRationnelle res = new ConstanteRationnelle(a.getNum()*b.getNum() ,a.getDen()*b.getDen());
		return res.simplifie();
	}
	
	private static ExpressionSymbolique mult(ConstanteEntiere a,ConstanteRationnelle b){
		return mult(new ConstanteRationnelle(a.getN(),1),b);
	}
	
	private static ExpressionSymbolique mult(ConstanteRationnelle a,ConstanteEntiere b) {
		return mult(b,a);
	}
}
