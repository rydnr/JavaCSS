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
 * Filename: InsertAfterCssActionTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for InsertAfterCssAction.
 *
 * Date: 2015/03/27
 * Time: 19:07
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
 * Tests for {@link InsertAfterCssAction}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * Created: 2015/03/27 19:07
 */
@RunWith(JUnit4.class)
public class InsertAfterCssActionTest {
    @Test
    public void execute_inserts_the_content_after_correctly() {
        Css css = new Css();
        css.addSelector(".rule::after");
        css.addProperty(new Property<String>("content", "<css-suffix"));
        CssActionFactory factory = new CssActionFactory();
        CssAction action = factory.createAction(css);
        Assert.assertNotNull(action);
        String newText = action.execute("my text");
        Assert.assertNotNull(newText);
        Assert.assertEquals("my text<css-suffix", newText);
    }
}
