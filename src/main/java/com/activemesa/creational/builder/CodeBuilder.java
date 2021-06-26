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
        StringBuilder sb = new StringBuilder();
        sb.append("public class ").append(className).append('\n');
        sb.append("{\n");
        for (int i = 0; i < fieldNames.size(); i++){
            sb.append(indent)
                    .append(fieldTypes.get(i))
                    .append(' ')
                    .append(fieldNames.get(i))
                    .append(";\n");
        }
        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(cb);
    }
}
