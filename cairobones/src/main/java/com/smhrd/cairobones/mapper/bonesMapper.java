package com.smhrd.cairobones.mapper;

import com.smhrd.cairobones.VO.tbl_bulletinVO;
import com.smhrd.cairobones.VO.tbl_commentVO;
import com.smhrd.cairobones.VO.tbl_doctorVO;
import com.smhrd.cairobones.VO.tbl_patientVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface bonesMapper {
    void bonesJoin(tbl_doctorVO tbl_doctor);
    tbl_doctorVO bonesLogin(tbl_doctorVO tbl_doctor);
    int fileUpload(tbl_patientVO xrayFile);
    tbl_patientVO fileView(int p_seq);

    List<tbl_patientVO> patientList();

    tbl_patientVO detail(int p_seq);

    /*게시판*/
    List<tbl_bulletinVO> getBulletin();
    tbl_bulletinVO bulletinDetail(int article_seq);
    int bulletinWrite(tbl_bulletinVO bulletinVO);
    int bulletinUpdate(tbl_bulletinVO bulletinVO);
    void bulletinDelete(int article_seq);
    void commentWrite(tbl_commentVO commentVO);
    List<tbl_commentVO> getCommentList(int article_seq);
    void commentUpdate(tbl_commentVO commentVO);
    void commentDelete(int comment_seq);
}
