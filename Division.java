import java.lang.ArithmeticException;

public class Division extends Operation {
	
	public Division(ExpressionSymbolique fg, ExpressionSymbolique fd) {
		super(fg,fd);
		operateur = '/';
	}

    public ExpressionSymbolique derive(Variable x) {
        return new Division(new Soustraction(new Multiplication(filsGauche.derive(x),filsDroit),
                                            new Multiplication(filsGauche,filsDroit.derive(x))),
                            new Puissance(filsDroit,2));
    }

	public ExpressionSymbolique simplifie() throws ArithmeticException{
		 ExpressionSymbolique g = filsGauche.simplifie();
		 ExpressionSymbolique d = filsDroit.simplifie();
        //element absorbant 0 et element neutre 1
        if (g.estEntier) {
            ConstanteEntiere g1 = (ConstanteEntiere) g;
            if (g1.getN()==0)
                return new ConstanteEntiere(0);
        }
        if (d.estEntier) {
            ConstanteEntiere d1 = (ConstanteEntiere) d;
            if (d1.getN()==0)
                throw new ArithmeticException("Division par zero!");
            if (d1.getN()==1)
                return g;
        }
		 if (g.estEntier && d.estEntier)
		 	return div((ConstanteEntiere) g,(ConstanteEntiere) d);
		 	
		 if (g.estRationnel && d.estRationnel)
			return div((ConstanteRationnelle) g,(ConstanteRationnelle) d);
				
		 if (g.estEntier && d.estRationnel)
			return div((ConstanteEntiere) g,(ConstanteRationnelle) d);
		 
		 if (g.estRationnel && d.estEntier)
		 	return div((ConstanteRationnelle) g,(ConstanteEntiere) d);

		 return new Division(g,d);
	}
	
	
	private static ExpressionSymbolique div(ConstanteEntiere a, ConstanteEntiere b) {
		if (a.getN()%b.getN()!=0)
			return new ConstanteRationnelle(a.getN(),b.getN());
		return new ConstanteEntiere(a.getN()/b.getN());
	}
	private static ExpressionSymbolique div(ConstanteRationnelle a, ConstanteRationnelle b) {
		ConstanteRationnelle res = new ConstanteRationnelle(a.getNum()*b.getDen() ,a.getDen()*b.getNum());
		return res.simplifie();
	}
	
	private static ExpressionSymbolique div(ConstanteEntiere a,ConstanteRationnelle b){
		return div(new ConstanteRationnelle(a.getN(),1),b);
	}
	
	private static ExpressionSymbolique div(ConstanteRationnelle a,ConstanteEntiere b) {
		return div(a,new ConstanteRationnelle(b.getN(),1));
	}
}
