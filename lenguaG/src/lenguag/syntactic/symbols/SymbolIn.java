/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * IN ::= RES_IN L_PAREN VARIABLE:v R_PAREN                                {: RESULT = new SymbolIn(v); :}
     ;
 */
public class SymbolIn extends Symbolbase {
    private SymbolVar variable;

    public SymbolIn(SymbolVar variable) {
        super("In", 0);
        this.variable = variable;
    }
    
}
