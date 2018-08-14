package joey;

public class Wifi_iface {
    String name;
    String device;
    String network;
    String mode;
    String encryption;
    String key;
    String ssid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String toString() {
        StringBuffer SS = new StringBuffer();
        SS.append("\nconfig wifi-iface");
        if (null != name) {
            SS.append(" " + name);
        }

        if (null != device) {
            SS.append("\n\toption device " + device);
        }
        if (null != network) {
            SS.append("\n\toption network " + network);
        }
        if (null != mode) {
            SS.append("\n\toption mode " + mode);
        }
        if (null != encryption) {
            SS.append("\n\toption encryption " + encryption);
        }
        if (null != key) {
            SS.append("\n\toption key " + key);
        }
        if (null != ssid) {
            SS.append("\n\toption ssid " + ssid);
        }
        SS.append("\n\n");
        return SS.toString();
    }

}
