package com.smhrd.cairobones.service;

import com.smhrd.cairobones.VO.tbl_doctorVO;
import com.smhrd.cairobones.VO.tbl_patientVO;
import com.smhrd.cairobones.mapper.bonesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class bonesService {
    // 회원가입 시 저장시간을 넣어줄 DateTime형
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    @Autowired
    bonesMapper mapper;

    public void doJoin(tbl_doctorVO tbl_doctor) {
    }

    public void bonesJoin(tbl_doctorVO tbl_doctor){
        mapper.bonesJoin(tbl_doctor);
    }

    public tbl_doctorVO bonesLogin(tbl_doctorVO tbl_doctor) {
        tbl_doctorVO doctorVo = mapper.bonesLogin(tbl_doctor);
        return doctorVo;
    }

    // 티스토리 블로그
    public int fileUpload(tbl_patientVO xrayFile){
        return mapper.fileUpload(xrayFile);
    }

    public tbl_patientVO fileView(int p_seq) {
        return mapper.fileView(p_seq);
    }

    /*public void fileUpload(tbl_patientVO tbl_patient, MultipartFile file) throws Exception{
        // 저장 경로 설정
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        // 식별자(UUID) 이용해서 파일 이름 설정
        // 랜덤으로 생성된 식별자 + _ + 파일이름 형식으로 저장됨.
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();

        // File 클래스를 이용해서 저장
        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);

        tbl_patient.setP_xraypath("/files/" + fileName);
        mapper.fileUpload(tbl_patient);
    }

    public tbl_patientVO fileView(int p_seq){

        return p_seq;
    }*/
}
