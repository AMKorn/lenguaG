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
// Aquí van las declaraciones: es decir, la forma de los identificadores y los numeros.

// *** Non-terminals ***
body			= {declarations}{main} 

main 			= {resMain}{lParen}{args}{rParen}{lKey}{instructions}{rKey}
/* DECLARATIONS -> DECLARATION DECLARATIONS 
    | FUNCTION DECLARATIONS 
    | . */
declarations	= (({declaration}|{function}){declarations})?

declaration 	= {constant}?{cont_declaration}
cont_declaration = {type}{identifier}{initialization}?

initialization	= {equal}{value}

function 		= {type}{identifier}{lParen}{args}{rParen}{lKey}{instructions}{rKey}

args			= ({arg}{moreArgs}*)?
moreArgs 		= {comma}{arg}
/* These are equivalent to this:
ARGS -> ARG MORE_ARGS
    | .

MORE_ARGS -> COMMA ARG
    | .*/

instructions 	= ({instruction}{instructions})?
/*INSTRUCTION -> DECLARATION ENDLINE
    | ASSIGNATION ENDLINE
    | SWAP ENDLINE
    | FUNCTION_CALL ENDLINE
    | IF
    | LOOP
    | FOR.*/
instruction 	= (({declaration}
				|{assignation}
				|{swap}
				|{functionCall}
				){endline})|{if}|{loop}|{for}

swap			= {identifier}{swapSymbol}{identifier}

assignation		= {identifier}{equal}({operation}|{value})

value			= {identifier}|({lParen}({value}|{operation}){rParen})|{not}{value}

operation 		= {value}({addition}
				|{substraction}
				|{product}
				|{division}
				|{module}
				|{or}
				|{and}
				|{op_rel})

op_rel			= {equals}|{bigger}|{beq}|{lesser}|{leq}|{neq}

addition		= {addSym}{value}
substraction	= {subSym}{value}
product			= {prodSym}{value}
division		= {divSym}{value}
module			= {modSym}{value}
or				= {resOr}{value}
and				= {resAnd}{value}

equals			= {eqSym}{value}
bigger			= {btSym}{value}
beq				= {beqSym}{value}
lesser			= {ltSym}{value}
leq				= {leqSym}{value}
neq 			= {neqSym}{value}

identifier		= {variable}|{fixedValue}|{functionCall}

variable		= {word}{arraySuffix}
arraySuffix		= {lBracket}{identifier}{rBracket}

fixedValue		= {number}|{character}|{list}|{boolean}

type			= {resInt}|{resChar}|{resBool}|{typeArray}
typeArray		= {type}{lBracket}{identifier}{rBracket}

list			= "list"

if				= {resIf}{lParen}{condition}{rParen}{lKey}{instructions}{rKey}
else			= {resElse}({resIf}{lParen}{condition}{rParen})?{lKey}{instructions}{rKey}

loop			= {resWhile}{lParen}{condition}{rParen}{lKey}{instructions}{rKey}

for				= {forHeader}{lKey}{instructions}{rKey}
forHeader		= {resFor}{lParen}{headerSegment}{endline}{condition}{endline}{headerSegment}{rParen}
headerSegment	= ({declaration}
				|{assignation}
				|{swap}
				|{functionCall}) // Take functionCall if we don't implement reference passing.

functionCall	= {identifier}{lParen}{args}{rParen}

// *** Terminals ***
word			= [a-zA-Z_][a-zA-Z0-9_]*

number			= "number"
character		= "character"
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

%public             // Per indicar que la classe és pública
%class Lexic        // El nom de la classe
%int                // El tipus dels tokens identificats

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

{body}		{System.out.println("Body read");}

//{digits}		{ System.out.println("He llegit el valor "+yytext()); }
// {nodigits}		{ /* Res a fer */ }