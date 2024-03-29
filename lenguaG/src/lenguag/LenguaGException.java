package lenguag;

public class LenguaGException extends Exception {
    
    public LenguaGException(String errorMessage){
        super(errorMessage);
    }

    public static class LexicException extends LenguaGException {
        
        public LexicException(String errorMessage){
            super(errorMessage);
        }
    }

    public static class SyntacticException extends LenguaGException {
        public SyntacticException(String errorMessage){
            super(errorMessage);
        }
    }

    public static class SemanticException extends LenguaGException {
        public SemanticException(String errorMessage){
            super(errorMessage);
        }
    }

    public static class CompilerException extends LenguaGException {
        public CompilerException(String errorMessage){
            super(errorMessage);
        }
    }
}
