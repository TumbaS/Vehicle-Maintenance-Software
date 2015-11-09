/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Miloš Urbanović
 */
public class Language {

    private String langName;
    private String langCode;
    private String countryCode;

    public Language() {
    }

    public Language(String langName, String langCode, String countryCode) {
        this.langName = langName;
        this.langCode = langCode;
        this.countryCode = countryCode;
    }
    
    

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        return langName;
    }

}
