package com.jcourse.ib.calc.commands;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 02.02.13
 * Time: 14:54
 * To change this template use File | Settings | File Templates.
 */
public class Minus extends BinarOperation implements Cmd
{

    Double operation(Double val1, Double val2)
    {
        return val1 - val2;
    }
}