package com.dustin.autogenerateobject;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> Description: mybatis 逆向工程根据数据库表的信息
 * 自动为每一张表生成对应的持久化对象，mapper，接口等等，不用手工一个个填写了
 * ps： 注意，此方法应该在初始执行一次，否则如果后续对内容进行了修改，会自动覆盖
 *  容易出现大量错误，且不容易排查</p>
 *
 * @author Wangsw
 * @date 2017/11/15下午 05:04
 * @Version 1.0.0
 */
public class AutoGenerateORM {

//    执行一次就可以， 如果想要运行一次，则把// 去掉运行就可以
//    public static void main(String[] args) throws Exception {
//        try {
//            AutoGenerateORM autoGenerateORM = new AutoGenerateORM();
//            autoGenerateORM.generatorSqlMap();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    // 根据配置信息自动生成相关的接口，类，sqlmap
    public void generatorSqlMap() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指定 逆向工程配置文件
        File configFile = new File("classpath:autogenerateobject\\AutoGenerateORMConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
}
