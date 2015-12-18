// COMS22201: Syntax analyser

parser grammar Syn;

options {
  tokenVocab = Lex;
  output = AST;
  backtrack = true;
}

@members
{
	private String cleanString(String s){
		String tmp;
		tmp = s.replaceAll("^'", "");
		s = tmp.replaceAll("'$", "");
		tmp = s.replaceAll("''", "'");
		return tmp;
	}
}

program :
    statements
  ;

statements :
    statement ( SEMICOLON^ statement )*
  ;

variable :
	IDENTIFIER
	;

exp :
	term ( ( SUM | MINUS )^ term)*
	;

term :
	factor ( MULT^ factor )*
	;

factor :
	variable
	| constant
	| OPENPAREN! exp CLOSEPAREN!
	;

constant :
	INTNUM
	;

boolexp :
	boolterm ( AND^ boolterm )*
	;

boolterm :
	NOT^ bool
	| bool
	;

bool :
	TRUE
	| FALSE
	| exp EQUALS exp
	| exp LESS exp
	| OPENPAREN! boolexp CLOSEPAREN!
	;

statement :
	variable ASSIGN^ exp
  | WRITELN^
  | SKIP
  | IF^  boolexp THEN statement ELSE statement
  | WHILE^ boolexp DO statement
  | READ^ OPENPAREN! variable CLOSEPAREN!
  | WRITE^ OPENPAREN! (INTNUM | string) CLOSEPAREN!
  | WRITE^ OPENPAREN! exp CLOSEPAREN!
  | WRITE^ OPENPAREN! boolexp CLOSEPAREN!
  | OPENPAREN! statements CLOSEPAREN!
  ;

// WRITE^ OPENPAREN! string CLOSEPAREN!


string
    scope { String tmp; }
    :
    s=STRING { $string::tmp = cleanString($s.text); }-> STRING[$string::tmp]
;
