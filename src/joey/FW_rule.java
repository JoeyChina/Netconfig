package joey;

import java.util.ArrayList;

public class FW_rule {
    String name;
    String src;
    String dest;
    String proto;
    String limit;
    String icmp_type;
    String src_ip;
    String src_port;
    String dest_ip;
    String dest_port;
    String family;
    String target;
    ArrayList<String> icmp_typeList =new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc_ip() {
        return src_ip;
    }

    public void setSrc_ip(String src_ip) {
        this.src_ip = src_ip;
    }

    public String getSrc_port() {
        return src_port;
    }

    public void setSrc_port(String src_port) {
        this.src_port = src_port;
    }

    public String getDest_ip() {
        return dest_ip;
    }

    public void setDest_ip(String dest_ip) {
        this.dest_ip = dest_ip;
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public String getDest_port() {
        return dest_port;
    }

    public void setDest_port(String dest_port) {
        this.dest_port = dest_port;
    }

    public String getIcmp_type() {
        return icmp_type;
    }

    public void setIcmp_type(String icmp_type) {
        this.icmp_type = icmp_type;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public ArrayList<String> getIcmp_typeList() {
        return icmp_typeList;
    }

    public void addIcmp_typeList(String icmp_type) {
        this.icmp_typeList.add(icmp_type);
    }

    public String toString() {
        StringBuffer SS = new StringBuffer();
        SS.append("\nconfig rule");

        if (null != name) {
            SS.append("\n\toption name " + name);
        }
        if (null != src) {
            SS.append("\n\toption src " + src);
        }
        if (null != dest) {
            SS.append("\n\toption dest " + dest);
        }
        if (null != proto) {
            SS.append("\n\toption proto " + proto);
        }
        if (null != src_ip) {
            SS.append("\n\toption src_ip " + src_ip);
        }
        if (null != src_port) {
            SS.append("\n\toption src_port " + src_port);
        }
        if (null != dest_ip) {
            SS.append("\n\toption dest_ip " + dest_ip);
        }
        if (null != dest_port) {
            SS.append("\n\toption dest_port " + dest_port);
        }

        if(null != icmp_type){
            SS.append("\n\toption icmp_type " + icmp_type);
        }
        if(icmp_typeList.size()>0)
            for(int i=0;i<icmp_typeList.size(); i++){
                SS.append("\n\tlist icmp_type " + icmp_typeList.get(i));
            }
        if (null != limit) {
            SS.append("\n\toption limit " + limit);
        }
        if (null != family) {
            SS.append("\n\toption family " + family);
        }
        if (null != target) {
            SS.append("\n\toption target " + target);
        }

        SS.append("\n\n");
        return SS.toString();
    }
}
