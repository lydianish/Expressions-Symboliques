/**
 * Created by Lydia on 04-Feb-17.
 */
public class TestIDClassiques {

    public static void main (String args[]){


        /*Identités classiques pour la fonction ln*/

        Logarithme L1 = new Logarithme(new Euler());
        Logarithme L2 = new Logarithme(new ConstanteEntiere(1));
        Logarithme L3 = new Logarithme(new Variable('x'));

        System.out.println("Identités classiques pour la fonction ln");
        L1.affiche();
        System.out.print(" = ");
        L1.simplifie().affiche();
        System.out.println();
        L2.affiche();
        System.out.print(" = ");
        L2.simplifie().affiche();
        System.out.println();
        L3.affiche();
        System.out.print(" = ");
        L3.simplifie().affiche();
        System.out.println();

        /*Identités classiques pour la fonction exp*/

        Exponentielle E1 = new Exponentielle(new ConstanteEntiere(0));
        Exponentielle E2 = new Exponentielle(new ConstanteEntiere(1));
        Exponentielle E3 = new Exponentielle(new Variable('x'));

        System.out.println("Identités classiques pour la fonction exp");
        E1.affiche();
        System.out.print(" = ");
        E1.simplifie().affiche();
        System.out.println();
        E2.affiche();
        System.out.print(" = ");
        E2.simplifie().affiche();
        System.out.println();
        E3.affiche();
        System.out.print(" = ");
        E3.simplifie().affiche();
        System.out.println();

        /*Identités classiques pour la fonction cos*/

        Cosinus C1 = new Cosinus(new ConstanteEntiere(0));
        Cosinus C2 = new Cosinus(new Pi());
        Cosinus C3 = new Cosinus(new Division(new Pi(),new ConstanteEntiere(2)));
        Cosinus C4 = new Cosinus(new Division(new Pi(),new ConstanteEntiere(-2)));
        Cosinus C5 = new Cosinus(new Variable('x'));

        System.out.println("Identités classiques pour la fonction cos");
        C1.affiche();
        System.out.print(" = ");
        C1.simplifie().affiche();
        System.out.println();
        C2.affiche();
        System.out.print(" = ");
        C2.simplifie().affiche();
        System.out.println();
        C3.affiche();
        System.out.print(" = ");
        C3.simplifie().affiche();
        System.out.println();
        C4.affiche();
        System.out.print(" = ");
        C4.simplifie().affiche();
        System.out.println();
        C5.affiche();
        System.out.print(" = ");
        C5.simplifie().affiche();
        System.out.println();

        /*Identités classiques pour la fonction sin*/

        Sinus S1 = new Sinus(new ConstanteEntiere(0));
        Sinus S2 = new Sinus(new Pi());
        Sinus S3 = new Sinus(new Division(new Pi(),new ConstanteEntiere(2)));
        Sinus S4 = new Sinus(new Division(new Pi(),new ConstanteEntiere(-2)));
        Sinus S5 = new Sinus(new Variable('x'));

        System.out.println("Identités classiques pour la fonction sin");
        S1.affiche();
        System.out.print(" = ");
        S1.simplifie().affiche();
        System.out.println();
        S2.affiche();
        System.out.print(" = ");
        S2.simplifie().affiche();
        System.out.println();
        S3.affiche();
        System.out.print(" = ");
        S3.simplifie().affiche();
        System.out.println();
        S4.affiche();
        System.out.print(" = ");
        S4.simplifie().affiche();
        System.out.println();
        S5.affiche();
        System.out.print(" = ");
        S5.simplifie().affiche();
        System.out.println();

    }
}
