package encryptdecrypt;

public class Coder {
  StringBuilder output = new StringBuilder();
  final int ALPHABET_LEN = 26;
  final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

  public void encode(Message m) {
    if (m.getMode().equals("dec")) {
      m.setData(decrypt(m.getData(), m.getKey(), m.getAlgorithm()));
    } else {
      m.setData(encrypt(m.getData(), m.getKey(), m.getAlgorithm()));
    }
  }

  private String encrypt(String input, int key, String alg) {
    for (int i = 0; i < input.length(); i++) {
      if (alg.equals("unicode")) {
        char ch = input.charAt(i);
        ch += key;
        output.append(ch);
      } else {
        if (input.charAt(i) == ' ') {
          output.append(input.charAt(i));
        } else {
          int j = 0;
          while (input.charAt(i) != ALPHABET.charAt(j)) {
            j++;
          }
          char ch = ALPHABET.charAt((j + key) % ALPHABET_LEN);
          output.append(ch);
        }
      }
    }
    return output.toString();
  }

  private String decrypt(String input, int key, String alg) {
    if (alg.equals("unicode")) {
      for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        ch -= key;
        output.append(ch);
      }
    } else {
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) == ' ') {
          output.append(input.charAt(i));
        } else {
          int j = 0;
          while (input.charAt(i) != ALPHABET.charAt(j)) {
            j++;
          }
          char ch = ALPHABET.charAt((j - key + ALPHABET_LEN) % ALPHABET_LEN);
          output.append(ch);
        }
      }
    }
    return output.toString();
  }
}
