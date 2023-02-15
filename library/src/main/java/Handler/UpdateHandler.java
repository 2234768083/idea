package Handler;

import View.MainView;
import View.UpdateView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Vector;

public class UpdateHandler implements ActionListener {
    private final UpdateView updateView;
    String id = new String();
    String item = new String();
    String peo = new String();
    String ip = new String();
    String are = new String();
    String fac = new String();
    String date = new String();
    String num = new String();
    public UpdateHandler(UpdateView updateView) {
        this.updateView = updateView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();

        if ("确认修改".equals(text)) {
            try {
                update();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if ("取消".equals(text)) {
            UpdateView.shutDown();
        }
    }

    public void update() throws IOException {
        id = updateView.getIdText();
        item = updateView.getNameText();
        peo = updateView.getPeoText();
        ip = updateView.getIpText();
        are = updateView.getAreText();
        fac = updateView.getFacText();
        date = updateView.getDateText();
        num = updateView.getNumText();

        if (!check(Integer.parseInt(id))) {
            JOptionPane.showMessageDialog(updateView, "该编号商品不存在");
        } else if (checkAll()) {
            JOptionPane.showMessageDialog(updateView, "请将信息填写完整");
        } else {
            Vector<Object> row = new Vector<>();
            row.addElement(id);
            row.addElement(item);
            row.addElement(peo);
            row.addElement(ip);
            row.addElement(are);
            row.addElement(fac);
            row.addElement(date);
            row.addElement(num);

            Vector<Vector<Object>> data = new Vector<>();
            File fileIn = new File("src\\main\\java\\io\\items.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(Files.newInputStream(fileIn.toPath()), StandardCharsets.UTF_8));

            String str = null;
            while ((str = in.readLine()) != null) {
                if (!str.equals(id)) {
                    Vector<Object> row1 = new Vector<>();
                    for ( int i = 1; i <= 8; i ++ ) {
                        row1.addElement(str);
                        str = in.readLine();
                    }
                    data.addElement(row1);
                } else {
                    for ( int i = 1; i <= 8; i ++ ) in.readLine();
                    data.addElement(row);
                }
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

            UpdateView.shutDown();
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

    public boolean checkAll() {
        return id.equals("") || peo.equals("") || item.equals("") || ip.equals("") || are.equals("")
                || fac.equals("") || date.equals("") || num.equals("");
    }
}