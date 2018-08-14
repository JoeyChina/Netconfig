package joey;

public class Dnsmasq {
    String name;
    String domainneeded;
    String boguspriv;
    String filterwin2k;
    String localise_queries;
    String rebind_protection;
    String rebind_localhost;
    String local;
    String domain;
    String expandhosts;
    String nonegcache;
    String authoritative;
    String readethers;
    String leasefile;
    String resolvfile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainneeded() {
        return domainneeded;
    }

    public void setDomainneeded(String domainneeded) {
        this.domainneeded = domainneeded;
    }

    public String getBoguspriv() {
        return boguspriv;
    }

    public void setBoguspriv(String boguspriv) {
        this.boguspriv = boguspriv;
    }

    public String getFilterwin2k() {
        return filterwin2k;
    }

    public void setFilterwin2k(String filterwin2k) {
        this.filterwin2k = filterwin2k;
    }

    public String getLocalise_queries() {
        return localise_queries;
    }

    public void setLocalise_queries(String localise_queries) {
        this.localise_queries = localise_queries;
    }

    public String getRebind_protection() {
        return rebind_protection;
    }

    public void setRebind_protection(String rebind_protection) {
        this.rebind_protection = rebind_protection;
    }

    public String getRebind_localhost() {
        return rebind_localhost;
    }

    public void setRebind_localhost(String rebind_localhost) {
        this.rebind_localhost = rebind_localhost;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getExpandhosts() {
        return expandhosts;
    }

    public void setExpandhosts(String expandhosts) {
        this.expandhosts = expandhosts;
    }

    public String getNonegcache() {
        return nonegcache;
    }

    public void setNonegcache(String nonegcache) {
        this.nonegcache = nonegcache;
    }

    public String getAuthoritative() {
        return authoritative;
    }

    public void setAuthoritative(String authoritative) {
        this.authoritative = authoritative;
    }

    public String getReadethers() {
        return readethers;
    }

    public void setReadethers(String readethers) {
        this.readethers = readethers;
    }

    public String getLeasefile() {
        return leasefile;
    }

    public void setLeasefile(String leasefile) {
        this.leasefile = leasefile;
    }

    public String getResolvfile() {
        return resolvfile;
    }

    public void setResolvfile(String resolvfile) {
        this.resolvfile = resolvfile;
    }


    public String toString() {
        StringBuffer SS = new StringBuffer();
        SS.append("\nconfig dnsmasq");
        if (null != name) {
            SS.append(" " + name);
        }

        if (null != domainneeded) {
            SS.append("\n\toption domainneeded " + domainneeded);
        }
        if (null != boguspriv) {
            SS.append("\n\toption boguspriv " + boguspriv);
        }
        if (null != filterwin2k) {
            SS.append("\n\toption filterwin2k " + filterwin2k);
        }
        if (null != localise_queries) {
            SS.append("\n\toption localise_queries " + localise_queries);
        }
        if (null != rebind_protection) {
            SS.append("\n\toption rebind_protection " + rebind_protection);
        }
        if (null != rebind_localhost) {
            SS.append("\n\toption rebind_localhost " + rebind_localhost);
        }
        if (null != local) {
            SS.append("\n\toption local " + local);
        }
        if (null != domain) {
            SS.append("\n\toption domain " + domain);
        }
        if (null != expandhosts) {
            SS.append("\n\toption expandhosts " + expandhosts);
        }
        if (null != nonegcache) {
            SS.append("\n\toption nonegcache " + nonegcache);
        }
        if (null != authoritative) {
            SS.append("\n\toption authoritative " + authoritative);
        }
        if (null != readethers) {
            SS.append("\n\toption readethers " + readethers);
        }
        if (null != leasefile) {
            SS.append("\n\toption leasefile " + leasefile);
        }
        if (null != resolvfile) {
            SS.append("\n\toption resolvfile " + resolvfile);
        }

        SS.append("\n");

    return SS.toString();
    }

}
