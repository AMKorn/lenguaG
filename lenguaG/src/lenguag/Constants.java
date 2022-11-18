package lenguag;

import lenguag.syntactic.ParserSym;

public class Constants {

    public static final int FALSE = 0;
    public static final int TRUE = -1;

    public static final int INTEGER_BYTES = 4;
    public static final int CHAR_BYTES = 1;
    public static final int BOOL_BYTES = 1;

    public static final int TYPE_INTEGER = ParserSym.TYPE_INTEGER;
    public static final int TYPE_BOOLEAN = ParserSym.TYPE_BOOLEAN;
    public static final int TYPE_CHARACTER = ParserSym.TYPE_CHARACTER;
    public static final int TYPE_VOID = ParserSym.TYPE_VOID;

    // Constants 
    public static final int TYPE_ARRAY = Integer.MAX_VALUE;
    public static final int TYPE_FUNCTION = TYPE_ARRAY-1;

    public static String getType(int type){
        switch(type){
            case TYPE_INTEGER:
                return "int";
            case TYPE_BOOLEAN:
                return "bool";
            case TYPE_CHARACTER:
                return "char";
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
