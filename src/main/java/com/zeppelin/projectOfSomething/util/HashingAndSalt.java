package com.zeppelin.projectOfSomething.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64.Encoder;
import java.util.Objects;

/**
 * The type Hashing and salt.
 *
 * @author eddie
 */
public class HashingAndSalt {

  private static SecureRandom sr = null;
  private static SecretKeyFactory sf = null;
  private static final String WINDOWS = "Windows";
  private static final Encoder ENCODER = java.util.Base64.getEncoder();
  private static final String OS_NAME = System.getProperties().getProperty("os.name");

  static {
    initSecureRandom();
    initSecretKeyFactory();
  }

  /**
   * Init secure random.
   */
  public synchronized static void initSecureRandom() {
    try {
      //for windows not the no blocking params
      if (OS_NAME != null && OS_NAME.contains(WINDOWS)) {
        sr = SecureRandom.getInstanceStrong();
        return;
      }
      sr = SecureRandom.getInstance("NativePRNGNonBlocking");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

  /**
   * Init secret key factory.
   */
  public synchronized static void initSecretKeyFactory() {
    try {
      sf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets random salt.
   *
   * @return the random salt
   */
  public static String getRandomSalt() {
    if (sr == null) {
      initSecureRandom();
    }
    return ENCODER.encodeToString(sr.generateSeed(16));
  }

  /**
   * Generate encoded password string.
   *
   * @param password the password
   * @param salt     the random salt
   * @return the string
   */
  public static String generateEncodedPassword(String password, String salt) {
    try {
      if (sf == null) {
        initSecretKeyFactory();
      }
      KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(),
              1000, 128);
      byte[] encodedPasswordByte = sf.generateSecret(spec).getEncoded();
      return ENCODER.encodeToString(encodedPasswordByte);
    } catch (InvalidKeySpecException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Verify password.
   *
   * @param password the input password
   * @param salt     the salt in table
   * @param hashing  the hashing password in table
   * @return the boolean
   */
  public static boolean verifyPassword(String password, String salt,
                                       String hashing) {
    if (password == null) {
      return false;
    }
    String encodedPassword = generateEncodedPassword(password, salt);
    return encodedPassword != null && Objects.equals(encodedPassword, hashing);
  }
}
