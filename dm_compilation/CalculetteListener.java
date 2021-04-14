// Generated from Calculette.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculetteParser}.
 */
public interface CalculetteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CalculetteParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CalculetteParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(CalculetteParser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(CalculetteParser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(CalculetteParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(CalculetteParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#instructionEntree}.
	 * @param ctx the parse tree
	 */
	void enterInstructionEntree(CalculetteParser.InstructionEntreeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#instructionEntree}.
	 * @param ctx the parse tree
	 */
	void exitInstructionEntree(CalculetteParser.InstructionEntreeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#instructionSortie}.
	 * @param ctx the parse tree
	 */
	void enterInstructionSortie(CalculetteParser.InstructionSortieContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#instructionSortie}.
	 * @param ctx the parse tree
	 */
	void exitInstructionSortie(CalculetteParser.InstructionSortieContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#express}.
	 * @param ctx the parse tree
	 */
	void enterExpress(CalculetteParser.ExpressContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#express}.
	 * @param ctx the parse tree
	 */
	void exitExpress(CalculetteParser.ExpressContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#declassigne}.
	 * @param ctx the parse tree
	 */
	void enterDeclassigne(CalculetteParser.DeclassigneContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#declassigne}.
	 * @param ctx the parse tree
	 */
	void exitDeclassigne(CalculetteParser.DeclassigneContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(CalculetteParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(CalculetteParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#assigne}.
	 * @param ctx the parse tree
	 */
	void enterAssigne(CalculetteParser.AssigneContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#assigne}.
	 * @param ctx the parse tree
	 */
	void exitAssigne(CalculetteParser.AssigneContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFinInstruction(CalculetteParser.FinInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFinInstruction(CalculetteParser.FinInstructionContext ctx);
}