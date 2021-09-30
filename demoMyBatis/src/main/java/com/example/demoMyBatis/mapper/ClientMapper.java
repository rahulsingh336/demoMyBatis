package com.example.demoMyBatis.mapper;

import com.example.demoMyBatis.model.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClientMapper {

    /*@Select("SELECT id as id, first_name as firstName, last_name as lastName FROM spring_demo.clients WHERE id = #{id}")
    Client selectOne(long id);
*/
    List<Client> findByFirstName(String firstName);

    //@Select("select * from clients")
    List<Client> findAllUsers();

}
