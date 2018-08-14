package joey;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    static String network_path = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\network";
    static String network_save_path = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\network_save";

    static String wireless_path = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\wireless";
    static String wireless_save_path = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\wireless_save";

    static String dhcp_path = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\dhcp";
    static String dhcp_save_path = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\dhcp_save";

    static String firewall_path = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\firewall";
    static String firewall_save_path = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\firewall_save";
    static String firewall_save_path2 = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\firewall_save2";


    static String system_path = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\system";
    static String system_save_path = "C:\\Users\\Administrator\\Desktop\\ap_etc\\etc\\config\\system_save";

    public static void main(String[] args) {
        System.out.print("Test");
//        NetworkConfigParse(network_path);
//        WirelessConfigParse(wireless_path);
//        DhcpConfigParse(dhcp_path);
//        FirewallConfigParse(firewall_path);
//        FirewallConfigParse2(firewall_path);
        ConfigParse(network_path,network_save_path);
        ConfigParse(wireless_path,wireless_save_path);
        ConfigParse(dhcp_path,dhcp_save_path);
        ConfigParse(firewall_path,firewall_save_path);
        ConfigParse(system_path,system_save_path);

    }

    public static ArrayList<ConfigBean> ConfigParse(String path, String outpath) {
        File file = new File(path);
        BufferedReader reader = null;
        String configType = null;

        ConfigBean configBean = null;
        ArrayList<ConfigBean> configs = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String lineString = null;
            while ((lineString = reader.readLine()) != null) {
                System.out.println(lineString);
                if (lineString.trim().length() ==0 || lineString.trim().indexOf('#') == 0) {
                    //被注释的脚本
                    continue;
                }
                String[] tmpStrings = null;
                if (lineString.length() > 0) {
                    //按任意多空格分割
                    tmpStrings = lineString.trim().split("\\s+");
                }

                if(tmpStrings.length>1)
                    if ("config".equals(tmpStrings[0])) {
                        if (configType != null) {
                            //一个节点解析完
                            System.out.print("一个节点解析完\n");

                            if (null != configBean) {
                                configs.add(configBean);
                                configType = null;
                                configBean = null;
                            }
                        }

                        configBean = new ConfigBean();
                        if (tmpStrings.length > 1) {
                            HashMap<String, String> cf_hashMap = new HashMap<>();
                            cf_hashMap.put("config", tmpStrings[1]);
                            configType = tmpStrings[1];
                            configBean.addOptionArray(cf_hashMap);

                            HashMap<String, String> name_hashMap = new HashMap<>();
                            if (tmpStrings.length > 2) {
                                name_hashMap.put("defname", tmpStrings[2]);
                            }else {
                                name_hashMap.put("defname", "");
                            }
                            configBean.addOptionArray(name_hashMap);
                        }
                    } else if ("option".equals(tmpStrings[0].trim())) {
                        if (null != configType) {
                            if (tmpStrings.length > 2) {
                                HashMap<String, String> option_hashMap = new HashMap<>();
                                option_hashMap.put("key", tmpStrings[1]);

                                String valueString = new String();
                                StringBuffer buffer = new StringBuffer();
                                for(int i=2;i<tmpStrings.length;i++){
                                    buffer.append(" "+tmpStrings[i]);
                                }
                                valueString = buffer.toString();

                                if(valueString.trim().indexOf('\'')>=0){
                                    int from = valueString.trim().indexOf('\'');
                                    int end = from +1+ valueString.trim().substring(from+1).indexOf('\'');
                                    if(from>=0 && end>1){
                                        option_hashMap.put("value", valueString.trim().substring(from,end+1));
                                    }else {
                                        option_hashMap.put("value", tmpStrings[2]);
                                    }
                                }else {
                                    option_hashMap.put("value", tmpStrings[2]);
                                }
                                configBean.addOptionArray(option_hashMap);
                            }
                        }
                    } else if ("list".equals(tmpStrings[0].trim())) {
                        if (null != configType) {
                            if (tmpStrings.length > 2) {
                                HashMap<String, String> list_hashMap = new HashMap<>();
                                list_hashMap.put("key", tmpStrings[1]);
                                list_hashMap.put("value", tmpStrings[2]);
                                configBean.addListArray(list_hashMap);
                            }
                        }
                    }
            }


            if (configType != null) {
                //最后一个节点解析完
                System.out.print("最后一个节点解析完\n");

                if (null != configBean) {
                    configs.add(configBean);
                    configType = null;
                    configBean = null;
                }
            }

            //文件解析结束
            File fSave = new File(outpath);
            if (fSave.exists()) {
                fSave.delete();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fSave));
            if ( configs.size()>0) {
                for(int i=0;i<configs.size();i++){
                    System.out.print(configs.get(i).toString());
                    writer.write(configs.get(i).toString());
                }

            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return configs;
    }

    public static void FirewallConfigParse2(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String configType = null;

        ConfigBean configBean = null;
        ArrayList<ConfigBean> configs = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String lineString = null;
            while ((lineString = reader.readLine()) != null) {
                System.out.println(lineString);
                if (lineString.trim().length() ==0 || lineString.trim().indexOf('#') == 0) {
                    //被注释的脚本
                    continue;
                }
                String[] tmpStrings = null;
                if (lineString.length() > 0) {
                    //按任意多空格分割
                    tmpStrings = lineString.trim().split("\\s+");
                }

                if(tmpStrings.length>1)
                if ("config".equals(tmpStrings[0])) {
                    if (configType != null) {
                        //一个节点解析完
                        System.out.print("一个节点解析完\n");

                        if (null != configBean) {
                            configs.add(configBean);
                            configType = null;
                            configBean = null;
                        }
                    }

                    configBean = new ConfigBean();
                    if (tmpStrings.length > 1) {
                        HashMap<String, String> cf_hashMap = new HashMap<>();
                        cf_hashMap.put("config", tmpStrings[1]);
                        configType = tmpStrings[1];
                        configBean.addOptionArray(cf_hashMap);
                        if (tmpStrings.length > 2) {
                            HashMap<String, String> name_hashMap = new HashMap<>();
                            name_hashMap.put("key", "name");
                            name_hashMap.put("value", tmpStrings[2]);
                            configBean.addOptionArray(name_hashMap);
                        }
                    }
                } else if ("option".equals(tmpStrings[0].trim())) {
                    if (null != configType) {
                        if (tmpStrings.length > 2) {
                            HashMap<String, String> option_hashMap = new HashMap<>();
                            option_hashMap.put("key", tmpStrings[1]);
                            option_hashMap.put("value", tmpStrings[2]);
                            configBean.addOptionArray(option_hashMap);
                        }
                    }
                } else if ("list".equals(tmpStrings[0].trim())) {
                    if (null != configType) {
                        if (tmpStrings.length > 2) {
                            HashMap<String, String> list_hashMap = new HashMap<>();
                            list_hashMap.put("key", tmpStrings[1]);
                            list_hashMap.put("value", tmpStrings[2]);
                            configBean.addListArray(list_hashMap);
                        }
                    }
                }
            }


            if (configType != null) {
                //最后一个节点解析完
                System.out.print("最后一个节点解析完\n");

                if (null != configBean) {
                    configs.add(configBean);
                    configType = null;
                    configBean = null;
                }
            }

            //文件解析结束
            File fSave = new File(firewall_save_path2);
            if (fSave.exists()) {
                fSave.delete();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fSave));
            if ( configs.size()>0) {
                for(int i=0;i<configs.size();i++){
                    System.out.print(configs.get(i).toString());
                    writer.write(configs.get(i).toString());
                }

            }


            writer.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void FirewallConfigParse(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String configType = null;

        FW_defaults mFW_defaults = null;
        FW_zone mFW_zone = null;
        FW_forwarding mFW_forwarding = null;
        FW_rule mFW_rule = null;
        Include mInclude = null;

        ArrayList<FW_rule> mFWRuleList = new ArrayList<>();
        ArrayList<FW_zone> mFWZoneList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String lineString = null;
            while ((lineString = reader.readLine()) != null) {
                System.out.println(lineString);

                if (lineString.length() > 0 && lineString.indexOf('#') == 0) {
                    //被注释的脚本
                    continue;
                }
                String[] tmpStrings = null;
                if (lineString.length() > 0) {
                    //按任意多空格分割
                    tmpStrings = lineString.trim().split("\\s+");
                }
                if (tmpStrings == null) {
                    continue;
                }

                if ("config".equals(tmpStrings[0])) {
                    if (configType != null) {
                        //一个节点解析完
                        System.out.print("一个节点解析完\n");
                        switch (configType) {
                            case "zone":
                                mFWZoneList.add(mFW_zone);
                                mFW_zone = null;
                                configType = null;
                                break;

                            case "rule":
                                mFWRuleList.add(mFW_rule);
                                mFW_rule = null;
                                configType = null;
                                break;
                        }
                    }

                    switch (tmpStrings[1]) {
                        case "defaults":
                            configType = "defaults";
                            mFW_defaults = new FW_defaults();
                            break;

                        case "zone":
                            configType = "zone";
                            mFW_zone = new FW_zone();
                            if (tmpStrings.length > 2) {
                                mFW_zone.setName(tmpStrings[2]);
                            }
                            break;

                        case "forwarding":
                            configType = "forwarding";
                            mFW_forwarding = new FW_forwarding();
                            break;

                        case "rule":
                            configType = "rule";
                            mFW_rule = new FW_rule();
                            if (tmpStrings.length > 2) {
                                mFW_rule.setName(tmpStrings[2]);
                            }
                            break;

                        case "include":
                            configType = "include";
                            mInclude = new Include();
                            break;

                        default:
                            break;
                    }
                } else if ("option".equals(tmpStrings[0].trim())) {
                    if (configType != null)
                        if (configType.equals("defaults") && (null != mFW_defaults)) {
                            switch (tmpStrings[1]) {
                                case "syn_flood":
                                    mFW_defaults.setSyn_flood(tmpStrings[2]);
                                    break;
                                case "input":
                                    mFW_defaults.setInput(tmpStrings[2]);
                                    break;
                                case "output":
                                    mFW_defaults.setOutput(tmpStrings[2]);
                                    break;
                                case "forward":
                                    mFW_defaults.setForward(tmpStrings[2]);
                                    break;

                              /*  case "disable_ipv6":
                                    mFW_defaults.setDisable_ipv6(tmpStrings[2]);
                                    break;*/
                            }
                        } else if (configType.equals("zone") && (null != mFW_zone)) {
                            switch (tmpStrings[1]) {
                                case "name":
                                    mFW_zone.setName(tmpStrings[2]);
                                    break;
                                case "input":
                                    mFW_zone.setInput(tmpStrings[2]);
                                    break;
                                case "output":
                                    mFW_zone.setOutput(tmpStrings[2]);
                                    break;
                                case "forward":
                                    mFW_zone.setForward(tmpStrings[2]);
                                    break;

                                case "masq":
                                    mFW_zone.setMasq(tmpStrings[2]);
                                    break;
                                case "mtu_fix":
                                    mFW_zone.setMtu_fix(tmpStrings[2]);
                                    break;

                            }
                        } else if (configType.equals("forwarding") && (null != mFW_forwarding)) {
                            switch (tmpStrings[1]) {
                                case "src":
                                    mFW_forwarding.setSrc(tmpStrings[2]);
                                    break;
                                case "dest":
                                    mFW_forwarding.setDest(tmpStrings[2]);
                                    break;
                            }
                        } else if (configType.equals("include") && (null != mInclude)) {
                            switch (tmpStrings[1]) {
                                case "path":
                                    mInclude.setPath(tmpStrings[2]);
                                    break;
                            }
                        } else if ((configType.equals("rule") && (null != mFW_rule))) {
                            switch (tmpStrings[1]) {
                                case "name":
                                    mFW_rule.setName(tmpStrings[2]);
                                    break;
                                case "src":
                                    mFW_rule.setSrc(tmpStrings[2]);
                                    break;
                                case "proto":
                                    mFW_rule.setProto(tmpStrings[2]);
                                    break;
                                case "dest":
                                    mFW_rule.setDest(tmpStrings[2]);
                                    break;
                                case "dest_port":
                                    mFW_rule.setDest_port(tmpStrings[2]);
                                    break;
                                case "dest_ip":
                                    mFW_rule.setDest_ip(tmpStrings[2]);
                                    break;
                                case "src_port":
                                    mFW_rule.setSrc_port(tmpStrings[2]);
                                    break;
                                case "src_ip":
                                    mFW_rule.setSrc_ip(tmpStrings[2]);
                                    break;
                                case "limit":
                                    mFW_rule.setLimit(tmpStrings[2]);
                                    break;
                                case "icmp_type":
                                    mFW_rule.setIcmp_type(tmpStrings[2]);
                                    break;
                                case "family":
                                    mFW_rule.setFamily(tmpStrings[2]);
                                    break;
                                case "target":
                                    mFW_rule.setTarget(tmpStrings[2]);
                                    break;
                            }
                        }

                } else if ("list".equals(tmpStrings[0].trim())) {
                    if (configType != null)
                        if (configType.equals("zone") && (null != mFW_zone)) {
                            if ("network".equals(tmpStrings[1])) {
                                mFW_zone.addNetworkList(tmpStrings[2]);
                            }
                        } else if (configType.equals("rule") && (null != mFW_rule)) {
                            if ("icmp_type".equals(tmpStrings[1])) {
                                mFW_rule.addIcmp_typeList(tmpStrings[2]);
                            }
                        }

                }

            }


            if (configType != null) {
                //最后一个节点解析完
                System.out.print("最后一个节点解析完\n");
                switch (configType) {
                    case "zone":
                        mFWZoneList.add(mFW_zone);
                        mFW_zone = null;
                        configType = null;
                        break;

                    case "rule":
                        mFWRuleList.add(mFW_rule);
                        mFW_rule = null;
                        configType = null;
                        break;
                }
            }

            //文件解析结束
            File fSave = new File(firewall_save_path);
            if (fSave.exists()) {
                fSave.delete();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fSave));
            if (null != mFW_defaults) {
                System.out.print(mFW_defaults.toString());
                writer.write(mFW_defaults.toString());
            }
            for (int i = 0; i < mFWZoneList.size(); i++) {
                System.out.print(mFWZoneList.get(i).toString());
                writer.write(mFWZoneList.get(i).toString());
            }
            if (null != mFW_forwarding) {
                System.out.print(mFW_forwarding.toString());
                writer.write(mFW_forwarding.toString());
            }

            for (int i = 0; i < mFWRuleList.size(); i++) {
                System.out.print(mFWRuleList.get(i).toString());
                writer.write(mFWRuleList.get(i).toString());
            }
            if (null != mInclude) {
                System.out.print(mInclude.toString());
                writer.write(mInclude.toString());
            }

            writer.close();

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }


    public static void DhcpConfigParse(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String configType = null;

        Dnsmasq mDnsmasq = null;
        Dhcp mDhcp = null;

        ArrayList<Dnsmasq> mDnsmasqList = new ArrayList<>();
        ArrayList<Dhcp> mDhcpList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String lineString = null;
            while ((lineString = reader.readLine()) != null) {
                System.out.println(lineString);

                if (lineString.length() > 0 && lineString.indexOf('#') == 0) {
                    //被注释的脚本
                    continue;
                }

                String[] tmpStrings = null;
                if (lineString.length() > 0) {
                    //按任意多空格分割
                    tmpStrings = lineString.trim().split("\\s+");
                }
                if (tmpStrings == null) {
                    continue;
                }


                if ("config".equals(tmpStrings[0])) {
                    if (configType != null) {
                        //一个节点解析完
                        System.out.print("一个节点解析完\n");
                        switch (configType) {
                            case "dnsmasq":
                                mDnsmasqList.add(mDnsmasq);
                                mDnsmasq = null;
                                configType = null;
                                break;

                            case "dhcp":
                                mDhcpList.add(mDhcp);
                                mDhcp = null;
                                configType = null;
                                break;


                        }
                    }
                    switch (tmpStrings[1]) {
                        case "dnsmasq":
                            configType = "dnsmasq";
                            mDnsmasq = new Dnsmasq();
                            if (tmpStrings.length > 2) {
                                mDnsmasq.setName(tmpStrings[2]);
                            }
                            break;

                        case "dhcp":
                            configType = "dhcp";
                            mDhcp = new Dhcp();
                            if (tmpStrings.length > 2) {
                                mDhcp.setName(tmpStrings[2]);
                            }
                            break;

                        default:
                            break;
                    }
                } else if ("option".equals(tmpStrings[0].trim())) {
                    if (configType != null)
                        if (configType.equals("dnsmasq") && (null != mDnsmasq)) {
                            switch (tmpStrings[1]) {
                                case "domainneeded":
                                    mDnsmasq.setDomainneeded(tmpStrings[2]);
                                    break;
                                case "boguspriv":
                                    mDnsmasq.setBoguspriv(tmpStrings[2]);
                                    break;
                                case "filterwin2k":
                                    mDnsmasq.setFilterwin2k(tmpStrings[2]);
                                    break;
                                case "localise_queries":
                                    mDnsmasq.setLocalise_queries(tmpStrings[2]);
                                    break;
                                case "rebind_protection":
                                    mDnsmasq.setRebind_protection(tmpStrings[2]);
                                    break;
                                case "rebind_localhost":
                                    mDnsmasq.setRebind_localhost(tmpStrings[2]);
                                    break;
                                case "local":
                                    mDnsmasq.setLocal(tmpStrings[2]);
                                    break;
                                case "domain":
                                    mDnsmasq.setDomain(tmpStrings[2]);
                                    break;
                                case "expandhosts":
                                    mDnsmasq.setExpandhosts(tmpStrings[2]);
                                    break;
                                case "nonegcache":
                                    mDnsmasq.setNonegcache(tmpStrings[2]);
                                    break;
                                case "authoritative":
                                    mDnsmasq.setAuthoritative(tmpStrings[2]);
                                    break;
                                case "readethers":
                                    mDnsmasq.setReadethers(tmpStrings[2]);
                                    break;
                                case "leasefile":
                                    mDnsmasq.setLeasefile(tmpStrings[2]);
                                    break;
                                case "resolvfile":
                                    mDnsmasq.setResolvfile(tmpStrings[2]);
                                    break;
                            }

                        } else if (configType.equals("dhcp") && (null != mDhcp)) {
                            switch (tmpStrings[1]) {
                                case "interface":
                                    mDhcp.setInterFace(tmpStrings[2]);
                                    break;
                                case "start":
                                    mDhcp.setStart(tmpStrings[2]);
                                    break;
                                case "limit":
                                    mDhcp.setLimit(tmpStrings[2]);
                                    break;
                                case "leasetime":
                                    mDhcp.setLeasetime(tmpStrings[2]);
                                    break;
                                case "ignore":
                                    mDhcp.setIgnore(tmpStrings[2]);
                                    break;
                            }
                        }
                }
            }

            if (configType != null) {
                //最后一个节点解析完
                System.out.print("最后一个节点解析完\n");
                switch (configType) {
                    case "dnsmasq":
                        mDnsmasqList.add(mDnsmasq);
                        mDnsmasq = null;
                        configType = null;
                        break;

                    case "dhcp":
                        mDhcpList.add(mDhcp);
                        mDhcp = null;
                        configType = null;
                        break;
                }
            }


            //文件解析结束

            File fSave = new File(dhcp_save_path);
            if (fSave.exists()) {
                fSave.delete();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fSave));
            for (int i = 0; i < mDnsmasqList.size(); i++) {
                System.out.print(mDnsmasqList.get(i).toString());
                writer.write(mDnsmasqList.get(i).toString());
            }
            for (int j = 0; j < mDhcpList.size(); j++) {
                System.out.print(mDhcpList.get(j).toString());
                writer.write(mDhcpList.get(j).toString());
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void WirelessConfigParse(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String configType = null;

        Wifi_device mWifiDevice = null;
        Wifi_iface mWifiIface = null;

        ArrayList<Wifi_device> mWifiDeviceList = new ArrayList<>();
        ArrayList<Wifi_iface> mWifiIfaceList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String lineString = null;
            while ((lineString = reader.readLine()) != null) {
                System.out.println(lineString);
                if (lineString.length() > 0 && lineString.indexOf('#') == 0) {
                    //被注释的脚本
                    continue;
                }

                String[] tmpStrings = null;
                if (lineString.length() > 0) {
                    //按任意多空格分割
                    tmpStrings = lineString.trim().split("\\s+");
                }
                if (tmpStrings == null) {
                    continue;
                }


                if ("config".equals(tmpStrings[0])) {
                    if (configType != null) {
                        //一个节点解析完
                        System.out.print("一个节点解析完\n");
                        switch (configType) {
                            case "wifi-device":
                                mWifiDeviceList.add(mWifiDevice);
                                mWifiDevice = null;
                                configType = null;
                                break;

                            case "wifi-iface":
                                mWifiIfaceList.add(mWifiIface);
                                mWifiIface = null;
                                configType = null;
                                break;


                        }
                    }
                    switch (tmpStrings[1]) {
                        case "wifi-device":
                            configType = "wifi-device";
                            mWifiDevice = new Wifi_device();
                            if (tmpStrings.length > 2) {
                                mWifiDevice.setName(tmpStrings[2]);
                            }
                            break;

                        case "wifi-iface":
                            configType = "wifi-iface";
                            mWifiIface = new Wifi_iface();
                            if (tmpStrings.length > 2) {
                                mWifiIface.setName(tmpStrings[2]);
                            }
                            break;

                        default:
                            break;
                    }
                } else if ("option".equals(tmpStrings[0].trim())) {
                    if (configType != null)
                        if (configType.equals("wifi-device") && (null != mWifiDevice)) {
                            switch (tmpStrings[1]) {
                                case "type":
                                    mWifiDevice.setType(tmpStrings[2]);
                                    break;
                                case "hwmode":
                                    mWifiDevice.setHwmode(tmpStrings[2]);
                                    break;
                                case "txpower":
                                    mWifiDevice.setTxpower(tmpStrings[2]);
                                    break;
                                case "path":
                                    mWifiDevice.setPath(tmpStrings[2]);
                                    break;
                                case "disabled":
                                    mWifiDevice.setDisabled(tmpStrings[2]);
                                    break;
                                case "channel":
                                    mWifiDevice.setChannel(tmpStrings[2]);
                                    break;
                                case "htmode":
                                    mWifiDevice.setHtmode(tmpStrings[2]);
                                    break;
                            }
                        } else if (configType.equals("wifi-iface") && (null != mWifiIface)) {
                            switch (tmpStrings[1]) {
                                case "device":
                                    mWifiIface.setDevice(tmpStrings[2]);
                                    break;
                                case "network":
                                    mWifiIface.setNetwork(tmpStrings[2]);
                                    break;
                                case "mode":
                                    mWifiIface.setMode(tmpStrings[2]);
                                    break;
                                case "encryption":
                                    mWifiIface.setEncryption(tmpStrings[2]);
                                    break;
                                case "key":
                                    mWifiIface.setKey(tmpStrings[2]);
                                    break;
                                case "ssid":
                                    mWifiIface.setSsid(tmpStrings[2]);
                                    break;
                            }
                        }

                } else if ("list".equals(tmpStrings[0].trim())) {
                    if (configType != null && "wifi-device".equals(configType)) {
                        if (tmpStrings.length > 2 && tmpStrings[1].equals("ht_capab")) {
                            mWifiDevice.addHt_capabs(tmpStrings[2]);
                        }
                    }
                }
            }

            if (configType != null) {
                //最后一个节点解析完
                System.out.print("最后一个节点解析完\n");
                switch (configType) {
                    case "wifi-device":
                        mWifiDeviceList.add(mWifiDevice);
                        mWifiDevice = null;
                        configType = null;
                        break;

                    case "wifi-iface":
                        mWifiIfaceList.add(mWifiIface);
                        mWifiIface = null;
                        configType = null;
                        break;
                }
            }


            //文件解析结束
            System.out.println("config 节点数: " + mWifiDeviceList.size());
            File fSave = new File(wireless_save_path);
            if (fSave.exists()) {
                fSave.delete();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fSave));
            for (int i = 0; i < mWifiDeviceList.size(); i++) {
                System.out.print(mWifiDeviceList.get(i).toString());
                writer.write(mWifiDeviceList.get(i).toString());
            }
            for (int j = 0; j < mWifiIfaceList.size(); j++) {
                System.out.print(mWifiIfaceList.get(j).toString());
                writer.write(mWifiIfaceList.get(j).toString());
            }
            writer.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void NetworkConfigParse(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String configType = null;
        Interface mInterface = null;
        Switch mSwitch = null;
        Switch_vlan mSwitchVlan = null;

        ArrayList<Interface> mInterfaceList = new ArrayList<>();
        ArrayList<Switch> mSwitchList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String lineString = null;
            while ((lineString = reader.readLine()) != null) {
                System.out.println(lineString);

                if (lineString.length() > 0 && lineString.indexOf('#') == 0) {
                    //被注释的脚本
                    continue;
                }
                String[] tmpStrings = null;
                if (lineString.length() > 0) {
                    //按任意多空格分割
                    tmpStrings = lineString.trim().split("\\s+");

//                    System.out.print("length: " + tmpStrings.length);
                    if (tmpStrings != null) {
                        if (tmpStrings.length >= 2) {
                            if ("config".equals(tmpStrings[0])) {
                                if (configType != null) {
                                    //一个节点解析完
                                    System.out.print("一个节点解析完\n");
                                    switch (configType) {
                                        case "interface":
                                            mInterfaceList.add(mInterface);
                                            mInterface = null;
                                            configType = null;
                                            break;

                                        case "switch":
                                            mSwitchList.add(mSwitch);
                                            mSwitch = null;
                                            configType = null;
                                            break;

                                        case "switch_vlan":
                                            if (mSwitchList.size() > 0)
                                                for (int i = 0; i < mSwitchList.size(); i++) {
                                                    if (mSwitchList.get(i).getName().equals(mSwitchVlan.getDevice())) {
                                                        mSwitchList.get(i).addSwitch_vlans(mSwitchVlan);
                                                    }
                                                }
                                            mSwitchVlan = null;
                                            configType = null;
                                            break;

                                    }
                                }
                                switch (tmpStrings[1]) {
                                    case "interface":
                                        configType = "interface";
                                        mInterface = new Interface();
                                        if (tmpStrings.length > 2) {
                                            mInterface.setName(tmpStrings[2]);
                                        }
                                        break;

                                    case "switch":
                                        configType = "switch";
                                        mSwitch = new Switch();
                                        if (tmpStrings.length > 2) {
                                            mSwitch.setName(tmpStrings[2]);
                                        }
                                        break;

                                    case "switch_vlan":
                                        configType = "switch_vlan";
                                        mSwitchVlan = new Switch_vlan();
                                        if (tmpStrings.length > 2) {
                                            mSwitchVlan.setName(tmpStrings[2]);
                                        }
                                        break;

                                    default:
                                        break;
                                }
                            } else if ("option".equals(tmpStrings[0].trim())) {
//                                System.out.println("tmpStrings[0]  " + tmpStrings[0] + " tmpStrings[1]  " + tmpStrings[1] + " tmpStrings[2]  " + tmpStrings[2]);
                                if (configType != null)
                                    if (configType.equals("interface") && (null != mInterface)) {
                                        switch (tmpStrings[1]) {
                                            case "ifname":
                                                mInterface.setIfname(tmpStrings[2]);
                                                break;
                                            case "type":
                                                mInterface.setType(tmpStrings[2]);
                                                break;
                                            case "proto":
                                                mInterface.setProto(tmpStrings[2]);
                                                break;
                                            case "ipaddr":
                                                mInterface.setIpaddr(tmpStrings[2]);
                                                break;
                                            case "netmask":
                                                mInterface.setNetmask(tmpStrings[2]);
                                                break;
                                            case "hostname":
                                                mInterface.setHostname(tmpStrings[2]);
                                                break;

                                        }
                                    } else if (configType.equals("switch")) {
                                        switch (tmpStrings[1]) {
                                            case "name":
                                                mSwitch.setName(tmpStrings[2]);
                                                break;
                                            case "reset":
                                                mSwitch.setReset(tmpStrings[2]);
                                                break;
                                            case "enable_vlan":
                                                mSwitch.setEnable_vlan(tmpStrings[2]);
                                                break;
                                        }

                                    } else if (configType.equals("switch_vlan")) {
                                        switch (tmpStrings[1]) {
                                            case "device":
                                                mSwitchVlan.setDevice(tmpStrings[2]);
                                                break;
                                            case "vlan":
                                                mSwitchVlan.setVlan(tmpStrings[2]);
                                                break;
                                            case "vid":
                                                mSwitchVlan.setVid(tmpStrings[2]);
                                                break;
                                            case "ports":
                                                StringBuffer sBuffer = new StringBuffer();
                                                for (int i = 2; i < tmpStrings.length; i++) {
                                                    sBuffer.append(tmpStrings[i] + " ");
                                                }
                                                mSwitchVlan.setPorts(sBuffer.toString().trim());
                                                break;
                                        }
                                    }

                            }

                        }
                    }


                }

            }

            if (configType != null) {
                //最后一个节点解析完
                System.out.print("一个节点解析完\n");
                switch (configType) {
                    case "interface":
                        mInterfaceList.add(mInterface);
                        mInterface = null;
                        configType = null;
                        break;

                    case "switch":
                        mSwitchList.add(mSwitch);
                        mSwitch = null;
                        configType = null;
                        break;

                    case "switch_vlan":
                        if (mSwitchList.size() > 0)
                            for (int i = 0; i < mSwitchList.size(); i++) {
                                if (mSwitchList.get(i).getName().equals(mSwitchVlan.getDevice())) {
                                    mSwitchList.get(i).addSwitch_vlans(mSwitchVlan);
                                }
                            }
                        mSwitchVlan = null;
                        configType = null;
                        break;

                }
            }

            //文件解析结束
            System.out.println("config 节点数: " + mInterfaceList.size());
            File fSave = new File(network_save_path);
            if (fSave.exists()) {
                fSave.delete();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fSave));
            for (int i = 0; i < mInterfaceList.size(); i++) {
                System.out.print(mInterfaceList.get(i).toString());
                writer.write(mInterfaceList.get(i).toString());
            }
            for (int j = 0; j < mSwitchList.size(); j++) {
                System.out.print(mSwitchList.get(j).toString());
                writer.write(mSwitchList.get(j).toString());
            }
            writer.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
