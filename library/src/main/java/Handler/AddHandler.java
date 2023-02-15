package Handler;

import View.AddView;
import View.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class AddHandler implements ActionListener {
    private final AddView addView;
    String id = new String();
    String name = new String();
    String peo = new String();
    String ip = new String();
    String are = new String();
    String fac = new String();
    String date = new String();
    String num = new String();

    public AddHandler(AddView addView) {
        this.addView = addView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();

        if ("确认添加".equals(text)) {
            try {
                add();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if ("取消".equals(text)) {
            AddView.shutDown();
        }
    }

    public void add() throws IOException {
        id = addView.getIdText();
        name = addView.getNameText();
        peo = addView.getPeoText();
        ip = addView.getIpText();
        are = addView.getAreText();
        fac = addView.getFacText();
        date = addView.getDateText();
        num = addView.getNumText();

        if (check(id)) {
            JOptionPane.showMessageDialog(addView, "该编号商品已存在");
        } else if (checkAll()) {
            JOptionPane.showMessageDialog(addView, "请将信息填写完整");
        } else {
            FileWriter fw = new FileWriter("src\\main\\java\\io\\items.txt",true);
            fw.append("\n");
            fw.append("\n");
            fw.append(id);
            fw.append("\n");
            fw.append(name);
            fw.append("\n");
            fw.append(peo);
            fw.append("\n");
            fw.append(ip);
            fw.append("\n");
            fw.append(are);
            fw.append("\n");
            fw.append(fac);
            fw.append("\n");
            fw.append(date);
            fw.append("\n");
            fw.append(num);
            fw.close();
            AddView.shutDown();
            MainView.shutDown();
            MainView.cre();
        }
    }

    public boolean check(String id) throws IOException {
        File fileIn = new File("src\\main\\java\\io\\items.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(Files.newInputStream(fileIn.toPath()), StandardCharsets.UTF_8));

        String str = null;
        while ((str = in.readLine()) != null) {
            if (id.equals(str)) {
                in.close();
                return true;
            }
            for ( int i = 1; i <= 8; i ++ ) in.readLine();
        }
        in.close();

        return false;
    }

    public boolean checkAll() {
        return id.equals("") || peo.equals("") || name.equals("") || ip.equals("") || are.equals("")
                || fac.equals("") || date.equals("") || num.equals("");
    }
}