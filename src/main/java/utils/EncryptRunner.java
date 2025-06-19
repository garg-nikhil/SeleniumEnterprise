package utils;

// This class is used to run the encryption utility for passwords.

public class EncryptRunner {

  public static void main(String[] args) {
    // System.setProperty("ENCRYPTION_KEY", ""); // for local only
    String encrypted = PasswordEncryptor.encrypt("");
    System.out.println("Encrypted: " + encrypted);
  }
}
