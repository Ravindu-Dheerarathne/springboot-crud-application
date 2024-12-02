package com.example.PointofSale.repository;

import com.example.PointofSale.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface SaleItemRepo extends JpaRepository<SaleItem,Integer> {
}
