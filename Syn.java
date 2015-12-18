// $ANTLR 3.5.2 Syn.g 2015-12-16 21:26:13

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class Syn extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASSIGN", "BOOLEAN", "CLOSEPAREN", 
		"COMMENT", "DO", "ELSE", "EQUALS", "FALSE", "IDENTIFIER", "IF", "INTNUM", 
		"LESS", "MINUS", "MULT", "NOT", "OPENPAREN", "READ", "SEMICOLON", "SKIP", 
		"STRING", "SUM", "THEN", "TRUE", "WHILE", "WRITE", "WRITELN", "WS"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ASSIGN=5;
	public static final int BOOLEAN=6;
	public static final int CLOSEPAREN=7;
	public static final int COMMENT=8;
	public static final int DO=9;
	public static final int ELSE=10;
	public static final int EQUALS=11;
	public static final int FALSE=12;
	public static final int IDENTIFIER=13;
	public static final int IF=14;
	public static final int INTNUM=15;
	public static final int LESS=16;
	public static final int MINUS=17;
	public static final int MULT=18;
	public static final int NOT=19;
	public static final int OPENPAREN=20;
	public static final int READ=21;
	public static final int SEMICOLON=22;
	public static final int SKIP=23;
	public static final int STRING=24;
	public static final int SUM=25;
	public static final int THEN=26;
	public static final int TRUE=27;
	public static final int WHILE=28;
	public static final int WRITE=29;
	public static final int WRITELN=30;
	public static final int WS=31;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public Syn(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public Syn(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return Syn.tokenNames; }
	@Override public String getGrammarFileName() { return "Syn.g"; }


		private String cleanString(String s){
			String tmp;
			tmp = s.replaceAll("^'", "");
			s = tmp.replaceAll("'$", "");
			tmp = s.replaceAll("''", "'");
			return tmp;
		}


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// Syn.g:22:1: program : statements ;
	public final Syn.program_return program() throws RecognitionException {
		Syn.program_return retval = new Syn.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope statements1 =null;


		try {
			// Syn.g:22:9: ( statements )
			// Syn.g:23:5: statements
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_statements_in_program56);
			statements1=statements();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, statements1.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class statements_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statements"
	// Syn.g:26:1: statements : statement ( SEMICOLON ^ statement )* ;
	public final Syn.statements_return statements() throws RecognitionException {
		Syn.statements_return retval = new Syn.statements_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMICOLON3=null;
		ParserRuleReturnScope statement2 =null;
		ParserRuleReturnScope statement4 =null;

		Object SEMICOLON3_tree=null;

		try {
			// Syn.g:26:12: ( statement ( SEMICOLON ^ statement )* )
			// Syn.g:27:5: statement ( SEMICOLON ^ statement )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_statement_in_statements71);
			statement2=statement();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, statement2.getTree());

			// Syn.g:27:15: ( SEMICOLON ^ statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==SEMICOLON) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Syn.g:27:17: SEMICOLON ^ statement
					{
					SEMICOLON3=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statements75); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SEMICOLON3_tree = (Object)adaptor.create(SEMICOLON3);
					root_0 = (Object)adaptor.becomeRoot(SEMICOLON3_tree, root_0);
					}

					pushFollow(FOLLOW_statement_in_statements78);
					statement4=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement4.getTree());

					}
					break;

				default :
					break loop1;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statements"


	public static class variable_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "variable"
	// Syn.g:30:1: variable : IDENTIFIER ;
	public final Syn.variable_return variable() throws RecognitionException {
		Syn.variable_return retval = new Syn.variable_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IDENTIFIER5=null;

		Object IDENTIFIER5_tree=null;

		try {
			// Syn.g:30:10: ( IDENTIFIER )
			// Syn.g:31:2: IDENTIFIER
			{
			root_0 = (Object)adaptor.nil();


			IDENTIFIER5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variable93); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER5_tree = (Object)adaptor.create(IDENTIFIER5);
			adaptor.addChild(root_0, IDENTIFIER5_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "variable"


	public static class exp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exp"
	// Syn.g:34:1: exp : term ( ( SUM | MINUS ) ^ term )* ;
	public final Syn.exp_return exp() throws RecognitionException {
		Syn.exp_return retval = new Syn.exp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set7=null;
		ParserRuleReturnScope term6 =null;
		ParserRuleReturnScope term8 =null;

		Object set7_tree=null;

		try {
			// Syn.g:34:5: ( term ( ( SUM | MINUS ) ^ term )* )
			// Syn.g:35:2: term ( ( SUM | MINUS ) ^ term )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term_in_exp104);
			term6=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term6.getTree());

			// Syn.g:35:7: ( ( SUM | MINUS ) ^ term )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==MINUS||LA2_0==SUM) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Syn.g:35:9: ( SUM | MINUS ) ^ term
					{
					set7=input.LT(1);
					set7=input.LT(1);
					if ( input.LA(1)==MINUS||input.LA(1)==SUM ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set7), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_term_in_exp119);
					term8=term();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, term8.getTree());

					}
					break;

				default :
					break loop2;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exp"


	public static class term_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term"
	// Syn.g:38:1: term : factor ( MULT ^ factor )* ;
	public final Syn.term_return term() throws RecognitionException {
		Syn.term_return retval = new Syn.term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MULT10=null;
		ParserRuleReturnScope factor9 =null;
		ParserRuleReturnScope factor11 =null;

		Object MULT10_tree=null;

		try {
			// Syn.g:38:6: ( factor ( MULT ^ factor )* )
			// Syn.g:39:2: factor ( MULT ^ factor )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term132);
			factor9=factor();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, factor9.getTree());

			// Syn.g:39:9: ( MULT ^ factor )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==MULT) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// Syn.g:39:11: MULT ^ factor
					{
					MULT10=(Token)match(input,MULT,FOLLOW_MULT_in_term136); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MULT10_tree = (Object)adaptor.create(MULT10);
					root_0 = (Object)adaptor.becomeRoot(MULT10_tree, root_0);
					}

					pushFollow(FOLLOW_factor_in_term139);
					factor11=factor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, factor11.getTree());

					}
					break;

				default :
					break loop3;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "term"


	public static class factor_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// Syn.g:42:1: factor : ( variable | constant | OPENPAREN ! exp CLOSEPAREN !);
	public final Syn.factor_return factor() throws RecognitionException {
		Syn.factor_return retval = new Syn.factor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OPENPAREN14=null;
		Token CLOSEPAREN16=null;
		ParserRuleReturnScope variable12 =null;
		ParserRuleReturnScope constant13 =null;
		ParserRuleReturnScope exp15 =null;

		Object OPENPAREN14_tree=null;
		Object CLOSEPAREN16_tree=null;

		try {
			// Syn.g:42:8: ( variable | constant | OPENPAREN ! exp CLOSEPAREN !)
			int alt4=3;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt4=1;
				}
				break;
			case INTNUM:
				{
				alt4=2;
				}
				break;
			case OPENPAREN:
				{
				alt4=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// Syn.g:43:2: variable
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_variable_in_factor153);
					variable12=variable();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, variable12.getTree());

					}
					break;
				case 2 :
					// Syn.g:44:4: constant
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_constant_in_factor158);
					constant13=constant();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constant13.getTree());

					}
					break;
				case 3 :
					// Syn.g:45:4: OPENPAREN ! exp CLOSEPAREN !
					{
					root_0 = (Object)adaptor.nil();


					OPENPAREN14=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_factor163); if (state.failed) return retval;
					pushFollow(FOLLOW_exp_in_factor166);
					exp15=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp15.getTree());

					CLOSEPAREN16=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_factor168); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "factor"


	public static class constant_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constant"
	// Syn.g:48:1: constant : INTNUM ;
	public final Syn.constant_return constant() throws RecognitionException {
		Syn.constant_return retval = new Syn.constant_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INTNUM17=null;

		Object INTNUM17_tree=null;

		try {
			// Syn.g:48:10: ( INTNUM )
			// Syn.g:49:2: INTNUM
			{
			root_0 = (Object)adaptor.nil();


			INTNUM17=(Token)match(input,INTNUM,FOLLOW_INTNUM_in_constant180); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INTNUM17_tree = (Object)adaptor.create(INTNUM17);
			adaptor.addChild(root_0, INTNUM17_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "constant"


	public static class boolexp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "boolexp"
	// Syn.g:52:1: boolexp : boolterm ( AND ^ boolterm )* ;
	public final Syn.boolexp_return boolexp() throws RecognitionException {
		Syn.boolexp_return retval = new Syn.boolexp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AND19=null;
		ParserRuleReturnScope boolterm18 =null;
		ParserRuleReturnScope boolterm20 =null;

		Object AND19_tree=null;

		try {
			// Syn.g:52:9: ( boolterm ( AND ^ boolterm )* )
			// Syn.g:53:2: boolterm ( AND ^ boolterm )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_boolterm_in_boolexp191);
			boolterm18=boolterm();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, boolterm18.getTree());

			// Syn.g:53:11: ( AND ^ boolterm )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==AND) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// Syn.g:53:13: AND ^ boolterm
					{
					AND19=(Token)match(input,AND,FOLLOW_AND_in_boolexp195); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND19_tree = (Object)adaptor.create(AND19);
					root_0 = (Object)adaptor.becomeRoot(AND19_tree, root_0);
					}

					pushFollow(FOLLOW_boolterm_in_boolexp198);
					boolterm20=boolterm();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolterm20.getTree());

					}
					break;

				default :
					break loop5;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "boolexp"


	public static class boolterm_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "boolterm"
	// Syn.g:56:1: boolterm : ( NOT ^ bool | bool );
	public final Syn.boolterm_return boolterm() throws RecognitionException {
		Syn.boolterm_return retval = new Syn.boolterm_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NOT21=null;
		ParserRuleReturnScope bool22 =null;
		ParserRuleReturnScope bool23 =null;

		Object NOT21_tree=null;

		try {
			// Syn.g:56:10: ( NOT ^ bool | bool )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==NOT) ) {
				alt6=1;
			}
			else if ( ((LA6_0 >= FALSE && LA6_0 <= IDENTIFIER)||LA6_0==INTNUM||LA6_0==OPENPAREN||LA6_0==TRUE) ) {
				alt6=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// Syn.g:57:2: NOT ^ bool
					{
					root_0 = (Object)adaptor.nil();


					NOT21=(Token)match(input,NOT,FOLLOW_NOT_in_boolterm212); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT21_tree = (Object)adaptor.create(NOT21);
					root_0 = (Object)adaptor.becomeRoot(NOT21_tree, root_0);
					}

					pushFollow(FOLLOW_bool_in_boolterm215);
					bool22=bool();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, bool22.getTree());

					}
					break;
				case 2 :
					// Syn.g:58:4: bool
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_bool_in_boolterm220);
					bool23=bool();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, bool23.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "boolterm"


	public static class bool_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "bool"
	// Syn.g:61:1: bool : ( TRUE | FALSE | exp EQUALS exp | exp LESS exp | OPENPAREN ! boolexp CLOSEPAREN !);
	public final Syn.bool_return bool() throws RecognitionException {
		Syn.bool_return retval = new Syn.bool_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token TRUE24=null;
		Token FALSE25=null;
		Token EQUALS27=null;
		Token LESS30=null;
		Token OPENPAREN32=null;
		Token CLOSEPAREN34=null;
		ParserRuleReturnScope exp26 =null;
		ParserRuleReturnScope exp28 =null;
		ParserRuleReturnScope exp29 =null;
		ParserRuleReturnScope exp31 =null;
		ParserRuleReturnScope boolexp33 =null;

		Object TRUE24_tree=null;
		Object FALSE25_tree=null;
		Object EQUALS27_tree=null;
		Object LESS30_tree=null;
		Object OPENPAREN32_tree=null;
		Object CLOSEPAREN34_tree=null;

		try {
			// Syn.g:61:6: ( TRUE | FALSE | exp EQUALS exp | exp LESS exp | OPENPAREN ! boolexp CLOSEPAREN !)
			int alt7=5;
			switch ( input.LA(1) ) {
			case TRUE:
				{
				alt7=1;
				}
				break;
			case FALSE:
				{
				alt7=2;
				}
				break;
			case IDENTIFIER:
				{
				int LA7_3 = input.LA(2);
				if ( (synpred11_Syn()) ) {
					alt7=3;
				}
				else if ( (synpred12_Syn()) ) {
					alt7=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case INTNUM:
				{
				int LA7_4 = input.LA(2);
				if ( (synpred11_Syn()) ) {
					alt7=3;
				}
				else if ( (synpred12_Syn()) ) {
					alt7=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case OPENPAREN:
				{
				int LA7_5 = input.LA(2);
				if ( (synpred11_Syn()) ) {
					alt7=3;
				}
				else if ( (synpred12_Syn()) ) {
					alt7=4;
				}
				else if ( (true) ) {
					alt7=5;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// Syn.g:62:2: TRUE
					{
					root_0 = (Object)adaptor.nil();


					TRUE24=(Token)match(input,TRUE,FOLLOW_TRUE_in_bool231); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE24_tree = (Object)adaptor.create(TRUE24);
					adaptor.addChild(root_0, TRUE24_tree);
					}

					}
					break;
				case 2 :
					// Syn.g:63:4: FALSE
					{
					root_0 = (Object)adaptor.nil();


					FALSE25=(Token)match(input,FALSE,FOLLOW_FALSE_in_bool236); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE25_tree = (Object)adaptor.create(FALSE25);
					adaptor.addChild(root_0, FALSE25_tree);
					}

					}
					break;
				case 3 :
					// Syn.g:64:4: exp EQUALS exp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_exp_in_bool241);
					exp26=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp26.getTree());

					EQUALS27=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_bool243); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EQUALS27_tree = (Object)adaptor.create(EQUALS27);
					adaptor.addChild(root_0, EQUALS27_tree);
					}

					pushFollow(FOLLOW_exp_in_bool245);
					exp28=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp28.getTree());

					}
					break;
				case 4 :
					// Syn.g:65:4: exp LESS exp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_exp_in_bool250);
					exp29=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp29.getTree());

					LESS30=(Token)match(input,LESS,FOLLOW_LESS_in_bool252); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESS30_tree = (Object)adaptor.create(LESS30);
					adaptor.addChild(root_0, LESS30_tree);
					}

					pushFollow(FOLLOW_exp_in_bool254);
					exp31=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp31.getTree());

					}
					break;
				case 5 :
					// Syn.g:66:4: OPENPAREN ! boolexp CLOSEPAREN !
					{
					root_0 = (Object)adaptor.nil();


					OPENPAREN32=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_bool259); if (state.failed) return retval;
					pushFollow(FOLLOW_boolexp_in_bool262);
					boolexp33=boolexp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolexp33.getTree());

					CLOSEPAREN34=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_bool264); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "bool"


	public static class statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// Syn.g:69:1: statement : ( variable ASSIGN ^ exp | WRITELN ^| SKIP | IF ^ boolexp THEN statement ELSE statement | WHILE ^ boolexp DO statement | READ ^ OPENPAREN ! variable CLOSEPAREN !| WRITE ^ OPENPAREN ! ( INTNUM | string ) CLOSEPAREN !| WRITE ^ OPENPAREN ! exp CLOSEPAREN !| WRITE ^ OPENPAREN ! boolexp CLOSEPAREN !| OPENPAREN ! statements CLOSEPAREN !);
	public final Syn.statement_return statement() throws RecognitionException {
		Syn.statement_return retval = new Syn.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASSIGN36=null;
		Token WRITELN38=null;
		Token SKIP39=null;
		Token IF40=null;
		Token THEN42=null;
		Token ELSE44=null;
		Token WHILE46=null;
		Token DO48=null;
		Token READ50=null;
		Token OPENPAREN51=null;
		Token CLOSEPAREN53=null;
		Token WRITE54=null;
		Token OPENPAREN55=null;
		Token INTNUM56=null;
		Token CLOSEPAREN58=null;
		Token WRITE59=null;
		Token OPENPAREN60=null;
		Token CLOSEPAREN62=null;
		Token WRITE63=null;
		Token OPENPAREN64=null;
		Token CLOSEPAREN66=null;
		Token OPENPAREN67=null;
		Token CLOSEPAREN69=null;
		ParserRuleReturnScope variable35 =null;
		ParserRuleReturnScope exp37 =null;
		ParserRuleReturnScope boolexp41 =null;
		ParserRuleReturnScope statement43 =null;
		ParserRuleReturnScope statement45 =null;
		ParserRuleReturnScope boolexp47 =null;
		ParserRuleReturnScope statement49 =null;
		ParserRuleReturnScope variable52 =null;
		ParserRuleReturnScope string57 =null;
		ParserRuleReturnScope exp61 =null;
		ParserRuleReturnScope boolexp65 =null;
		ParserRuleReturnScope statements68 =null;

		Object ASSIGN36_tree=null;
		Object WRITELN38_tree=null;
		Object SKIP39_tree=null;
		Object IF40_tree=null;
		Object THEN42_tree=null;
		Object ELSE44_tree=null;
		Object WHILE46_tree=null;
		Object DO48_tree=null;
		Object READ50_tree=null;
		Object OPENPAREN51_tree=null;
		Object CLOSEPAREN53_tree=null;
		Object WRITE54_tree=null;
		Object OPENPAREN55_tree=null;
		Object INTNUM56_tree=null;
		Object CLOSEPAREN58_tree=null;
		Object WRITE59_tree=null;
		Object OPENPAREN60_tree=null;
		Object CLOSEPAREN62_tree=null;
		Object WRITE63_tree=null;
		Object OPENPAREN64_tree=null;
		Object CLOSEPAREN66_tree=null;
		Object OPENPAREN67_tree=null;
		Object CLOSEPAREN69_tree=null;

		try {
			// Syn.g:69:11: ( variable ASSIGN ^ exp | WRITELN ^| SKIP | IF ^ boolexp THEN statement ELSE statement | WHILE ^ boolexp DO statement | READ ^ OPENPAREN ! variable CLOSEPAREN !| WRITE ^ OPENPAREN ! ( INTNUM | string ) CLOSEPAREN !| WRITE ^ OPENPAREN ! exp CLOSEPAREN !| WRITE ^ OPENPAREN ! boolexp CLOSEPAREN !| OPENPAREN ! statements CLOSEPAREN !)
			int alt9=10;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt9=1;
				}
				break;
			case WRITELN:
				{
				alt9=2;
				}
				break;
			case SKIP:
				{
				alt9=3;
				}
				break;
			case IF:
				{
				alt9=4;
				}
				break;
			case WHILE:
				{
				alt9=5;
				}
				break;
			case READ:
				{
				alt9=6;
				}
				break;
			case WRITE:
				{
				int LA9_7 = input.LA(2);
				if ( (synpred20_Syn()) ) {
					alt9=7;
				}
				else if ( (synpred21_Syn()) ) {
					alt9=8;
				}
				else if ( (synpred22_Syn()) ) {
					alt9=9;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 7, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case OPENPAREN:
				{
				alt9=10;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// Syn.g:70:2: variable ASSIGN ^ exp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_variable_in_statement276);
					variable35=variable();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, variable35.getTree());

					ASSIGN36=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_statement278); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSIGN36_tree = (Object)adaptor.create(ASSIGN36);
					root_0 = (Object)adaptor.becomeRoot(ASSIGN36_tree, root_0);
					}

					pushFollow(FOLLOW_exp_in_statement281);
					exp37=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp37.getTree());

					}
					break;
				case 2 :
					// Syn.g:71:5: WRITELN ^
					{
					root_0 = (Object)adaptor.nil();


					WRITELN38=(Token)match(input,WRITELN,FOLLOW_WRITELN_in_statement287); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					WRITELN38_tree = (Object)adaptor.create(WRITELN38);
					root_0 = (Object)adaptor.becomeRoot(WRITELN38_tree, root_0);
					}

					}
					break;
				case 3 :
					// Syn.g:72:5: SKIP
					{
					root_0 = (Object)adaptor.nil();


					SKIP39=(Token)match(input,SKIP,FOLLOW_SKIP_in_statement294); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SKIP39_tree = (Object)adaptor.create(SKIP39);
					adaptor.addChild(root_0, SKIP39_tree);
					}

					}
					break;
				case 4 :
					// Syn.g:73:5: IF ^ boolexp THEN statement ELSE statement
					{
					root_0 = (Object)adaptor.nil();


					IF40=(Token)match(input,IF,FOLLOW_IF_in_statement300); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IF40_tree = (Object)adaptor.create(IF40);
					root_0 = (Object)adaptor.becomeRoot(IF40_tree, root_0);
					}

					pushFollow(FOLLOW_boolexp_in_statement304);
					boolexp41=boolexp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolexp41.getTree());

					THEN42=(Token)match(input,THEN,FOLLOW_THEN_in_statement306); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					THEN42_tree = (Object)adaptor.create(THEN42);
					adaptor.addChild(root_0, THEN42_tree);
					}

					pushFollow(FOLLOW_statement_in_statement308);
					statement43=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement43.getTree());

					ELSE44=(Token)match(input,ELSE,FOLLOW_ELSE_in_statement310); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ELSE44_tree = (Object)adaptor.create(ELSE44);
					adaptor.addChild(root_0, ELSE44_tree);
					}

					pushFollow(FOLLOW_statement_in_statement312);
					statement45=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement45.getTree());

					}
					break;
				case 5 :
					// Syn.g:74:5: WHILE ^ boolexp DO statement
					{
					root_0 = (Object)adaptor.nil();


					WHILE46=(Token)match(input,WHILE,FOLLOW_WHILE_in_statement318); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					WHILE46_tree = (Object)adaptor.create(WHILE46);
					root_0 = (Object)adaptor.becomeRoot(WHILE46_tree, root_0);
					}

					pushFollow(FOLLOW_boolexp_in_statement321);
					boolexp47=boolexp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolexp47.getTree());

					DO48=(Token)match(input,DO,FOLLOW_DO_in_statement323); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DO48_tree = (Object)adaptor.create(DO48);
					adaptor.addChild(root_0, DO48_tree);
					}

					pushFollow(FOLLOW_statement_in_statement325);
					statement49=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement49.getTree());

					}
					break;
				case 6 :
					// Syn.g:75:5: READ ^ OPENPAREN ! variable CLOSEPAREN !
					{
					root_0 = (Object)adaptor.nil();


					READ50=(Token)match(input,READ,FOLLOW_READ_in_statement331); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					READ50_tree = (Object)adaptor.create(READ50);
					root_0 = (Object)adaptor.becomeRoot(READ50_tree, root_0);
					}

					OPENPAREN51=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_statement334); if (state.failed) return retval;
					pushFollow(FOLLOW_variable_in_statement337);
					variable52=variable();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, variable52.getTree());

					CLOSEPAREN53=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_statement339); if (state.failed) return retval;
					}
					break;
				case 7 :
					// Syn.g:76:5: WRITE ^ OPENPAREN ! ( INTNUM | string ) CLOSEPAREN !
					{
					root_0 = (Object)adaptor.nil();


					WRITE54=(Token)match(input,WRITE,FOLLOW_WRITE_in_statement346); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					WRITE54_tree = (Object)adaptor.create(WRITE54);
					root_0 = (Object)adaptor.becomeRoot(WRITE54_tree, root_0);
					}

					OPENPAREN55=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_statement349); if (state.failed) return retval;
					// Syn.g:76:23: ( INTNUM | string )
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==INTNUM) ) {
						alt8=1;
					}
					else if ( (LA8_0==STRING) ) {
						alt8=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						throw nvae;
					}

					switch (alt8) {
						case 1 :
							// Syn.g:76:24: INTNUM
							{
							INTNUM56=(Token)match(input,INTNUM,FOLLOW_INTNUM_in_statement353); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							INTNUM56_tree = (Object)adaptor.create(INTNUM56);
							adaptor.addChild(root_0, INTNUM56_tree);
							}

							}
							break;
						case 2 :
							// Syn.g:76:33: string
							{
							pushFollow(FOLLOW_string_in_statement357);
							string57=string();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, string57.getTree());

							}
							break;

					}

					CLOSEPAREN58=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_statement360); if (state.failed) return retval;
					}
					break;
				case 8 :
					// Syn.g:77:5: WRITE ^ OPENPAREN ! exp CLOSEPAREN !
					{
					root_0 = (Object)adaptor.nil();


					WRITE59=(Token)match(input,WRITE,FOLLOW_WRITE_in_statement367); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					WRITE59_tree = (Object)adaptor.create(WRITE59);
					root_0 = (Object)adaptor.becomeRoot(WRITE59_tree, root_0);
					}

					OPENPAREN60=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_statement370); if (state.failed) return retval;
					pushFollow(FOLLOW_exp_in_statement373);
					exp61=exp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exp61.getTree());

					CLOSEPAREN62=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_statement375); if (state.failed) return retval;
					}
					break;
				case 9 :
					// Syn.g:78:5: WRITE ^ OPENPAREN ! boolexp CLOSEPAREN !
					{
					root_0 = (Object)adaptor.nil();


					WRITE63=(Token)match(input,WRITE,FOLLOW_WRITE_in_statement382); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					WRITE63_tree = (Object)adaptor.create(WRITE63);
					root_0 = (Object)adaptor.becomeRoot(WRITE63_tree, root_0);
					}

					OPENPAREN64=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_statement385); if (state.failed) return retval;
					pushFollow(FOLLOW_boolexp_in_statement388);
					boolexp65=boolexp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolexp65.getTree());

					CLOSEPAREN66=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_statement390); if (state.failed) return retval;
					}
					break;
				case 10 :
					// Syn.g:79:5: OPENPAREN ! statements CLOSEPAREN !
					{
					root_0 = (Object)adaptor.nil();


					OPENPAREN67=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_statement397); if (state.failed) return retval;
					pushFollow(FOLLOW_statements_in_statement400);
					statements68=statements();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statements68.getTree());

					CLOSEPAREN69=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_statement402); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statement"


	protected static class string_scope {
		String tmp;
	}
	protected Stack<string_scope> string_stack = new Stack<string_scope>();

	public static class string_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "string"
	// Syn.g:85:1: string : s= STRING -> STRING[$string::tmp] ;
	public final Syn.string_return string() throws RecognitionException {
		string_stack.push(new string_scope());
		Syn.string_return retval = new Syn.string_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token s=null;

		Object s_tree=null;
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

		try {
			// Syn.g:87:5: (s= STRING -> STRING[$string::tmp] )
			// Syn.g:88:5: s= STRING
			{
			s=(Token)match(input,STRING,FOLLOW_STRING_in_string435); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(s);

			if ( state.backtracking==0 ) { string_stack.peek().tmp = cleanString((s!=null?s.getText():null)); }
			// AST REWRITE
			// elements: STRING
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 88:54: -> STRING[$string::tmp]
			{
				adaptor.addChild(root_0, (Object)adaptor.create(STRING, string_stack.peek().tmp));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			string_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "string"

	// $ANTLR start synpred11_Syn
	public final void synpred11_Syn_fragment() throws RecognitionException {
		// Syn.g:64:4: ( exp EQUALS exp )
		// Syn.g:64:4: exp EQUALS exp
		{
		pushFollow(FOLLOW_exp_in_synpred11_Syn241);
		exp();
		state._fsp--;
		if (state.failed) return;

		match(input,EQUALS,FOLLOW_EQUALS_in_synpred11_Syn243); if (state.failed) return;

		pushFollow(FOLLOW_exp_in_synpred11_Syn245);
		exp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred11_Syn

	// $ANTLR start synpred12_Syn
	public final void synpred12_Syn_fragment() throws RecognitionException {
		// Syn.g:65:4: ( exp LESS exp )
		// Syn.g:65:4: exp LESS exp
		{
		pushFollow(FOLLOW_exp_in_synpred12_Syn250);
		exp();
		state._fsp--;
		if (state.failed) return;

		match(input,LESS,FOLLOW_LESS_in_synpred12_Syn252); if (state.failed) return;

		pushFollow(FOLLOW_exp_in_synpred12_Syn254);
		exp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred12_Syn

	// $ANTLR start synpred20_Syn
	public final void synpred20_Syn_fragment() throws RecognitionException {
		// Syn.g:76:5: ( WRITE OPENPAREN ( INTNUM | string ) CLOSEPAREN )
		// Syn.g:76:5: WRITE OPENPAREN ( INTNUM | string ) CLOSEPAREN
		{
		match(input,WRITE,FOLLOW_WRITE_in_synpred20_Syn346); if (state.failed) return;

		match(input,OPENPAREN,FOLLOW_OPENPAREN_in_synpred20_Syn349); if (state.failed) return;

		// Syn.g:76:23: ( INTNUM | string )
		int alt10=2;
		int LA10_0 = input.LA(1);
		if ( (LA10_0==INTNUM) ) {
			alt10=1;
		}
		else if ( (LA10_0==STRING) ) {
			alt10=2;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 10, 0, input);
			throw nvae;
		}

		switch (alt10) {
			case 1 :
				// Syn.g:76:24: INTNUM
				{
				match(input,INTNUM,FOLLOW_INTNUM_in_synpred20_Syn353); if (state.failed) return;

				}
				break;
			case 2 :
				// Syn.g:76:33: string
				{
				pushFollow(FOLLOW_string_in_synpred20_Syn357);
				string();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_synpred20_Syn360); if (state.failed) return;

		}

	}
	// $ANTLR end synpred20_Syn

	// $ANTLR start synpred21_Syn
	public final void synpred21_Syn_fragment() throws RecognitionException {
		// Syn.g:77:5: ( WRITE OPENPAREN exp CLOSEPAREN )
		// Syn.g:77:5: WRITE OPENPAREN exp CLOSEPAREN
		{
		match(input,WRITE,FOLLOW_WRITE_in_synpred21_Syn367); if (state.failed) return;

		match(input,OPENPAREN,FOLLOW_OPENPAREN_in_synpred21_Syn370); if (state.failed) return;

		pushFollow(FOLLOW_exp_in_synpred21_Syn373);
		exp();
		state._fsp--;
		if (state.failed) return;

		match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_synpred21_Syn375); if (state.failed) return;

		}

	}
	// $ANTLR end synpred21_Syn

	// $ANTLR start synpred22_Syn
	public final void synpred22_Syn_fragment() throws RecognitionException {
		// Syn.g:78:5: ( WRITE OPENPAREN boolexp CLOSEPAREN )
		// Syn.g:78:5: WRITE OPENPAREN boolexp CLOSEPAREN
		{
		match(input,WRITE,FOLLOW_WRITE_in_synpred22_Syn382); if (state.failed) return;

		match(input,OPENPAREN,FOLLOW_OPENPAREN_in_synpred22_Syn385); if (state.failed) return;

		pushFollow(FOLLOW_boolexp_in_synpred22_Syn388);
		boolexp();
		state._fsp--;
		if (state.failed) return;

		match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_synpred22_Syn390); if (state.failed) return;

		}

	}
	// $ANTLR end synpred22_Syn

	// Delegated rules

	public final boolean synpred12_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred12_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred11_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred11_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred21_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred21_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred22_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred22_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred20_Syn() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred20_Syn_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_statements_in_program56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements71 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_SEMICOLON_in_statements75 = new BitSet(new long[]{0x0000000070B06000L});
	public static final BitSet FOLLOW_statement_in_statements78 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_variable93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp104 = new BitSet(new long[]{0x0000000002020002L});
	public static final BitSet FOLLOW_set_in_exp108 = new BitSet(new long[]{0x000000000010A000L});
	public static final BitSet FOLLOW_term_in_exp119 = new BitSet(new long[]{0x0000000002020002L});
	public static final BitSet FOLLOW_factor_in_term132 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_MULT_in_term136 = new BitSet(new long[]{0x000000000010A000L});
	public static final BitSet FOLLOW_factor_in_term139 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_variable_in_factor153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constant_in_factor158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPENPAREN_in_factor163 = new BitSet(new long[]{0x000000000010A000L});
	public static final BitSet FOLLOW_exp_in_factor166 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_factor168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTNUM_in_constant180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolterm_in_boolexp191 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_AND_in_boolexp195 = new BitSet(new long[]{0x000000000818B000L});
	public static final BitSet FOLLOW_boolterm_in_boolexp198 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_NOT_in_boolterm212 = new BitSet(new long[]{0x000000000810B000L});
	public static final BitSet FOLLOW_bool_in_boolterm215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bool_in_boolterm220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_bool231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_bool236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_bool241 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_EQUALS_in_bool243 = new BitSet(new long[]{0x000000000010A000L});
	public static final BitSet FOLLOW_exp_in_bool245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_bool250 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LESS_in_bool252 = new BitSet(new long[]{0x000000000010A000L});
	public static final BitSet FOLLOW_exp_in_bool254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPENPAREN_in_bool259 = new BitSet(new long[]{0x000000000818B000L});
	public static final BitSet FOLLOW_boolexp_in_bool262 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_bool264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variable_in_statement276 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_statement278 = new BitSet(new long[]{0x000000000010A000L});
	public static final BitSet FOLLOW_exp_in_statement281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WRITELN_in_statement287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SKIP_in_statement294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_statement300 = new BitSet(new long[]{0x000000000818B000L});
	public static final BitSet FOLLOW_boolexp_in_statement304 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_THEN_in_statement306 = new BitSet(new long[]{0x0000000070B06000L});
	public static final BitSet FOLLOW_statement_in_statement308 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ELSE_in_statement310 = new BitSet(new long[]{0x0000000070B06000L});
	public static final BitSet FOLLOW_statement_in_statement312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_statement318 = new BitSet(new long[]{0x000000000818B000L});
	public static final BitSet FOLLOW_boolexp_in_statement321 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_DO_in_statement323 = new BitSet(new long[]{0x0000000070B06000L});
	public static final BitSet FOLLOW_statement_in_statement325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_READ_in_statement331 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_OPENPAREN_in_statement334 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_variable_in_statement337 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_statement339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WRITE_in_statement346 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_OPENPAREN_in_statement349 = new BitSet(new long[]{0x0000000001008000L});
	public static final BitSet FOLLOW_INTNUM_in_statement353 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_string_in_statement357 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_statement360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WRITE_in_statement367 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_OPENPAREN_in_statement370 = new BitSet(new long[]{0x000000000010A000L});
	public static final BitSet FOLLOW_exp_in_statement373 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_statement375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WRITE_in_statement382 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_OPENPAREN_in_statement385 = new BitSet(new long[]{0x000000000818B000L});
	public static final BitSet FOLLOW_boolexp_in_statement388 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_statement390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPENPAREN_in_statement397 = new BitSet(new long[]{0x0000000070B06000L});
	public static final BitSet FOLLOW_statements_in_statement400 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_statement402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_string435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_synpred11_Syn241 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_EQUALS_in_synpred11_Syn243 = new BitSet(new long[]{0x000000000010A000L});
	public static final BitSet FOLLOW_exp_in_synpred11_Syn245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_synpred12_Syn250 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LESS_in_synpred12_Syn252 = new BitSet(new long[]{0x000000000010A000L});
	public static final BitSet FOLLOW_exp_in_synpred12_Syn254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WRITE_in_synpred20_Syn346 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_OPENPAREN_in_synpred20_Syn349 = new BitSet(new long[]{0x0000000001008000L});
	public static final BitSet FOLLOW_INTNUM_in_synpred20_Syn353 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_string_in_synpred20_Syn357 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_synpred20_Syn360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WRITE_in_synpred21_Syn367 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_OPENPAREN_in_synpred21_Syn370 = new BitSet(new long[]{0x000000000010A000L});
	public static final BitSet FOLLOW_exp_in_synpred21_Syn373 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_synpred21_Syn375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WRITE_in_synpred22_Syn382 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_OPENPAREN_in_synpred22_Syn385 = new BitSet(new long[]{0x000000000818B000L});
	public static final BitSet FOLLOW_boolexp_in_synpred22_Syn388 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLOSEPAREN_in_synpred22_Syn390 = new BitSet(new long[]{0x0000000000000002L});
}
