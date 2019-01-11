package com.zime.toup.dao;

import com.zime.toup.entity.Orderview;
import com.zime.toup.entity.OrderviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderviewMapper {
    long countByExample(OrderviewExample example);

    int deleteByExample(OrderviewExample example);

    int insert(Orderview record);

    int insertSelective(Orderview record);

    List<Orderview> selectByExample(OrderviewExample example);

    int updateByExampleSelective(@Param("record") Orderview record, @Param("example") OrderviewExample example);

    int updateByExample(@Param("record") Orderview record, @Param("example") OrderviewExample example);
}