package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.warehousemanage.mapper")
public class WarehouseManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseManageApplication.class, args);
    }

}
