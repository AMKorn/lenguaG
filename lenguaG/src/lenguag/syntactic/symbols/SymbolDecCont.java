/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * CONT_DECLARATION ::= TYPE:v1 VARIABLE:v2 EQUAL EXPRESSION:v3
    | TYPE:v1 VARIABLE:v2 EQUAL OPERATION:v3                            
    | TYPE:v1 VARIABLE:v2   
 */
public class SymbolDecCont extends SymbolBase {

    private SymbolType type;
    private SymbolVar variable;

    //SymbolExpr expression;
    //SymbolOper operation; 
    private SymbolBase value; // TODO value stuff

    public SymbolDecCont(SymbolType v1, SymbolVar v2, SymbolBase v3) {
        super("Cont_Declaration", v3.value);
        this.type = v1;
        this.variable = v2;
        this.value = v3;
    }

    public SymbolDecCont(SymbolType v1, SymbolVar v2) {
        super("Cont_Declaration", 0);
        this.type = v1;
        this.variable = v2;
    }

    public int getType(){
        return type.getType();
    }

    public SymbolVar getVar(){
        return variable;
    }

    public SymbolBase getValue(){
        return value;
    }    
}
