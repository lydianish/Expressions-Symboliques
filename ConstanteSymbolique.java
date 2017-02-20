/**
 * Created by Lydia on 04-Feb-17.
 */
public class ConstanteSymbolique extends ExpressionSymbolique{

    public ConstanteSymbolique(String s) {
        nom = s;
        estConstanteSymbolique = true;
        estOperationSymbolique = true;
    }

    public ExpressionSymbolique simplifie(){
        return this;
    }

    public void affiche(){
        System.out.print(nom);
    }

    public ExpressionSymbolique derive( Variable x) {return new ConstanteEntiere(0);}

    //Attributs

    public String getNom(){return nom;}

    protected String nom;

}
