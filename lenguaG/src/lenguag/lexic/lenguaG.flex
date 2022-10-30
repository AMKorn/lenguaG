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

%%
// Aquí van las declaraciones: es decir, la forma de los tokens.

// Identifyiers
identifier		= [a-zA-Z_][a-zA-Z0-9_]*

/* arrayIdentifier	= {identifier}{arraySuffix}+ 	// When an existing arrays is indexed
arraySuffix		= {lBracket}({identifier}|{number}){rBracket}

typeArray		= ({typeInt}|{typeChar}|{typeBool}){lBracket}{rBracket} */

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
	public void analyze() {
		try{
			yylex();
		} catch (IOException ioe){
			// Compiler error
			System.err.println("!!!! COMPILER ERROR !!!! Error processing input file.");
		}
	}
%}

%%

// Rules/actions
// What each token has to return, or whatever actions we must take. Order is very important, whatever comes first has priority.

{comment}			{ /* We fully ignore comments */ }

// Reserved words
{resMain}			{ System.out.println("Terminal : " + yytext()); }
{constant}			{ System.out.println("Terminal : " + yytext()); }
{not}				{ System.out.println("Terminal : " + yytext()); }
{resOr}				{ System.out.println("Terminal : " + yytext()); }
{resAnd}			{ System.out.println("Terminal : " + yytext()); }
{resIf}				{ System.out.println("Terminal : " + yytext()); }
{resElse}			{ System.out.println("Terminal : " + yytext()); }
{resWhile}			{ System.out.println("Terminal : " + yytext()); }
{resFor}			{ System.out.println("Terminal : " + yytext()); }
{resReturn}			{ System.out.println("Terminal : " + yytext()); }
{resIn} 			{ System.out.println("Terminal : " + yytext()); }
{resOut} 			{ System.out.println("Terminal : " + yytext()); }

// Symbols
{lParen}			{ System.out.println("Symbol : " + yytext()); }
{rParen}			{ System.out.println("Symbol : " + yytext()); }
{lKey}				{ System.out.println("Symbol : " + yytext()); }
{rKey} 				{ System.out.println("Symbol : " + yytext()); }
{lBracket}			{ System.out.println("Symbol : " + yytext()); }
{rBracket}			{ System.out.println("Symbol : " + yytext()); }
{endline}			{ System.out.println("Symbol : " + yytext()); }
{comma}				{ System.out.println("Symbol : " + yytext()); }

{addSym}			{ System.out.println("Op: " + yytext()); }
{subSym}			{ System.out.println("Op: " + yytext()); }
{prodSym}			{ System.out.println("Op: " + yytext()); }
{divSym}			{ System.out.println("Op: " + yytext()); }
{modSym}			{ System.out.println("Op: " + yytext()); }
{eqSym}				{ System.out.println("Op: " + yytext()); }
{beqSym}			{ System.out.println("Op: " + yytext()); }
{btSym}				{ System.out.println("Op: " + yytext()); }
{leqSym}			{ System.out.println("Op: " + yytext()); }
{ltSym}				{ System.out.println("Op: " + yytext()); }
{neqSym}			{ System.out.println("Op: " + yytext()); }

{assign}			{ System.out.println("AssignOp: " + yytext()); }
{swapSym} 			{ System.out.println("AssignOp: " + yytext()); }

// Non-reserved words
{character}			{ System.out.println("		Character: " + yytext()); }
{number}			{ System.out.println("		Number: " + yytext()); }
{boolean}			{ System.out.println("		Boolean: " + yytext()); }
{string}			{ System.out.println("		String: " + yytext()); }

//{typeArray}			{ System.out.println("	Array de tipo: " + yytext()); }
//{arrayIdentifier}	{ System.out.println("	Array: " + yytext()); }
{typeInt}			{ System.out.println("	Type: " + yytext()); }
{typeFloat}			{ System.out.println("	Type: " + yytext()); }
{typeChar}			{ System.out.println("	Type: " + yytext()); }
{typeBool}			{ System.out.println("	Type: " + yytext()); }
{typeVoid}			{ System.out.println("	Type: " + yytext()); }

{identifier}		{ System.out.println("Identifier: " + yytext()); }

{ws}				{ /* Do nothing */ }
[^]					{ System.out.println(" *** Elemento no reconocido " + yytext() + " en la posicion [line: " + (yyline+1) + ", column: " + (yycolumn+1) + "]"); }