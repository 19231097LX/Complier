// Generated from miniSysY.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link miniSysYParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface miniSysYVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(miniSysYParser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(miniSysYParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(miniSysYParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(miniSysYParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(miniSysYParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(miniSysYParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#retStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetStatement(miniSysYParser.RetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(miniSysYParser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(miniSysYParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(miniSysYParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(miniSysYParser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(miniSysYParser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(miniSysYParser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(miniSysYParser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(miniSysYParser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(miniSysYParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(miniSysYParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(miniSysYParser.InitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#expStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpStatement(miniSysYParser.ExpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(miniSysYParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(miniSysYParser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(miniSysYParser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code priE}
	 * labeled alternative in {@link miniSysYParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriE(miniSysYParser.PriEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryOpExp}
	 * labeled alternative in {@link miniSysYParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOpExp(miniSysYParser.UnaryOpExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code libfunc}
	 * labeled alternative in {@link miniSysYParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibfunc(miniSysYParser.LibfuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#funcRParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncRParams(miniSysYParser.FuncRParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code braces}
	 * labeled alternative in {@link miniSysYParser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraces(miniSysYParser.BracesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code num}
	 * labeled alternative in {@link miniSysYParser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(miniSysYParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code left}
	 * labeled alternative in {@link miniSysYParser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft(miniSysYParser.LeftContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#condStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondStatement(miniSysYParser.CondStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(miniSysYParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(miniSysYParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(miniSysYParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(miniSysYParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(miniSysYParser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(miniSysYParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(miniSysYParser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniSysYParser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(miniSysYParser.LOrExpContext ctx);
}