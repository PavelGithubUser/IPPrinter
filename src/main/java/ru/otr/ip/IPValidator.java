package ru.otr.ip;

public class IPValidator {
    private final int amouantcNumbers = 4;

    public boolean validate(String[] parsIP) {
        if (parsIP.length == amouantcNumbers && validatePartsIP(parsIP)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validatePartsIP(String[] parsIP) {
        for (int i = 0; i < parsIP.length; i++) {
            try {
                if (Integer.parseInt(parsIP[i]) < 0 || Integer.parseInt(parsIP[i]) > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

}