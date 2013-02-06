package com.jcourse.ib.calc.main;

import com.jcourse.ib.calc.commands.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 02.02.13
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */

public class Calc
{
    public void main()
    {
        Map<String, Cmd> cmdMap = new HashMap<>();
        initCmdMap(cmdMap);

        Map<String, Double> defineMap = new HashMap<>();

        Stack<Double> calcStack = new Stack<>();

        List<String> commandsStr = read_commands();

        for(String stroka : commandsStr)
        {
            System.out.println(stroka);
            String[] splitStr = null;
            Cmd command = null;

            //Parser.parse(stroka, splitStr, command, cmdMap);
            stroka = stroka.trim();
            splitStr = stroka.split(" ");
            command =  cmdMap.get(splitStr[0]);

            command.exec(
                    splitStr,
                    calcStack,
                    defineMap
            );
        }

    }

    private List<String> read_commands()
    {
        List<String> stroki = new ArrayList();
        stroki.add("DEFINE a 25");
        stroki.add("PUSH a");
        stroki.add("SQRT");
        stroki.add("PRINT");

        stroki.add("PUSH 4");
        stroki.add("PUSH a");
        stroki.add("+");
        stroki.add("PRINT");
        return stroki;
    }

    private void initCmdMap(Map<String, Cmd> cmdMap)
    {
        cmdMap.put("#", new Komment());
        cmdMap.put("PUSH", new Push());
        cmdMap.put("POP", new Pop());
        cmdMap.put("PRINT", new Print());
        cmdMap.put("DEFINE", new Define());
        cmdMap.put("SQRT", new Sqrt());
        cmdMap.put("+", new Plus());
    }
}