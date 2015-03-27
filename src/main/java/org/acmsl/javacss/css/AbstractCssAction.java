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
 * Filename: AbstractCssAction.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2015/03/27
 * Time: 20:23
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

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2015/03/27 20:23
 */
@ThreadSafe
public abstract class AbstractCssAction
    implements CssAction {

    /**
     * The associated {@link Css} block.
     */
    private final Css css;

    /**
     * Creates a new {@code InsertAfterCssAction} instance.
     * @param css the {@link Css} block.
     */
    protected AbstractCssAction(Css css) {
        this.css = css;
    }

    /**
     * Retrieves the {@link Css} block.
     * @return such information.
     */
    public Css getCss() {
        return this.css;
    }

    /**
     * Retrieves the content property from given {@link Css}.
     * @param css the CSS block.
     * @return the "content" property.
     */
    protected Property getContentProperty(Css css) {
        Property result = null;

        for (Property property : css.getProperties()) {
            if (Property.CONTENT.equals(property.getKey())) {
                result = property;
                break;
            }
        }

        return result;
    }
}
