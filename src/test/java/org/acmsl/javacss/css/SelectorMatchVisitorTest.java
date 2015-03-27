/*
                        devdel

    Copyright (C) 2002-today  Jose San Leandro Armendariz
                              chous@acm-sl.org

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the License, or any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General Public License for more details.

    You should have received a copy of the GNU General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

    Thanks to ACM S.L. for distributing this library under the GPL license.
    Contact info: jose.sanleandro@acm-sl.com

 ******************************************************************************
 *
 * Filename: SelectorMatchVisitorTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2015/03/20
 * Time: 10:37
 *
 */
package org.acmsl.javacss.css;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.javacss.java8.parser.Java8Lexer;
import org.acmsl.javacss.java8.parser.Java8Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.xpath.XPath;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2015/03/20 10:37
 */
@RunWith(JUnit4.class)
public class SelectorMatchVisitorTest
{
    @Test
    public void compares_selectors_correctly() {
        String javaInput = "package com.foo.bar;";

        Java8Lexer lexer = new Java8Lexer(new ANTLRInputStream(javaInput));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokens);
        ParseTree ast = parser.compilationUnit();

        Collection<ParseTree> matches = XPath.findAll(ast, "//';'", parser);

        Assert.assertNotNull(matches);
        Assert.assertEquals(1, matches.size());

        ParseTree semiColon = matches.toArray(new ParseTree[1])[0];
        Assert.assertNotNull(semiColon);

        matches = XPath.findAll(ast, "//'package'", parser);

        Assert.assertNotNull(matches);
        Assert.assertEquals(1, matches.size());

        ParseTree packageNode = matches.toArray(new ParseTree[1])[0];
        Assert.assertNotNull(packageNode);

        List<String> selectors = Arrays.asList(".packageDeclaration", "\";\"::before");

        SelectorMatchVisitor visitor = new SelectorMatchVisitor(selectors, ast);

        Assert.assertTrue(visitor.matches(ast.getChild(0), ".packageDeclaration"));
        Assert.assertTrue(visitor.matches(semiColon, "\";\"::before"));
    }
}
