package joey;

import java.util.ArrayList;

public class Wifi_device {
    String name;
    String type;
    String hwmode;
    String txpower;
    String path;
    String disabled;
    String channel;
    String htmode;
    ArrayList<String> ht_capabs = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHwmode() {
        return hwmode;
    }

    public void setHwmode(String hwmode) {
        this.hwmode = hwmode;
    }

    public String getTxpower() {
        return txpower;
    }

    public void setTxpower(String txpower) {
        this.txpower = txpower;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getHtmode() {
        return htmode;
    }

    public void setHtmode(String htmode) {
        this.htmode = htmode;
    }

    public ArrayList<String> getHt_capabs() {
        return ht_capabs;
    }

    public void addHt_capabs(String ht_capab) {
        this.ht_capabs.add(ht_capab);
    }


    public String toString() {
        StringBuffer SS = new StringBuffer();
        SS.append("\nconfig wifi-device");
        if (null != name) {
            SS.append(" " + name);
        }

        if (null != type) {
            SS.append("\n\toption type " + type);
        }
        if (null != hwmode) {
            SS.append("\n\toption hwmode " + hwmode);
        }
        if (null != txpower) {
            SS.append("\n\toption txpower " + txpower);
        }
        if (null != path) {
            SS.append("\n\toption path " + path);
        }

        if (ht_capabs.size() > 0)
            for (int i = 0; i < ht_capabs.size(); i++) {
                SS.append("\n\tlist ht_capab " + ht_capabs.get(i));
            }


        if (null != disabled) {
            SS.append("\n\toption disabled " + disabled);
        }
        if (null != channel) {
            SS.append("\n\toption channel " + channel);
        }
        if (null != htmode) {
            SS.append("\n\toption htmode " + htmode);
        }
        SS.append("\n");
        return SS.toString();
    }
}
