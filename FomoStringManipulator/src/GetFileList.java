import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by codemonkey on 5/19/15.
 */
public class GetFileList {

    private static String dest = "/Users/codemonkey/git/tornado-boilerplate/templates";

    public static void main(String[] args) {
        // get file of files from a folder
        for (String str : getFileList()) {
            System.out.println(str);
        }
    }

    public static List<String> getFileList() {
        File f = new File(dest);
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
//        names.remove(0);

        for (int i = 0; i < names.size(); i++) {
            String fullname = names.get(i);
            if (fullname.indexOf('.') == -1 || fullname.indexOf('.') == 0) {
                System.out.println("removed... " + fullname);
                names.remove(i);
                i--;
                continue;
            }
            names.set(i, fullname.substring(0, fullname.indexOf('.')));
        }
        System.out.println("done");
        System.out.println();

        return names;
    }
}
