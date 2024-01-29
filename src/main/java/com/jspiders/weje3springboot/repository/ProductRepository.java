
package com.jspiders.weje3springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.weje3springboot.pojo.ProductPojo;

public interface ProductRepository extends JpaRepository<ProductPojo, Integer> {

}
