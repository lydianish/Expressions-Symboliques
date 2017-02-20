import com.sun.org.apache.xpath.internal.operations.Div;

/**
 * Created by Lydia on 04-Feb-17.
 */
public class TestFonction {

    public static void main (String args[]){

        Variable a = new Variable('a');
        ConstanteEntiere b = new ConstanteEntiere(1);
        Variable c = new Variable('y');
        Variable d = new Variable('x');
        ConstanteEntiere e = new ConstanteEntiere(2);
        ConstanteEntiere f = new ConstanteEntiere(0);
        ConstanteEntiere g = new ConstanteEntiere(5);

        /*Expression (1) du sujet*/

        Puissance P = new Puissance(d,2);//x^2
        Multiplication M = new Multiplication(e,P);//2x^2
        Addition A = new Addition(M,f);//2x^2+3

        System.out.println("Expression (1) du sujet");
        A.simplifie().affiche();
        System.out.println();

        /*Expression (2) du sujet*/

        Multiplication M1 = new Multiplication(f,c);//3y
        Multiplication M2 = new Multiplication(g,new Multiplication(d,c));//5xy
        Soustraction S1 = new Soustraction(M1,M2);
        Addition A1 = new Addition(S1,b);// 3y-5xy+1
        Division D1 = new Division(f,d);//3/x
        Addition A2 = new Addition(b,D1);//1+3/x
        Division D2 = new Division(A1,A2);
        Addition A3 = new Addition(P,D2);

        System.out.println("Expression (2) du sujet");
        A3.simplifie().affiche();
        System.out.println();

        /*Expression (3) du sujet*/

        Multiplication M3 = new Multiplication(e, new Pi());//2pi
        Addition A4 = new Addition(d,b);//x+1
        Multiplication M4 = new Multiplication(M3,A4);
        Sinus S = new Sinus(M4);
        Division D3 = new Division(b,P);//1/x^2
        Exponentielle E = new Exponentielle(D3);
        Multiplication M5 = new Multiplication(S,E);//sin(2pi(x+1))exp(1/x^2)
        Addition A5 = new Addition(d,g);//x+5
        Logarithme L = new Logarithme(A5);//ln(x+5)
        Soustraction S2 = new Soustraction(M5,L);

        System.out.println("Expression (3) du sujet");
        S2.simplifie().affiche();
        System.out.println();

       /* Expression (4) du sujet*/

        Addition A6 = new Addition(b,c);
        Addition A7 = new Addition(b,d);
        Division D4 = new Division(A6,A7);
        Addition A8 = new Addition(a,D4);
        RacineCarree R = new RacineCarree(A8);

        System.out.println("Expression (4) du sujet");
        R.simplifie().affiche();
        System.out.println();

    }
}
