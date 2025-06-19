package utils;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class PasswordEncryptor {
  // This utility class provides methods to encrypt and decrypt passwords using AES encryption.

  private static final String ALGORITHM = "AES";

  // ✅ Secure this key via environment variable or Jenkins/GitHub secrets
  private static final String ENCRYPTION_KEY = System.getenv("ENCRYPTION_KEY");

  public static String encrypt(String plainText) {
    try {
      if (ENCRYPTION_KEY == null || ENCRYPTION_KEY.length() < 16) {
        throw new IllegalStateException("ENCRYPTION_KEY is missing or invalid.");
      }
      SecretKeySpec keySpec = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), ALGORITHM);
      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, keySpec);
      byte[] encrypted = cipher.doFinal(plainText.getBytes());
      return Base64.getEncoder().encodeToString(encrypted);
    } catch (Exception e) {
      throw new RuntimeException("Error while encrypting password", e);
    }
  }

  public static String decrypt(String encryptedText) {
    try {
      SecretKeySpec keySpec = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), ALGORITHM);
      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.DECRYPT_MODE, keySpec);
      byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
      return new String(decrypted);
    } catch (Exception e) {
      throw new RuntimeException("Error while decrypting password", e);
    }
  }
}
