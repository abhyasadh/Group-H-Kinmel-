package com.system.kinmel.repo;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
    @Query(value = "SELECT * FROM cart WHERE user_id = ?1 AND status='Added'", nativeQuery = true)
    Optional<List<Cart>> fetchAll(Integer userId);

    @Query(value = "SELECT product_id FROM cart WHERE status='Purchased' LIMIT 4", nativeQuery = true)
    Optional<List<Integer>> fetchTrending();

    @Query(value = "SELECT product_id, COUNT(product_id) FROM cart GROUP BY product_id ORDER BY COUNT(product_id) DESC LIMIT 4", nativeQuery = true)
    Optional<List<Integer>> most();

    @Query(value = "SELECT product_id, SUM(quantity) AS sum_column1 FROM cart GROUP BY product_id ORDER BY sum_column1 DESC LIMIT 4", nativeQuery = true)
    Optional<List<Integer>> best();


    @Query(value = "SELECT user_id, COUNT(*) as count FROM Cart GROUP BY user_id",nativeQuery = true)
    List<Object[]> fetchAllCustomer();


    @Query(value = "SELECT SUM(c.quantity * p.product_price) AS weekly_sales FROM cart c JOIN products p ON c.product_id = p.id WHERE c.created_date >= NOW() - INTERVAL '7 weeks' GROUP BY DATE_TRUNC('week', c.created_date) ORDER BY DATE_TRUNC('week', c.created_date) DESC",nativeQuery = true)
    List<Integer> fetchlast5weeksales();

//    @Query(nativeQuery = true, value = "SELECT COALESCE(SUM(c.quantity * p.product_price), 0) AS daily_sales, d.sale_date "
//            + "FROM (SELECT generate_series(NOW() - INTERVAL '1 week', NOW(), '1 day')::date AS sale_date) d "
//            + "LEFT JOIN cart c ON DATE_TRUNC('day', c.created_date) = d.sale_date "
//            + "LEFT JOIN products p ON c.product_id = p.id "
//            + "GROUP BY d.sale_date ORDER BY d.sale_date DESC")
//    List<Object[]> getDailySalesLastWeek();

    @Query(nativeQuery = true, value = "SELECT COALESCE(SUM(c.quantity * p.product_price), 0) AS daily_sales, d.sale_date "
            + "FROM (SELECT generate_series(NOW() - INTERVAL '1 week', NOW(), '1 day') AS sale_date) d "
            + "LEFT JOIN cart c ON DATE_TRUNC('day', c.created_date) = CAST(d.sale_date AS DATE) "
            + "LEFT JOIN products p ON c.product_id = p.id "
            + "GROUP BY d.sale_date ORDER BY d.sale_date DESC")
    List<Object[]> getDailySalesLastWeek();




    @Query(nativeQuery = true, value = "SELECT p.id AS product_id, p.product_name, COALESCE(SUM(c.quantity), 0) AS quantity_sold "
            + "FROM products p "
            + "LEFT JOIN cart c ON c.product_id = p.id AND DATE_TRUNC('week', c.created_date) = DATE_TRUNC('week', NOW() - INTERVAL '1 week') "
            + "GROUP BY p.id, p.product_name "
            + "ORDER BY quantity_sold DESC")
    List<Object[]> getProductSalesLastWeek();

    @Query(nativeQuery = true, value = "SELECT c.status, COUNT(*) AS status_count "
            + "FROM cart c "
            + "WHERE c.created_date >= NOW() - INTERVAL '1 week' "
            + "GROUP BY c.status")
    List<Object[]> getStatusCountLastWeek();

    @Query(value = "SELECT DISTINCT c.status FROM Cart c",nativeQuery = true)
    List<String> findDistinctStatuses();

    @Query(nativeQuery = true,value = "SELECT * from Cart")
    List<Cart> findallCart();


    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE Cart SET status = :status WHERE id = :id")
    void updateTaskStatus(@Param("id") Integer id, @Param("status") String status);










}
