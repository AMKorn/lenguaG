/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
RETURN ::= RES_RETURN OPERATION:value
         | RES_RETURN
 */
public class SymbolReturn extends SymbolInstr {
    
    private SymbolOperation value;

    public SymbolReturn(SymbolOperation value) {
        super("Return", 0, instructionType.instReturn);
        this.value = value;
    }

    public SymbolReturn() {
        super("Return", 0, instructionType.instReturn);
    }

    public SymbolOperation getValue(){
        return value;
    }
}
