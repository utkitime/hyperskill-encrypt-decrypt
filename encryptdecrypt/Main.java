package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        Coder coder = new Coder();
        Message message = new Message();

        for (int j = 0; j < args.length; j += 2) {
            switch (args[j]) {
                case "-mode":
                    message.setMode(args[j + 1]);
                    break;
                case "-key":
                    message.setKey(Integer.parseInt(args[j + 1]));
                    break;
                case "-data":
                    message.setData(args[j + 1]);
                    break;
                case "-out":
                    message.setPathToOutFile(args[j + 1]);
                    break;
                case "-in":
                    message.setData(Helper.readFile(args[j + 1]));
                    break;
                case "-alg":
                    message.setAlgorithm(args[j + 1]);
                default:
            }
        }

        coder.encode(message);

        if (message.getPathToOutFile() == null) {
            System.out.println(message.getData());
        } else {
            Helper.writeToFile(message.getPathToOutFile(), message.getData());
        }

    }
}