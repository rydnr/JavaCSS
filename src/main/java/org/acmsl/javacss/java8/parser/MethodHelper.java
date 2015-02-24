package org.acmsl.javacss.java8.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MethodHelper {
    private final String input;

    public MethodHelper(String input) {
        this.input = input;
    }

    public int countMethods() {
        int result = 0;

        Java8Lexer lexer = new Java8Lexer(new ANTLRInputStream(input));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        Java8Parser parser = new Java8Parser(tokens);
        ParseTree ast = parser.compilationUnit();

        result = countMethods(ast);

        return result;
    }

    public int countMethods(ParseTree node) {
        int result = 0;

        if (isMethod(node)) {
            result = 1;
        } else {
            for (int i = 0; i < node.getChildCount(); i++) {
                result += countMethods(node.getChild(i));
            }
        }

        return result;
    }

    public boolean isMethod(ParseTree node) {
        return node.getPayload() instanceof Java8Parser.MethodDeclarationContext;
    }
}
