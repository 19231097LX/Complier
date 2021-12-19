// Generated from miniSysY.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link miniSysYParser}.
 */
public interface miniSysYListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(miniSysYParser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(miniSysYParser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(miniSysYParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(miniSysYParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(miniSysYParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(miniSysYParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(miniSysYParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(miniSysYParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(miniSysYParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(miniSysYParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(miniSysYParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(miniSysYParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#retStatement}.
	 * @param ctx the parse tree
	 */
	void enterRetStatement(miniSysYParser.RetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#retStatement}.
	 * @param ctx the parse tree
	 */
	void exitRetStatement(miniSysYParser.RetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(miniSysYParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(miniSysYParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(miniSysYParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(miniSysYParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(miniSysYParser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(miniSysYParser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(miniSysYParser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(miniSysYParser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(miniSysYParser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(miniSysYParser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(miniSysYParser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(miniSysYParser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(miniSysYParser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(miniSysYParser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(miniSysYParser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(miniSysYParser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(miniSysYParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(miniSysYParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(miniSysYParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(miniSysYParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(miniSysYParser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(miniSysYParser.InitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#expStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpStatement(miniSysYParser.ExpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#expStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpStatement(miniSysYParser.ExpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(miniSysYParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(miniSysYParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(miniSysYParser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(miniSysYParser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(miniSysYParser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(miniSysYParser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code priE}
	 * labeled alternative in {@link miniSysYParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPriE(miniSysYParser.PriEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code priE}
	 * labeled alternative in {@link miniSysYParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPriE(miniSysYParser.PriEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryOpExp}
	 * labeled alternative in {@link miniSysYParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOpExp(miniSysYParser.UnaryOpExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryOpExp}
	 * labeled alternative in {@link miniSysYParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOpExp(miniSysYParser.UnaryOpExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code libfunc}
	 * labeled alternative in {@link miniSysYParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterLibfunc(miniSysYParser.LibfuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code libfunc}
	 * labeled alternative in {@link miniSysYParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitLibfunc(miniSysYParser.LibfuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#funcRParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncRParams(miniSysYParser.FuncRParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#funcRParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncRParams(miniSysYParser.FuncRParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code braces}
	 * labeled alternative in {@link miniSysYParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterBraces(miniSysYParser.BracesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code braces}
	 * labeled alternative in {@link miniSysYParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitBraces(miniSysYParser.BracesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link miniSysYParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterNum(miniSysYParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link miniSysYParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitNum(miniSysYParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code left}
	 * labeled alternative in {@link miniSysYParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterLeft(miniSysYParser.LeftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code left}
	 * labeled alternative in {@link miniSysYParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitLeft(miniSysYParser.LeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#condStatement}.
	 * @param ctx the parse tree
	 */
	void enterCondStatement(miniSysYParser.CondStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#condStatement}.
	 * @param ctx the parse tree
	 */
	void exitCondStatement(miniSysYParser.CondStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(miniSysYParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(miniSysYParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(miniSysYParser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(miniSysYParser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(miniSysYParser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(miniSysYParser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void enterLAndExp(miniSysYParser.LAndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void exitLAndExp(miniSysYParser.LAndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniSysYParser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void enterLOrExp(miniSysYParser.LOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniSysYParser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void exitLOrExp(miniSysYParser.LOrExpContext ctx);
}