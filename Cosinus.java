/**
 * Created by Lydia on 04-Feb-17.
 */
public class Cosinus extends Fonction {

    public Cosinus(ExpressionSymbolique p){
        super("cos",p);
    }


    public ExpressionSymbolique simplifie(){
        ExpressionSymbolique p = param.simplifie();
        //cos(0)=1
        if (p.estEntier){
            ConstanteEntiere p1 = (ConstanteEntiere)p;
            if (p1.getN()==0)
                return new ConstanteEntiere(1);
        }
        //cos(pi)=-1
        if (p.estConstanteSymbolique){
            ConstanteSymbolique p2 = (ConstanteSymbolique) p;
            if (p2.getNom()=="pi")
                return new ConstanteEntiere(-1);
        }
        //cos(pi/2)= cos(-pi/2) = 0
        if (p.estOperationSymbolique && !p.estConstanteSymbolique && !p.estVariable){
            Operation p3 = (Operation) p;
            if (p3.getOperateur()=='/' && p3.getFilsDroit().estEntier) {
                ConstanteEntiere p4 = (ConstanteEntiere) p3.getFilsDroit();
                if (p4.getN() == 2 || p4.getN() == -2)
                    return new ConstanteEntiere(0);
            }
        }
        return new Cosinus(p);
    }

    /*retourne la fonction derivee*/
    public ExpressionSymbolique derive() {
        return new Multiplication(new ConstanteEntiere(-1), new Sinus(param));
    }
}
