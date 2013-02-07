package com.jcourse.ib.calc;

import com.jcourse.ib.calc.main.Calc;

/**
 * Created with IntelliJ IDEA.
 * User: Student
 * Date: 02.02.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class StackCalc
{
    public static void main(String arg[])
    {

        try
        {
            Calc calc = new Calc();
            calc.execute_commands_from_console();
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //calc.main();
    }
}
