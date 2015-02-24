package org.acmsl.javacss.java8.parser;

import org.stringtemplate.v4.ST;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MethodHelperTest {
    @Test public void can_count_the_number_of_methods()
        throws Exception {

        for (int i = 0; i < 10; i++) {
            countMethodTest(i);
        }
    }
    
    protected void countMethodTest(int methodCount)
        throws Exception {
        ST inputTemplate =
            new ST(
                "public class MyClass {\n"
              + "<methods>\n"
                + "}\n");

        StringBuilder methods = new StringBuilder();
        
        for (int i = 0; i < methodCount; i++) {
            ST methodTemplate =
                new ST("    public int method<counter>(String value) { return <counter>; }\n");

            methodTemplate.add("counter", Integer.valueOf(i));
            methods.append(methodTemplate.render());
        }

        inputTemplate.add("methods", methods);
        String input = inputTemplate.render();
        
        Assert.assertEquals(methodCount, new MethodHelper(input).countMethods());
    }
}
