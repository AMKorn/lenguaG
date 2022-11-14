/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */

package lenguag.syntactic.symbols;

/*
 * FUNCTION ::= TYPE:type VARIABLE:variable L_PAREN ARGS:args R_PAREN L_KEY INSTRUCTIONS:instructions R_KEY 
 */
public class SymbolFunc extends SymbolBase {
    private SymbolType type;
    private SymbolVar variable;
    private SymbolArgs args;
    private SymbolInstrs instructions;

    public SymbolFunc(SymbolType type, SymbolVar variable, SymbolArgs args, SymbolInstrs instructions) {
        super("Function", 0);
        this.type = type;
        this.variable = variable;
        this.args = args;
        this.instructions = instructions;
    }

    public SymbolType getType(){
        return type;
    }

    public String getFunctionName(){
        return variable.getName();
    }

    public int getNArgs(){
        return args.getNArgs();
    }

    public SymbolArgs getArgs(){
        return args;
    }

    public SymbolInstrs getInstructions(){
        return instructions;
    }
}
