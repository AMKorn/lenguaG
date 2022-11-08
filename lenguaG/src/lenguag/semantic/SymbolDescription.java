package lenguag.semantic;

/**
 * Class that represents a variable's description in the symbol table
 */
public class SymbolDescription {

    // The variable's type
    private int type;

    public SymbolDescription(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }

}
