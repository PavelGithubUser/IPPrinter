package com;

public class IPAddres {
    private int[] ipAdrres = new int[4];

    public IPAddres(String[] ipAdrress) {
        for (int i = 0; i < ipAdrress.length; i++) {
            this.ipAdrres[i] = Integer.parseInt(ipAdrress[i]);
        }
    }

    public boolean compareIP(IPAddres ipAddress) {
        for (int i = 0; i < this.ipAdrres.length; i++) {
            if (this.ipAdrres[i] != ipAddress.getIpAdrres()[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isMore(IPAddres ipAddress) {
        for (int i = 0; i < this.ipAdrres.length; i++) {
            if (this.ipAdrres[i] < ipAddress.getIpAdrres()[i]) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < this.ipAdrres.length; i++) {
            System.out.print(this.ipAdrres[i]);
            if (i < this.ipAdrres.length - 1) {
                System.out.print(".");
            }
        }
        System.out.println();
    }

    public void inc() {
        int part = ipAdrres.length - 1;
        while (part >= 0) {
            if (ipAdrres[part] < 255) {
                ipAdrres[part]++;
                return;
            } else {
                ipAdrres[part] = 0;
                part--;
            }
        }
        for (int i = 0; i < ipAdrres.length; i++) {
            ipAdrres[i] = 255;
        }
        System.out.println("The increase is impossible.");
    }

    public int[] getIpAdrres() {
        return ipAdrres;
    }

    public void setIpAdrres(int[] ipAdrres) {
        this.ipAdrres = ipAdrres;
    }
}
