package lenguag.syntactic.symbols;

/**
 * ARGS ::= ARG:argument MORE_ARGS:contArgs
 *        | 
 * 
 * MORE_ARGS ::= COMMA ARG:argument MORE_ARGS:contArgs
            |
 */
public class SymbolArgs extends SymbolBase {

    private int nArgs;
    private SymbolArg argument;
    private SymbolArgs contArgs;

    public SymbolArgs(SymbolArg argument, SymbolArgs contArgs, int line, int column) {
        super("Arguments", 0, line, column);
        this.argument = argument;
        this.contArgs = contArgs;
        if(contArgs == null) nArgs = 1;
        else nArgs = contArgs.getNArgs()+1;
    }

    public SymbolArgs(){
        super("Arguments", 0);
        nArgs = 0;
    }
    
    public SymbolArg getArg(){
        return argument;
    }

    public SymbolArgs getNext(){
        return contArgs;
    }

    public int getNArgs(){
        return nArgs;
    }
}