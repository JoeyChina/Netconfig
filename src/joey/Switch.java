package joey;

import java.util.ArrayList;

public class Switch {
    private String name;
    private String reset;
    private String enable_vlan;
    private ArrayList<Switch_vlan> switch_vlans = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReset() {
        return reset;
    }

    public void setReset(String reset) {
        this.reset = reset;
    }

    public String getEnable_vlan() {
        return enable_vlan;
    }

    public void setEnable_vlan(String enable_vlan) {
        this.enable_vlan = enable_vlan;
    }

    public ArrayList<Switch_vlan> getSwitch_vlans() {
        return switch_vlans;
    }

    public void addSwitch_vlans(Switch_vlan switch_vlan) {
        this.switch_vlans.add(switch_vlan);
    }


    public String toString() {
        StringBuffer SS = new StringBuffer();
        SS.append("\nconfig switch");
        if (null != name) {
            SS.append("\n\toption name " + name);
        }

        if (null != reset) {
            SS.append("\n\toption reset " + reset);
        }

        if (null != enable_vlan) {
            SS.append("\n\toption enable_vlan " + enable_vlan);
        }
        if (switch_vlans != null && switch_vlans.size() > 0) {
            SS.append("\n");

            for (int i = 0; i < switch_vlans.size(); i++) {
                String sName = switch_vlans.get(i).getName();
                String sDevice = switch_vlans.get(i).getDevice();
                String sVlan = switch_vlans.get(i).getVlan();
                String sVid = switch_vlans.get(i).getVid();
                String sPorts = switch_vlans.get(i).getPorts();

                SS.append("\nconfig switch_vlan");
                if (null != sName) {
                    SS.append(" " + sName);
                }
                if (null != sDevice) {
                    SS.append("\n\toption device " + sDevice);
                }

                if (null != sVlan) {
                    SS.append("\n\toption vlan " + sVlan);
                }

                if (null != sVid) {
                    SS.append("\n\toption vid " + sVid);
                }

                if (null != sPorts) {
                    SS.append("\n\toption ports " + sPorts);
                }
                SS.append("\n");
            }
        }
        SS.append("\n");

        return SS.toString();
    }
}
