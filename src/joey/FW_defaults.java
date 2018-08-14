package joey;

public class FW_defaults {
    String syn_flood;
    String input;
    String output;
    String forward;

    public String getSyn_flood() {
        return syn_flood;
    }

    public void setSyn_flood(String syn_flood) {
        this.syn_flood = syn_flood;
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

    public String toString() {
        StringBuffer SS = new StringBuffer();
        SS.append("\nconfig defaults");
        if (null != syn_flood) {
            SS.append("\n\toption syn_flood " + syn_flood);
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

        SS.append("\n");
        return SS.toString();
    }
}
