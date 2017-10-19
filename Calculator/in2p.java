/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *The shunting yard algorithm implementation is used here.
 *
 *
 * This program is built to take, from the command line, an expression in infix notation and turn it to
 *postfix notation. As the function scans through the infix notation, it it encounters an operand
 * it puts it in the output queue,
 * when it encounters an operator it put it in the stack (assuming the stack is empty).
 * If the object at the top of the stack (assuming it is not empty) has higher precedence
 * then you pop it out of the stack onto the output,
 * if not you put the operator in the stack (same case as if stack is empty).
 * Then it goes back to the enqueue and restarts the loop until there's nothing left.
 * @author abrahamyesgat
 */

import java.io.*;
import java.lang.Math;

public class in2p {
    public static String eval(String args[])
    {
        int i;
        String s;
        stack Opstack = new stack();     //make a stack for operators (name Opstack)
        Queue inQ = new Queue();        //Create 2 Queues input Q and Output Q
        Queue outQ = new Queue();
        
        System.out.print("Infix: ");    //Enqueue the input
        for (i = 0; i < args.length; i++) {
            inQ.enqueue(args[i]);
            System.out.print(args[i] + " ");
        }
        while(inQ.top != null)
        {
            precedence operator= new precedence();
            //if the first element of the input queue is a number, enqueue it to output queue
            if(operator.priority(inQ.top.element)==0)
            {
                String a = inQ.dequeue();
                outQ.enqueue(a);
            }
            //if the stack is empty and the first element of the input queue is an operator, push it to the stack
            else if(Opstack.top == null && operator.priority(inQ.top.element)!= 0) //since if it DOES equal zero we get an operand (refer to precedence class)
            {
                String b = inQ.dequeue();
                Opstack.push(b);
            }
            //if the operator that is being analyzed has a precedence that is "stronger" than that of the prwevious element in the stack, add it to the stack.
            else if(operator.priority(inQ.top.element)!=0 &&  operator.priority(inQ.top.element) > operator.priority(Opstack.top.element))
            {
                String c = inQ.dequeue();
                Opstack.push(c);
            }
            //if the  operator that is being analyzed has a lower or equal (<=) precedence than that of the the first element of the stack, enqueue the elements onto the stack, until condition not satisfied.
            //When not true push the next element onto the stack
            else
            {
                //While the stack is not empty
                    if(operator.priority(inQ.top.element)!=0 && operator.priority(inQ.top.element) == operator.priority(Opstack.top.element))                    { //If this token has a "stronger" precedence it can be put on the  on the stack with lower precedences beneath it
                        String r=inQ.dequeue();
                        String e= Opstack.pop();
                        outQ.enqueue(e);
                        Opstack.push(r);

                    }
                    else if (operator.priority(inQ.top.element) < operator.priority(Opstack.top.element))
                    {
                        String r = Opstack.pop(); // while the operator is of a lower precedence and meets an operator of higher precedence, we send it to the outQ
                        outQ.enqueue(r);

                    }



            }
        }
        //while the inQ queue is empty, enqueue whatever remains in the stack
        while (Opstack.top != null)
        {
            String l = Opstack.pop();
            outQ.enqueue(l);


        }

        //print the postfix notation
/*
         System.out.println();
        System.out.print("Postfix: ");
        while ((s=outQ.dequeue())  != null)
            System.out.print(s + " ");
        System.out.println();
        */




        System.out.print(" \nAnswer: ");
        // Created a new stack for the evaluation of the postfix
        
        stack vals = new stack();

        //check each element in the postfix string, if its a number, push, if its a operator, operate on the two numbers
        
        
        while (outQ.top != null) {
            String l=outQ.dequeue();
            
            
            precedence calc= new precedence(); // making a new precedence for the evaluation of the postfix
            
            if(precedence.priority(l)==0) //this case implies that the token is a number
            {
                vals.push(l); //we push the token onto the stack
               
            }

            else if(l.equals("x"))//this case the token is a "x"
            {
                double v= Double.parseDouble(vals.pop()) * Double.parseDouble(vals.pop());
                vals.push(String.valueOf(v));
            }
            else if(l.equals("/"))//this case the token is a  "/"
            {
                double v= Double.parseDouble(vals.pop());
                double b=Double.parseDouble(vals.pop());
                vals.push(String.valueOf(b/v));
            }


            else if(l.equals("+")) //in this case the token is a "+" sign
            {
                double v= Double.parseDouble(vals.pop()) + Double.parseDouble(vals.pop());
                vals.push(String.valueOf(v));
               
            }
            else if(l.equals("-"))//in this case the token is a "-" sign
            {
                double v= Double.parseDouble(vals.pop());
                double b= Double.parseDouble(vals.pop());
                vals.push(String.valueOf(b-v));
            }


        }
        
        System.out.println(vals.top.element);
        return (vals.top.element);



    }

}
