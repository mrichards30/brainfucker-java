package me.mrichards.brainfuckjava;

public class BrainfuckInterpreter {

    public static void main(String[] args) throws IllegalTokenException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Pass your Brainfuck code as the first argument.");
        }
        Brainfucker brainfuck = new Brainfucker(args[0]);
        System.out.println(brainfuck.execute());
    }

}
