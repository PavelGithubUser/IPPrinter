package ru.otr.ip;

import java.util.List;

public class IPValidator {
    private final int amouantcNumbers = 4;

    public boolean isValid(List<String> parseIP) {
        return (parseIP.size() == amouantcNumbers && validateIPTerms(parseIP));
    }

    private boolean validateIPTerms(List<String> ipTerms) {
        try {
            return ipTerms.stream().allMatch(term -> Integer.parseInt(term) > 0 && Integer.parseInt(term) <= 255);
        } catch (NumberFormatException e) {
            return false;
        }
    }

}