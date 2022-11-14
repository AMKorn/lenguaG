/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * This is a support class of sort, used mostly by SymbolDec
 * 
 * CONT_DECLARATION ::= TYPE:v1 VARIABLE:v2 EQUAL OPERATION:v3
 *                    | TYPE:v1 VARIABLE:v2
 */
public class SymbolDecCont extends SymbolBase {

    private SymbolType type;
    private SymbolVar variable;
    private SymbolOper value;

    public SymbolDecCont(SymbolType v1, SymbolVar v2, SymbolOper v3) {
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

    public SymbolType getType(){
        return type;
    }

    public SymbolVar getVar(){
        return variable;
    }

    public SymbolOper getValue(){
        return value;
    }    
}
