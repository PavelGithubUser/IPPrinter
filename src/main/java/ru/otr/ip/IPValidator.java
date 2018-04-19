package ru.otr.ip;

import java.util.List;

public class IPValidator {
    private final int amouantcNumbers = 4;

    public boolean validate(List<String> parsIP) {
        return (parsIP.size() == amouantcNumbers && validatePartsIP(parsIP));
    }

    private boolean validatePartsIP(List<String> parsIP) {
        for (String item : parsIP) {
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