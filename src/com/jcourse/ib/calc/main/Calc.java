package com.jcourse.ib.calc.main;

import com.jcourse.ib.calc.commands.*;

import java.io.IOException;
import java.io.InputStream;
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
    static Properties comandsProps = new Properties();
    static
    {
        try
        {
            InputStream in = Calc.class.getResourceAsStream("conf.properties");
            comandsProps.load(in);
            in.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    public void main()
    {
        Map<String, Cmd> cmdMap = new HashMap<>();
        initCmdMap(cmdMap);

        Map<String, Double> defineMap = new HashMap<>();

        Stack<Double> calcStack = new Stack<>();

        List<String> commandsStr = read_commands();

        for(String stroka : commandsStr)
        {
            String[] splitStr = null;
            Cmd command = null;

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
        if (!comandsProps.isEmpty())
        {
            Enumeration propertyNames = comandsProps.propertyNames();
            while (propertyNames.hasMoreElements())
            {
                String operName = (String)propertyNames.nextElement();
                String operClass = comandsProps.getProperty(operName);

                try
                {
                    cmdMap.put(operName, (Cmd) Class.forName(operClass).newInstance());
                }
                catch (ClassNotFoundException e)
                {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                catch (InstantiationException e)
                {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                catch (IllegalAccessException e)
                {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
        else
        {

        }
    }
}