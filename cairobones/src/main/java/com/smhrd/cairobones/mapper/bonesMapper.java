package com.smhrd.cairobones.mapper;

import com.smhrd.cairobones.VO.tbl_doctorVO;
import com.smhrd.cairobones.VO.tbl_patientVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface bonesMapper {
    void bonesJoin(tbl_doctorVO tbl_doctor);
    tbl_doctorVO bonesLogin(tbl_doctorVO tbl_doctor);
    int fileUpload(tbl_patientVO xrayFile);
    tbl_patientVO fileView(int p_seq);
}
