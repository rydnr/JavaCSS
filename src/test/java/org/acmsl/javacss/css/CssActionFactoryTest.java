/*
                        JavaCSS

    Copyright (C) 2015-today  Jose San Leandro Armendariz
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
 * Filename: CssActionFactoryTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for CssActionFactory.
 *
 * Date: 2015/03/26
 * Time: 19:13
 *
 */
package org.acmsl.javacss.css;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link CssActionFactory}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * Created: 2015/03/26 19:13
 */
@RunWith(JUnit4.class)
public class CssActionFactoryTest {
    @Test
    public void when_there_is_nothing_to_do_createAction_returns_NullCssAction() {
        CssActionFactory factory = new CssActionFactory();

        Css css = new Css();
        css.addSelector(".rule");
        css.addProperty(new Property<String>("content", "value"));
        CssAction action = factory.createAction(css);
        Assert.assertNotNull(action);
        Assert.assertTrue(action instanceof NullCssAction);
    }

    @Test
    public void for_a_before_pseudo_selector_createAction_returns_InsertBeforeCssAction() {
        CssActionFactory factory = new CssActionFactory();
        Css css = new Css();
        css.addSelector(".rule::before");
        css.addProperty(new Property<String>("content", "value"));
        CssAction action = factory.createAction(css);
        Assert.assertNotNull(action);
        Assert.assertTrue(action instanceof InsertBeforeCssAction);
    }

    @Test
    public void for_an_after_pseudo_selector_createAction_returns_InsertAfterCssAction() {
        CssActionFactory factory = new CssActionFactory();
        Css css = new Css();
        css.addSelector(".rule::after");
        css.addProperty(new Property<String>("content", "value"));
        CssAction action = factory.createAction(css);
        Assert.assertNotNull(action);
        Assert.assertTrue(action instanceof InsertAfterCssAction);
    }
}
