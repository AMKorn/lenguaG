/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * ARRAY_SUFFIX ::= L_BRACKET VARIABLE:index R_BRACKET ARRAY_SUFFIX:contStuff
 *                |
 */
public class SymbolArrSuff extends SymbolBase {
    
    private SymbolVar index;
    private SymbolArrSuff contSuff;
    private int nDims;

    public SymbolArrSuff(SymbolVar index, SymbolArrSuff contSuff){
        super("Array Suffix", 0);
        this.index = index;
        this.contSuff = contSuff;
        nDims = contSuff.getDimensions()+1;
    }

    public SymbolArrSuff(){
        super("Array Suffix", 0);
        nDims = 0;
    }

    public int getDimensions(){
        return nDims;
    }

    public SymbolVar getIndex(){
        return index;
    }

    public SymbolArrSuff getNext(){
        return contSuff;
    }
}
