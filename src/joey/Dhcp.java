package joey;

public class Dhcp {
    String name;
    String interFace;
    String start;
    String limit;
    String leasetime;
    String ignore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterFace() {
        return interFace;
    }

    public void setInterFace(String interFace) {
        this.interFace = interFace;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getLeasetime() {
        return leasetime;
    }

    public void setLeasetime(String leasetime) {
        this.leasetime = leasetime;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

    public String toString() {
        StringBuffer SS = new StringBuffer();
        SS.append("\nconfig dhcp");
        if (null != name) {
            SS.append(" " + name);
        }

        if (null != interFace) {
            SS.append("\n\toption interface " + interFace);
        }

        if (null != start) {
            SS.append("\n\toption start " + start);
        }
        if (null != limit) {
            SS.append("\n\toption limit " + limit);
        }
        if (null != leasetime) {
            SS.append("\n\toption leasetime " + leasetime);
        }
        if (null != ignore) {
            SS.append("\n\toption ignore " + ignore);
        }

        SS.append("\n");
        return SS.toString();
    }


}
