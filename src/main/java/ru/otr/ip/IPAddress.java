package ru.otr.ip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otr.ip.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class IPAddress {
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    private List<Integer> ipAddrress = new ArrayList<Integer>();

    public IPAddress(List<String> ipAddrressTerms) {
        for (String item : ipAddrressTerms) {
            this.ipAddrress.add(Integer.parseInt(item));
        }
    }

    public boolean isGreater(IPAddress ipAddress) {
        for (int i = 0; i < this.ipAddrress.size(); i++) {
            if (this.ipAddrress.get(i) < ipAddress.getIpAddrress().get(i)) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < this.ipAddrress.size(); i++) {
            System.out.print(this.ipAddrress.get(i));
            if (i < this.ipAddrress.size() - 1) {
                System.out.print(".");
            }
        }
        System.out.println();
    }

    public void increment() {
        final IPAddress MAX_IP_ADDRESS = new IPAddress(Arrays.asList("255.255.255.255".split(Pattern.quote("."))));
        int partIndex = ipAddrress.size() - 1;
        while (partIndex >= 0) {
            if (ipAddrress.get(partIndex) < 255) {
                ipAddrress.set(partIndex, ipAddrress.get(partIndex) + 1);
                return;
            } else {
                ipAddrress.set(partIndex, 0);
                partIndex--;
            }
        }
        this.ipAddrress = MAX_IP_ADDRESS.getIpAddrress();
        logger.info("The increase is impossible.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IPAddress ipAddress = (IPAddress) o;

        return ipAddrress != null ? ipAddrress.equals(ipAddress.ipAddrress) : ipAddress.ipAddrress == null;
    }

    @Override
    public int hashCode() {
        return ipAddrress != null ? ipAddrress.hashCode() : 0;
    }

    public List<Integer> getIpAddrress() {
        return ipAddrress;
    }

    public void setIpAddrress(List<Integer> ipAddrress) {
        this.ipAddrress = ipAddrress;
    }
}
