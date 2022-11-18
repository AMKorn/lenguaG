/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * DECLARATION ::= CONSTANT:isConstant CONT_DECLARATION:contDeclaration
 *               | CONT_DECLARATION:contDeclaration
 */
public class SymbolDec extends SymbolInstr {
    public final boolean isConstant;
    public final String variableName;

    private SymbolType type;
    private SymbolOperation value;
    
    public SymbolDec(SymbolDecCont contDeclaration, int line, int column) {
        super("Declaration", 0, instructionType.instDeclaration, line, column);

        type = contDeclaration.getType();
        variableName = contDeclaration.getVar();
        value = contDeclaration.getValue();
        isConstant = false;
    }
    
    public SymbolDec(SymbolDecCont contDeclaration, boolean isConstant, int line, int column){
        super("Declaration", 0, instructionType.instDeclaration, line, column);
        type = contDeclaration.getType();
        variableName = contDeclaration.getVar();
        value = contDeclaration.getValue();
        this.isConstant = isConstant;
    }
    
    public SymbolType getType(){
        return type;
    }

    public SymbolOperation getValue(){
        return value;
    }
}
