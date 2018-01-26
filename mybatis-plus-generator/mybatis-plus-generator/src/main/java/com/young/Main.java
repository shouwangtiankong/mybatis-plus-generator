package com.young;

import com.young.config.GeneratorConfig;

/**
 * @ Desc: Mybatis-plus 自动生成代码
 * @ Author: Young
 * @ Create: 2018/1/26
 * @ Version: 1.0
 */
public class Main {

    public static void main(String[] args) {

        GeneratorConfig generatorConfig = new GeneratorConfig();

        // 调用自动生成
        generatorConfig.generator();
    }
}
