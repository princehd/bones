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

    public void bonesJoin(tbl_doctor tbl_doctor){
        tbl_doctor.setDoctor_id("id");
        tbl_doctor.setDoctor_pw("pw");
        tbl_doctor.setDoctor_name("name");
        tbl_doctor.setDoctor_license("doctor_license");
        tbl_doctor.setLicense_date("license_date");
        tbl_doctor.setDoctor_joindate(localTime);
        mapper.bonesJoin(tbl_doctor);
    }

    public void doJoin(tbl_doctor tbl_doctor) {
    }
}
