/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * OUT ::= RES_OUT L_PAREN VALUE:v R_PAREN                                 {: RESULT = new SymbolOut(v); :}
      ;
 */
public class SymbolOut extends SymbolBase{
    private SymbolValue value;

    public SymbolOut(SymbolValue value) {
        super("Out", 0);
        this.value = value;
    }
}
