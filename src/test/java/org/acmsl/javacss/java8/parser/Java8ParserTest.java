package org.acmsl.javacss.java8.parser;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

@RunWith(JUnit4.class)
public class Java8ParserTest {
    @Test public void can_parse_an_interface_with_extends_and_a_single_method()
        throws Exception {
        String input =
              "public interface Resolver\n"
            + "    extends Serializable {\n\n"

            + "    public int resolve(String value);\n"
            + "}\n";
            
        Java8Lexer lexer = new Java8Lexer(new ANTLRInputStream(input));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        Java8Parser parser = new Java8Parser(tokens);
        ParseTree ast = parser.compilationUnit();
        Assert.assertNotNull(ast);
    }
}
