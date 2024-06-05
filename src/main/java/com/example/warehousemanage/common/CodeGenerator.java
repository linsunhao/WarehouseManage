package com.example.warehousemanage.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

/**
 * 代码自动生成器
 * 可自动生成实体类、数据层、业务层、表现层代码
 * 去MyBtisPlus官网可复制代码
 */
public class CodeGenerator {

        public static void execute(){
            //配置数据库参数
            DataSourceConfig.Builder config = new DataSourceConfig.Builder(
                    "jdbc:mysql://localhost:3306/quanzhan?allowPublicKeyRetrieval=true&useSSL=false",
                    "root",
                    "123456");
            //mybatisPlus总共支持6种配置
            FastAutoGenerator.create(config)
                    //全局配置
                    .globalConfig((scanner,builder)  -> {
                        //配置作者
                        builder.author("sun")
                                //配置时间
                                .commentDate("2024-04-09")
                                //输出目录
                                .outputDir("D:\\study\\heima\\quanzhan\\WarehouseManage\\src\\main\\java");
                    })
                    //包配置
                    .packageConfig((scanner,builder) -> {
                        //配置父包名
                        builder.parent("com.example.warehousemanage")
                                .entity("entity")
                                .controller("controller")
                                .mapper("mapper")
                                .service("service");
                    })
                    //策略配置
                    .strategyConfig((scanner,builder)  -> {
                        // 设置需要生成的表名
                        builder.addInclude("record")
                                //配置模型
                                .entityBuilder().enableFileOverride()
                                //配置控制器
                                .controllerBuilder().enableRestStyle().enableFileOverride()
                                //配置服务
                                .serviceBuilder().enableFileOverride()
                                //配置Mapper
                                .mapperBuilder().enableFileOverride();
                    })
                    //模板配置
                    .templateConfig((scanner,builder)->{
                        //配置不需要生成的文件
//                  builder.disable(TemplateType.CONTROLLER,TemplateType.SERVICE,TemplateType.SERVICE_IMPL);
                    })
                    //注入配置
//                .injectionConfig((scanner,builder)  ->{})
                    //模板引擎配置
//                .templateConfig(builder->{})
                    .execute();
        }

        public static void main(String[] args) {
            CodeGenerator.execute();
        }
    }

