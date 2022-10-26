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

array 			= {identifier}{arraySuffix}
arraySuffix		= {lBracket}({identifier}|{number}){lBracket}

number			= 0|[1-9][0-9]*					// Integer number specification for now
character		= {quote}[a-z]{quote}
boolean			= {resTrue}|{resFalse}

// Reserved words
resMain			= "main"
constant 		= "val"
not				= "not"
resOr			= "or"
resAnd			= "and"
resInt			= "int"
resChar			= "char"
resBool			= "bool"
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
quote			= [\"|\']

ws 				= [' '|\t'|'\r'|'\n']+

commentLine		= \/\/
commentBeg		= \/\*
commentEnd		= \*\/
comment			= {commentLine}.*				// Comment line symbol and any character except for \n, star times.
				|{commentBeg}[^]*{commentEnd}

%public             // Per indicar que la classe és pública
%class Lexic        // El nom de la classe
%int                // Type of identified tokens

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

// Regles/accions
// Basicamente especificar los tokens que tenemos que devolver

{comment}		{ /* We fully ignore comments */ }

// Reserved words
{resMain}		{ System.out.println("main"); }
{constant}		{ System.out.println("val"); }

// Non-reserved words
{identifier}	{ System.out.println(yytext()); }

{ws}			{ /* Do nothing */ }
[^]				{ System.out.println("no se uwu no me pongas nervioso no sé lo que significa " + yytext()); }