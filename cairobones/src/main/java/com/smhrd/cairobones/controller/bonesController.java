package com.smhrd.cairobones.controller;

import com.smhrd.cairobones.VO.tbl_doctor;
import com.smhrd.cairobones.mapper.bonesMapper;
import com.smhrd.cairobones.service.bonesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;

@Controller
@RequiredArgsConstructor
public class bonesController {

    @Autowired
    bonesService service;

    @GetMapping("/join")
    public String bonesJoin(){
        return "/join";
    }

    @PostMapping("/doJoin")
    private String doJoin(tbl_doctor tbl_doctor){
        service.doJoin(tbl_doctor);
        return "redirect:/login";
    }
}
