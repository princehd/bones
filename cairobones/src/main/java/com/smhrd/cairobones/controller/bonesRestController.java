package com.smhrd.cairobones.controller;

import com.smhrd.cairobones.VO.tbl_commentVO;
import com.smhrd.cairobones.service.bonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class bonesRestController {

    @Autowired
    bonesService service;

    @PostMapping("/getCommentList/{article_seq}")
    public List<tbl_commentVO> commentList(@PathVariable int article_seq){
        List<tbl_commentVO> commentList = service.getCommentList(article_seq);
        return commentList;
    }
}
