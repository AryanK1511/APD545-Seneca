package com.apd.workshop03.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User {
    private String username;
    private String hashedPassword;

    public User(String username, String password) {
        this.username = username;
        this.hashedPassword = hashPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setPassword(String password) {
        this.hashedPassword = hashPassword(password);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkPassword(String password) {
        String hashedInput = hashPassword(password); // Hash the input password
        return hashedInput.equals(this.hashedPassword);
    }
}
