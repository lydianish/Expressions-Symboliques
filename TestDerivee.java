/**
 * Created by Lydia on 04-Feb-17.
 */
public class TestDerivee {

    public static void main (String args[]){


        //les fonctions derivees

        Variable x = new Variable('x');
        Variable y = new Variable('y');

        Addition X = new Addition(new Puissance(x,3),new Pi());//x^3+pi
        Soustraction Y = new Soustraction(new ConstanteEntiere(11), new Puissance(y,2));//11-y^2
        Addition A = new Addition(X,Y) ;
        System.out.println("\nExpression : ");
        A.affiche();
        System.out.println("\nDerivée par rapport à x : ");
        ExpressionSymbolique Ax = A.derive(x);
        Ax.affiche();
        System.out.println(" = ");
        Ax.simplifie().affiche();
        System.out.println("\nDerivée par rapport à y : ");
        ExpressionSymbolique Ay = A.derive(y);
        Ay.affiche();
        System.out.println(" = ");
        Ay.simplifie().affiche();
        System.out.println();


        Multiplication M = new Multiplication(x, new RacineCarree(y));
        System.out.println("\nExpression : ");
        M.affiche();
        System.out.println("\nDerivée par rapport à x : ");
        ExpressionSymbolique Mx = M.derive(x);
        Mx.affiche();
        System.out.println(" = ");
        Mx.simplifie().affiche();
        System.out.println("\nDerivée par rapport à y : ");
        ExpressionSymbolique My = M.derive(y);
        My.affiche();
        System.out.println(" = ");
        My.simplifie().affiche();
        System.out.println();

        Division D = new Division(new Exponentielle(x),new Cosinus(new Addition(y,new ConstanteRationnelle(1,4))));
        System.out.println("\nExpression : ");
        D.affiche();
        System.out.println("\nDerivée par rapport à x : ");
        ExpressionSymbolique Dx = D.derive(x);
        Dx.affiche();
        System.out.println(" = ");
        Dx.simplifie().affiche();
        System.out.println("\nDerivée par rapport à y : ");
        ExpressionSymbolique Dy = D.derive(y);
        Dy.affiche();
        System.out.println(" = ");
        Dy.simplifie().affiche();
        System.out.println();

        Soustraction S = new Soustraction(new Cosinus(new Addition(new Multiplication(y,new ConstanteRationnelle(1,7)),new Pi())),new Logarithme(x));
        System.out.println("\nExpression : ");
        S.affiche();
        System.out.println("\nDerivée par rapport à x : ");
        ExpressionSymbolique Sx = S.derive(x);
        Sx.affiche();
        System.out.println(" = ");
        Sx.simplifie().affiche();
        System.out.println("\nDerivée par rapport à y : ");
        ExpressionSymbolique Sy = S.derive(y);
        Sy.affiche();
        System.out.println(" = ");
        Sy.simplifie().affiche();
        System.out.println();
    }
}
