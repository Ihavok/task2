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
public class Sqrt extends UnarOperation implements Cmd
{
    Double operation(Double val)
    {
        return Math.sqrt(val);
    }
}