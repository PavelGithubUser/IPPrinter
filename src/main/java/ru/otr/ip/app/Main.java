package ru.otr.ip.app;

import ru.otr.ip.IPAddres;
import ru.otr.ip.IPValidator;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String[] parsFirstIP;
        String[] parsSecondIP;

        while (true) {
            System.out.println("Set first IP.");
            if ((parsFirstIP = validiteAndPars()) != null) {
                break;
            }
        }

        while (true) {
            System.out.println("Set second IP.");
            if ((parsSecondIP = validiteAndPars()) != null) {
                break;
            }
        }

        IPAddres firsIPAddres = new IPAddres(parsFirstIP);
        IPAddres secondIPAddres = new IPAddres(parsSecondIP);
        firsIPAddres.inc();
        if (firsIPAddres.isMore(secondIPAddres)) {
            System.out.println("The range is too small or incorrect.");
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
            System.out.println("Incorrect ip.");
            return null;
        }
        return ipTerms;
    }

}
