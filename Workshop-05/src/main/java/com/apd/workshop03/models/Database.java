package com.apd.workshop03.models;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final Map<String, User> users = new HashMap<>();
    private static User currentUser;

    private Database() {}

    public static void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static User getUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        return null; // Return null if user not found or password doesn't match
    }

    public static void removeUser(String username) {
        users.remove(username);
    }

    public static Map<String, User> getAllUsers() {
        return users;
    }
}
