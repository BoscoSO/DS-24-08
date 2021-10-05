package e4;

import javax.crypto.spec.PSource;

public class MAINTEST {
    public static void main(String[] args) {
        Calculator c=new Calculator();


        // Same, obtaining negative value
        c.addOperation("-", 3.7f, 5.8f);
        c.addOperation("*", 4.8f);
        c.addOperation("/", 2.0f);
        c.addOperation("+", 2.04f);
        //assertEquals("[STATE:[-]3.7_5.8[*]4.8[/]2.0[+]2.04]",
        System.out.println(c.toString());

    }
}
