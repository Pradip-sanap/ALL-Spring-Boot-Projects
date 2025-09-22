package com.jpa.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.hibernate.query.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpa.entity.Mobile;


public interface MobileRepository extends JpaRepository<Mobile, Long>{
	
	// ---------------------------
    // 1️⃣ Derived Query Methods
    // ---------------------------
	
	List<Mobile> findByBrand(String brand);
	List<Mobile> findByBrandAndModel(String brand, String model);

	List<Mobile> findByPriceGreaterThan(double price);
	List<Mobile> findByPriceLessThan(double price);
	
	List<Mobile> findByPriceBetween(double lower, double higher);
	
	List<Mobile> findByModelLike(String modelPattern);		// e.g. "%Pro%"
	// Contains (auto adds % both sides)
    List<Mobile> findByModelContaining(String keyword);
    
    // Starts with / Ends with
    List<Mobile> findByModelStartingWith(String prefix);
    List<Mobile> findByModelEndingWith(String suffix);
    
 // --------------- ORDERING ---------------
    // Order by ascending / descending
    List<Mobile> findByBrandOrderByPriceAsc(String brand);
    List<Mobile> findByBrandOrderByPriceDesc(String brand);
    
 // --------------- LIMITING RESULTS ---------------
    // First or Top N results
    Mobile findFirstByOrderByPriceAsc();   // cheapest phone
    Mobile findFirstByOrderByPriceDesc();  // most expensive phone
    List<Mobile> findTop3ByBrandOrderByPriceDesc(String brand); // top 3 costly phones by brand
    
 // --------------- BOOLEAN EXPRESSIONS ---------------
    // Exists
    boolean existsBySku(String sku);
    
 // Count
    long countByBrand(String brand);
    
 // ---------------------------
    // 1️⃣ AND / OR / NOT
    // ---------------------------

    List<Mobile> findByBrandAndPriceLessThan(String brand, double price);

    List<Mobile> findByBrandOrBrand(String brand1, String brand2);

    List<Mobile> findByPriceNot(double price);

    List<Mobile> findByBrandNot(String brand);


    // ---------------------------
    // 2️⃣ IN / NOT IN
    // ---------------------------

    List<Mobile> findByBrandIn(List<String> brands);

    List<Mobile> findByBrandNotIn(List<String> brands);


    // ---------------------------
    // 3️⃣ DISTINCT
    // ---------------------------

    List<Mobile> findDistinctByBrand(String brand);


    // ---------------------------
    // 4️⃣ PAGINATION + SORTING
    // ---------------------------

    // Pageable → for pagination
//    Page findByBrand(String brand, Pageable pageable);
    
    

    // Sorting → dynamic sorting
    List<Mobile> findById(String os, Sort sort);

    // 5️⃣ BOOLEAN KEYWORDS 

    List<Mobile> findByStockGreaterThan(int stock);

    List<Mobile> findByStockIs(int stock);

    List<Mobile> findByStockIsNot(int stock);

    List<Mobile> findByStockIsNull();

    List<Mobile> findByStockIsNotNull();
    
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    
    // ---------------------------
    // JPQL Queries
    // --------------------------- 
    
    // 1️⃣ BASIC SELECT QUERIES 

    // Fetch all mobiles
    @Query("SELECT m FROM Mobile m")
    List<Mobile> findAllMobilesJPQL();

    // Fetch by brand
    @Query("SELECT m FROM Mobile m WHERE m.brand = ?1")
    List<Mobile> findByBrandJPQL(String brand);

    // Fetch by price less than
    @Query("SELECT m FROM Mobile m WHERE m.price < :price")
    List<Mobile> findCheaperThan(@Param("price") double price);

    @Query("SELECT m FROM Mobile m WHERE m.brand = :brand AND m.price < :price")
    List<Mobile> findCheapMobilesByBrand(String brand, double price);

    
 // -------------------------------
    // 2️⃣ SPECIFIC FIELD SELECTION
    // -------------------------------

    // Select only model names
    @Query("SELECT m.model FROM Mobile m WHERE m.brand = :brand")
    List<String> findModelsByBrand(@Param("brand") String brand);

    // Select multiple fields (Object[] projection)
    @Query("SELECT m.brand, m.model, m.price FROM Mobile m")
    List<Object[]> findBrandModelPrice();
    
 // 4️⃣ AGGREGATE FUNCTIONS 

    @Query("SELECT COUNT(m) FROM Mobile m WHERE m.brand = :brand")
    long countByBrandJPQL(@Param("brand") String brand);

    @Query("SELECT AVG(m.price) FROM Mobile m")
    double averagePrice();

    @Query("SELECT MAX(m.price) FROM Mobile m")
    double maxPrice();

    @Query("SELECT MIN(m.price) FROM Mobile m")
    double minPrice();
    
 // 5️⃣ GROUP BY / HAVING 

    @Query("SELECT m.brand, COUNT(m) FROM Mobile m GROUP BY m.brand")
    List<Object[]> countMobilesByBrand();

    @Query("SELECT m.brand, AVG(m.price) FROM Mobile m GROUP BY m.brand HAVING AVG(m.price) > :price")
    List<Object[]> avgPriceByBrandGreaterThan(@Param("price") double price);
	
}
