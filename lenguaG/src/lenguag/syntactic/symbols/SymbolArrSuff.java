/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/**
 * ARRAY_SUFFIX ::= L_BRACKET OPERATION:index R_BRACKET ARRAY_SUFFIX:contStuff
 *                |
 */
public class SymbolArrSuff extends SymbolBase {
    
    private SymbolOperation index;
    private SymbolArrSuff contSuff;
    private int nDims;

    public SymbolArrSuff(SymbolOperation index, SymbolArrSuff contSuff){
        super("Array Suffix", 0);
        this.index = index;
        this.contSuff = contSuff;
        if(contSuff == null) nDims = 1;
        else nDims = contSuff.getDimensions()+1;
    }

    public SymbolArrSuff(){
        super("Array Suffix", 0);
        nDims = 0;
    }

    public int getDimensions(){
        return nDims;
    }

    public SymbolOperation getIndex(){
        return index;
    }

    public SymbolArrSuff getNext(){
        return contSuff;
    }

    @Override
    public String toString(){
        String s = super.toString();
        s+="["+ nDims +"]";
        return s;
    }
}
