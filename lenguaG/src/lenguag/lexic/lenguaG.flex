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
//integer 		= 0|\-?[1-9][0-9]*
//float			= {integer}?\.[0-9]+(e{integer})?
// Take the following three lines out if it's difficult to implement later down the line
binary			= \-?0b[01]+
octal			= \-?0o[0-7]+
hexadecimal		= \-?0x[0-9a-fA-F]+

int_number		= {integer}
				|{binary}|{octal}|{hexadecimal} // Just take this line out if it's difficult to implement later down the line
character		= {quote}\\?.{quote}	// any character, which could be escaped
boolean			= {resTrue}|{resFalse}	// either true or false
string 			= {doubleQuotes}[^]*{doubleQuotes}

// Reserved words
typeInt			= "int"
//typeFloat 		= "float"
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

	private void addTokens(String token){
		if (LenguaG.DEBUGGING) System.out.println("Detected token: " + token + " at position [line: " + (yyline+1) + ", column: " + (yycolumn+1) + "]");
		tokens.add(token);
	}

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
		return " * Not recognized token " + yytext() + " at position [line: " + (yyline+1) + ", column: " + (yycolumn+1) + "]";
	}
	
	private int parseNum(String s) throws NumberFormatException {
		// We check if it's a negative number.
		//if(s.charAt(0) == '-') return -(parseNum(s.substring(1)));
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
{resMain}			{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.RES_MAIN); }
{constant}			{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.CONSTANT); }
{not}				{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.NOT); }
{resOr}				{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.OR); }
{resAnd}			{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.AND); }
{resIf}				{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.RES_IF); }
{resElse}			{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.RES_ELSE); }
{resWhile}			{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.RES_WHILE); }
{resFor}			{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.RES_FOR); }
{resReturn}			{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.RES_RETURN); }
{resIn} 			{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.RES_IN); }
{resOut} 			{ addTokens("Terminal : " + yytext()); return symbol(ParserSym.RES_OUT); }
// Types
{typeInt}			{ addTokens("Type: " + yytext()); return symbol(ParserSym.TYPE_INTEGER); }
//{typeFloat}			{ addTokens("Type: " + yytext()); return symbol(ParserSym.TYPE_FLOAT); }
{typeChar}			{ addTokens("Type: " + yytext()); return symbol(ParserSym.TYPE_CHARACTER); }
{typeBool}			{ addTokens("Type: " + yytext()); return symbol(ParserSym.TYPE_BOOLEAN); }
{typeVoid}			{ addTokens("Type: " + yytext()); return symbol(ParserSym.TYPE_VOID); }

// Special characters
{lParen}			{ addTokens("Symbol : " + yytext()); return symbol(ParserSym.L_PAREN); }
{rParen}			{ addTokens("Symbol : " + yytext()); return symbol(ParserSym.R_PAREN); }
{lKey}				{ addTokens("Symbol : " + yytext()); return symbol(ParserSym.L_KEY); }
{rKey} 				{ addTokens("Symbol : " + yytext()); return symbol(ParserSym.R_KEY); }
{lBracket}			{ addTokens("Symbol : " + yytext()); return symbol(ParserSym.L_BRACKET); }
{rBracket}			{ addTokens("Symbol : " + yytext()); return symbol(ParserSym.R_BRACKET); }
{endline}			{ addTokens("Symbol : " + yytext()); return symbol(ParserSym.ENDLINE); }
{comma}				{ addTokens("Symbol : " + yytext()); return symbol(ParserSym.COMMA); }

{addSym}			{ addTokens("Op: " + yytext()); return symbol(ParserSym.ADD); }
{subSym}			{ addTokens("Op: " + yytext()); return symbol(ParserSym.SUB); }
{prodSym}			{ addTokens("Op: " + yytext()); return symbol(ParserSym.PROD); }
{divSym}			{ addTokens("Op: " + yytext()); return symbol(ParserSym.DIV); }
{modSym}			{ addTokens("Op: " + yytext()); return symbol(ParserSym.MOD); }
{eqSym}				{ addTokens("Op: " + yytext()); return symbol(ParserSym.IS_EQUAL); }
{beqSym}			{ addTokens("Op: " + yytext()); return symbol(ParserSym.BEQ); }
{btSym}				{ addTokens("Op: " + yytext()); return symbol(ParserSym.BIGGER); }
{leqSym}			{ addTokens("Op: " + yytext()); return symbol(ParserSym.LEQ); }
{ltSym}				{ addTokens("Op: " + yytext()); return symbol(ParserSym.LESSER); }
{neqSym}			{ addTokens("Op: " + yytext()); return symbol(ParserSym.NEQ); }

{assign}			{ addTokens("AssignOp: " + yytext()); return symbol(ParserSym.EQUAL); }
{swapSym} 			{ addTokens("AssignOp: " + yytext()); return symbol(ParserSym.OP_SWAP); }

// Non-reserved words
{character}			{ addTokens("Character: " + yytext()); return symbol(ParserSym.CHARACTER, yytext().charAt(0)); }
//{float}				{ addTokens("Float: " + yytext()); return symbol(ParserSym.FLOAT, Float.parseFloat(yytext())); }
{int_number}		{ addTokens("Number: " + yytext()); 
						try {Integer value = parseNum(yytext());
							return symbol(ParserSym.INTEGER, value); 
						} catch(NumberFormatException nf) {
							errors.add(errorMessage()); 
							return symbol(ParserSym.error);
						}
					}
{boolean}			{ addTokens("Boolean: " + yytext()); return symbol(ParserSym.BOOLEAN, Boolean.parseBoolean(yytext())); }
//{string}			{ addTokens("string: " + yytext()); return symbol(ParserSym.STRING, yytext());} // TODO if string is implemented

{identifier}		{ addTokens("Identifier: " + yytext()); return symbol(ParserSym.IDENTIFIER, yytext()); }

{ws}				{ /* Do nothing */ }
[^]					{ errors.add(errorMessage()); 
						return symbol(ParserSym.error); 
					}