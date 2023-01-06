package lenguag.syntactic.symbols;

/**
 * ARG ::= TYPE:type IDENTIFIER:identifier
 */
public class SymbolArg extends SymbolBase {
    private SymbolType type;
    public final String identifier;

    public SymbolArg(SymbolType type, String identifier, int line, int column) {
        super("Argument", 0, line, column);
        this.type = type;
        this.identifier = identifier;
    }

    public SymbolType getType(){
        return type;
    }

    /* public String getVariable(){
        return variable;
    } */
}