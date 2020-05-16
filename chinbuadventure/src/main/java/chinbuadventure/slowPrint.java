/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinbuadventure;

/**
 *
 * @author Thopte
 */
public class slowPrint {
    public static void printString(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++){
            try {
            System.out.print(chars[i]);
            Thread.sleep(100);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
}
