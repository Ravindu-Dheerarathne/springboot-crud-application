package com.example.PointofSale.repository;

import com.example.PointofSale.dto.queryInterface.TrackQuantitiesInterface;
import com.example.PointofSale.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository <Product,Integer> {

    @Query(value = "select pr.product_id, pr.name, pr.stock_qty from product pr where pr.name like %?1%;", nativeQuery = true)
    List<TrackQuantitiesInterface> trackQuantities(String productName);
}
