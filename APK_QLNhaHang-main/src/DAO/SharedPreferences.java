/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.prefs.Preferences;

/**
 *
 * @author Admin
 */
public class SharedPreferences {

    private static final String USER_KEY = "user";
    private static final String PASS_KEY = "pass";

    public static void saveCredentials(String user, String pass) {
        Preferences prefs = Preferences.userNodeForPackage(SharedPreferences.class);
        prefs.put(USER_KEY, user);
        prefs.put(PASS_KEY, pass);
    }

    public static String getUser() {
        Preferences prefs = Preferences.userNodeForPackage(SharedPreferences.class);
        return prefs.get(USER_KEY, null);
    }

    public static String getPassword() {
        Preferences prefs = Preferences.userNodeForPackage(SharedPreferences.class);
        return prefs.get(PASS_KEY, null);
    }

    public static void clearCredentials() {
        Preferences prefs = Preferences.userNodeForPackage(SharedPreferences.class);
        prefs.remove(USER_KEY);
        prefs.remove(PASS_KEY);
    }
}
