package com.example.demoMyBatis.mapper;

import com.example.demoMyBatis.model.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FindAllMapper {

    @Select("select * from clients")
    @Results(value = {
            @Result(property = "firstName", column = "first_name")
    })
    List<Client> findAll();
}
