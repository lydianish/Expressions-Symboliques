/**
 * Created by Lydia on 04-Feb-17.
 */
public class Variable extends ExpressionSymbolique {



    public Variable(char s){
        nom = s;
        estVariable = true;
        estOperationSymbolique = true;
    }

    public ExpressionSymbolique simplifie(){
        return this;
    }

    public void affiche(){
        System.out.print(nom);
    }

    public ExpressionSymbolique derive( Variable x) {
        if (x.nom==this.nom)
            return new ConstanteEntiere(1);
        return new ConstanteEntiere(0);
    }

    //Attributs

    private char nom;
}
