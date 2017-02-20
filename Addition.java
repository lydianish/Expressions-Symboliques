public class Addition extends Operation {
	
	public Addition(ExpressionSymbolique fg, ExpressionSymbolique fd) {
		super(fg,fd);
		operateur = '+';
	}

	public ExpressionSymbolique derive(Variable x) {
		return new Addition(filsGauche.derive(x),filsDroit.derive(x));
	}

	public ExpressionSymbolique simplifie(){
		 ExpressionSymbolique g = filsGauche.simplifie();
		 ExpressionSymbolique d = filsDroit.simplifie();
		 //element neutre 0
		if (g.estEntier) {
			ConstanteEntiere g1 = (ConstanteEntiere) g;
			if (g1.getN()==0)
				return d;
		}
		if (d.estEntier) {
			ConstanteEntiere d1 = (ConstanteEntiere) d;
			if (d1.getN()==0)
				return g;
		}
		 if (g.estEntier && d.estEntier)
		 	return add((ConstanteEntiere) g,(ConstanteEntiere) d);
		 	
		 if (g.estRationnel && d.estRationnel)
			return add((ConstanteRationnelle) g,(ConstanteRationnelle) d);
				
		 if (g.estEntier && d.estRationnel)
			return add((ConstanteEntiere) g,(ConstanteRationnelle) d);
		 
		 if (g.estRationnel && d.estEntier)
		 	return add((ConstanteRationnelle) g,(ConstanteEntiere) d);
		 
		 return new Addition(g,d);
	}
	
	
	private static ExpressionSymbolique add(ConstanteEntiere a, ConstanteEntiere b) {
		return new ConstanteEntiere(a.getN()+b.getN());
	}
	private static ExpressionSymbolique add(ConstanteRationnelle a, ConstanteRationnelle b) {
		ConstanteRationnelle res = new ConstanteRationnelle(a.getNum()*b.getDen()+b.getNum()*a.getDen() ,a.getDen()*b.getDen());
		return res.simplifie();
	}
	
	private static ExpressionSymbolique add(ConstanteEntiere a,ConstanteRationnelle b){
		return add(new ConstanteRationnelle(a.getN(),1),b);
	}
	
	private static ExpressionSymbolique add(ConstanteRationnelle a,ConstanteEntiere b) {
		return add(b,a);
	}
	
}
