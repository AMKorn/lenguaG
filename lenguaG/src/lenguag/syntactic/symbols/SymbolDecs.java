/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * DECLARATIONS ::= DECLARATION:declaration ENDLINE DECLARATIONS:declarations
 *                | FUNCTION:declaration DECLARATIONS:declarations
 *                |
 */

public class SymbolDecs extends SymbolBase {

    private SymbolBase declaration;
    private SymbolDecs declarations;
    
    public SymbolDecs(SymbolBase declaration, SymbolDecs declarations){
        super("Declarations", declaration.value);
        this.declaration = declaration;
        this.declarations = declarations;
    }
    
    public SymbolDecs() {
        super("Declarations", 0);
    }
    
    /**
     * @return either SymbolDec or SymbolFunc
     */
    public SymbolBase getDeclaration(){
        return declaration;
    }

    public SymbolDecs getNext(){
        return declarations;
    }
}
