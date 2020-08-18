package com.jk.mapper;

import com.jk.entity.PeopleEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select(" SELECT a.id,a.`name`,a.age,b.`name` as typeName FROM t_people a LEFT JOIN t_people_type b on a.type_id = b.id  ")
    List<PeopleEntity> findpeopleList();



}
