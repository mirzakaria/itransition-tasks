import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Hashing {
    public static String findHexDigits(String path) throws IOException, NoSuchAlgorithmException {
        Path filePath = Path.of("task2/" + path);  // Replace with your file path
        byte[] data = Files.readAllBytes(filePath);
        MessageDigest md = MessageDigest.getInstance("SHA3-256");
        byte[] result = md.digest(data);
        String hexString = new String();

        for (int i = 0; i < result.length; i++) {
            String hex = Integer.toHexString(0xFF & result[i]);
            if (hex.length() == 1) {
                hexString += "0";
            }
            hexString += hex;
        }
        return hexString;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String[] allHashes = new String[256];
        File folder = new File("task2");;

        File[] files = folder.listFiles();
        int i = 0;
        for (File file : files) {
            if (file.isFile()) {
                allHashes[i] = findHexDigits(file.getName());
                i++;
            }
        }
        Arrays.sort(allHashes);

        StringBuilder sb = new StringBuilder(new String());
        for (String s: allHashes) {
            sb.append(s);
        }
        sb.append("mir.zakaria02@gmail.com");
        System.out.println(sb.toString());

        MessageDigest md = MessageDigest.getInstance("SHA3-256");
        byte[] result = md.digest(sb.toString().getBytes());

        String hexString = "";

        for (i = 0; i < result.length; i++) {
            String hex = Integer.toHexString(0xFF & result[i]);
            if (hex.length() == 1) {
                hexString += "0";
            }
            hexString += hex;
        }

        System.out.println(hexString.toString());

//        1d956676b2cb47d5c1ade26821971016e636c02eec9e2ed4bc2f4a319127fa77

    }
}