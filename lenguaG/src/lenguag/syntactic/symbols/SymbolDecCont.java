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
    SymbolExpr expression;
    SymbolOper operation; 
    SymbolType type;
    SymbolVar variable;

    public SymbolDecCont(SymbolType v1, SymbolVar v2, SymbolExpr v3) {
        super("Cont_Declaration", 0);
        this.type = v1;
        this.variable = v2;
        this.expression = v3;
    }

    public SymbolDecCont(SymbolType v1, SymbolVar v2, SymbolOper v3) {
        super("Cont_Declaration", 0);
        this.type = v1;
        this.variable = v2;
        this.operation = v3;
    }

    public SymbolDecCont(SymbolType v1, SymbolVar v2, SymbolOper v3) {
        super("Cont_Declaration", 0);
        this.type = v1;
        this.variable = v2;
    }

    
}
