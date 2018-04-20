package ru.otr.ip;

import java.util.List;

public class IPValidator {
    private final int amouantcNumbers = 4;

    public boolean validate(List<String> parseIP) {
        return (parseIP.size() == amouantcNumbers && validatePartsIP(parseIP));
    }

    private boolean validatePartsIP(List<String> parseIP) {
        for (String item : parseIP) {
            try {
                if (Integer.parseInt(item) < 0 || Integer.parseInt(item) > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

}