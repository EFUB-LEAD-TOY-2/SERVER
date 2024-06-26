package com.efub.leadtoyproject.domain.item.repository;

import com.efub.leadtoyproject.domain.item.domain.Item;
import com.efub.leadtoyproject.domain.product.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE i.itemId IN :itemIds")
    List<Item> findAllByIds(List<Long> itemIds);
    List<Item> findByProductProductId(Long productId);
}
