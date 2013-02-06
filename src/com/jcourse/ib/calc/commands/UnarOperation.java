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
public abstract class UnarOperation implements Cmd
{
    public void exec(String[] arg, Stack stack, Map<String, Double> map)
    {
         if ( stack.size() > 1 )
         {
             String el = stack.pop().toString();

             Double val = det_map_value_by_par(el, map);

             Double rez_val = operation(val);
             stack.push(rez_val);
         }
    }

    abstract Double operation(Double val);

    private Double det_map_value_by_par(String el, Map<String, Double> map)
    {
        Double val;
        if (map.containsKey(el))
        {
            val = map.get(el);
        }
        else
        {
            val = Double.valueOf(el);
        }
        return val;
    }
}