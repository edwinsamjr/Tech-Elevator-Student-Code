package com.techelevator.language;

import java.util.HashMap;
import java.util.Map;

public class SalutationTranslator {

    private String defaultLanguage = "English";
    private Map<String, String> greetings;

    public SalutationTranslator() {
        greetings = new HashMap<>();

        greetings.put("English", "Hello");
        greetings.put("Spanish", "Hola");
        greetings.put("French", "Bonjour");
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getGreeting() {
        String greeting = this.getGreeting(this.defaultLanguage);
        return greeting;
    }

    public String getGreeting(String language) {
        /*
        if (language == null) {
            return "";
        }


        if (language.equals("English")) {
            return "Hello";
        } else if (language.equals("Spanish")) {
            return "Hola";
        } else if (language.equals("French")) {
            return "Bonjour";
        }

        return "";
        */

        return this.greetings.getOrDefault(language, "");
    }
}
