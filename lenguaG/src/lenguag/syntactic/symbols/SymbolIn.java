/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
 * IN ::= RES_IN L_PAREN VARIABLE:variable R_PAREN
     ;
 */
public class SymbolIn extends SymbolInstr {
    private SymbolVar variable;

    public SymbolIn(SymbolVar variable) {
        super("In", 0, instructionType.instIn);
        this.variable = variable;
    }
    
    public SymbolVar getVar(){
        return variable;
    }
}
