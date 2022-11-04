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

import java.io.*;
import java.util.*;

%%
// Aquí van las declaraciones: es decir, la forma de los tokens.

// Identifyiers
identifier		= [a-zA-Z_][a-zA-Z0-9_]*

integer 		= 0|[1-9][0-9]*
float			= {integer}?\.[0-9]+(e{integer})?
// Take the following three lines out if it's difficult to implement later down the line
binary			= 0b[01]+
octal			= 0o[0-7]+
hexadecimal		= 0x[0-9a-fA-F]+

number			= {integer}|{float}
				|{binary}|{octal}|{hexadecimal} // Just take this line out if it's difficult to implement later down the line
character		= {quote}\\?.{quote}	// any character, which could be escaped
boolean			= {resTrue}|{resFalse}	// either true or false
string 			= {doubleQuotes}[^]*{doubleQuotes}

// Reserved words
typeInt			= "int"
typeFloat 		= "float"
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

commentLine		= ["\/\/"\#]
commentBeg		= \/\*
commentEnd		= \*\/
comment			= {commentLine}.*				// Comment line symbol and any character except for \n, star times.
				|{commentBeg}[^]*{commentEnd}

%public             // Per indicar que la classe és pública
%class Lexic        // El nom de la classe
%int                // Type of identified tokens
%line
%column

// El següent codi es copiarà també, dins de la classe. És a dir, si es posa res ha de ser en el format adient: mètodes, atributs, etc. 
// En nuestro caso lo que tenemos que poner es aquello a lo que llamaremos desde el main para hacer el analisis lexico
%{
	private ArrayList<String> tokens;

	public void analyze() {
		tokens = new ArrayList<>();
		try{
			yylex();
		} catch (IOException ioe){
			// Compiler error
			System.err.println("!!!! COMPILER ERROR !!!! Error processing input file.");
		}
	}

	public String writeTokens(){
		String tokenList = "";

		for(String s : tokens){
			tokenList += s + "\n";
		}

		return tokenList;
	}
%}

%%

// Rules/actions
// What each token has to return, or whatever actions we must take. Order is very important, whatever comes first has priority.

{comment}			{ /* We fully ignore comments */ }

// Reserved words
{resMain}			{ tokens.add("Terminal : " + yytext()); }
{constant}			{ tokens.add("Terminal : " + yytext()); }
{not}				{ tokens.add("Terminal : " + yytext()); }
{resOr}				{ tokens.add("Terminal : " + yytext()); }
{resAnd}			{ tokens.add("Terminal : " + yytext()); }
{resIf}				{ tokens.add("Terminal : " + yytext()); }
{resElse}			{ tokens.add("Terminal : " + yytext()); }
{resWhile}			{ tokens.add("Terminal : " + yytext()); }
{resFor}			{ tokens.add("Terminal : " + yytext()); }
{resReturn}			{ tokens.add("Terminal : " + yytext()); }
{resIn} 			{ tokens.add("Terminal : " + yytext()); }
{resOut} 			{ tokens.add("Terminal : " + yytext()); }
// Types
{typeInt}			{ tokens.add("Type: " + yytext()); }
{typeFloat}			{ tokens.add("Type: " + yytext()); }
{typeChar}			{ tokens.add("Type: " + yytext()); }
{typeBool}			{ tokens.add("Type: " + yytext()); }
{typeVoid}			{ tokens.add("Type: " + yytext()); }

// Special characters
{lParen}			{ tokens.add("Symbol : " + yytext()); }
{rParen}			{ tokens.add("Symbol : " + yytext()); }
{lKey}				{ tokens.add("Symbol : " + yytext()); }
{rKey} 				{ tokens.add("Symbol : " + yytext()); }
{lBracket}			{ tokens.add("Symbol : " + yytext()); }
{rBracket}			{ tokens.add("Symbol : " + yytext()); }
{endline}			{ tokens.add("Symbol : " + yytext()); }
{comma}				{ tokens.add("Symbol : " + yytext()); }

{addSym}			{ tokens.add("Op: " + yytext()); }
{subSym}			{ tokens.add("Op: " + yytext()); }
{prodSym}			{ tokens.add("Op: " + yytext()); }
{divSym}			{ tokens.add("Op: " + yytext()); }
{modSym}			{ tokens.add("Op: " + yytext()); }
{eqSym}				{ tokens.add("Op: " + yytext()); }
{beqSym}			{ tokens.add("Op: " + yytext()); }
{btSym}				{ tokens.add("Op: " + yytext()); }
{leqSym}			{ tokens.add("Op: " + yytext()); }
{ltSym}				{ tokens.add("Op: " + yytext()); }
{neqSym}			{ tokens.add("Op: " + yytext()); }

{assign}			{ tokens.add("AssignOp: " + yytext()); }
{swapSym} 			{ tokens.add("AssignOp: " + yytext()); }

// Non-reserved words
{character}			{ tokens.add("		Character: " + yytext()); }
{number}			{ tokens.add("		Number: " + yytext()); }
{boolean}			{ tokens.add("		Boolean: " + yytext()); }
{string}			{ tokens.add("		String: " + yytext()); }

{identifier}		{ tokens.add("Identifier: " + yytext()); }

{ws}				{ /* Do nothing */ }
[^]					{ System.out.println(" *** Elemento no reconocido " + yytext() + " en la posicion [line: " + (yyline+1) + ", column: " + (yycolumn+1) + "]"); }