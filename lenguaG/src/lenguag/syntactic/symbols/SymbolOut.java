/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * OUT ::= RES_OUT L_PAREN OPERATION:value R_PAREN
      ;
 */
public class SymbolOut extends SymbolInstr {
    private SymbolOperation value;

    public SymbolOut(SymbolOperation value) {
        super("Out", 0, instructionType.instOut);
        this.value = value;
    }

    public SymbolOperation getValue(){
        return value;
    }
}
