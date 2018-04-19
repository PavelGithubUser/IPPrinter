package ru.otr.ip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otr.ip.app.Application;

import java.util.ArrayList;
import java.util.List;

public class IPAddres {
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    private List<Integer> ipAdrres = new ArrayList<Integer>();

    public IPAddres(List<String> ipAdrres) {
        for (String item : ipAdrres) {
            this.ipAdrres.add(Integer.parseInt(item));
        }
    }

    public boolean equals(IPAddres ipAddres) {
        for (int i = 0; i < this.ipAdrres.size(); i++) {
            if (this.ipAdrres.get(i) != ipAddres.getIpAdrres().get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isGreater(IPAddres ipAddres) {
        for (int i = 0; i < this.ipAdrres.size(); i++) {
            if (this.ipAdrres.get(i) < ipAddres.getIpAdrres().get(i)) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < this.ipAdrres.size(); i++) {
            System.out.print(this.ipAdrres.get(i));
            if (i < this.ipAdrres.size() - 1) {
                System.out.print(".");
            }
        }
        System.out.println();
    }

    public void inc() {
        int partIndex = ipAdrres.size() - 1;
        while (partIndex >= 0) {
            if (ipAdrres.get(partIndex) < 255) {
                ipAdrres.set(partIndex, ipAdrres.get(partIndex) + 1);
                return;
            } else {
                ipAdrres.set(partIndex, 0);
                partIndex--;
            }
        }
        for (int i = 0; i < ipAdrres.size(); i++) {
            ipAdrres.set(i, 255);
        }
        logger.info("The increase is impossible.");
    }

    public List<Integer> getIpAdrres() {
        return ipAdrres;
    }

    public void setIpAdrres(List<Integer> ipAdrres) {
        this.ipAdrres = ipAdrres;
    }
}
