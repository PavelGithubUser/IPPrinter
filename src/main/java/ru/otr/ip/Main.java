package ru.otr.ip;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);

            System.out.println("Set first IP.");
            String firstIP = in.nextLine();

            System.out.println("Set second IP.");
            String secondIP = in.nextLine();

            String[] parsFirstIP = firstIP.split(Pattern.quote("."));
            String[] parsSecondIP = secondIP.split(Pattern.quote("."));
            IPValidator validator = new IPValidator();

            if (validator.validate(parsFirstIP) && validator.validate(parsSecondIP)) {
                IPAddres firsIPAddres = new IPAddres(parsFirstIP);
                IPAddres secondIPAddres = new IPAddres(parsSecondIP);
                firsIPAddres.inc();
                if (firsIPAddres.isMore(secondIPAddres)) {
                    System.out.println("The range is too small or incorrect.");
                    continue;
                }
                while (!firsIPAddres.compareIP(secondIPAddres)) {
                    firsIPAddres.print();
                    firsIPAddres.inc();
                }
                return;
            } else {
                System.out.println("One or both of the IP addresses are not valid.");
            }
        }

    }

}
