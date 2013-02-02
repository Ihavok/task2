package com.jcourse.ib.calc.main;

import com.jcourse.ib.calc.commands.Cmd;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 02.02.13
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class Parser
{
    public static void parse(String stroka, String[] splitStr, Cmd command, Map<String, Cmd> cmdMap)
    {
        stroka = stroka.trim();
        splitStr = stroka.split(" ");
        command =  cmdMap.get(splitStr[0]);
    }
}
