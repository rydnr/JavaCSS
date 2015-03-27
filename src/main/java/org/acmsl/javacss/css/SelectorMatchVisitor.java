/*
                        JavaCSS

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
 * Filename: SelectorMatchVisitor.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: An ANTLR visitor to find whether some selectors match certain
 *              subtrees of an AST.
 *
 * Date: 2015/03/20
 * Time: 10:35
 *
 */
package org.acmsl.javacss.css;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.javacss.java8.parser.Java8BaseVisitor;
import org.acmsl.javacss.java8.parser.Java8Parser.PackageDeclarationContext;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

/**
 * An ANTLR visitor to find whether some selectors match certain subtrees of an AST.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2015/03/20 10:35
 */
@ThreadSafe
public class SelectorMatchVisitor
    extends Java8BaseVisitor<ParseTree> {
    boolean match = false;

    final ParseTree focusNode;
    final List<String> selectors;
    final Iterator<String> iterator;
    String currentSelector = null;

    public SelectorMatchVisitor(List<String> selectors, ParseTree focusNode) {
        this.selectors = selectors;
        this.iterator = selectors.iterator();
        if (this.iterator.hasNext()) {
            this.currentSelector = this.iterator.next();
        }
        this.focusNode = focusNode;
    }

    @Override
    public ParseTree visitChildren(RuleNode node) {
        ParseTree result;

        if (!this.match) {
            result = visit(node);
        } else {
            result = null;
        }

        return result;
    }

    @Override
    public ParseTree visitTerminal(TerminalNode node) {
        ParseTree result;

        if (!this.match) {
            result = visit(node);
        } else {
            result = null;
        }

        return result;
    }

    @Override
    public ParseTree visit(ParseTree node) {
        ParseTree result = null;

        if (!this.match) {
            if (matches(node, this.currentSelector)) {
                if (this.iterator.hasNext()) {
                    this.currentSelector = this.iterator.next();
                    result = super.visit(node);
                } else if (focusNode.equals(node)) {
                    match = true;
                }
            } else if (node.getChildCount() > 0) {
                if (!this.match) {
                    result = super.visitChildren((RuleNode) node);
                }
            }
        }
        return result;
    }

    protected boolean matches(final ParseTree node, final String currentSelector) {
        boolean result = false;

        if (currentSelector.startsWith(".")) {
            // class selector
            String className = node.getPayload().getClass().getSimpleName();

            // remove any container class, if it's anonymous
            if (className.contains("$")) {
                className = className.substring(className.lastIndexOf("$"));
            }
            // uncapitalize the first letter
            if (className.length() > 1) {
                className = className.substring(0, 1).toLowerCase(Locale.getDefault()) + className.substring(1);
            }
            // remove the trailing "Context".
            className = className.substring(0, className.lastIndexOf("Context"));

            result = currentSelector.equals("." + className);
        } else if (currentSelector.startsWith("\"")) {
            Object payload = node.getPayload();

            if (payload instanceof CommonToken) {
                String value = ((CommonToken) payload).getText();

                String selectorPart = currentSelector.substring(1);
                selectorPart = selectorPart.substring(0, selectorPart.indexOf("\""));

                result = value.equals(selectorPart);
            }
        }

        return result;
    }

    public boolean matchFound() {
        return this.match;
    }
}
