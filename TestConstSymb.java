/**
 * Created by Lydia on 04-Feb-17.
 */
public class TestConstSymb {

    public static void main (String args[]){

        ConstanteEntiere a = new ConstanteEntiere(1);
        ConstanteEntiere b = new ConstanteEntiere(2);
        ConstanteEntiere c = new ConstanteEntiere(3);
        Pi d = new Pi();

        Addition A1 = new Addition(b,a); // (2 + 1)
        Multiplication M1 = new Multiplication(c,b); // (3 * 2)
        Multiplication M2 = new Multiplication(A1,d); // (2 + 1)*pi
        Addition A2 = new Addition(M2,M1); // (2 + 1)*pi + (3 * 2)

        A2.affiche();
        System.out.println();
        A2.simplifie().affiche(); // 3*pi + 5
        System.out.println();


        ConstanteEntiere e = new ConstanteEntiere(5);
        ConstanteEntiere f = new ConstanteEntiere(12);
        Euler g = new Euler();

        Division D1 = new Division(e,f);// 5/12
        Division D2 = new Division(D1,b);// (5/12)/2
        Soustraction S = new Soustraction(g,D2);// e - (5/12)/2

        S.affiche();
        System.out.println();
        S.simplifie().affiche(); // e - (5/24)
        System.out.println();
    }
}
