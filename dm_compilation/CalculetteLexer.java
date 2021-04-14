// Generated from Calculette.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, TYPE=5, ENTIER=6, FLOAT=7, ADD=8, SUB=9, 
		MUL=10, DIV=11, IDENTIFIANT=12, READ=13, WRITE=14, COMMENT_MUL=15, COMMENT_SIMPLE=16, 
		NEWLINE=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "TYPE", "ENTIER", "FLOAT", "ADD", "SUB", 
			"MUL", "DIV", "IDENTIFIANT", "READ", "WRITE", "COMMENT_MUL", "COMMENT_SIMPLE", 
			"NEWLINE", "WS"
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


	   private TablesSymboles tablesSymboles = new TablesSymboles();


	public CalculetteLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u008d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\68\n\6\3\7\6\7;\n\7\r\7\16\7<\3\b\6\b@\n\b\r\b\16\bA\3\b"+
		"\3\b\7\bF\n\b\f\b\16\bI\13\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\r"+
		"T\n\r\r\r\16\rU\3\r\7\rY\n\r\f\r\16\r\\\13\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20m\n\20\f\20\16"+
		"\20p\13\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21{\n\21\f\21"+
		"\16\21~\13\21\3\21\3\21\3\22\5\22\u0083\n\22\3\22\3\22\3\23\6\23\u0088"+
		"\n\23\r\23\16\23\u0089\3\23\3\23\3n\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\6\4\2C\\"+
		"c|\5\2\62;C\\c|\4\2\f\f\17\17\4\2\13\13\"\"\2\u0096\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'"+
		"\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13\67\3\2\2\2\r:\3\2\2\2\17"+
		"?\3\2\2\2\21J\3\2\2\2\23L\3\2\2\2\25N\3\2\2\2\27P\3\2\2\2\31S\3\2\2\2"+
		"\33]\3\2\2\2\35b\3\2\2\2\37h\3\2\2\2!v\3\2\2\2#\u0082\3\2\2\2%\u0087\3"+
		"\2\2\2\'(\7*\2\2(\4\3\2\2\2)*\7+\2\2*\6\3\2\2\2+,\7?\2\2,\b\3\2\2\2-."+
		"\7=\2\2.\n\3\2\2\2/\60\7k\2\2\60\61\7p\2\2\618\7v\2\2\62\63\7h\2\2\63"+
		"\64\7n\2\2\64\65\7q\2\2\65\66\7c\2\2\668\7v\2\2\67/\3\2\2\2\67\62\3\2"+
		"\2\28\f\3\2\2\29;\4\62;\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\16"+
		"\3\2\2\2>@\4\62;\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2C"+
		"G\7\60\2\2DF\4\62;\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\20\3\2\2"+
		"\2IG\3\2\2\2JK\7-\2\2K\22\3\2\2\2LM\7/\2\2M\24\3\2\2\2NO\7,\2\2O\26\3"+
		"\2\2\2PQ\7\61\2\2Q\30\3\2\2\2RT\t\2\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2"+
		"UV\3\2\2\2VZ\3\2\2\2WY\t\3\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2"+
		"\2[\32\3\2\2\2\\Z\3\2\2\2]^\7t\2\2^_\7g\2\2_`\7c\2\2`a\7f\2\2a\34\3\2"+
		"\2\2bc\7y\2\2cd\7t\2\2de\7k\2\2ef\7v\2\2fg\7g\2\2g\36\3\2\2\2hi\7\61\2"+
		"\2ij\7,\2\2jn\3\2\2\2km\13\2\2\2lk\3\2\2\2mp\3\2\2\2no\3\2\2\2nl\3\2\2"+
		"\2oq\3\2\2\2pn\3\2\2\2qr\7,\2\2rs\7\61\2\2st\3\2\2\2tu\b\20\2\2u \3\2"+
		"\2\2vw\7\61\2\2wx\7\61\2\2x|\3\2\2\2y{\n\4\2\2zy\3\2\2\2{~\3\2\2\2|z\3"+
		"\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\b\21\2\2\u0080\"\3\2"+
		"\2\2\u0081\u0083\7\17\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\7\f\2\2\u0085$\3\2\2\2\u0086\u0088\t\5\2\2"+
		"\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\23\2\2\u008c&\3\2\2\2\r\2\67"+
		"<AGUZn|\u0082\u0089\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}