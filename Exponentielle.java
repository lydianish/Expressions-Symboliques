/**
 * Created by Lydia on 04-Feb-17.
 */
public class Exponentielle extends Fonction {

    public Exponentielle(ExpressionSymbolique p){
        super("exp",p);
    }

    public ExpressionSymbolique simplifie(){
        ExpressionSymbolique p = param.simplifie();
        if (p.estEntier){
            ConstanteEntiere p1 = (ConstanteEntiere)p;
            if (p1.getN()==0)//exp(0)=1
                return new ConstanteEntiere(1);
            if (p1.getN()==1)//exp(1)=e
                return new Euler();
        }
        return new Exponentielle(p);
    }

    /*retourne la fonction derivee*/
    public ExpressionSymbolique derive() {return this;}
}
