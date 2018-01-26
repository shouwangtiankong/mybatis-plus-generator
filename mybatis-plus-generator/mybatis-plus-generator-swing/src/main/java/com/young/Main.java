package com.young;

import com.young.mpg.MainFrame;

import java.awt.*;

/**
 * @ Desc:
 * @ Author: Young
 * @ Create: 2018/1/26
 * @ Version: 1.0
 */
public class Main {

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true); // 显示窗体
            }
        });
    }
}
