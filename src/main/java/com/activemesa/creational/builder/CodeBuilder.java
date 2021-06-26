// Builder Coding Exercise
package com.activemesa.creational.builder;

import java.util.ArrayList;
import java.util.List;


public class CodeBuilder {

    public String className;
    public List<String> fieldNames = new ArrayList<>();
    public List<String> fieldTypes = new ArrayList<>();

    public CodeBuilder(String className)
    {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        fieldNames.add(name);
        fieldTypes.add(type);

        return this;
    }

    @Override
    public String toString()
    {
        String indent = "  ";
        String nl = System.lineSeparator();

        StringBuilder sb = new StringBuilder();
        sb.append("public class ").append(className).append(nl);
        sb.append("{").append(nl);
        for (int i = 0; i < fieldNames.size(); i++){
            sb.append(indent)
                    .append(fieldTypes.get(i))
                    .append(' ')
                    .append(fieldNames.get(i))
                    .append(";")
                    .append(nl);
        }
        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(cb);
    }
}
