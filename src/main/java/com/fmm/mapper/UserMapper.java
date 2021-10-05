package com.fmm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fmm.vo.UserVo;

import io.quarkiverse.mybatis.runtime.meta.MapperDataSource;

@Mapper
@MapperDataSource("db1")
public interface UserMapper {
	
	@Select("""
			SELECT * FROM USERS WHERE id = #{id}
			""")
	UserVo getUser(Integer id);

    @Insert("INSERT INTO USERS (id, name) VALUES (#{id}, #{name})")
    Integer createUser(@Param("id") Integer id, @Param("name") String name);

    @Delete("DELETE FROM USERS WHERE id = #{id}")
    Integer removeUser(Integer id);
}
