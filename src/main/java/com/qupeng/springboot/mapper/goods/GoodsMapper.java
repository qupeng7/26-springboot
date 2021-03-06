package com.qupeng.springboot.mapper.goods;

import com.qupeng.springboot.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectAllGoods();

    int updateByStore(@Param("goodsId") Integer goodsId, @Param("buyNum") Integer buyNum);
}