package com.young.mpg;

import com.young.config.GeneratorConfig;
import javafx.scene.control.Labeled;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ Desc:
 * @ Author: Young
 * @ Create: 2018/1/26
 * @ Version: 1.0
 */
public class MainFrame extends JFrame {

    private JPanel contentPanel;
    private JButton jButton_confirm = new JButton("确认");

    // 全局配置
    private JTextField jTextField_output_dir = new JTextField("d:/code-generator"); // 文件输出根路径
    // 数据源配置
    private JTextField jTextField_db_username = new JTextField("root"); // 数据库 用户名
    private JTextField jTextField_db_password = new JTextField("123456"); // 数据库 密码
    private JTextField jTextField_db_name = new JTextField("db_demo"); // 数据库 名
    // 包配置
    private JTextField jTextField_package_parent = new JTextField("com.young"); // 包名
    private JTextField jTextField_package_module_name = new JTextField("demo"); // 模块名

    /**
     * Create the frame
     */
    public MainFrame() {
        setTitle("Mybatis-plus Generator"); // 窗体名称
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 500);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new GridLayout(13, 12));
        setContentPane(contentPanel);
        // 全局配置
        contentPanel.add(new JLabel("文件输出根路径 默认：" + jTextField_output_dir.getText()));
        contentPanel.add(jTextField_output_dir);
        // 数据源配置
        contentPanel.add(new JLabel("数据库 用户名 默认：" + jTextField_db_username.getText()));
        contentPanel.add(jTextField_db_username);
        contentPanel.add(new JLabel("数据库 密码 默认：" + jTextField_db_password.getText()));
        contentPanel.add(jTextField_db_password);
        contentPanel.add(new JLabel("数据库名 默认：" + jTextField_db_name.getText()));
        contentPanel.add(jTextField_db_name);
        // 包配置
        contentPanel.add(new JLabel("基础包名 默认：" + jTextField_package_parent.getText()));
        contentPanel.add(jTextField_package_parent);
        contentPanel.add(new JLabel("模块名 默认：" + jTextField_package_module_name.getText()));
        contentPanel.add(jTextField_package_module_name);
        jButton_confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String output_dir = jTextField_output_dir.getText();
                String db_username = jTextField_db_username.getText();
                String db_password = jTextField_db_password.getText();
                String db_name = jTextField_db_name.getText();
                String package_parent = jTextField_package_parent.getText();
                String package_module_name = jTextField_package_module_name.getText();

                // MyBatis Plus 自动生成代码
                GeneratorConfig generatorConfig = new GeneratorConfig();
                generatorConfig.setOutputDir(output_dir);
                generatorConfig.setDb_username(db_username);
                generatorConfig.setDb_password(db_password);
                generatorConfig.setDb_name(db_name);
                generatorConfig.setPackage_parent(package_parent);
                generatorConfig.setPackage_module_name(package_module_name);
                // 调用自动生成
                generatorConfig.generator();
            }
        });
        contentPanel.add(jButton_confirm);
    }

}
