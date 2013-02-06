package com.jcourse.ib.calc.commands;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 02.02.13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
public interface Cmd
{
    void exec
            (
            String arg[],
            Stack stack,
            Map<String, Double> map
            );

    //Double operation(Double val1, Double val2);
}
