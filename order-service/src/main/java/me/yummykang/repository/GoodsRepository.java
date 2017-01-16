package me.yummykang.repository;

import me.yummykang.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/11 13:35
 */
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
}
