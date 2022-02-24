package com.smhrd.cairobones.service;

import com.smhrd.cairobones.VO.tbl_doctor;
import com.smhrd.cairobones.mapper.bonesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class bonesService {
    // 회원가입 시 저장시간을 넣어줄 DateTime형
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    @Autowired
    bonesMapper mapper;

    public void doJoin(tbl_doctor tbl_doctor) {
    }

    public void bonesJoin(tbl_doctor tbl_doctor){
        mapper.bonesJoin(tbl_doctor);
    }

    public tbl_doctor bonesLogin(tbl_doctor tbl_doctor) {
        tbl_doctor doctorVo = mapper.bonesLogin(tbl_doctor);
        return doctorVo;
    }
}
