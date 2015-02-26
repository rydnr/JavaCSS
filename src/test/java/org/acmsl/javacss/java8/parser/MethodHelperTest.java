package org.acmsl.javacss.java8.parser;

import org.stringtemplate.v4.ST;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

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

            methodTemplate.add("counter", i);
            methods.append(methodTemplate.render());
        }

        inputTemplate.add("methods", methods);
        String input = inputTemplate.render();
        
        Assert.assertEquals(methodCount, new MethodHelper(input).countMethods());
    }

    @Test public void can_retrieves_the_return_types_of_methods()
        throws Exception {

        List<String> returnTypes;
        String[] availableTypes = { "void", "String", "int", "List<?>", "Map" };


        for (int i = 0; i < 10; i++) {
            returnTypes = new ArrayList<String>(i);
            for (int j = 0; j < i; j++) {
                returnTypes.add(availableTypes[(int) (Math.random() * availableTypes.length)]);
            }
            retrieveReturnTypeOfMethodTest(returnTypes);
        }
    }

    protected void retrieveReturnTypeOfMethodTest(List<String> returnTypes)
        throws Exception {
        ST inputTemplate =
            new ST(
                "public class MyClass {\n"
                + "<methods>\n"
                + "}\n");

        StringBuilder methods = new StringBuilder();

        for (int i = 0; i < returnTypes.size(); i++) {
            ST methodTemplate =
                new ST("    public <type> method<counter>(String value) { return <counter>; }\n");

            methodTemplate.add("type", returnTypes.get(i));
            methodTemplate.add("counter", i);
            methods.append(methodTemplate.render());
        }

        inputTemplate.add("methods", methods);
        String input = inputTemplate.render();

        List<String> types = new MethodHelper(input).retrieveReturnTypesOfMethods();
        Assert.assertNotNull(types);
        Assert.assertEquals(returnTypes.size(), types.size());
        for (String returnType : returnTypes) {
            Assert.assertTrue(types.contains(returnType));
        }
        for (String type : types) {
            Assert.assertTrue(returnTypes.contains(type));
        }
    }

}
