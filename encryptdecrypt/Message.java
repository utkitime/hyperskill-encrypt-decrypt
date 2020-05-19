package encryptdecrypt;

public class Message {
  private int key = 0;
  private String data = "";
  private String mode = "enc";
  private String algorithm = "shift";
  private String pathToOutFile;

  public void setKey(int key) {
    this.key = key;
  }

  public int getKey() {
    return key;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public String getAlgorithm() {
    return algorithm;
  }

  public String getPathToOutFile() {
    return pathToOutFile;
  }

  public void setPathToOutFile(String pathToOutFile) {
    this.pathToOutFile = pathToOutFile;
  }
}
