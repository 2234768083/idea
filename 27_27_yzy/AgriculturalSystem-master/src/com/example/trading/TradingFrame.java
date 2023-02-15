package com.example.trading;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TradingFrame extends JFrame {
    // 农副产品名称文本框
    private JTextField nameText;
    // 交易量文本框
    private JTextField volumeText;
    // 交易价格文本框
    private JTextField priceText;
    // 插入按钮
    private JButton insertButton;
    // 更新按钮
    private JButton updateButton;
    // 删除按钮
    private JButton deleteButton;

    public TradingFrame() {
        // 初始化界面
        init();
    }

    // 初始化界面的方法
    private void init() {
        // 设置窗体标题
        setTitle("农副产品交易管理系统");
        // 设置窗体大小
        setSize(500, 400);
// 设置窗体居中显示
        setLocationRelativeTo(null);
// 设置窗体布局为网格布局
        setLayout(new GridLayout(4, 2));

// 创建农副产品名称标签
        JLabel nameLabel = new JLabel("农副产品名称：");
// 创建农副产品名称文本框
        nameText = new JTextField();
// 创建交易量标签
        JLabel volumeLabel = new JLabel("交易量：");
// 创建交易量文本框
        volumeText = new JTextField();
// 创建交易价格标签
        JLabel priceLabel = new JLabel("交易价格：");
// 创建交易价格文本框
        priceText = new JTextField();

// 创建插入按钮
        insertButton = new JButton("插入");
// 创建更新按钮
        updateButton = new JButton("更新");
// 创建删除按钮
        deleteButton = new JButton("删除");

// 添加农副产品名称标签到窗体
        add(nameLabel);
// 添加农副产品名称文本框到窗体
        add(nameText);
// 添加交易量标签到窗体
        add(volumeLabel);
// 添加交易量文本框到窗体
        add(volumeText);
// 添加交易价格标签到窗体
        add(priceLabel);
// 添加交易价格文本框到窗体
        add(priceText);
// 添加插入按钮到窗体
        add(insertButton);
// 添加更新按钮到窗体
        add(updateButton);
// 添加删除按钮到窗体
        add(deleteButton);

// 为插入按钮添加事件监听器
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// 创建农副产品交易对象
                AgriculturalProductTrading trading = new AgriculturalProductTrading();
// 设置农副产品名称
                trading.setName(nameText.getText());
// 设置交易量
                trading.setVolume(Integer.parseInt(volumeText.getText()));
// 设置交易价格
                trading.setPrice(Integer.parseInt(priceText.getText()));

                Copy code
                // 创建农副产品交易数据库操作类
                AgriculturalProductTradingDB db = new AgriculturalProductTradingDB(conn);
// 插入农副产品交易信息
                db.insert(trading);
            }
        });

// 为更新按钮添加事件监听器
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// 创建农副产品交易对象
                AgriculturalProductTrading trading = new AgriculturalProductTrading();
// 设置农副产品名称
                trading.setName(nameText.getText());
// 设置交易量
                trading.setVolume(Integer.parseInt(volumeText.getText()));
// 设置交易价格
                trading.setPrice(Integer.parseInt(priceText.getText()));

                Copy code
                // 创建农副产品交易数据库操作类
                AgriculturalProductTradingDB db = new AgriculturalProductTradingDB(conn);
                // 更新农副产品交易信息
                db.update(trading);
            }
        });

// 为删除按钮添加事件监听器
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// 获取农副产品名称
                String name = nameText.getText();
                // 创建农副产品交易数据库操作类
                AgriculturalProductTradingDB db = new AgriculturalProductTradingDB(conn);
                // 删除农副产品交易信息
                db.delete(name);
            }
        });
    }
}