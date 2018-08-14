package joey;

public class FW_forwarding {
    String src;
    String dest;

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

    public String toString() {
        StringBuffer SS = new StringBuffer();
        SS.append("\nconfig forwarding");
        if (null != src) {
            SS.append("\n\toption src " + src);
        }

        if (null != dest) {
            SS.append("\n\toption dest " + dest);
        }

        SS.append("\n\n");
        return SS.toString();
    }
}
