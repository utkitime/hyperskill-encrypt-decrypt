package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Helper {
  static String readFile(String pathToFile) {
    File file = new File(pathToFile);
    String data = "";

    try (Scanner scanner = new Scanner(file)) {
      data = scanner.nextLine();
    } catch (FileNotFoundException e) {
      System.out.println("No file found: " + pathToFile);
    }
    return data;
  }

  static void writeToFile(String pathToFile, String textToWrite) {
    File file = new File(pathToFile);

    try (FileWriter writer = new FileWriter(file)) {
      writer.write(textToWrite);
    } catch (IOException e) {
      System.out.printf("An exception occurs %s", e.getMessage());
    }
  }
}
