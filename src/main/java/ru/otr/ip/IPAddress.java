package ru.otr.ip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otr.ip.app.Application;

import java.util.ArrayList;
import java.util.List;

public class IPAddress {
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    private List<Integer> ipAddrress = new ArrayList<Integer>();

    public IPAddress(List<String> ipAddrress) {
        for (String item : ipAddrress) {
            this.ipAddrress.add(Integer.parseInt(item));
        }
    }

    public boolean equals(IPAddress ipAddress) {
        for (int i = 0; i < this.ipAddrress.size(); i++) {
            if (!this.ipAddrress.get(i).equals(ipAddress.getIpAddrress().get(i))) {
                return false;
            }
        }
        return true;
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

    public void inc() {
        final int MAX_IP_ADDRESS = 255;
        int partIndex = ipAddrress.size() - 1;
        while (partIndex >= 0) {
            if (ipAddrress.get(partIndex) < MAX_IP_ADDRESS) {
                ipAddrress.set(partIndex, ipAddrress.get(partIndex) + 1);
                return;
            } else {
                ipAddrress.set(partIndex, 0);
                partIndex--;
            }
        }
        for (int i = 0; i < ipAddrress.size(); i++) {
            ipAddrress.set(i, MAX_IP_ADDRESS);
        }
        logger.info("The increase is impossible.");
    }

    public List<Integer> getIpAddrress() {
        return ipAddrress;
    }

    public void setIpAddrress(List<Integer> ipAddrress) {
        this.ipAddrress = ipAddrress;
    }
}
