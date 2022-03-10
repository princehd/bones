package com.smhrd.cairobones.service;

import com.smhrd.cairobones.VO.tbl_bulletinVO;
import com.smhrd.cairobones.VO.tbl_commentVO;
import com.smhrd.cairobones.VO.tbl_doctorVO;
import com.smhrd.cairobones.VO.tbl_patientVO;
import com.smhrd.cairobones.mapper.bonesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

    public List<tbl_patientVO> getPatientList() {
        return mapper.patientList();
    }

    public tbl_patientVO detail(int p_seq) {
        return mapper.detail(p_seq);
    }

    public List<tbl_bulletinVO> getBulletin(){
        return mapper.getBulletin();
    }

    public tbl_bulletinVO bulletinDetail(int article_seq){
        return mapper.bulletinDetail(article_seq);
    }

    public int bulletinWrite(tbl_bulletinVO bulletinVO) {
        return mapper.bulletinWrite(bulletinVO);
    }

    public int bulletinUpdate(tbl_bulletinVO bulletinVO){
        return mapper.bulletinUpdate(bulletinVO);
    }

    public void bulletinDelete(int article_seq){
        mapper.bulletinDelete(article_seq);
    }

    public void commentWrite(tbl_commentVO commentVO) {
        mapper.commentWrite(commentVO);
    }

    public List<tbl_commentVO> getCommentList() {
        return mapper.getCommentList();
    }
}
