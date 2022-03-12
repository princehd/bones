package com.smhrd.cairobones.mapper;

import com.smhrd.cairobones.VO.*;
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

    /* 랜드마크 / 계산값 */
    List<tbl_bones_pointVO> getLandmark(int p_seq);
    int landmarkChange(tbl_bones_pointVO bonesPointVO);
    List<tbl_point_valueVO> landmarkValue(int point_seq);
    int valueChange(tbl_point_valueVO pointValueVO);

    /*환자 진단/처방*/
    int patientPre(tbl_patientVO patientVO);
}
