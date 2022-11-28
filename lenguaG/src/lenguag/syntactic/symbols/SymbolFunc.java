/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */

package lenguag.syntactic.symbols;

/*
 * FUNCTION ::= TYPE:type IDENTIFIER:name L_PAREN ARGS:args R_PAREN L_KEY INSTRUCTIONS:instructions R_KEY 
 */
public class SymbolFunc extends SymbolBase {
    private SymbolType type;
    private String name;
    private SymbolArgs args;
    private SymbolInstrs instructions;

    public SymbolFunc(SymbolType type, String name, SymbolArgs args, SymbolInstrs instructions, int line, int column) {
        super("Function", 0, line, column);
        this.type = type;
        this.name = name;
        this.args = args;
        this.instructions = instructions;
    }

    public SymbolType getType(){
        return type;
    }

    public String getFunctionName(){
        return name;
    }

    /**
     * Returns the amount of arguments of the function.
     * @return
     */
    public int getNArgs(){
        if(args == null) return 0;
        return args.getNArgs();
    }

    /**
     * Function to get the symbol for the arguments.
     * @return
     */
    public SymbolArgs getArgs(){
        return args;
    }

    public SymbolInstrs getInstructions(){
        return instructions;
    }
}
