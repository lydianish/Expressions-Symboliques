/**
 * Created by Lydia on 04-Feb-17.
 */
public class Sinus extends Fonction {

    public Sinus(ExpressionSymbolique p){
        super("sin",p);
    }

    public ExpressionSymbolique simplifie(){

        ExpressionSymbolique p = param.simplifie();
        //sin(0)=0
        if (p.estEntier){
            ConstanteEntiere p1 = (ConstanteEntiere)p;
            if (p1.getN()==0)
                return new ConstanteEntiere(0);
        }
        //sin(pi)=0
        if (p.estConstanteSymbolique){
            ConstanteSymbolique p2 = (ConstanteSymbolique) p;
            if (p2.getNom()=="pi")
                return new ConstanteEntiere(0);
        }
        //sin(pi/2)= 1, sin(-pi/2) = -1
        if (p.estOperationSymbolique && !p.estConstanteSymbolique && !p.estVariable){
            Operation p3 = (Operation) p;
            if (p3.getOperateur()=='/' && p3.getFilsDroit().estEntier) {
                ConstanteEntiere p4 = (ConstanteEntiere) p3.getFilsDroit();
                if (p4.getN() == 2)
                    return new ConstanteEntiere(1);
                if (p4.getN() == -2)
                    return new ConstanteEntiere(-1);
            }
        }
        return new Sinus(p);
    }

    /*retourne la fonction derivee*/
    public ExpressionSymbolique derive() {return new Cosinus(param);}
}
