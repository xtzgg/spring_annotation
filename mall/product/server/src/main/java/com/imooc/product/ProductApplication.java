package com.imooc.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 技术点：es 搜索引擎进行搜索
 * 		   rabbitMQ进行消费减库存
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication {
		public static void main(String[] args) {
				SpringApplication.run(ProductApplication.class, args);
		}
}

