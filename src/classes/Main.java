/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import gui.LangChooser;
import gui.LoginGUI;
import java.util.Locale;
import java.util.prefs.Preferences;

/**
 *
 * @author Miloš Urbanović
 */
public class Main {

    public static void main(String[] args) {
        Preferences pref = Preferences.userNodeForPackage(Main.class);
        String langCode = pref.get("L_CODE", "NO");
        String countryCode = pref.get("C_CODE", "NO");

        if (langCode.equals("NO")) {
            new LangChooser().setVisible(true);
        } else {
            Locale locale = new Locale(langCode, countryCode);            
            new LoginGUI(locale).setVisible(true);
        }
    }

}
