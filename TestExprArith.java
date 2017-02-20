public class TestExprArith {
	public static void main (String args[]){

		/*Expression (5) du sujet*/
		ConstanteEntiere a = new ConstanteEntiere(9);
		ConstanteEntiere b = new ConstanteEntiere(2);
		ConstanteEntiere c = new ConstanteEntiere(3);
		ConstanteEntiere d = new ConstanteEntiere(1);
		ConstanteEntiere e = new ConstanteEntiere(5);
		ConstanteEntiere f = new ConstanteEntiere(12);
		
		Addition A1 = new Addition(a,b); // (9 + 2)
		Addition A2 = new Addition(e,f); // (5 + 12)
		Division D = new Division(d,A2); // 1/(5 + 12)
		Soustraction S = new Soustraction(c, D); // 3-1/(5 + 12)
		Multiplication M = new Multiplication(A1,S);
		
		M.affiche();
		System.out.println();
		M.simplifie().affiche(); // 550/17
		System.out.println();
		
	}

}
