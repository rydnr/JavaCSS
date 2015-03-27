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
 * Filename: NullCssAction.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Null object implementation for CssAction.
 *
 * Date: 2015/03/27
 * Time: 08:23
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
 * Null object implementation for {@link CssAction}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * Created: 2015/03/27 08:23
 */
@ThreadSafe
public class NullCssAction
    implements CssAction {
    @Override
    public String execute(String text) {
        return text;
    }
}
