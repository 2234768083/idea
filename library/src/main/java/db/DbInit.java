package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Vector;

public class DbInit {
    public static Vector<Vector<Object>> init() throws IOException {
        Vector<Vector<Object>> data = new Vector<>();
        File fileIn = new File("src\\main\\java\\io\\items.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(Files.newInputStream(fileIn.toPath()), StandardCharsets.UTF_8));

        String str = null;
        while ((str = in.readLine()) != null) {
            Vector<Object> row = new Vector<>();
            for ( int i = 1; i <= 8; i ++ ) {
                row.addElement((Object) str);
                str = in.readLine();
            }
            data.addElement(row);
        }
        in.close();
        return data;
    }
}
