package com.example.PointofSale.repository;

import com.example.PointofSale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@EnableJpaRepositories
public interface SaleRepo extends JpaRepository<Sale,Integer> {

    @Query(value = "SELECT SUM(total_amount) AS total_amount_between_dates FROM Sale WHERE sale_date BETWEEN :startDate AND :endDate ", nativeQuery = true)
    double getTotalSales(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT SUM(si.quantity) AS total_quantity_between_dates_by_productId FROM sale_item si WHERE si.product_id = :productId AND si.sale_id IN ( SELECT sale_id FROM sale WHERE sale_date BETWEEN :startDate AND :endDate ) ", nativeQuery = true)
    int getTotalSalesByProductId(LocalDate startDate, LocalDate endDate, int productId);

    @Query(value = "SELECT EXISTS ( SELECT 1 FROM sale_item si WHERE si.product_id = :productId AND si.sale_id IN ( SELECT sale_id FROM sale WHERE sale_date BETWEEN :startDate AND :endDate ) )  ", nativeQuery = true)
    Long productIdExistsInSaleTbl(LocalDate startDate, LocalDate endDate, Integer productId);
}
