package lenguag;

import lenguag.syntactic.ParserSym;

public class Constants {

    // Constants defined by us
    public static final int TYPE_ARRAY = Integer.MAX_VALUE;
    public static final int TYPE_FUNCTION = TYPE_ARRAY-1;

    public static final int UNKNOWN = -1;

    public static final int FALSE = 0;
    public static final int TRUE = -1;

    public static final int INTEGER_BYTES = 4;
    public static final int CHAR_BYTES = 1;
    public static final int BOOL_BYTES = 1;

    // Constants defined in ParserSym.java (lenguaG.cup)
    public static final int TYPE_INTEGER = ParserSym.TYPE_INTEGER;
    public static final int TYPE_CHARACTER = ParserSym.TYPE_CHARACTER;
    public static final int TYPE_BOOLEAN = ParserSym.TYPE_BOOLEAN;
    public static final int TYPE_VOID = ParserSym.TYPE_VOID;

    public static final int ADD = ParserSym.ADD;
    public static final int SUB = ParserSym.SUB;
    public static final int PROD = ParserSym.PROD;
    public static final int DIV = ParserSym.DIV;
    public static final int MOD = ParserSym.MOD;
    public static final int OR = ParserSym.OR;
    public static final int AND = ParserSym.AND;
    public static final int IS_EQUAL = ParserSym.IS_EQUAL;
    public static final int BIGGER = ParserSym.BIGGER;
    public static final int BEQ = ParserSym.BEQ;
    public static final int LESSER = ParserSym.LESSER;
    public static final int LEQ = ParserSym.LEQ;
    public static final int NEQ = ParserSym.NEQ;

    public static String getTypeName(int type){
        switch(type){
            case TYPE_INTEGER:
                return "int";
            case TYPE_CHARACTER:
                return "char";
            case TYPE_BOOLEAN:
                return "bool";
            case TYPE_VOID:
                return "void";
            case TYPE_ARRAY:
                return "list";
            case TYPE_FUNCTION:
                return "function";
            default:
                return "unidentified type";
        }
    }

}
