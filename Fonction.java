/**
 * Created by Lydia on 04-Feb-17.
 */
public class Fonction extends ExpressionSymbolique {


    public Fonction(String s, ExpressionSymbolique p){
        nom = s;
        param = p;
        estFonction = true;
    }

    public void affiche(){
        System.out.print(nom);
        System.out.print('(');
        param.affiche();
        System.out.print(')');
    }

    public ExpressionSymbolique derive(Variable x) {
        return new Multiplication(this.derive(),param.derive(x));
    }

    /*retourne la fonction derivee*/
    public ExpressionSymbolique derive() {return null;}

    //Attributs

    protected String nom;
    protected ExpressionSymbolique param;

}
