import java.lang.ArithmeticException;

public class ConstanteRationnelle extends ExpressionSymbolique {


	public ConstanteRationnelle(int n, int d) throws ArithmeticException {
		if (d==0)
			throw new ArithmeticException("Erreur: le dénominateur ne peut pas être nul.");
		estRationnel = true;
		num = n;
		if (d<0) {
			den = -d;
			num *= -1;
		}
		else
			den = d;
	}
	
	public void affiche() {
		if (num<0)
			System.out.print("("+num + "/" + den+")");
		else
		System.out.print(num + "/" + den);
	}

	private int pgcd() {
		if (num==0)
			return 0;
		int a, b, r, rprec;
		a = Math.max(Math.abs(num),den);
		b = Math.min(Math.abs(num),den);
		rprec = b;
		r = a%b;
		while (r>0){
			rprec = r;
			a = b;
			b = r;
			r = a%b;
		}
		return rprec;
	}

	/*transforme le rationnel courant en fraction irreductible*/
	private void simplifier(){
		int d = pgcd();
		num /= d;
		den /= d;
	}

	public ExpressionSymbolique simplifie() {
		simplifier();
		if (den==1)
			return new ConstanteEntiere(num);
		return this;
	}

    public ExpressionSymbolique derive( Variable x) {return new ConstanteEntiere(0);}

    //Attributs

    public int getNum() {
        return num;
    }

    public int getDen() {
        return den;
    }

    private int num;
    private int den;


}
