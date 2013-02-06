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
public abstract class BinarOperation implements Cmd
{
    public void exec(String[] arg, Stack stack, Map<String, Double> map)
    {
         if ( stack.size() > 1 )
         {
             String el1 = stack.pop().toString();
             String el2 = stack.pop().toString();

             Double val1 = det_map_value_by_par(el1, map);
             Double val2 = det_map_value_by_par(el2, map);;

             Double val = operation(val1,val2);
             stack.push(val);
         }
    }

    abstract Double operation(Double val1, Double val2);

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