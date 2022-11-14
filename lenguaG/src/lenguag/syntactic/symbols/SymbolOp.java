/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
package lenguag.syntactic.symbols;

/*
OP ::= ADD
     | SUB
     | PROD
     | DIV
     | MOD
     | OR
     | AND
     | OP_REL

OP_REL ::= IS_EQUAL
         | BIGGER
         | BEQ
         | LESSER
         | LEQ 
         | NEQ
 */
public class SymbolOp extends SymbolBase {

    private boolean isRelational;
    private int operation;

    public SymbolOp(int operation) {
        super("Op", 0);
        this.operation = operation;
        isRelational = false;
    }

    public SymbolOp(int operation, boolean isRelational){
        super("Op", 0);
        this.operation = operation;
        isRelational = true;
    }

    public int getOperation(){
        return operation;
    }

    public boolean isRelational(){
        return isRelational;
    }
}
