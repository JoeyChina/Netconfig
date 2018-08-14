package joey;

import java.util.ArrayList;
import java.util.HashMap;

public class ConfigBean {
    ArrayList<HashMap> optionArray = new ArrayList<>();
    ArrayList<HashMap> listArray = new ArrayList<>();

    public ArrayList<HashMap> getOptionArray() {
        return optionArray;
    }

    public void addOptionArray(HashMap option) {
        this.optionArray.add(option);
    }

    public ArrayList<HashMap> getListArray() {
        return listArray;
    }

    public void addListArray(HashMap list) {
        this.listArray.add(list);
    }

    public String toString() {
        StringBuffer SS = new StringBuffer();

        String config = null;
        config = (String) optionArray.get(0).get("config");

        if (config != null && config.trim().length() > 0) {
            SS.append("\nconfig " + config);

            String defname = (String) optionArray.get(1).get("defname");
            if (defname != null && defname.trim().length() > 0)
                SS.append("\t" + defname.trim());

            //index 0 存放 config name,1 defname
            for (int j = 2; j < optionArray.size(); j++) {
                SS.append("\n\toption " + (String) optionArray.get(j).get("key") + "\t\t" + (String) optionArray.get(j).get("value"));
//                SS.append("\n\toption " + (String) optionArray.get(j).get("key") + "\t\t" +ValueFormat.format((String) optionArray.get(j).get("value")) );
            }

            for (int j = 0; j < listArray.size(); j++) {
                SS.append("\n\tlist " + (String) listArray.get(j).get("key") + "\t\t" + (String) listArray.get(j).get("value"));
            }
            SS.append("\n\n");
        }


        return SS.toString();
    }

}
