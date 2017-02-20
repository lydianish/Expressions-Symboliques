/**
 * Created by Lydia on 04-Feb-17.
 */
public class Puissance extends Fonction {


    public Puissance(ExpressionSymbolique p, int n){
        super("^",p);
        this.n=n;
    }

    public void affiche(){
        param.affiche();
        System.out.print(nom+n);
    }

    public ExpressionSymbolique simplifie(){
        if (n==0)
            return new ConstanteEntiere(1);
        if (n==1)
            return param.simplifie();
        return new Puissance(param.simplifie(),n);
    }

    /*retourne la fonction derivee*/
    public ExpressionSymbolique derive() {
        return new Multiplication(new ConstanteEntiere(n),new Puissance(param,n-1));
    }

    //Attributs

    private int n;
}
