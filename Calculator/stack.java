/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author abrahamyesgat
 */
public class stack {
    listNode top=null;

void push(String arg){
listNode node= new listNode();
node.element=arg;
if(top!=null)
    node.next=top;
else
    node.next=null;
top=node;
}
String pop(){
    if (top==null) return null;
    String element= top.element;
    top=top.next;
    return element;
}
}
