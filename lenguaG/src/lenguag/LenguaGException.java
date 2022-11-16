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
}
