/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author abrahamyesgat
 */

public class Queue
{
    
    public  listNode top = null;
    public  listNode last = null;
    
    public void enqueue (String element)
    {
        
        listNode node = new listNode();
        node.element=element;
        node.next=null;
        
        if(last!=null)
        {
            last.next=node;
        }
        
        else
        {
            top = node;
        }
        
        last = node;
    }
    
    public String dequeue()
    {
        if (top != null)
        {
            
            
            String element = top.element;
            
            if(top==last)
                last=null;
            top=top.next;
            return element;
        }
        
        else
            return null;
    }
    
}

