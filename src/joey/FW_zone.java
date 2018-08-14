package joey;

import java.util.ArrayList;

public class FW_zone {
    String name;
    String input;
    String output;
    String forward;
    String masq;
    String mtu_fix;
    ArrayList<String> networkList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public String getMasq() {
        return masq;
    }

    public void setMasq(String masq) {
        this.masq = masq;
    }

    public String getMtu_fix() {
        return mtu_fix;
    }

    public void setMtu_fix(String mtu_fix) {
        this.mtu_fix = mtu_fix;
    }

    public ArrayList<String> getNetworkList() {
        return networkList;
    }

    public void addNetworkList(String network) {
        this.networkList.add(network);
    }



    public String toString() {
        StringBuffer SS = new StringBuffer();
        SS.append("\nconfig zone");
        if (null != name) {
            SS.append("\n\toption name " + name);
        }
        if(networkList.size()>0)
            for(int i=0;i<networkList.size(); i++){
                SS.append("\n\tlist network " + networkList.get(i));
            }

        if (null != input) {
            SS.append("\n\toption input " + input);
        }
        if (null != output) {
            SS.append("\n\toption output " + output);
        }

        if (null != forward) {
            SS.append("\n\toption forward " + forward);
        }
        if (null != masq) {
            SS.append("\n\toption masq " + masq);
        }
        if (null != mtu_fix) {
            SS.append("\n\toption mtu_fix " + mtu_fix);
        }

        SS.append("\n\n");
        return SS.toString();
    }
}
