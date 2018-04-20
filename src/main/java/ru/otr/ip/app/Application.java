package ru.otr.ip.app;

import ru.otr.ip.IPAddress;
import ru.otr.ip.IPValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    static IPValidator validator = new IPValidator();

    public static void main(String[] args) {
        boolean isIPCombinationValid = false;

        while(!isIPCombinationValid ){
            IPAddress firsIPAddress;
            IPAddress secondIPAddress;

            logger.info("Set first IP.");
            while ((firsIPAddress = getValidInputIP()) == null) {
                logger.error("you provided invalid IP, please try again");
            }

            logger.info("Set second IP.");
            while ((secondIPAddress = getValidInputIP()) == null) {
                logger.info("you provided invalid IP, please try again");
            }

            firsIPAddress.increment();
            if (firsIPAddress.isGreater(secondIPAddress)) {
                logger.info("The range is too small or incorrect.");
            } else {
                while (!firsIPAddress.equals(secondIPAddress)) {
                    firsIPAddress.print();
                    firsIPAddress.increment();
                }
                isIPCombinationValid = true;
            }
        }
    }

    public static IPAddress getValidInputIP() {
        Scanner in = new Scanner(System.in);
        String ipAdress = in.nextLine();
        List<String> ipTerms = Arrays.asList(ipAdress.split(Pattern.quote(".")));
        if (!validator.isValid(ipTerms)) {
            return null;
        }
        return new IPAddress(ipTerms);
    }

}