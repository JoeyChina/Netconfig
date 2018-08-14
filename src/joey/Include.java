package joey;

public class Include {
    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String toString() {
        StringBuffer SS = new StringBuffer();
        if (null != path) {
            SS.append("\nconfig include");
            SS.append("\n\toption path " + path);
        }
      return   SS.toString();
    }
}
