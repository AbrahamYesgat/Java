/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author abrahamyesgat
 */
public class precedence {

        public static int priority(String a)
    {
        switch(a)
        {
            case "+": return 1;
            case "-": return 1;
            case "x": return 2;
            case "/": return 2;

            default: return 0;
        }
    }

}

