package me.mrichards.brainfuckjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BrainfuckInterpreter {

  public static void main(String[] args)
      throws IllegalTokenException, IOException, IllegalArgumentException {
    if (args.length < 2) {
      throw new IllegalArgumentException(
          "Wrong number of arguments. Use -f <file_name>, or -r <code>.");
    }
        Brainfucker brainfucker = new Brainfucker(switch (args[0]) {
            case "-f", "-file" -> Files.readAllLines(Paths.get(args[1])).stream().reduce("", (a, b) -> a + b).trim();
            case "-r", "-raw" -> args[1];
            default -> throw new IllegalArgumentException("Unknown argument " + args[0] + " - use -f <file_name>, or -r <code>.");
        });
        System.out.println(brainfucker.execute());
    }

}
