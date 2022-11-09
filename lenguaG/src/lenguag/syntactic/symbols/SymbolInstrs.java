/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */

package lenguag.syntactic.symbols;

/*
 * INSTRUCTIONS ::= INSTRUCTION:v1 INSTRUCTIONS:v2
    |
 */
public class SymbolInstrs extends SymbolBase{
    SymbolInstr instruction;
    SymbolInstrs instructions;

    public SymbolInstrs(SymbolInstr v1, SymbolInstrs v2) {
        super("Instructions", 0);
        this.instruction = v1;
        this.instructions = v2;
    }

    public SymbolInstrs() {
        super("Instructions", 0);
    }
}