package io.testomat.utils;

import org.jspecify.annotations.NonNull;

public class StringParsers {
    @NonNull
    public static Integer parseIntegerFromString(String targetText){
        String textWithDigit = targetText.replaceAll("\\D+", "");
        return Integer.parseInt(textWithDigit);
    }
}
