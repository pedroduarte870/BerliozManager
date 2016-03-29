/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berlioz;

import java.io.IOException;
import java.rmi.server.Operation;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.LexerInterpreter;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserInterpreter;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.LexerGrammar;

/**
 *
 * @author Emanuel
 */
public class testar {
   
    
    public static ParseTree parse(String fileName,
                              String combinedGrammarFileName,
                              String startRule)
    throws IOException
{
    final Grammar g = Grammar.load(combinedGrammarFileName);
    LexerInterpreter lexEngine = g.createLexerInterpreter(new ANTLRFileStream(fileName));
    CommonTokenStream tokens = new CommonTokenStream(lexEngine);
    ParserInterpreter parser = g.createParserInterpreter(tokens);
//    parser.addParseListener(new gramaticaListener());
    ParseTree t = parser.parse(g.getRule(startRule).index);
    
    System.out.println("parse tree: "+t.toStringTree(parser));
    return t;
}
    
    public static ParseTree parse(String fileNameToParse,
                              String lexerGrammarFileName,
                              String parserGrammarFileName,
                              String startRule)
    throws IOException
{
    final LexerGrammar lg = (LexerGrammar) Grammar.load(lexerGrammarFileName);
    final Grammar pg = Grammar.load(parserGrammarFileName);
    ANTLRFileStream input = new ANTLRFileStream(fileNameToParse);
    LexerInterpreter lexEngine = lg.createLexerInterpreter(input);
    CommonTokenStream tokens = new CommonTokenStream(lexEngine);
    ParserInterpreter parser = pg.createParserInterpreter(tokens);
    ParseTree t = parser.parse(pg.getRule(startRule).index);
    System.out.println("parse tree: " + t.toStringTree(parser));
    return t;
}
    
    public static void main(String[] args) throws IOException {
 
    //Operation o = new Operation("Resultado.txt");   
    ANTLRFileStream input = new ANTLRFileStream("testeGAMU.txt");
    audition_grammarLexer lexEngine = new audition_grammarLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexEngine);
    final audition_grammarParser pg = new audition_grammarParser(tokens);
    //pg.addParseListener(new gramaticaBaseListener(o));
    
    ParseTree t = pg.gamu();
   
}
}