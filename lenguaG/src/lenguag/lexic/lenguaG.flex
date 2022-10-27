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

arrayIdentifier	= {identifier}{arraySuffix}+ 	// When an existing arrays is indexed
arraySuffix		= {lBracket}({identifier}|{number}){rBracket}

typeArray		= ({typeInt}|{typeChar}|{typeBool}){lBracket}{rBracket}

integer 		= 0|[1-9][0-9]*
float			= {integer}?\.[0-9]+
// Take the following three lines out if it's difficult to implement later down the line
binary			= 0b[01]+
octal			= 0o[0-7]+
hexadecimal		= 0x[0-9a-fA-F]+

number			= {integer}|{float}
				|{binary}|{octal}|{hexadecimal} // Just take this line out if it's difficult to implement later down the line
character		= {quote}[.]{quote}
boolean			= {resTrue}|{resFalse}

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

// Symbols
lParen			= \(
rParen			= \)
lKey			= \{
rKey 			= \}
lBracket		= \[
rBracket		= \]
endline			= ;
swapSymbol 		= \<\<\>\>
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
neqSym			= !\=
quote			= \'
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
	public static void lexicAnalysis(String file){
		try {
			FileReader in = new FileReader(file);
			
			Lexic parser = new Lexic(in);
			parser.yylex();   // This methods starts parsing the document
		} catch (FileNotFoundException e) {
			System.err.println("Input file " + file + " does not exist.");
		} catch (IOException e) {
			System.err.println("Error processing input file.");
		}
	}
%}

%%

// Rules/actions
// What each token has to return, or whatever actions we must take. Order is very important, whatever comes first has priority.

{comment}			{ /* We fully ignore comments */ }

// Reserved words
{resMain}			{ /* TODO */ }
{constant}			{ /* TODO */ }
{typeInt}			{ System.out.println(yytext()); }
{typeChar}			{ System.out.println(yytext()); }
{typeBool}			{ System.out.println(yytext()); }
{typeVoid}			{ System.out.println(yytext()); }

// Non-reserved words
{character}			{ System.out.println("	Carácter: " + yytext()); }
{number}			{ System.out.println("	Numero: " + yytext()); }
{boolean}			{ System.out.println("	Booleano: " + yytext()); }

{typeArray}			{ System.out.println("		Array de tipo: " + yytext()); }
{arrayIdentifier}	{ System.out.println("		Array: " + yytext()); }

{identifier}		{ System.out.println("	Identificador?: " + yytext()); }

{ws}				{ /* Do nothing */ }
[^]					{ System.out.println("Elemento no reconocido " + yytext() + " en la posicion [line: " + (yyline+1) + ", column: " + (yycolumn+1) + "]"); }