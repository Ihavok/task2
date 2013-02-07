package com.jcourse.ib.calc.main;

import com.jcourse.ib.calc.commands.*;

import java.io.*;
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

    Map<String, Cmd> cmdMap = new HashMap<String, Cmd>();
    Map<String, Double> defineMap = new HashMap<String, Double>();
    Stack<Double> calcStack = new Stack<Double>();

    public Calc() throws Exception
    {
        initCmdMap();

        execute_commands_from_file();
    }

    public void execute_commands_from_console() throws IOException
    {
        String commandStr = "";
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while( !(commandStr = input.readLine()).equalsIgnoreCase("Exit") )
        {
            execute_command(commandStr);
        }
    }

    private void execute_commands_from_file()
    {
        List<String> commandsStr = read_commands_from_file();
        execute_commands(commandsStr);
    }

    private void execute_commands(List<String> commandsStr)
    {
        for(String commandStr : commandsStr)
        {
            execute_command(commandStr);
        }
    }

    private void execute_command(String commandStr)
    {
        String[] splitStr = null;
        Cmd command = null;

        commandStr = commandStr.trim().toUpperCase();
        splitStr = commandStr.split(" ");

        if (splitStr.length > 0)
        {
            if (cmdMap.containsKey(splitStr[0]))
            {
                command = cmdMap.get(splitStr[0]);

                command.exec(
                        splitStr,
                        calcStack,
                        defineMap
                );
            }
            else
            {
                //todo
            }
        }
        else
        {
            //todo
        }
    }

    private List<String> read_commands_from_file()
    {
        List<String> stroki = new ArrayList();

        try
        {
            DataInputStream in = new DataInputStream(new FileInputStream("commands.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)
            {
                if(strLine.length() > 0)
                {
                    stroki.add(strLine);
                }
            }
            in.close();
        }
        catch (FileNotFoundException e)
        {
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            System.out.println("File commands.txt not found");
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return stroki;
    }

    private void initCmdMap()
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
            //todo
        }
    }
}
