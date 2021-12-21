// Generated from miniSysY.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class miniSysYParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD=1, SUB=2, MUL=3, DIV=4, MOD=5, ASSIGN=6, L_PAREN=7, R_PAREN=8, L_BRACE=9, 
		R_BRACE=10, INT=11, CONST=12, COMMA=13, RETURN=14, SEMICOLON=15, IF=16, 
		ELSE=17, NOT=18, GR=19, LR=20, GE=21, LE=22, EQUAL=23, NOTEQUAL=24, AND=25, 
		OR=26, Ident=27, Number=28, Hexadecimal_const=29, Octal_const=30, Decimal_const=31, 
		WS=32, LINES_COMMENT=33, SIGNLE_LINE_COMMENT=34;
	public static final int
		RULE_compUnit = 0, RULE_funcDef = 1, RULE_funcType = 2, RULE_block = 3, 
		RULE_blockItem = 4, RULE_stmt = 5, RULE_retStatement = 6, RULE_assignStatement = 7, 
		RULE_decl = 8, RULE_constDecl = 9, RULE_bType = 10, RULE_constDef = 11, 
		RULE_constInitVal = 12, RULE_constExp = 13, RULE_lVal = 14, RULE_varDecl = 15, 
		RULE_varDef = 16, RULE_initVal = 17, RULE_expStatement = 18, RULE_exp = 19, 
		RULE_addExp = 20, RULE_mulExp = 21, RULE_unaryExp = 22, RULE_funcRParams = 23, 
		RULE_primaryExp = 24, RULE_condStatement = 25, RULE_cond = 26, RULE_relExp = 27, 
		RULE_eqExp = 28, RULE_lAndExp = 29, RULE_lOrExp = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"compUnit", "funcDef", "funcType", "block", "blockItem", "stmt", "retStatement", 
			"assignStatement", "decl", "constDecl", "bType", "constDef", "constInitVal", 
			"constExp", "lVal", "varDecl", "varDef", "initVal", "expStatement", "exp", 
			"addExp", "mulExp", "unaryExp", "funcRParams", "primaryExp", "condStatement", 
			"cond", "relExp", "eqExp", "lAndExp", "lOrExp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'('", "')'", "'{'", 
			"'}'", "'int'", "'const'", "','", "'return'", "';'", "'if'", "'else'", 
			"'!'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "SUB", "MUL", "DIV", "MOD", "ASSIGN", "L_PAREN", "R_PAREN", 
			"L_BRACE", "R_BRACE", "INT", "CONST", "COMMA", "RETURN", "SEMICOLON", 
			"IF", "ELSE", "NOT", "GR", "LR", "GE", "LE", "EQUAL", "NOTEQUAL", "AND", 
			"OR", "Ident", "Number", "Hexadecimal_const", "Octal_const", "Decimal_const", 
			"WS", "LINES_COMMENT", "SIGNLE_LINE_COMMENT"
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
	public String getGrammarFileName() { return "miniSysY.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public miniSysYParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompUnitContext extends ParserRuleContext {
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public CompUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterCompUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitCompUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitCompUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompUnitContext compUnit() throws RecognitionException {
		CompUnitContext _localctx = new CompUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compUnit);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(62);
					decl();
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(68);
			funcDef();
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

	public static class FuncDefContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TerminalNode Ident() { return getToken(miniSysYParser.Ident, 0); }
		public TerminalNode L_PAREN() { return getToken(miniSysYParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(miniSysYParser.R_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			funcType();
			setState(71);
			match(Ident);
			setState(72);
			match(L_PAREN);
			setState(73);
			match(R_PAREN);
			setState(74);
			block();
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

	public static class FuncTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(miniSysYParser.INT, 0); }
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterFuncType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitFuncType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitFuncType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(INT);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode L_BRACE() { return getToken(miniSysYParser.L_BRACE, 0); }
		public TerminalNode R_BRACE() { return getToken(miniSysYParser.R_BRACE, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(L_BRACE);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << L_PAREN) | (1L << L_BRACE) | (1L << INT) | (1L << CONST) | (1L << RETURN) | (1L << SEMICOLON) | (1L << IF) | (1L << NOT) | (1L << Ident) | (1L << Number))) != 0)) {
				{
				{
				setState(79);
				blockItem();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(R_BRACE);
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

	public static class BlockItemContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_blockItem);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
			case L_PAREN:
			case L_BRACE:
			case RETURN:
			case SEMICOLON:
			case IF:
			case NOT:
			case Ident:
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				stmt();
				}
				break;
			case INT:
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StmtContext extends ParserRuleContext {
		public RetStatementContext retStatement() {
			return getRuleContext(RetStatementContext.class,0);
		}
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public ExpStatementContext expStatement() {
			return getRuleContext(ExpStatementContext.class,0);
		}
		public CondStatementContext condStatement() {
			return getRuleContext(CondStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stmt);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				retStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				assignStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				expStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				condStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				block();
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

	public static class RetStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(miniSysYParser.RETURN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(miniSysYParser.SEMICOLON, 0); }
		public RetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterRetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitRetStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitRetStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetStatementContext retStatement() throws RecognitionException {
		RetStatementContext _localctx = new RetStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_retStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(RETURN);
			setState(99);
			exp();
			setState(100);
			match(SEMICOLON);
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

	public static class AssignStatementContext extends ParserRuleContext {
		public LValContext lVal() {
			return getRuleContext(LValContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(miniSysYParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(miniSysYParser.SEMICOLON, 0); }
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitAssignStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			lVal();
			setState(103);
			match(ASSIGN);
			setState(104);
			exp();
			setState(105);
			match(SEMICOLON);
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
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_decl);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				constDecl();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				varDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(miniSysYParser.CONST, 0); }
		public BTypeContext bType() {
			return getRuleContext(BTypeContext.class,0);
		}
		public List<ConstDefContext> constDef() {
			return getRuleContexts(ConstDefContext.class);
		}
		public ConstDefContext constDef(int i) {
			return getRuleContext(ConstDefContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(miniSysYParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(miniSysYParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(miniSysYParser.COMMA, i);
		}
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterConstDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitConstDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitConstDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(CONST);
			setState(112);
			bType();
			setState(113);
			constDef();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(114);
				match(COMMA);
				setState(115);
				constDef();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			match(SEMICOLON);
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

	public static class BTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(miniSysYParser.INT, 0); }
		public BTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterBType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitBType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitBType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BTypeContext bType() throws RecognitionException {
		BTypeContext _localctx = new BTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(INT);
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

	public static class ConstDefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(miniSysYParser.Ident, 0); }
		public TerminalNode ASSIGN() { return getToken(miniSysYParser.ASSIGN, 0); }
		public ConstInitValContext constInitVal() {
			return getRuleContext(ConstInitValContext.class,0);
		}
		public ConstDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterConstDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitConstDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitConstDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDefContext constDef() throws RecognitionException {
		ConstDefContext _localctx = new ConstDefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(Ident);
			setState(126);
			match(ASSIGN);
			setState(127);
			constInitVal();
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

	public static class ConstInitValContext extends ParserRuleContext {
		public ConstExpContext constExp() {
			return getRuleContext(ConstExpContext.class,0);
		}
		public ConstInitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constInitVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterConstInitVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitConstInitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitConstInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstInitValContext constInitVal() throws RecognitionException {
		ConstInitValContext _localctx = new ConstInitValContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constInitVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			constExp();
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

	public static class ConstExpContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public ConstExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterConstExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitConstExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitConstExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstExpContext constExp() throws RecognitionException {
		ConstExpContext _localctx = new ConstExpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			addExp(0);
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

	public static class LValContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(miniSysYParser.Ident, 0); }
		public LValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterLVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitLVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitLVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LValContext lVal() throws RecognitionException {
		LValContext _localctx = new LValContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(Ident);
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

	public static class VarDeclContext extends ParserRuleContext {
		public BTypeContext bType() {
			return getRuleContext(BTypeContext.class,0);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(miniSysYParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(miniSysYParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(miniSysYParser.COMMA, i);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			bType();
			setState(136);
			varDef();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(137);
				match(COMMA);
				setState(138);
				varDef();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
			match(SEMICOLON);
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

	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(miniSysYParser.Ident, 0); }
		public TerminalNode ASSIGN() { return getToken(miniSysYParser.ASSIGN, 0); }
		public InitValContext initVal() {
			return getRuleContext(InitValContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_varDef);
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(Ident);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(Ident);
				setState(148);
				match(ASSIGN);
				setState(149);
				initVal();
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

	public static class InitValContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public InitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterInitVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitInitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitValContext initVal() throws RecognitionException {
		InitValContext _localctx = new InitValContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_initVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			exp();
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

	public static class ExpStatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(miniSysYParser.SEMICOLON, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterExpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitExpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitExpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpStatementContext expStatement() throws RecognitionException {
		ExpStatementContext _localctx = new ExpStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << L_PAREN) | (1L << NOT) | (1L << Ident) | (1L << Number))) != 0)) {
				{
				setState(154);
				exp();
				}
			}

			setState(157);
			match(SEMICOLON);
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

	public static class ExpContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			addExp(0);
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

	public static class AddExpContext extends ParserRuleContext {
		public MulExpContext mulExp() {
			return getRuleContext(MulExpContext.class,0);
		}
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public TerminalNode ADD() { return getToken(miniSysYParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(miniSysYParser.SUB, 0); }
		public AddExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterAddExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitAddExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitAddExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExpContext addExp() throws RecognitionException {
		return addExp(0);
	}

	private AddExpContext addExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddExpContext _localctx = new AddExpContext(_ctx, _parentState);
		AddExpContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_addExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(162);
			mulExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addExp);
					setState(164);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(165);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(166);
					mulExp(0);
					}
					} 
				}
				setState(171);
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

	public static class MulExpContext extends ParserRuleContext {
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public MulExpContext mulExp() {
			return getRuleContext(MulExpContext.class,0);
		}
		public TerminalNode MUL() { return getToken(miniSysYParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(miniSysYParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(miniSysYParser.MOD, 0); }
		public MulExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterMulExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitMulExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitMulExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulExpContext mulExp() throws RecognitionException {
		return mulExp(0);
	}

	private MulExpContext mulExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulExpContext _localctx = new MulExpContext(_ctx, _parentState);
		MulExpContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_mulExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(173);
			unaryExp();
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulExp);
					setState(175);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(176);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(177);
					unaryExp();
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class UnaryExpContext extends ParserRuleContext {
		public UnaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExp; }
	 
		public UnaryExpContext() { }
		public void copyFrom(UnaryExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryOpExpContext extends UnaryExpContext {
		public Token sign;
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public TerminalNode ADD() { return getToken(miniSysYParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(miniSysYParser.SUB, 0); }
		public TerminalNode NOT() { return getToken(miniSysYParser.NOT, 0); }
		public UnaryOpExpContext(UnaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterUnaryOpExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitUnaryOpExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitUnaryOpExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PriEContext extends UnaryExpContext {
		public PrimaryExpContext primaryExp() {
			return getRuleContext(PrimaryExpContext.class,0);
		}
		public PriEContext(UnaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterPriE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitPriE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitPriE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LibfuncContext extends UnaryExpContext {
		public TerminalNode Ident() { return getToken(miniSysYParser.Ident, 0); }
		public TerminalNode L_PAREN() { return getToken(miniSysYParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(miniSysYParser.R_PAREN, 0); }
		public FuncRParamsContext funcRParams() {
			return getRuleContext(FuncRParamsContext.class,0);
		}
		public LibfuncContext(UnaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterLibfunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitLibfunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitLibfunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpContext unaryExp() throws RecognitionException {
		UnaryExpContext _localctx = new UnaryExpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_unaryExp);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new PriEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				primaryExp();
				}
				break;
			case 2:
				_localctx = new UnaryOpExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				((UnaryOpExpContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT))) != 0)) ) {
					((UnaryOpExpContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(185);
				unaryExp();
				}
				break;
			case 3:
				_localctx = new LibfuncContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				match(Ident);
				setState(187);
				match(L_PAREN);
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << L_PAREN) | (1L << NOT) | (1L << Ident) | (1L << Number))) != 0)) {
					{
					setState(188);
					funcRParams();
					}
				}

				setState(191);
				match(R_PAREN);
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

	public static class FuncRParamsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(miniSysYParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(miniSysYParser.COMMA, i);
		}
		public FuncRParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcRParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterFuncRParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitFuncRParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitFuncRParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncRParamsContext funcRParams() throws RecognitionException {
		FuncRParamsContext _localctx = new FuncRParamsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_funcRParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			exp();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(195);
				match(COMMA);
				setState(196);
				exp();
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class PrimaryExpContext extends ParserRuleContext {
		public PrimaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExp; }
	 
		public PrimaryExpContext() { }
		public void copyFrom(PrimaryExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LeftContext extends PrimaryExpContext {
		public LValContext lVal() {
			return getRuleContext(LValContext.class,0);
		}
		public LeftContext(PrimaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitLeft(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitLeft(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumContext extends PrimaryExpContext {
		public TerminalNode Number() { return getToken(miniSysYParser.Number, 0); }
		public NumContext(PrimaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracesContext extends PrimaryExpContext {
		public TerminalNode L_PAREN() { return getToken(miniSysYParser.L_PAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(miniSysYParser.R_PAREN, 0); }
		public BracesContext(PrimaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitBraces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitBraces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpContext primaryExp() throws RecognitionException {
		PrimaryExpContext _localctx = new PrimaryExpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_primaryExp);
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_PAREN:
				_localctx = new BracesContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(L_PAREN);
				setState(203);
				exp();
				setState(204);
				match(R_PAREN);
				}
				break;
			case Number:
				_localctx = new NumContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(Number);
				}
				break;
			case Ident:
				_localctx = new LeftContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				lVal();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CondStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(miniSysYParser.IF, 0); }
		public TerminalNode L_PAREN() { return getToken(miniSysYParser.L_PAREN, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(miniSysYParser.R_PAREN, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(miniSysYParser.ELSE, 0); }
		public CondStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterCondStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitCondStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitCondStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondStatementContext condStatement() throws RecognitionException {
		CondStatementContext _localctx = new CondStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_condStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(IF);
			setState(211);
			match(L_PAREN);
			setState(212);
			cond();
			setState(213);
			match(R_PAREN);
			setState(214);
			stmt();
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(215);
				match(ELSE);
				setState(216);
				stmt();
				}
				break;
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

	public static class CondContext extends ParserRuleContext {
		public LOrExpContext lOrExp() {
			return getRuleContext(LOrExpContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			lOrExp(0);
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

	public static class RelExpContext extends ParserRuleContext {
		public Token sign;
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public RelExpContext relExp() {
			return getRuleContext(RelExpContext.class,0);
		}
		public TerminalNode GR() { return getToken(miniSysYParser.GR, 0); }
		public TerminalNode LR() { return getToken(miniSysYParser.LR, 0); }
		public TerminalNode GE() { return getToken(miniSysYParser.GE, 0); }
		public TerminalNode LE() { return getToken(miniSysYParser.LE, 0); }
		public RelExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterRelExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitRelExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitRelExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelExpContext relExp() throws RecognitionException {
		return relExp(0);
	}

	private RelExpContext relExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelExpContext _localctx = new RelExpContext(_ctx, _parentState);
		RelExpContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_relExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(222);
			addExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relExp);
					setState(224);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(225);
					((RelExpContext)_localctx).sign = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GR) | (1L << LR) | (1L << GE) | (1L << LE))) != 0)) ) {
						((RelExpContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(226);
					addExp(0);
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class EqExpContext extends ParserRuleContext {
		public Token sign;
		public RelExpContext relExp() {
			return getRuleContext(RelExpContext.class,0);
		}
		public EqExpContext eqExp() {
			return getRuleContext(EqExpContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(miniSysYParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(miniSysYParser.NOTEQUAL, 0); }
		public EqExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterEqExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitEqExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitEqExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqExpContext eqExp() throws RecognitionException {
		return eqExp(0);
	}

	private EqExpContext eqExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqExpContext _localctx = new EqExpContext(_ctx, _parentState);
		EqExpContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_eqExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(233);
			relExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_eqExp);
					setState(235);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(236);
					((EqExpContext)_localctx).sign = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						((EqExpContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(237);
					relExp(0);
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class LAndExpContext extends ParserRuleContext {
		public EqExpContext eqExp() {
			return getRuleContext(EqExpContext.class,0);
		}
		public LAndExpContext lAndExp() {
			return getRuleContext(LAndExpContext.class,0);
		}
		public TerminalNode AND() { return getToken(miniSysYParser.AND, 0); }
		public LAndExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lAndExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterLAndExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitLAndExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitLAndExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LAndExpContext lAndExp() throws RecognitionException {
		return lAndExp(0);
	}

	private LAndExpContext lAndExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LAndExpContext _localctx = new LAndExpContext(_ctx, _parentState);
		LAndExpContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_lAndExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(244);
			eqExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LAndExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lAndExp);
					setState(246);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(247);
					match(AND);
					setState(248);
					eqExp(0);
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class LOrExpContext extends ParserRuleContext {
		public LAndExpContext lAndExp() {
			return getRuleContext(LAndExpContext.class,0);
		}
		public LOrExpContext lOrExp() {
			return getRuleContext(LOrExpContext.class,0);
		}
		public TerminalNode OR() { return getToken(miniSysYParser.OR, 0); }
		public LOrExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lOrExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).enterLOrExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniSysYListener ) ((miniSysYListener)listener).exitLOrExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniSysYVisitor ) return ((miniSysYVisitor<? extends T>)visitor).visitLOrExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LOrExpContext lOrExp() throws RecognitionException {
		return lOrExp(0);
	}

	private LOrExpContext lOrExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LOrExpContext _localctx = new LOrExpContext(_ctx, _parentState);
		LOrExpContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_lOrExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(255);
			lAndExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(262);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LOrExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lOrExp);
					setState(257);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(258);
					match(OR);
					setState(259);
					lAndExp(0);
					}
					} 
				}
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 20:
			return addExp_sempred((AddExpContext)_localctx, predIndex);
		case 21:
			return mulExp_sempred((MulExpContext)_localctx, predIndex);
		case 27:
			return relExp_sempred((RelExpContext)_localctx, predIndex);
		case 28:
			return eqExp_sempred((EqExpContext)_localctx, predIndex);
		case 29:
			return lAndExp_sempred((LAndExpContext)_localctx, predIndex);
		case 30:
			return lOrExp_sempred((LOrExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean addExp_sempred(AddExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mulExp_sempred(MulExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relExp_sempred(RelExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean eqExp_sempred(EqExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lAndExp_sempred(LAndExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lOrExp_sempred(LOrExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u010c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\7\2B\n\2\f\2\16\2E\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\7\5S\n\5\f\5\16\5V\13\5\3\5\3\5\3\6\3\6\5\6\\\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\5\7c\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\5\np\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\7\13w\n\13\f\13\16\13z\13\13\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\7\21"+
		"\u008e\n\21\f\21\16\21\u0091\13\21\3\21\3\21\3\22\3\22\3\22\3\22\5\22"+
		"\u0099\n\22\3\23\3\23\3\24\5\24\u009e\n\24\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\7\26\u00aa\n\26\f\26\16\26\u00ad\13\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\7\27\u00b5\n\27\f\27\16\27\u00b8\13\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\5\30\u00c0\n\30\3\30\5\30\u00c3\n\30\3\31\3\31"+
		"\3\31\7\31\u00c8\n\31\f\31\16\31\u00cb\13\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\5\32\u00d3\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00dc\n"+
		"\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u00e6\n\35\f\35\16\35"+
		"\u00e9\13\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u00f1\n\36\f\36\16\36"+
		"\u00f4\13\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u00fc\n\37\f\37\16\37"+
		"\u00ff\13\37\3 \3 \3 \3 \3 \3 \7 \u0107\n \f \16 \u010a\13 \3 \2\b*,8"+
		":<>!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2"+
		"\7\3\2\3\4\3\2\5\7\4\2\3\4\24\24\3\2\25\30\3\2\31\32\2\u0105\2C\3\2\2"+
		"\2\4H\3\2\2\2\6N\3\2\2\2\bP\3\2\2\2\n[\3\2\2\2\fb\3\2\2\2\16d\3\2\2\2"+
		"\20h\3\2\2\2\22o\3\2\2\2\24q\3\2\2\2\26}\3\2\2\2\30\177\3\2\2\2\32\u0083"+
		"\3\2\2\2\34\u0085\3\2\2\2\36\u0087\3\2\2\2 \u0089\3\2\2\2\"\u0098\3\2"+
		"\2\2$\u009a\3\2\2\2&\u009d\3\2\2\2(\u00a1\3\2\2\2*\u00a3\3\2\2\2,\u00ae"+
		"\3\2\2\2.\u00c2\3\2\2\2\60\u00c4\3\2\2\2\62\u00d2\3\2\2\2\64\u00d4\3\2"+
		"\2\2\66\u00dd\3\2\2\28\u00df\3\2\2\2:\u00ea\3\2\2\2<\u00f5\3\2\2\2>\u0100"+
		"\3\2\2\2@B\5\22\n\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2"+
		"EC\3\2\2\2FG\5\4\3\2G\3\3\2\2\2HI\5\6\4\2IJ\7\35\2\2JK\7\t\2\2KL\7\n\2"+
		"\2LM\5\b\5\2M\5\3\2\2\2NO\7\r\2\2O\7\3\2\2\2PT\7\13\2\2QS\5\n\6\2RQ\3"+
		"\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\f\2\2X\t"+
		"\3\2\2\2Y\\\5\f\7\2Z\\\5\22\n\2[Y\3\2\2\2[Z\3\2\2\2\\\13\3\2\2\2]c\5\16"+
		"\b\2^c\5\20\t\2_c\5&\24\2`c\5\64\33\2ac\5\b\5\2b]\3\2\2\2b^\3\2\2\2b_"+
		"\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\r\3\2\2\2de\7\20\2\2ef\5(\25\2fg\7\21\2"+
		"\2g\17\3\2\2\2hi\5\36\20\2ij\7\b\2\2jk\5(\25\2kl\7\21\2\2l\21\3\2\2\2"+
		"mp\5\24\13\2np\5 \21\2om\3\2\2\2on\3\2\2\2p\23\3\2\2\2qr\7\16\2\2rs\5"+
		"\26\f\2sx\5\30\r\2tu\7\17\2\2uw\5\30\r\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2"+
		"xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7\21\2\2|\25\3\2\2\2}~\7\r\2\2~\27\3"+
		"\2\2\2\177\u0080\7\35\2\2\u0080\u0081\7\b\2\2\u0081\u0082\5\32\16\2\u0082"+
		"\31\3\2\2\2\u0083\u0084\5\34\17\2\u0084\33\3\2\2\2\u0085\u0086\5*\26\2"+
		"\u0086\35\3\2\2\2\u0087\u0088\7\35\2\2\u0088\37\3\2\2\2\u0089\u008a\5"+
		"\26\f\2\u008a\u008f\5\"\22\2\u008b\u008c\7\17\2\2\u008c\u008e\5\"\22\2"+
		"\u008d\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\21\2\2"+
		"\u0093!\3\2\2\2\u0094\u0099\7\35\2\2\u0095\u0096\7\35\2\2\u0096\u0097"+
		"\7\b\2\2\u0097\u0099\5$\23\2\u0098\u0094\3\2\2\2\u0098\u0095\3\2\2\2\u0099"+
		"#\3\2\2\2\u009a\u009b\5(\25\2\u009b%\3\2\2\2\u009c\u009e\5(\25\2\u009d"+
		"\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\7\21"+
		"\2\2\u00a0\'\3\2\2\2\u00a1\u00a2\5*\26\2\u00a2)\3\2\2\2\u00a3\u00a4\b"+
		"\26\1\2\u00a4\u00a5\5,\27\2\u00a5\u00ab\3\2\2\2\u00a6\u00a7\f\4\2\2\u00a7"+
		"\u00a8\t\2\2\2\u00a8\u00aa\5,\27\2\u00a9\u00a6\3\2\2\2\u00aa\u00ad\3\2"+
		"\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac+\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ae\u00af\b\27\1\2\u00af\u00b0\5.\30\2\u00b0\u00b6\3\2\2\2"+
		"\u00b1\u00b2\f\4\2\2\u00b2\u00b3\t\3\2\2\u00b3\u00b5\5.\30\2\u00b4\u00b1"+
		"\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"-\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00c3\5\62\32\2\u00ba\u00bb\t\4\2"+
		"\2\u00bb\u00c3\5.\30\2\u00bc\u00bd\7\35\2\2\u00bd\u00bf\7\t\2\2\u00be"+
		"\u00c0\5\60\31\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3"+
		"\2\2\2\u00c1\u00c3\7\n\2\2\u00c2\u00b9\3\2\2\2\u00c2\u00ba\3\2\2\2\u00c2"+
		"\u00bc\3\2\2\2\u00c3/\3\2\2\2\u00c4\u00c9\5(\25\2\u00c5\u00c6\7\17\2\2"+
		"\u00c6\u00c8\5(\25\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\61\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc"+
		"\u00cd\7\t\2\2\u00cd\u00ce\5(\25\2\u00ce\u00cf\7\n\2\2\u00cf\u00d3\3\2"+
		"\2\2\u00d0\u00d3\7\36\2\2\u00d1\u00d3\5\36\20\2\u00d2\u00cc\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\63\3\2\2\2\u00d4\u00d5\7\22\2"+
		"\2\u00d5\u00d6\7\t\2\2\u00d6\u00d7\5\66\34\2\u00d7\u00d8\7\n\2\2\u00d8"+
		"\u00db\5\f\7\2\u00d9\u00da\7\23\2\2\u00da\u00dc\5\f\7\2\u00db\u00d9\3"+
		"\2\2\2\u00db\u00dc\3\2\2\2\u00dc\65\3\2\2\2\u00dd\u00de\5> \2\u00de\67"+
		"\3\2\2\2\u00df\u00e0\b\35\1\2\u00e0\u00e1\5*\26\2\u00e1\u00e7\3\2\2\2"+
		"\u00e2\u00e3\f\3\2\2\u00e3\u00e4\t\5\2\2\u00e4\u00e6\5*\26\2\u00e5\u00e2"+
		"\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"9\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\b\36\1\2\u00eb\u00ec\58\35\2"+
		"\u00ec\u00f2\3\2\2\2\u00ed\u00ee\f\3\2\2\u00ee\u00ef\t\6\2\2\u00ef\u00f1"+
		"\58\35\2\u00f0\u00ed\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3;\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\b\37\1\2"+
		"\u00f6\u00f7\5:\36\2\u00f7\u00fd\3\2\2\2\u00f8\u00f9\f\3\2\2\u00f9\u00fa"+
		"\7\33\2\2\u00fa\u00fc\5:\36\2\u00fb\u00f8\3\2\2\2\u00fc\u00ff\3\2\2\2"+
		"\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe=\3\2\2\2\u00ff\u00fd\3"+
		"\2\2\2\u0100\u0101\b \1\2\u0101\u0102\5<\37\2\u0102\u0108\3\2\2\2\u0103"+
		"\u0104\f\3\2\2\u0104\u0105\7\34\2\2\u0105\u0107\5<\37\2\u0106\u0103\3"+
		"\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"?\3\2\2\2\u010a\u0108\3\2\2\2\26CT[box\u008f\u0098\u009d\u00ab\u00b6\u00bf"+
		"\u00c2\u00c9\u00d2\u00db\u00e7\u00f2\u00fd\u0108";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}