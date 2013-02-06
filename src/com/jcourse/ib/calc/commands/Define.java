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
public class Define implements Cmd
{
    public void exec(String[] arg, Stack stack, Map<String, Double> map)
    {
         String par_name = arg[1];
         Double par_value = Double.valueOf(arg[2]);
         map.put(par_name, par_value);
    }
}