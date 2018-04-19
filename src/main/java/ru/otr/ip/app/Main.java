package ru.otr.ip.app;

import ru.otr.ip.IPAddres;
import ru.otr.ip.IPValidator;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.Pattern;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String[] parsFirstIP;
        String[] parsSecondIP;

        while (true) {
            logger.info("Set first IP.");
            if ((parsFirstIP = validiteAndPars()) != null) {
                break;
            }
        }

        while (true) {
            logger.info("Set second IP.");
            if ((parsSecondIP = validiteAndPars()) != null) {
                break;
            }
        }

        IPAddres firsIPAddres = new IPAddres(parsFirstIP);
        IPAddres secondIPAddres = new IPAddres(parsSecondIP);
        firsIPAddres.inc();
        if (firsIPAddres.isMore(secondIPAddres)) {
            logger.info("The range is too small or incorrect.");
        }
        while (!firsIPAddres.compareIP(secondIPAddres)) {
            firsIPAddres.print();
            firsIPAddres.inc();
        }
        return;


    }

    public static String[] validiteAndPars() {
        Scanner in = new Scanner(System.in);
        IPValidator validator = new IPValidator();
        String ipAdress = in.nextLine();
        String[] ipTerms = ipAdress.split(Pattern.quote("."));
        if (!validator.validate(ipTerms)) {
            logger.info("Incorrect ip.");
            return null;
        }
        return ipTerms;
    }

}
