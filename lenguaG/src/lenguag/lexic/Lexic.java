/* The following code was generated by JFlex 1.7.0 */

/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Román Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
// Si estás en Lexic.java, OJO! Este archivo no debe ser modificado manualmente: para hacer cambios hacerlo en lenguaG.flex 
// y luego seleccionar dicho archivo como input de jflex en "lexical specification". El output se debe dejar tal cual.

package lenguag.lexic;

// Other libraries
//import java.io.*;
import java.util.*;
import java_cup.runtime.*;

// Our project imports
import lenguag.syntactic.ParserSym;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>lenguag/lexic/lenguaG.flex</tt>
 */
public class Lexic implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\57\1\14\1\15\1\15\1\14\22\0\1\57\1\55\1\0"+
    "\1\60\1\0\1\54\1\0\1\56\1\36\1\37\1\52\1\51\1\45"+
    "\1\4\1\0\1\53\1\3\1\6\6\10\2\2\1\0\1\44\1\47"+
    "\1\46\1\50\2\0\6\12\24\1\1\42\1\13\1\43\1\0\1\1"+
    "\1\0\1\23\1\5\1\21\1\27\1\32\1\33\1\1\1\22\1\16"+
    "\2\1\1\25\1\30\1\17\1\7\2\1\1\24\1\34\1\20\1\31"+
    "\1\26\1\35\1\11\2\1\1\40\1\0\1\41\7\0\1\15\u1fa2\0"+
    "\1\15\1\15\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\1\4\2\2\1\5\13\2"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\2\1"+
    "\1\25\4\0\1\2\1\26\1\2\1\27\1\30\14\2"+
    "\1\31\1\32\1\0\1\33\1\0\1\34\2\0\3\3"+
    "\1\2\1\35\1\36\1\37\2\2\1\40\2\2\1\41"+
    "\2\2\1\42\2\2\2\0\2\43\1\44\1\45\1\46"+
    "\1\2\1\47\1\50\1\51\1\2\1\52\1\25\1\2"+
    "\1\53\1\54";

  private static int [] zzUnpackAction() {
    int [] result = new int[102];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\u0126\0\u0157"+
    "\0\u0188\0\u01b9\0\u01ea\0\u021b\0\u024c\0\u027d\0\u02ae\0\u02df"+
    "\0\u0310\0\u0341\0\u0372\0\u03a3\0\61\0\61\0\61\0\61"+
    "\0\61\0\61\0\61\0\61\0\u03d4\0\u0405\0\u0436\0\61"+
    "\0\61\0\u0467\0\61\0\u0498\0\u04c9\0\u04fa\0\u052b\0\u055c"+
    "\0\u058d\0\304\0\u05be\0\142\0\u05ef\0\u0620\0\142\0\u0651"+
    "\0\u0682\0\u06b3\0\u06e4\0\u0715\0\u0746\0\u0777\0\u07a8\0\u07d9"+
    "\0\u080a\0\u083b\0\u086c\0\61\0\61\0\u089d\0\61\0\u08ce"+
    "\0\61\0\u08ff\0\u0930\0\u052b\0\u055c\0\u058d\0\u0961\0\142"+
    "\0\142\0\142\0\u0992\0\u09c3\0\142\0\u09f4\0\u0a25\0\142"+
    "\0\u0a56\0\u0a87\0\142\0\u0ab8\0\u0ae9\0\u0b1a\0\u0b4b\0\61"+
    "\0\u08ff\0\142\0\142\0\142\0\u0b7c\0\142\0\142\0\142"+
    "\0\u0bad\0\61\0\u08ce\0\u0bde\0\142\0\142";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[102];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\4\1\10"+
    "\1\4\2\3\1\2\1\11\1\2\1\12\1\13\1\14"+
    "\1\15\1\3\1\16\1\17\1\3\1\20\1\3\1\21"+
    "\1\3\1\22\1\23\1\3\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\1\11\1\46"+
    "\62\0\3\3\1\0\6\3\3\0\20\3\25\0\2\4"+
    "\2\0\1\4\1\0\1\4\55\0\1\47\1\0\1\50"+
    "\1\0\1\51\51\0\1\4\1\52\2\0\1\4\1\0"+
    "\1\4\51\0\3\3\1\0\2\3\1\53\3\3\3\0"+
    "\20\3\24\0\3\3\1\0\6\3\3\0\6\3\1\54"+
    "\4\3\1\55\4\3\37\0\1\11\42\0\1\11\2\0"+
    "\3\3\1\0\6\3\3\0\1\3\1\56\13\3\1\57"+
    "\2\3\24\0\3\3\1\0\2\3\1\60\3\3\3\0"+
    "\20\3\24\0\3\3\1\0\6\3\3\0\6\3\1\61"+
    "\11\3\24\0\3\3\1\0\6\3\3\0\4\3\1\62"+
    "\13\3\24\0\3\3\1\0\6\3\3\0\1\3\1\63"+
    "\16\3\24\0\3\3\1\0\6\3\3\0\14\3\1\64"+
    "\3\3\24\0\3\3\1\0\2\3\1\65\3\3\3\0"+
    "\5\3\1\66\12\3\24\0\3\3\1\0\6\3\3\0"+
    "\5\3\1\67\12\3\24\0\3\3\1\0\6\3\3\0"+
    "\7\3\1\70\10\3\24\0\3\3\1\0\2\3\1\71"+
    "\3\3\3\0\5\3\1\72\12\3\24\0\3\3\1\0"+
    "\6\3\3\0\4\3\1\73\13\3\71\0\1\74\60\0"+
    "\1\75\1\76\57\0\1\77\64\0\1\100\1\46\53\0"+
    "\1\101\12\0\13\102\1\103\2\0\43\102\14\46\2\0"+
    "\43\46\3\0\1\104\2\0\1\104\55\0\1\105\2\0"+
    "\1\105\1\0\1\105\52\0\2\106\1\0\2\106\1\0"+
    "\1\106\1\0\1\106\6\0\1\106\1\0\1\106\3\0"+
    "\1\106\2\0\2\106\26\0\3\3\1\0\2\3\1\107"+
    "\3\3\3\0\20\3\24\0\3\3\1\0\6\3\3\0"+
    "\2\3\1\110\15\3\24\0\3\3\1\0\6\3\3\0"+
    "\2\3\1\111\15\3\24\0\3\3\1\0\6\3\3\0"+
    "\2\3\1\112\15\3\24\0\3\3\1\0\6\3\3\0"+
    "\13\3\1\113\4\3\24\0\3\3\1\0\6\3\3\0"+
    "\5\3\1\114\12\3\24\0\3\3\1\0\6\3\3\0"+
    "\11\3\1\115\6\3\24\0\3\3\1\0\6\3\3\0"+
    "\2\3\1\116\15\3\24\0\3\3\1\0\6\3\3\0"+
    "\1\117\17\3\24\0\3\3\1\0\6\3\3\0\7\3"+
    "\1\120\10\3\24\0\3\3\1\0\6\3\3\0\1\121"+
    "\17\3\24\0\3\3\1\0\6\3\3\0\16\3\1\122"+
    "\1\3\24\0\3\3\1\0\6\3\3\0\6\3\1\123"+
    "\11\3\24\0\3\3\1\0\6\3\3\0\7\3\1\124"+
    "\10\3\24\0\3\3\1\0\6\3\3\0\1\125\17\3"+
    "\73\0\1\126\10\0\52\100\1\127\6\100\56\0\1\130"+
    "\2\0\14\102\2\0\40\102\1\131\2\102\1\0\3\3"+
    "\1\0\6\3\3\0\7\3\1\132\10\3\24\0\3\3"+
    "\1\0\6\3\3\0\14\3\1\133\3\3\24\0\3\3"+
    "\1\0\6\3\3\0\6\3\1\134\11\3\24\0\3\3"+
    "\1\0\6\3\3\0\13\3\1\135\4\3\24\0\3\3"+
    "\1\0\6\3\3\0\11\3\1\136\6\3\24\0\3\3"+
    "\1\0\6\3\3\0\1\3\1\137\16\3\24\0\3\3"+
    "\1\0\6\3\3\0\14\3\1\140\3\3\24\0\3\3"+
    "\1\0\6\3\3\0\16\3\1\113\1\3\24\0\3\3"+
    "\1\0\6\3\3\0\7\3\1\141\10\3\73\0\1\142"+
    "\10\0\52\100\1\127\1\143\5\100\1\0\3\3\1\0"+
    "\6\3\3\0\6\3\1\144\11\3\24\0\3\3\1\0"+
    "\6\3\3\0\14\3\1\145\3\3\24\0\3\3\1\0"+
    "\6\3\3\0\1\3\1\146\16\3\23\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3087];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\22\1\10\11\3\1\2\11\1\1\1\11"+
    "\3\1\4\0\21\1\2\11\1\0\1\11\1\0\1\11"+
    "\2\0\22\1\2\0\1\11\11\1\1\11\4\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[102];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
	private ArrayList<String> tokens = new ArrayList<>();

	private ArrayList<String> errors = new ArrayList<>();

	public void printTokens(){
		for(String s: tokens){
			System.out.println(s);
		}
	}

	public String writeTokens(){
		String tokenList = "";

		for(String s : tokens){
			tokenList += s + "\n";
		}

		return tokenList;
	}

	public String writeErrors(){
		String errorsList = "";

		for(String s : errors){
			errorsList += s + "\n";
		}

		return errorsList;
	}

	public boolean getError(){
		return !errors.isEmpty();
	}

	private String errorMessage(){
		return " * Elemento no reconocido " + yytext() + " en la posicion [line: " + (yyline+1) + ", column: " + (yycolumn+1) + "]";
	}
	
	private int parseNum(String s) throws NumberFormatException {
		// We check if it's a negative number.
		if(s.charAt(0) == '-') return -(parseNum(s.substring(0)));
		// We check whether the first number is a 0, if so there might be a prefix specifying base, unless it's just a 0 by itself.
		if(s.charAt(0) != '0' || s.length() == 1) return Integer.parseInt(s);
		// If 
		char base = s.charAt(1);
		String[] sParts = s.split(""+base);
		switch(base){
			case 'b':
				return Integer.parseInt(sParts[1], 2);
			case 'o':
				return Integer.parseInt(sParts[1], 8);
			case 'x':
				return Integer.parseInt(sParts[1], 16);
			default:
				throw new NumberFormatException(errorMessage());
		}
	}

	// Functions to streamline CUP symbol returns.
    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }
    
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexic(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 178) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { 	return symbol(ParserSym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { errors.add(errorMessage()); 
						return symbol(ParserSym.error);
            } 
            // fall through
          case 45: break;
          case 2: 
            { tokens.add("Identifier: " + yytext()); return symbol(ParserSym.IDENTIFIER, yytext());
            } 
            // fall through
          case 46: break;
          case 3: 
            { tokens.add("Number: " + yytext()); 
						try {Integer value = parseNum(yytext());
							return symbol(ParserSym.INTEGER, value); 
						} catch(NumberFormatException nf) {
							errors.add(errorMessage()); 
							return symbol(ParserSym.error);
						}
            } 
            // fall through
          case 47: break;
          case 4: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.SUB);
            } 
            // fall through
          case 48: break;
          case 5: 
            { /* Do nothing */
            } 
            // fall through
          case 49: break;
          case 6: 
            { tokens.add("Symbol : " + yytext()); return symbol(ParserSym.L_PAREN);
            } 
            // fall through
          case 50: break;
          case 7: 
            { tokens.add("Symbol : " + yytext()); return symbol(ParserSym.R_PAREN);
            } 
            // fall through
          case 51: break;
          case 8: 
            { tokens.add("Symbol : " + yytext()); return symbol(ParserSym.L_KEY);
            } 
            // fall through
          case 52: break;
          case 9: 
            { tokens.add("Symbol : " + yytext()); return symbol(ParserSym.R_KEY);
            } 
            // fall through
          case 53: break;
          case 10: 
            { tokens.add("Symbol : " + yytext()); return symbol(ParserSym.L_BRACKET);
            } 
            // fall through
          case 54: break;
          case 11: 
            { tokens.add("Symbol : " + yytext()); return symbol(ParserSym.R_BRACKET);
            } 
            // fall through
          case 55: break;
          case 12: 
            { tokens.add("Symbol : " + yytext()); return symbol(ParserSym.ENDLINE);
            } 
            // fall through
          case 56: break;
          case 13: 
            { tokens.add("Symbol : " + yytext()); return symbol(ParserSym.COMMA);
            } 
            // fall through
          case 57: break;
          case 14: 
            { tokens.add("AssignOp: " + yytext()); return symbol(ParserSym.EQUAL);
            } 
            // fall through
          case 58: break;
          case 15: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.LESSER);
            } 
            // fall through
          case 59: break;
          case 16: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.BIGGER);
            } 
            // fall through
          case 60: break;
          case 17: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.ADD);
            } 
            // fall through
          case 61: break;
          case 18: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.PROD);
            } 
            // fall through
          case 62: break;
          case 19: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.DIV);
            } 
            // fall through
          case 63: break;
          case 20: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.MOD);
            } 
            // fall through
          case 64: break;
          case 21: 
            { /* We fully ignore comments */
            } 
            // fall through
          case 65: break;
          case 22: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.OR);
            } 
            // fall through
          case 66: break;
          case 23: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.RES_IN);
            } 
            // fall through
          case 67: break;
          case 24: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.RES_IF);
            } 
            // fall through
          case 68: break;
          case 25: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.IS_EQUAL);
            } 
            // fall through
          case 69: break;
          case 26: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.LEQ);
            } 
            // fall through
          case 70: break;
          case 27: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.BEQ);
            } 
            // fall through
          case 71: break;
          case 28: 
            { tokens.add("Op: " + yytext()); return symbol(ParserSym.NEQ);
            } 
            // fall through
          case 72: break;
          case 29: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.RES_OUT);
            } 
            // fall through
          case 73: break;
          case 30: 
            { tokens.add("Type: " + yytext()); return symbol(ParserSym.TYPE_INTEGER);
            } 
            // fall through
          case 74: break;
          case 31: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.NOT);
            } 
            // fall through
          case 75: break;
          case 32: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.AND);
            } 
            // fall through
          case 76: break;
          case 33: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.CONSTANT);
            } 
            // fall through
          case 77: break;
          case 34: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.RES_FOR);
            } 
            // fall through
          case 78: break;
          case 35: 
            { tokens.add("Character: " + yytext()); return symbol(ParserSym.CHARACTER, yytext().charAt(0));
            } 
            // fall through
          case 79: break;
          case 36: 
            { tokens.add("Type: " + yytext()); return symbol(ParserSym.TYPE_BOOLEAN);
            } 
            // fall through
          case 80: break;
          case 37: 
            { tokens.add("Boolean: " + yytext()); return symbol(ParserSym.BOOLEAN, Boolean.parseBoolean(yytext()));
            } 
            // fall through
          case 81: break;
          case 38: 
            { tokens.add("Type: " + yytext()); return symbol(ParserSym.TYPE_CHARACTER);
            } 
            // fall through
          case 82: break;
          case 39: 
            { tokens.add("Type: " + yytext()); return symbol(ParserSym.TYPE_VOID);
            } 
            // fall through
          case 83: break;
          case 40: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.RES_MAIN);
            } 
            // fall through
          case 84: break;
          case 41: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.RES_ELSE);
            } 
            // fall through
          case 85: break;
          case 42: 
            { tokens.add("AssignOp: " + yytext()); return symbol(ParserSym.OP_SWAP);
            } 
            // fall through
          case 86: break;
          case 43: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.RES_WHILE);
            } 
            // fall through
          case 87: break;
          case 44: 
            { tokens.add("Terminal : " + yytext()); return symbol(ParserSym.RES_RETURN);
            } 
            // fall through
          case 88: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
