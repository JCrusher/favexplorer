/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package favexplorer;

/**
 *
 * @author lukas
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class SimpleEncoder {
    static String user = System.getProperty("user.name");
    static File loc = new File("/home/"+user+"/favexp/user");
    static Properties p = new Properties();

    public static void main(String[] args) throws IOException {
        SimpleEncoder.writer(user, loc);
        boolean b = SimpleEncoder.reader("lukas", loc);
        System.out.println(b);
    }

    public static void writer(String s, File location) throws IOException {
        char[] c = s.toCharArray();
        int[] array = new int[c.length];
        if (location == null) {
            location = loc;
        }
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int in = (ch - 10) * 2;
            p.setProperty(String.valueOf(i), String.valueOf(in));
        }
        FileOutputStream ou = new FileOutputStream(location);
        p.store(ou, null);
        ou.close();
    }

    public static boolean reader(String s, File location) throws IOException {
        Object[] a;
        boolean b = false;
        String check = "";
        if (location == null) {
            location = loc;
        }
        FileInputStream in = new FileInputStream(location);
        p.load(in);
        Collection collection = p.values();
        for (Object o : a = collection.toArray()) {
            String each = o.toString();
            System.out.print(each);
            int i = Integer.parseInt(each) / 2 + 10;
            char ch = (char)i;
            check = check + String.valueOf(ch);
        }
        StringBuilder st = new StringBuilder(check);
        st.reverse();
        check = st.toString();
        System.out.print(check);
        if (check.equals(s)) {
            b = true;
        }
        return b;
    }
}
