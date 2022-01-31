package com.techelevator.language;

public class LanguageApp {

    public static void main(String[] args) {
        SalutationTranslator translator = new SalutationTranslator();

        System.out.println(translator.getGreeting("Spanish"));

        translator.setDefaultLanguage("Spanish");
        System.out.println(translator.getGreeting());

        SalutationTranslator t2 = new SalutationTranslator();
        System.out.println(t2.getGreeting());
        System.out.println(t2.getGreeting(null));

    }
}
