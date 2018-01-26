package com.young.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @ Desc: Mybatis-plus 自动生成代码
 * @ Author: Young
 * @ Create: 2018/1/26
 * @ Version: 1.0
 */
public class GeneratorConfig {

    // 全局配置
    private String outputDir;
    private String author;
    // 数据源配置
    private String db_username;
    private String db_password;
    private String db_name;
    // 包配置
    private String package_parent;
    private String package_module_name;

    public GeneratorConfig() {
        this.outputDir = "d:/code-generator";
        this.author = "";
        this.db_username = "root";
        this.db_password = "123456";
        this.db_name = "";
        this.package_parent = "com.young";
        this.package_module_name = "demo";
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDb_username() {
        return db_username;
    }

    public void setDb_username(String db_username) {
        this.db_username = db_username;
    }

    public String getDb_password() {
        return db_password;
    }

    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getPackage_parent() {
        return package_parent;
    }

    public void setPackage_parent(String package_parent) {
        this.package_parent = package_parent;
    }

    public String getPackage_module_name() {
        return package_module_name;
    }

    public void setPackage_module_name(String package_module_name) {
        this.package_module_name = package_module_name;
    }

    public void generator() {
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(outputDir);
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(true); // 不需要ActiveRecord特性的请改为false
        globalConfig.setEnableCache(false); // XML 二级缓存
        globalConfig.setBaseResultMap(true); // XML ResultMap
        globalConfig.setBaseColumnList(false); // XML columList
        globalConfig.setAuthor(author); // 作者
        //globalConfig.setKotlin(true); // 是否生成 kotlin 代码
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        //globalConfig.setMapperName("%sDao");
        //globalConfig.setXmlName("%sDao");
        //globalConfig.setServiceName("%sService"); // 去掉 接口开头字符 I
        //globalConfig.setServiceImplName("%sServiceDiy");
        //globalConfig.setControllerName("%sAction");
        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL); // 数据库类型
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername(db_username);
        dataSourceConfig.setPassword(db_password);
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/" + db_name + "?characterEncoding=utf8");
        // 字段类型映射
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert(){
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                //System.out.println("type change: " + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });
        autoGenerator.setDataSource(dataSourceConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        // strategyConfig.setCapitalMode(true); // 全局大写命名 ORACLE 注意
        //strategyConfig.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        //strategyConfig.setInclude(new String[] { "user" }); // 需要生成的表
        //strategyConfig.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        //strategyConfig.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        //strategyConfig.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        //strategyConfig.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        //strategyConfig.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        //strategyConfig.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        //strategyConfig.setSuperControllerClass("com.baomidou.demo.TestController");
        // [实体]是否生成字段常量(默认 false) : public static final String ID = "test_id";
        //strategyConfig.setEntityColumnConstant(true);
        // [实体]是否为构建者模型(默认 false) : public User setName(String name) {this.name = name; return this;}
        //strategyConfig.setEntityBuilderModel(true);
        autoGenerator.setStrategy(strategyConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(package_parent);
        packageConfig.setModuleName(package_module_name);
        //packageConfig.setController("controller"); // 默认 web
        autoGenerator.setPackageInfo(packageConfig);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
//        InjectionConfig injectionConfig = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<String, Object>();
//                //map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
//            }
//        };
        // 自定义 xxList.jsp 生成
//        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
//        focList.add(new FileOutConfig("/template/list.jsp.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return "d://code-generator/view/" + tableInfo.getName() + "_list.jsp";
//            }
//        });
//        injectionConfig.setFileOutConfigList(focList);

//        // 调整 mapper.xml 生成目录
//        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return "d://code-generator/xml/" + tableInfo.getEntityName() + ".xml";
//            }
//        });
//        injectionConfig.setFileOutConfigList(focList);

//        autoGenerator.setCfg(injectionConfig);

        // 关闭默认 xml 生成，调整生成 至 根目录
//        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null);
//        autoGenerator.setTemplate(templateConfig);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
//        TemplateConfig tc = new TemplateConfig();
//        tc.setController("/templates/controller.java.vm");
//        tc.setEntity("...");
//        tc.setMapper("...");
//        tc.setXml(null);
//        tc.setService("...");
//        tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
//        autoGenerator.setTemplate(tc);

        autoGenerator.execute();
        //System.out.println(autoGenerator.getCfg().getMap().get("abc"));
        System.out.println("===========success============");
    }
}
