package com.system.kinmel.repo;

import com.system.kinmel.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Integer> {

    @Query(value = "SELECT * from sale where start_date < NOW() and end_date > NOW()", nativeQuery = true)
    List<Sale> saleProducts();

}
