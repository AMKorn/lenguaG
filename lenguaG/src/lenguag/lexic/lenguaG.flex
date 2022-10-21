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

digit     = [0-9]
nodigit   = [^0-9]
digits    = {digit}+
nodigits  = {nodigit}+


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

{digits}		{ System.out.println("He llegit el valor "+yytext()); }
{nodigits}		{ /* Res a fer */ }

