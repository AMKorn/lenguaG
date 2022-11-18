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
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory.Location;

// Our project imports
import lenguag.*;
import lenguag.syntactic.ParserSym;

%%
%public             // Per indicar que la classe és pública
%class Lexic        // El nom de la classe

//%int                // Type of identified tokens
%type java_cup.runtime.Symbol

%line				// So that jflex keeps track of the line
%column				// and the column

%cup

%eofval{
	return symbol(ParserSym.EOF);
%eofval}

// Aquí van las declaraciones: es decir, la forma de los tokens.

// Identifyiers
identifier		= [a-zA-Z_][a-zA-Z0-9_]*

integer 		= 0|[1-9][0-9]*
binary			= 0b[01]+
octal			= 0o[0-7]+
hexadecimal		= 0x[0-9a-fA-F]+

int_number		= {integer}
				|{binary}|{octal}|{hexadecimal}
character		= {quote}\\?.{quote}	// any character, which could be escaped
boolean			= {resTrue}|{resFalse}	// either true or false
string 			= {doubleQuotes}.*{doubleQuotes}

// Reserved words
typeInt			= "int"
typeChar		= "char"
typeBool		= "bool"
typeVoid		= "void"

resMain			= "main"
constant 		= "val"
not				= "not"
resOr			= "or"
resAnd			= "and"
resTrue			= "true"
resFalse		= "false"
resIf			= "if"
resElse			= "else"
resWhile		= "while"
resFor			= "for"
resReturn		= "return"
resIn 			= "in"
resOut 			= "out"

// Symbols
lParen			= \(
rParen			= \)
lKey			= \{
rKey 			= \}
lBracket		= \[
rBracket		= \]
endline			= ;
comma			= ,

assign 			= \=
swapSym 		= \<\<\>\>
addSym			= \+
subSym			= \-
prodSym			= \*
divSym			= \/
modSym			= \%
eqSym			= \=\=
btSym			= \>
beqSym			= \>\=
ltSym			= \<
leqSym			= \<\=
neqSym			= \!\=
quote			= '
doubleQuotes	= \"

ws 				= [ \t\r\n]+

commentLine		= "//"|\#
commentBeg		= \/\*
commentEnd		= \*\/
comment			= {commentLine}.*				// Comment line symbol and any character except for \n, star times.
				|{commentBeg}[^]*{commentEnd}

// El següent codi es copiarà també, dins de la classe. És a dir, si es posa res ha de ser en el format adient: mètodes, atributs, etc. 
// En nuestro caso lo que tenemos que poner es aquello a lo que llamaremos desde el main para hacer el analisis lexico
%{
	private ArrayList<String> tokens = new ArrayList<>();
	private ArrayList<String> errors = new ArrayList<>();

	/* private void addTokens(String token){
		tokens.add(token);
	} */

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

	public boolean thereIsError(){
		return !errors.isEmpty();
	}

	private String errorMessage(){
		return " !! Lexic error: Not recognized token " + yytext() + " at position [line: " + (yyline+1) + ", column: " + (yycolumn+1) + "]";
	}
	
	private int parseNum(String s) throws NumberFormatException {
		// We check whether the first number is a 0, if so there might be a prefix specifying base, unless it's just a 0 by itself.
		if(s.charAt(0) != '0' || s.length() == 1) return Integer.parseInt(s);
		// If 
		char base = s.charAt(1);
		String num = s.substring(2);
		//String[] sParts = s.split(""+base);
		switch(base){
			case 'b':
				return Integer.parseInt(num, 2);
			case 'o':
				return Integer.parseInt(num, 8);
			case 'x':
				return Integer.parseInt(num, 16);
			default:
				throw new NumberFormatException(errorMessage());
		}
	}

	// Functions to streamline CUP symbol returns.
    private ComplexSymbol symbol(int type) {
        Location l = new Location(yyline+1, yycolumn+1);
        Location r = new Location(yyline+1, yycolumn+yylength());
        return new ComplexSymbol(ParserSym.terminalNames[type], type, l, r);
        //return new ComplexSymbol(type, yyline+1, yycolumn+1);
    }
    
    private ComplexSymbol symbol(int type, Object value) {
        Location l = new Location(yyline+1, yycolumn+1);
        Location r = new Location(yyline+1, yycolumn+yylength());
        return new ComplexSymbol(ParserSym.terminalNames[type], type, l, r, value);
    }
%}

%%

// Rules/actions
// What each token has to return, or whatever actions we must take. Order is very important, whatever comes first has priority.

{comment}			{ /* We fully ignore comments */ }

// Reserved words
{resMain}			{ tokens.add(yytext() + " : RES_MAIN"); return symbol(ParserSym.RES_MAIN); }
{constant}			{ tokens.add(yytext() + " : CONSTANT"); return symbol(ParserSym.CONSTANT); }
{not}				{ tokens.add(yytext() + " : NOT"); return symbol(ParserSym.NOT); }
{resOr}				{ tokens.add(yytext() + " : OR"); return symbol(ParserSym.OR); }
{resAnd}			{ tokens.add(yytext() + " : AND"); return symbol(ParserSym.AND); }
{resIf}				{ tokens.add(yytext() + " : RES_IF"); return symbol(ParserSym.RES_IF); }
{resElse}			{ tokens.add(yytext() + " : RES_ELSE"); return symbol(ParserSym.RES_ELSE); }
{resWhile}			{ tokens.add(yytext() + " : RES_WHILE"); return symbol(ParserSym.RES_WHILE); }
{resFor}			{ tokens.add(yytext() + " : RES_FOR"); return symbol(ParserSym.RES_FOR); }
{resReturn}			{ tokens.add(yytext() + " : RES_RETURN"); return symbol(ParserSym.RES_RETURN); }
{resIn} 			{ tokens.add(yytext() + " : RES_IN"); return symbol(ParserSym.RES_IN); }
{resOut} 			{ tokens.add(yytext() + " : RES_OUT"); return symbol(ParserSym.RES_OUT); }
// Types
{typeInt}			{ tokens.add(yytext() + " : TYPE_INTEGER"); return symbol(ParserSym.TYPE_INTEGER); }
{typeChar}			{ tokens.add(yytext() + " : TYPE_CHARACTER"); return symbol(ParserSym.TYPE_CHARACTER); }
{typeBool}			{ tokens.add(yytext() + " : TYPE_BOOLEAN"); return symbol(ParserSym.TYPE_BOOLEAN); }
{typeVoid}			{ tokens.add(yytext() + " : TYPE_VOID"); return symbol(ParserSym.TYPE_VOID); }

// Special characters
{lParen}			{ tokens.add(yytext() + " : L_PAREN"); return symbol(ParserSym.L_PAREN); }
{rParen}			{ tokens.add(yytext() + " : R_PAREN"); return symbol(ParserSym.R_PAREN); }
{lKey}				{ tokens.add(yytext() + " : L_KEY"); return symbol(ParserSym.L_KEY); }
{rKey} 				{ tokens.add(yytext() + " : R_KEY"); return symbol(ParserSym.R_KEY); }
{lBracket}			{ tokens.add(yytext() + " : L_BRACKET"); return symbol(ParserSym.L_BRACKET); }
{rBracket}			{ tokens.add(yytext() + " : R_BRACKET"); return symbol(ParserSym.R_BRACKET); }
{endline}			{ tokens.add(yytext() + " : ENDLINE"); return symbol(ParserSym.ENDLINE); }
{comma}				{ tokens.add(yytext() + " : COMMA"); return symbol(ParserSym.COMMA); }

{addSym}			{ tokens.add(yytext() + " : ADD"); return symbol(ParserSym.ADD); }
{subSym}			{ tokens.add(yytext() + " : SUB"); return symbol(ParserSym.SUB); }
{prodSym}			{ tokens.add(yytext() + " : PROD"); return symbol(ParserSym.PROD); }
{divSym}			{ tokens.add(yytext() + " : DIV"); return symbol(ParserSym.DIV); }
{modSym}			{ tokens.add(yytext() + " : MOD"); return symbol(ParserSym.MOD); }
{eqSym}				{ tokens.add(yytext() + " : IS_EQUAL"); return symbol(ParserSym.IS_EQUAL); }
{beqSym}			{ tokens.add(yytext() + " : BEQ"); return symbol(ParserSym.BEQ); }
{btSym}				{ tokens.add(yytext() + " : BIGGER"); return symbol(ParserSym.BIGGER); }
{leqSym}			{ tokens.add(yytext() + " : LEQ"); return symbol(ParserSym.LEQ); }
{ltSym}				{ tokens.add(yytext() + " : LESSER"); return symbol(ParserSym.LESSER); }
{neqSym}			{ tokens.add(yytext() + " : NEQ"); return symbol(ParserSym.NEQ); }

{assign}			{ tokens.add(yytext() + " : EQUAL"); return symbol(ParserSym.EQUAL); }
{swapSym} 			{ tokens.add(yytext() + " : OP_SWAP"); return symbol(ParserSym.OP_SWAP); }

// Non-reserved words
{character}			{ tokens.add(yytext() + " : CHARACTER"); return symbol(ParserSym.CHARACTER, yytext().charAt(0)); }
{int_number}		{ 	try {
							Integer value = parseNum(yytext()); 
							tokens.add(yytext() + " : INTEGER"); 
							return symbol(ParserSym.INTEGER, value); 
						} catch(NumberFormatException nf) {
							errors.add(errorMessage()); System.err.println(errorMessage());
							return symbol(ParserSym.error);
						}
					}
{boolean}			{ tokens.add(yytext() + " : BOOLEAN"); return symbol(ParserSym.BOOLEAN, Boolean.parseBoolean(yytext())); }
{string}			{ tokens.add(yytext() + " : STRING"); return symbol(ParserSym.STRING, yytext());}

{identifier}		{ tokens.add(yytext() + " : IDENTIFIER"); return symbol(ParserSym.IDENTIFIER, yytext()); }

{ws}				{ /* Do nothing */ }
[^]					{ errors.add(errorMessage()); System.err.println(errorMessage());
						return symbol(ParserSym.error); 
					}