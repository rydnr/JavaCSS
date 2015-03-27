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
 * Filename: Css.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Represents CSS blocks.
 *
 * Date: 2015/03/26
 * Time: 12:12
 *
 */
package org.acmsl.javacss.css;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/*
 * Importing JDK classes.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Represents CSS blocks.
 * @since 3.0
 * Created: 2015/03/26 12:12
 */
@ThreadSafe
public class Css {
    /**
     * The selectors.
     */
    private List<String> selectors = new ArrayList<>();
    /**
     * The CSS properties.
     */
    private List<Property<?>> properties = new ArrayList<>();

    /**
     * Adds a new selector.
     * @param selector the selector.
     */
    public void addSelector(String selector) {
        this.selectors.add(selector);
    }

    /**
     * Retrieves the selectors.
     * @return such information.
     */
    public List<String> getSelectors() {
        return selectors;
    }

    /**
     * Retrieves the properties.
     * @return such information.
     */
    public List<Property<?>> getProperties() {
        return properties;
    }

    /**
     * Adds a new property.
     * @param property the property.
     */
    public void addProperty(final Property<?> property) {
        this.properties.add(property);
    }
}
