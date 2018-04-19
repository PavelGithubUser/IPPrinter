package ru.otr.ip.app;

import ru.otr.ip.IPAddres;
import ru.otr.ip.IPValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        List<String> firstIPTerms;
        List<String> secondIPTerms;

        while (true) {
            logger.info("Set first IP.");
            if ((firstIPTerms = validiteAndPars()) != null) {
                break;
            }
        }

        while (true) {
            logger.info("Set second IP.");
            if ((secondIPTerms = validiteAndPars()) != null) {
                break;
            }
        }

        IPAddres firsIPAddres = new IPAddres(firstIPTerms);
        IPAddres secondIPAddres = new IPAddres(secondIPTerms);
        firsIPAddres.inc();
        if (firsIPAddres.isGreater(secondIPAddres)) {
            logger.info("The range is too small or incorrect.");
        }
        while (!firsIPAddres.equals(secondIPAddres)) {
            firsIPAddres.print();
            firsIPAddres.inc();
        }
        return;
    }

    public static List<String> validiteAndPars() {
        Scanner in = new Scanner(System.in);
        IPValidator validator = new IPValidator();
        String ipAdress = in.nextLine();
        List<String> ipTerms = Arrays.asList(ipAdress.split(Pattern.quote(".")));
        if (!validator.validate(ipTerms)) {
            logger.info("Incorrect ip.");
            return null;
        }
        return ipTerms;
    }

}
