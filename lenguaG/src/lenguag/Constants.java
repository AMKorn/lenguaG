package lenguag;

import lenguag.syntactic.ParserSym;

public class Constants {

    public static int FALSE = 0;
    public static int TRUE = -1;

    public static int INTEGER_BYTES = 4;
    public static int CHAR_BYTES = 1;
    public static int BOOL_BYTES = 1;

    public static String getType(int type){
        switch(type){
            case ParserSym.TYPE_INTEGER:
                return "int";
            case ParserSym.TYPE_BOOLEAN:
                return "bool";
            case ParserSym.TYPE_CHARACTER:
                return "char";
            case ParserSym.TYPE_ARRAY:
                return "list";
            case ParserSym.TYPE_VOID:
                return "void";
            default:
                return "unidentified type";
        }
    }

    // public static int TYPE_INTEGER = ParserSym.TYPE_INTEGER;
    // public static int TYPE_BOOLEAN = ParserSym.TYPE_BOOLEAN;
    // public static int TYPE_CHARACTER = ParserSym.TYPE_CHARACTER;
    // public static int TYPE_VOID = ParserSym.TYPE_VOID;

    // public static int TYPE_ARRAY = ParserSym.TYPE_ARRAY;

}
