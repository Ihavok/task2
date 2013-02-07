package com.jcourse.ib.calc.commands;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 02.02.13
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
public class Print implements Cmd
{
    public void exec(String[] arg, Stack stack, Map<String, Double> map )
    {
        if ( !stack.empty() )
        {
            //String el = stack.pop().toString();
            String el = stack.lastElement().toString();
            System.out.println(el);
        }
    }
}
