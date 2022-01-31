package com.techelevator.language;

public class LanguageApp {

    public static void main(String[] args) {
        SalutationTranslator translator = new SalutationTranslator();

        System.out.println(translator.getGreeting(null));
    }
}
