/**
 * Asignatura: 21780 - Compiladores
 * Miembros:
 * 	- Roman Colom, Marc
 * 	- Korn, Andreas Manuel
 * 	- Vilella Candia, Joan 
 */
// Si estás en Lexic.java, OJO! Este archivo no debe ser modificado a mano: para hacer cambios usar jflex con lenguaG.flex

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
	public static void main(String []args) {
		if (args.length < 1) {
			System.err.println("Indica un fitxer amb les dades d'entrada");
			System.exit(0);
		}
		try {
			FileReader in = new FileReader(args[0]);
			
			Lexic parser = new Lexic(in);
			parser.yylex();   // <- El mètode d'invocació per començar a parsejar el document
		} catch (FileNotFoundException e) {
			System.err.println("El fitxer d'entrada '"+args[0]+"' no existeix");
		} catch (IOException e) {
			System.err.println("Error processant el fitxer d'entrada");
		}
	}
%}

%%

// Regles/accions
// Basicamente especificar los tokens que tenemos que devolver

{digits}		{ System.out.println("He llegit el valor "+yytext()); }
{nodigits}		{ /* Res a fer */ }

