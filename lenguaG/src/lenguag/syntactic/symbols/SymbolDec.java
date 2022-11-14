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
    private boolean isConstant;

    private SymbolType type;
    private SymbolVar variable;
    private SymbolOperation value;
    // private SymbolDecCont contDeclaration;
    
    public SymbolDec(SymbolDecCont contDeclaration) {
        super("Declaration", 0, instructionType.instDeclaration);

        type = contDeclaration.getType();
        variable = contDeclaration.getVar();
        value = contDeclaration.getValue();
        isConstant = false;
    }
    
    public SymbolDec(SymbolDecCont contDeclaration, boolean isConstant){
        super("Declaration", 0, instructionType.instDeclaration);
        type = contDeclaration.getType();
        variable = contDeclaration.getVar();
        value = contDeclaration.getValue();
        this.isConstant = isConstant;
    }

    public boolean isConstant(){
        return isConstant;
    }
    
    public SymbolType getType(){
        return type;
    }

    public SymbolVar getVar(){
        return variable;
    }

    public SymbolOperation getValue(){
        return value;
    }
}
