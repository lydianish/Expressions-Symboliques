public class Soustraction extends Operation {
	
	public Soustraction(ExpressionSymbolique fg, ExpressionSymbolique fd) {
		super(fg,fd);
		operateur = '-';
	}

    public ExpressionSymbolique derive(Variable x) {
        return new Soustraction(filsGauche.derive(x),filsDroit.derive(x));
    }

	public ExpressionSymbolique simplifie(){
		 ExpressionSymbolique g = filsGauche.simplifie();
		 ExpressionSymbolique d = filsDroit.simplifie();
        //element neutre 0
		if (g.estEntier) {
			ConstanteEntiere g1 = (ConstanteEntiere) g;
			if (g1.getN()==0)
				return new Multiplication(new ConstanteEntiere(-1),d).simplifie();
		}
		if (d.estEntier) {
			ConstanteEntiere d1 = (ConstanteEntiere) d;
			if (d1.getN()==0)
				return g;
		}

		 if (g.estEntier && d.estEntier)
		 	return sub((ConstanteEntiere) g,(ConstanteEntiere) d);
		 	
		 if (g.estRationnel && d.estRationnel)
			return sub((ConstanteRationnelle) g,(ConstanteRationnelle) d);
				
		 if (g.estEntier && d.estRationnel)
			return sub((ConstanteEntiere) g,(ConstanteRationnelle) d);
		 
		 if (g.estRationnel && d.estEntier)
		 	return sub((ConstanteRationnelle) g,(ConstanteEntiere) d);
		 
		 return new Soustraction(g,d);
	}
	
	
	private static ExpressionSymbolique sub(ConstanteEntiere a, ConstanteEntiere b) {
		return new ConstanteEntiere(a.getN()-b.getN());
	}
	private static ExpressionSymbolique sub(ConstanteRationnelle a, ConstanteRationnelle b) {
		ConstanteRationnelle res = new ConstanteRationnelle(a.getNum()*b.getDen()-b.getNum()*a.getDen() ,a.getDen()*b.getDen());
		return res.simplifie();
	}
	
	private static ExpressionSymbolique sub(ConstanteEntiere a,ConstanteRationnelle b){
		return sub(new ConstanteRationnelle(a.getN(),1),b);
	}
	
	private static ExpressionSymbolique sub(ConstanteRationnelle a,ConstanteEntiere b) {
		return sub(b,a);
	}


}
