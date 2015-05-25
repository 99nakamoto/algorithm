import java.util.List;

/**
 * Created by codemonkey on 5/19/15.
 */
public class GenerateUrlsPy {

    public static void main(String[] args) {
        for (String str : getUrlsMapping()) {
            System.out.println(str);
        }
    }

    public static List<String> getUrlsMapping() {
        List<String> files = GetFileList.getFileList();
        for (int i = 0; i < files.size(); i++) {
            String url = "    (r\"/" + files.get(i) + "\", handlers.ran." + toHandlerName(files.get(i)) + "Handler),";
            files.set(i, url);
        }

        return files;
    }

    public static String toHandlerName(String str) {
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        str.replace("-", "");
        if ('0' <= str.charAt(0) && str.charAt(0) <= '9') {
            str = "Page" + str;
        }
        return str;
    }
}
