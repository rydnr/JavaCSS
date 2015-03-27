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
 * Filename: CssAction.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Represents all actions to be performed according to CSS blocks.
 *
 * Date: 2015/03/27
 * Time: 08:19
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
 * Represents all actions to be performed according to CSS blocks.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * Created: 2015/03/27 08:19
 */
@ThreadSafe
public interface CssAction {
    /**
     * Applies the action to given text.
     * @param text the text.
     * @return the outcome of applying the action.
     */
    String execute(String text);
}
