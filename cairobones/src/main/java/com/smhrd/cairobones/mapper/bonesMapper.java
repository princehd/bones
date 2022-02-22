package com.smhrd.cairobones.mapper;

import com.smhrd.cairobones.VO.tbl_doctor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface bonesMapper {
    void bonesJoin(tbl_doctor vo);
}
