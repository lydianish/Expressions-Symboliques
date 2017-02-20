/**
 * Created by Lydia on 04-Feb-17.
 */
public class Logarithme extends Fonction {

    public Logarithme(ExpressionSymbolique p){
        super("ln",p);
    }

    public ExpressionSymbolique simplifie(){
        ExpressionSymbolique p = param.simplifie();
        if (p.estEntier){//ln(1)=0
            ConstanteEntiere p1 = (ConstanteEntiere)p;
            if (p1.getN()==1)
                return new ConstanteEntiere(0);
        }
        if (p.estConstanteSymbolique){//ln(e)=1
            ConstanteSymbolique p2 = (ConstanteSymbolique) p;
            if (p2.getNom()=="e")
                return new ConstanteEntiere(1);
        }
        return new Logarithme(p);
    }

    /*retourne la fonction derivee*/
    public ExpressionSymbolique derive() {
        return new Division(new ConstanteEntiere(1),param);
    }

}
