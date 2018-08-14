package joey;

public  class ValueFormat {
    public static String format(String mString){
        String res = new String();
        if(null != mString){
            res = mString;
        }
        int begin = mString.indexOf('\'');
        int end =0;
        if(begin>=0){
            end = mString.substring(begin+1).indexOf('\'');
            if(end>0){
                res = mString.substring(begin+1,begin+end+1);
            }
        }

        return res;
    }
}
