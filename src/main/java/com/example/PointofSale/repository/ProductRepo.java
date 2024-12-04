package com.example.PointofSale.repository;

import com.example.PointofSale.dto.queryInterface.TrackQuantitiesInterface;
import com.example.PointofSale.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository <Product,Integer> {

    @Query(value = "select pr.product_id, pr.name, pr.stock_qty from product pr where pr.name like %?1%;", nativeQuery = true)
    List<TrackQuantitiesInterface> trackQuantities(String productName);

    boolean existsByProductId(int productId);

    @Query(value = " select pr.stock_qty from product pr where pr.product_id = ?1 " , nativeQuery = true)
    int getProductQtyByProductId(int productId);

    @Modifying
    @Transactional
    @Query(value = " update product set stock_qty= ?1 where product_id = ?2 " , nativeQuery = true)
    void setProductQtyByProductId(int productQuantity, int productId);

    @Query(value = "select pr.name from product pr where pr.product_id = ?1 " , nativeQuery = true)
    String getProductNameByProductId(int productId);

    @Query(value = "select `price(usd)` from product where product_id = ?1 " , nativeQuery = true)
    double getPrice(int productId);


    Page<Product> findAllByCategoryEquals(String category , Pageable pageable);

    int countAllByCategoryEquals(String category);
}

