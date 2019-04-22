package com.imooc.product.repository;

import com.imooc.product.dataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
	//根据type查询类目
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
	//做个测试
}
