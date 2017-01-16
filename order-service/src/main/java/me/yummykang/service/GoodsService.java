package me.yummykang.service;

import me.yummykang.entity.Goods;
import me.yummykang.exception.BusinessException;
import me.yummykang.repository.GoodsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/11 13:34
 */
@Service
public class GoodsService {
    private Logger logger = LoggerFactory.getLogger(GoodsService.class);

    @Autowired
    private GoodsRepository goodsRepository;

    public Integer buyOne() {
        Goods goods = goodsRepository.findOne(1);
        if (goods.getNum() == 0) {
            try {
                throw new BusinessException("001", "已经没有库存啦");
            } catch (BusinessException e) {
                logger.error("------________{}________-------", e.getErrorMsg());
            }
        } else {
            goods.setNum(goods.getNum() - 1);
            goodsRepository.save(goods);
        }
        return goods.getNum();
    }
}
