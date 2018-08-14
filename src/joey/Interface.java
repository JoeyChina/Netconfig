package joey;

/*
config interface 'lan'
        option ifname 'eth0.1'
        option type 'bridge'
        option proto 'static'
        option ipaddr '192.168.10.1'
        option netmask '255.255.255.0'
        option hostname 'CanallB2A6B7'
        */
public class Interface {
    private String name;
    private String ifname;
    private String type;
    private String proto;
    private String ipaddr;
    private String netmask;
    private String hostname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIfname() {
        return ifname;
    }

    public void setIfname(String ifname) {
        this.ifname = ifname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String toString() {
        StringBuffer SS = new StringBuffer();
        SS.append("\nconfig interface");
        if (null != name) {
            SS.append(" " + name);
        }

        if (null != ifname) {
            SS.append("\n\toption ifname " + ifname);
        }
        if (null != type) {
            SS.append("\n\toption type " + type);
        }
        if (null != proto) {
            SS.append("\n\toption proto " + proto);
        }
        if (null != ipaddr) {
            SS.append("\n\toption ipaddr " + ipaddr);
        }
        if (null != netmask) {
            SS.append("\n\toption netmask " + netmask);
        }
        if (null != hostname) {
            SS.append("\n\toption hostname " + hostname);
        }
        SS.append("\n");

        return SS.toString();
    }
}
