package ru.otr.ip;

import java.util.List;

public class IPValidator {
    private final int IP_SECTIONS_COUNT = 4;

    public boolean isValid(List<String> parseIP) {
        return (parseIP.size() == IP_SECTIONS_COUNT && validateIPTerms(parseIP));
    }

    private boolean validateIPTerms(List<String> ipTerms) {
        try {
            return ipTerms.stream().allMatch(term -> Integer.parseInt(term) >= 0
                    && Integer.parseInt(term) <= 255
                    && term.length() < 4);
        } catch (NumberFormatException e) {
            return false;
        }
    }

}