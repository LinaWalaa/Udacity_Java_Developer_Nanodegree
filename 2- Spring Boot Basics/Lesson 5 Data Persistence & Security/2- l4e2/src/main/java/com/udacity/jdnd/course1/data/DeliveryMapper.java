package com.udacity.jdnd.course1.data;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DeliveryMapper {

    @Select("SELECT * FROM DELIVERY WHERE id = #{id}")
    public Delivery findDelivery(Integer id);

    @Insert("INSERT INTO DELIVERY (order_id, time) VALUES(#{order_id}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Integer insert(Delivery delivery);

    @Delete("DELETE FROM DELIVERY WHERE id = #{id}")
    public void delete(Integer id);
}

