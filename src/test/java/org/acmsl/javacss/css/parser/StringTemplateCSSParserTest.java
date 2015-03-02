package org.acmsl.javacss.css.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;

@RunWith(JUnit4.class)
public class StringTemplateCSSParserTest
{
    @Test
    public void parses_a_simple_input() {
        String input =
            ".packageDeclaration #identifier::before {\n"
          + "    content: \"  \";\n"
          + "}\n";

        StringTemplateCSSLexer lexer = new StringTemplateCSSLexer(new ANTLRInputStream(input));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        StringTemplateCSSParser parser = new StringTemplateCSSParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree ast = parser.css();
        Assert.assertNotNull(ast);
    }

    @Test
    public void parses_another_simple_input() {
        String input =
              "  .packageDeclaration \";\"::after {\n"
            + "    content: \"\\n\\n\";\n"
            + "  }";

        StringTemplateCSSLexer lexer = new StringTemplateCSSLexer(new ANTLRInputStream(input));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        StringTemplateCSSParser parser = new StringTemplateCSSParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree ast = parser.css();
        Assert.assertNotNull(ast);
    }
}