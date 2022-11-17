package me.mrichards.brainfuckjava;

import java.util.Scanner;

public class Brainfucker {

    private final String code;
    private final StringBuilder output = new StringBuilder();
    private int currentToken = 0;
    private final int[] tape = new int[30_000];
    private int pointer = 100;
    private int lastOpenBracket = 0;

    public Brainfucker(String code) {
        this.code = code;
    }

    public String execute() throws IllegalTokenException {
        for (currentToken = 0; currentToken >= 0 && currentToken < code.length(); currentToken++) {
            char token = code.charAt(currentToken);
            switch (token) {
                case '[' -> this.beginLoop();
                case ']' -> this.endLoop();
                case '>' -> this.pointer++;
                case '<' -> this.pointer--;
                case '+' -> this.tape[pointer]++;
                case '-' -> this.tape[pointer]--;
                case '.' -> output.append((char) this.tape[pointer]);
                case ',' -> this.acceptInputOntoTape();
                default -> throw new IllegalTokenException("Illegal character '" + token + "' at code index " + currentToken + ".");
            }
        }
        return output.toString();
    }

    public void acceptInputOntoTape() {
        Scanner scanner = new Scanner(System.in);
        tape[pointer] = scanner.next().charAt(0);
    }

    public void beginLoop() {
        if (tape[pointer] != 0) {
            this.lastOpenBracket = this.currentToken;
        } else {
            while (code.charAt(currentToken) != ']') {
                this.currentToken++;
            }
        }
    }

    public void endLoop() {
        if (tape[pointer] != 0) {
            this.currentToken = this.lastOpenBracket;
        }
    }

}
