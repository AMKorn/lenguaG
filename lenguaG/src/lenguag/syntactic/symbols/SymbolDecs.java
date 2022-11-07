/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * DECLARATIONS -> DECLARATION DECLARATIONS 
    | FUNCTION DECLARATIONS 
    | .
 */

public class SymbolDecs extends SymbolBase {
    
    SymbolDec declaration;
    SymbolFunc function;
    
    SymbolDecs declarations;
    
    public SymbolDecs(SymbolDec declaration, SymbolDecs declarations) {
        super("Declarations", 0);
        this.declaration = declaration;
        this.declarations = declarations;
    }
    
    public SymbolDecs(SymbolFunc function, SymbolDecs declarations) {
        super("Declarations", 0);
        this.function = function;
        this.declarations = declarations;
    }
    
    public SymbolDecs() {
        super("Declarations", 0); 
        
    }
    
}
