
/**
 * Created by Lydia on 04-Feb-17.
 */
public class RacineCarree extends Fonction {

    public RacineCarree(ExpressionSymbolique p){
        super("sqrt",p);
    }

    public ExpressionSymbolique simplifie(){
        return new RacineCarree(param.simplifie());
    }

    /*retourne la fonction derivee*/
    public ExpressionSymbolique derive() {
        return new Division(new ConstanteEntiere(1),
                            new Multiplication(new ConstanteEntiere(2),new RacineCarree(param)));
    }
}
