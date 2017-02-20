/**
 * Created by Lydia on 04-Feb-17.
 */
public class TestVarSymb {

    public static void main (String args[]){

        ConstanteEntiere a = new ConstanteEntiere(1);
        ConstanteEntiere b = new ConstanteEntiere(25);
        ConstanteEntiere c = new ConstanteEntiere(3);
        Variable d = new Variable('x');

        Addition A1 = new Addition(b,a); // (25 + 1)
        Multiplication M1 = new Multiplication(c,b); // (3 * 25)
        Multiplication M2 = new Multiplication(A1,d); // (25 + 1)*x
        Addition A2 = new Addition(M2,M1); // (25 + 1)*pi + (3 * 25)

        A2.affiche();
        System.out.println();
        A2.simplifie().affiche(); // 26*x + 75
        System.out.println();


        ConstanteEntiere e = new ConstanteEntiere(25);
        ConstanteEntiere f = new ConstanteEntiere(12);
        Variable g = new Variable('y');

        Division D1 = new Division(e,f);// 50/12
        Division D2 = new Division(D1,b);// (50/12)/25
        Soustraction S = new Soustraction(g,D2);// y - (50/12)/25

        S.affiche();
        System.out.println();
        S.simplifie().affiche(); // y - (1/6)
        System.out.println();
    }
}
