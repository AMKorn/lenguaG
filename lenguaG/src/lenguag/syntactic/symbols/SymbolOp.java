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

    public final boolean isRelational;
    public final int operation;

    public SymbolOp(int operation) {
        super("Op", 0);
        this.operation = operation;
        isRelational = false;
    }

    public SymbolOp(int operation, boolean isRelational){
        super("Op", 0);
        this.operation = operation;
        this.isRelational = isRelational;
    }
}
