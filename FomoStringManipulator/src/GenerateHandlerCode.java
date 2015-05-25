import java.util.List;

/**
 * Created by codemonkey on 5/19/15.
 */
public class GenerateHandlerCode {

    public static void main(String[] args) {
        for (String str : getHandlerCode()) {
            System.out.println(str);
        }
    }

    public static List<String> getHandlerCode() {
        List<String> files = GetFileList.getFileList();
        for (int i = 0; i < files.size(); i++) {
            String code = "";

            code += "# " + files.get(i);
            code += "\n";
            code += "class " + GenerateUrlsPy.toHandlerName(files.get(i)) + "Handler(RequestHandler):";
            code += "\n";
            code += "    def get(self):";
            code += "\n";
            code += "        self.render(\"" + files.get(i)+ ".html\")";
            code += "\n";
            files.set(i, code);
        }

        return files;
    }
}
