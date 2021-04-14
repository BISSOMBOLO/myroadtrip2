// Generated from Calculette.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, TYPE=5, ENTIER=6, FLOAT=7, ADD=8, SUB=9, 
		MUL=10, DIV=11, IDENTIFIANT=12, READ=13, WRITE=14, COMMENT_MUL=15, COMMENT_SIMPLE=16, 
		NEWLINE=17, WS=18;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_instruction = 2, RULE_instructionEntree = 3, 
		RULE_instructionSortie = 4, RULE_express = 5, RULE_declassigne = 6, RULE_decl = 7, 
		RULE_assigne = 8, RULE_finInstruction = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "instruction", "instructionEntree", "instructionSortie", 
			"express", "declassigne", "decl", "assigne", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'='", "';'", null, null, null, "'+'", "'-'", "'*'", 
			"'/'", null, "'read'", "'write'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "TYPE", "ENTIER", "FLOAT", "ADD", "SUB", 
			"MUL", "DIV", "IDENTIFIANT", "READ", "WRITE", "COMMENT_MUL", "COMMENT_SIMPLE", 
			"NEWLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	   private TablesSymboles tablesSymboles = new TablesSymboles();

	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculetteParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			calcul();
			setState(21);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclassigneContext declassigne;
		public DeclContext decl;
		public InstructionContext instruction;
		public TerminalNode EOF() { return getToken(CalculetteParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<DeclassigneContext> declassigne() {
			return getRuleContexts(DeclassigneContext.class);
		}
		public DeclassigneContext declassigne(int i) {
			return getRuleContext(DeclassigneContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(23);
					match(NEWLINE);
					}
					} 
				}
				setState(28);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				setState(35);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(29);
					((CalculContext)_localctx).declassigne = declassigne();
					 _localctx.code += ((CalculContext)_localctx).declassigne.code; 
					}
					break;
				case 2:
					{
					setState(32);
					((CalculContext)_localctx).decl = decl();
					 _localctx.code += ((CalculContext)_localctx).decl.code; 
					}
					break;
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40);
					match(NEWLINE);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(46);
					((CalculContext)_localctx).instruction = instruction();
					 _localctx.code += ((CalculContext)_localctx).instruction.code; 
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(54);
				match(NEWLINE);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "  HALT\n"; 
			setState(61);
			match(EOF);
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressContext express;
		public AssigneContext assigne;
		public InstructionSortieContext instructionSortie;
		public InstructionEntreeContext instructionEntree;
		public ExpressContext express() {
			return getRuleContext(ExpressContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public AssigneContext assigne() {
			return getRuleContext(AssigneContext.class,0);
		}
		public InstructionSortieContext instructionSortie() {
			return getRuleContext(InstructionSortieContext.class,0);
		}
		public InstructionEntreeContext instructionEntree() {
			return getRuleContext(InstructionEntreeContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				((InstructionContext)_localctx).express = express(0);
				setState(64);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).express.code; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				((InstructionContext)_localctx).assigne = assigne();
				setState(68);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assigne.code; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				((InstructionContext)_localctx).instructionSortie = instructionSortie();
				setState(72);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).instructionSortie.code; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				((InstructionContext)_localctx).instructionEntree = instructionEntree();
				setState(76);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).instructionEntree.code; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				finInstruction();
				 ((InstructionContext)_localctx).code = ""; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionEntreeContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public TerminalNode READ() { return getToken(CalculetteParser.READ, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public InstructionEntreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionEntree; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstructionEntree(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstructionEntree(this);
		}
	}

	public final InstructionEntreeContext instructionEntree() throws RecognitionException {
		InstructionEntreeContext _localctx = new InstructionEntreeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instructionEntree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(READ);
			setState(85);
			match(T__0);
			setState(86);
			((InstructionEntreeContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(87);
			match(T__1);

			        AdresseType at = tablesSymboles.getAdresseType((((InstructionEntreeContext)_localctx).IDENTIFIANT!=null?((InstructionEntreeContext)_localctx).IDENTIFIANT.getText():null));
			        ((InstructionEntreeContext)_localctx).code =  "READ \n"+ " STOREG " +at.adresse+"\n";
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionSortieContext extends ParserRuleContext {
		public String code;
		public ExpressContext express;
		public TerminalNode WRITE() { return getToken(CalculetteParser.WRITE, 0); }
		public ExpressContext express() {
			return getRuleContext(ExpressContext.class,0);
		}
		public InstructionSortieContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionSortie; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstructionSortie(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstructionSortie(this);
		}
	}

	public final InstructionSortieContext instructionSortie() throws RecognitionException {
		InstructionSortieContext _localctx = new InstructionSortieContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instructionSortie);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(WRITE);
			setState(91);
			match(T__0);
			setState(92);
			((InstructionSortieContext)_localctx).express = express(0);
			setState(93);
			match(T__1);

			        ((InstructionSortieContext)_localctx).code =  ((InstructionSortieContext)_localctx).express.code+ "WRITE \n " + "POP\n";
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressContext extends ParserRuleContext {
		public String code;
		public ExpressContext a;
		public ExpressContext express;
		public Token ENTIER;
		public Token IDENTIFIANT;
		public Token op;
		public ExpressContext b;
		public List<ExpressContext> express() {
			return getRuleContexts(ExpressContext.class);
		}
		public ExpressContext express(int i) {
			return getRuleContext(ExpressContext.class,i);
		}
		public TerminalNode SUB() { return getToken(CalculetteParser.SUB, 0); }
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public TerminalNode MUL() { return getToken(CalculetteParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(CalculetteParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(CalculetteParser.ADD, 0); }
		public ExpressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_express; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExpress(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExpress(this);
		}
	}

	public final ExpressContext express() throws RecognitionException {
		return express(0);
	}

	private ExpressContext express(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressContext _localctx = new ExpressContext(_ctx, _parentState);
		ExpressContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_express, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(97);
				match(T__0);
				setState(98);
				((ExpressContext)_localctx).express = express(0);
				setState(99);
				match(T__1);
				 ((ExpressContext)_localctx).code =  ((ExpressContext)_localctx).express.code; 
				}
				break;
			case SUB:
				{
				setState(102);
				match(SUB);
				setState(103);
				((ExpressContext)_localctx).ENTIER = match(ENTIER);
				 ((ExpressContext)_localctx).code =  "  PUSHI -" + (((ExpressContext)_localctx).ENTIER!=null?((ExpressContext)_localctx).ENTIER.getText():null) + "\n"; 
				}
				break;
			case ENTIER:
				{
				setState(105);
				((ExpressContext)_localctx).ENTIER = match(ENTIER);
				 ((ExpressContext)_localctx).code =  "  PUSHI " + (((ExpressContext)_localctx).ENTIER!=null?((ExpressContext)_localctx).ENTIER.getText():null) + "\n"; 
				}
				break;
			case IDENTIFIANT:
				{
				setState(107);
				((ExpressContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

							AdresseType at = tablesSymboles.getAdresseType((((ExpressContext)_localctx).IDENTIFIANT!=null?((ExpressContext)_localctx).IDENTIFIANT.getText():null));

							((ExpressContext)_localctx).code =  "  PUSHG " + at.adresse + "\n";
						
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(121);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_express);
						setState(111);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(112);
						((ExpressContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((ExpressContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(113);
						((ExpressContext)_localctx).b = ((ExpressContext)_localctx).express = express(6);

						          			((ExpressContext)_localctx).code =  ((ExpressContext)_localctx).a.code + ((ExpressContext)_localctx).b.code;

						          			if ((((ExpressContext)_localctx).op!=null?((ExpressContext)_localctx).op.getText():null).equals("*")) {
						          				_localctx.code += "  MUL\n";
						          			}
						          			else {
						          				_localctx.code += "  DIV\n";
						          			}
						          		
						}
						break;
					case 2:
						{
						_localctx = new ExpressContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_express);
						setState(116);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(117);
						((ExpressContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(118);
						((ExpressContext)_localctx).b = ((ExpressContext)_localctx).express = express(5);

						          			((ExpressContext)_localctx).code =  ((ExpressContext)_localctx).a.code + ((ExpressContext)_localctx).b.code;

						          			if ((((ExpressContext)_localctx).op!=null?((ExpressContext)_localctx).op.getText():null).equals("+")) {
						          				_localctx.code += "  ADD\n";
						          			}
						          			else {
						          				_localctx.code += "  SUB\n";
						          			}
						          		
						}
						break;
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DeclassigneContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ExpressContext express;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressContext express() {
			return getRuleContext(ExpressContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public DeclassigneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declassigne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterDeclassigne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitDeclassigne(this);
		}
	}

	public final DeclassigneContext declassigne() throws RecognitionException {
		DeclassigneContext _localctx = new DeclassigneContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declassigne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			((DeclassigneContext)_localctx).TYPE = match(TYPE);
			setState(127);
			((DeclassigneContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(128);
			match(T__2);
			setState(129);
			((DeclassigneContext)_localctx).express = express(0);
			setState(130);
			finInstruction();

			       tablesSymboles.putVar((((DeclassigneContext)_localctx).IDENTIFIANT!=null?((DeclassigneContext)_localctx).IDENTIFIANT.getText():null),(((DeclassigneContext)_localctx).TYPE!=null?((DeclassigneContext)_localctx).TYPE.getText():null));
			       AdresseType at = tablesSymboles.getAdresseType((((DeclassigneContext)_localctx).IDENTIFIANT!=null?((DeclassigneContext)_localctx).IDENTIFIANT.getText():null));
			        ((DeclassigneContext)_localctx).code =  "PUSHI 0\n"+((DeclassigneContext)_localctx).express.code+ "STOREG "+at.adresse+"\n";
			     
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			((DeclContext)_localctx).TYPE = match(TYPE);
			setState(134);
			((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(135);
			finInstruction();


			      tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),(((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
			      if((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("int")){
			        ((DeclContext)_localctx).code =  "PUSHI 0"+"\n";
			      }else {
			        ((DeclContext)_localctx).code =  "PUSHF 0.0"+"\n";
			      }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssigneContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressContext express;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressContext express() {
			return getRuleContext(ExpressContext.class,0);
		}
		public AssigneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assigne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterAssigne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitAssigne(this);
		}
	}

	public final AssigneContext assigne() throws RecognitionException {
		AssigneContext _localctx = new AssigneContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assigne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((AssigneContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(139);
			match(T__2);
			setState(140);
			((AssigneContext)_localctx).express = express(0);

			            ((AssigneContext)_localctx).code =  ((AssigneContext)_localctx).express.code;

						AdresseType at = tablesSymboles.getAdresseType((((AssigneContext)_localctx).IDENTIFIANT!=null?((AssigneContext)_localctx).IDENTIFIANT.getText():null));

						_localctx.code += "  STOREG " + at.adresse + "\n";
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(143);
					_la = _input.LA(1);
					if ( !(_la==T__3 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(146); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return express_sempred((ExpressContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean express_sempred(ExpressContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\u0097\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\3\7\3\33\n\3\f\3\16\3\36\13\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\7\3&\n\3\f\3\16\3)\13\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\3\3\7"+
		"\3\64\n\3\f\3\16\3\67\13\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4U\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7p\n\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\7\7|\n\7\f\7\16\7\177\13\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\6\13\u0093\n\13"+
		"\r\13\16\13\u0094\3\13\2\3\f\f\2\4\6\b\n\f\16\20\22\24\2\5\3\2\f\r\3\2"+
		"\n\13\4\2\6\6\23\23\2\u009c\2\26\3\2\2\2\4\34\3\2\2\2\6T\3\2\2\2\bV\3"+
		"\2\2\2\n\\\3\2\2\2\fo\3\2\2\2\16\u0080\3\2\2\2\20\u0087\3\2\2\2\22\u008c"+
		"\3\2\2\2\24\u0092\3\2\2\2\26\27\5\4\3\2\27\30\7\2\2\3\30\3\3\2\2\2\31"+
		"\33\7\23\2\2\32\31\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35"+
		"\'\3\2\2\2\36\34\3\2\2\2\37 \5\16\b\2 !\b\3\1\2!&\3\2\2\2\"#\5\20\t\2"+
		"#$\b\3\1\2$&\3\2\2\2%\37\3\2\2\2%\"\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3"+
		"\2\2\2(-\3\2\2\2)\'\3\2\2\2*,\7\23\2\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-"+
		".\3\2\2\2.\65\3\2\2\2/-\3\2\2\2\60\61\5\6\4\2\61\62\b\3\1\2\62\64\3\2"+
		"\2\2\63\60\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66;\3\2\2"+
		"\2\67\65\3\2\2\28:\7\23\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>"+
		"\3\2\2\2=;\3\2\2\2>?\b\3\1\2?@\7\2\2\3@\5\3\2\2\2AB\5\f\7\2BC\5\24\13"+
		"\2CD\b\4\1\2DU\3\2\2\2EF\5\22\n\2FG\5\24\13\2GH\b\4\1\2HU\3\2\2\2IJ\5"+
		"\n\6\2JK\5\24\13\2KL\b\4\1\2LU\3\2\2\2MN\5\b\5\2NO\5\24\13\2OP\b\4\1\2"+
		"PU\3\2\2\2QR\5\24\13\2RS\b\4\1\2SU\3\2\2\2TA\3\2\2\2TE\3\2\2\2TI\3\2\2"+
		"\2TM\3\2\2\2TQ\3\2\2\2U\7\3\2\2\2VW\7\17\2\2WX\7\3\2\2XY\7\16\2\2YZ\7"+
		"\4\2\2Z[\b\5\1\2[\t\3\2\2\2\\]\7\20\2\2]^\7\3\2\2^_\5\f\7\2_`\7\4\2\2"+
		"`a\b\6\1\2a\13\3\2\2\2bc\b\7\1\2cd\7\3\2\2de\5\f\7\2ef\7\4\2\2fg\b\7\1"+
		"\2gp\3\2\2\2hi\7\13\2\2ij\7\b\2\2jp\b\7\1\2kl\7\b\2\2lp\b\7\1\2mn\7\16"+
		"\2\2np\b\7\1\2ob\3\2\2\2oh\3\2\2\2ok\3\2\2\2om\3\2\2\2p}\3\2\2\2qr\f\7"+
		"\2\2rs\t\2\2\2st\5\f\7\btu\b\7\1\2u|\3\2\2\2vw\f\6\2\2wx\t\3\2\2xy\5\f"+
		"\7\7yz\b\7\1\2z|\3\2\2\2{q\3\2\2\2{v\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~"+
		"\3\2\2\2~\r\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\7\2\2\u0081\u0082\7\16"+
		"\2\2\u0082\u0083\7\5\2\2\u0083\u0084\5\f\7\2\u0084\u0085\5\24\13\2\u0085"+
		"\u0086\b\b\1\2\u0086\17\3\2\2\2\u0087\u0088\7\7\2\2\u0088\u0089\7\16\2"+
		"\2\u0089\u008a\5\24\13\2\u008a\u008b\b\t\1\2\u008b\21\3\2\2\2\u008c\u008d"+
		"\7\16\2\2\u008d\u008e\7\5\2\2\u008e\u008f\5\f\7\2\u008f\u0090\b\n\1\2"+
		"\u0090\23\3\2\2\2\u0091\u0093\t\4\2\2\u0092\u0091\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\25\3\2\2\2\r\34"+
		"%\'-\65;To{}\u0094";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}