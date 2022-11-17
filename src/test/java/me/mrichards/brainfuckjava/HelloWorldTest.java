package me.mrichards.brainfuckjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    @Test
    public void test_hello_world() throws IllegalTokenException {
        final String helloWorldCode = ">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++.[-]>++++++++[<++++>-]<.>+++++++++++[<++++++++>-]<-.--------.+++.------.--------.[-]>++++++++[<++++>-]<+.[-]++++++++++.";
        Brainfucker brainfucker = new Brainfucker(helloWorldCode);
        Assertions.assertEquals("Hello world!", brainfucker.execute().trim());
    }

}
