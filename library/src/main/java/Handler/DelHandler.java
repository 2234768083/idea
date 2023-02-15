package Handler;

import View.DelView;
import View.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Vector;

public class DelHandler implements ActionListener {
    private final DelView delView;
    String id = null;
    public DelHandler(DelView delView) {
        this.delView = delView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();

        if ("确认删除".equals(text)) {
            try {
                del();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if ("取消".equals(text)) {
            DelView.shutDown();
        }
    }

    public void del() throws IOException {
        id = DelView.getIdText();

        if (!check(Integer.parseInt(id))) {
            JOptionPane.showMessageDialog(delView, "该编号商品不存在");
        } else {
            Vector<Vector<Object>> data = new Vector<>();
            File fileIn = new File("src\\main\\java\\io\\items.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(Files.newInputStream(fileIn.toPath()), StandardCharsets.UTF_8));

            String str = null;
            while ((str = in.readLine()) != null) {
                String rId = str;
                Vector<Object> row = new Vector<>();
                for ( int i = 1; i <= 8; i ++ ) {
                    row.addElement(str);
                    str = in.readLine();
                }
                if (rId.equals(id)) continue;
                data.addElement(row);
            }
            in.close();

            File fileOut = new File("src\\main\\java\\io\\items.txt");
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(fileOut.toPath()), "UTF-8"));

            int n = data.size();
            int cnt = 1;
            for (Vector<Object> x : data) {
                int row_cnt = 1;
                for (Object y : x) {
                    out.write((String) y);
                    if (cnt == n && row_cnt == 8) break;
                    row_cnt ++;
                    out.newLine();
                }
                if (cnt == n) break;
                cnt ++;
                out.newLine();
            }
            out.flush();
            out.close();
            in.close();

            DelView.shutDown();
            MainView.shutDown();
            MainView.cre();
        }
    }

    public boolean check(int id) throws IOException {
        File fileIn = new File("src\\main\\java\\io\\items.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(Files.newInputStream(fileIn.toPath()), StandardCharsets.UTF_8));

        String str = null;
        while ((str = in.readLine()) != null) {
            if (id == Integer.parseInt(str)) {
                in.close();
                return true;
            }
            for ( int i = 1; i <= 8; i ++ ) in.readLine();
        }
        in.close();

        return false;
    }
}
