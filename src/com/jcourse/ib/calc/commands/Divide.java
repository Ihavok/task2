package com.jcourse.ib.calc.commands;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 02.02.13
 * Time: 14:54
 * To change this template use File | Settings | File Templates.
 */
public class Divide extends BinarOperation implements Cmd
{

    Double operation(Double val1, Double val2)
    {
        Double val = null;
        if (val2 != 0)
        {
            val = val1 / val2;
        }
        else
        {
            //
        }
        return val;
    }
}