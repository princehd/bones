package com.smhrd.cairobones.controller;

import com.smhrd.cairobones.VO.tbl_doctor;
import com.smhrd.cairobones.mapper.bonesMapper;
import com.smhrd.cairobones.service.bonesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.*;

@Controller
@RequiredArgsConstructor
public class bonesController {

    @Autowired
    bonesService service;

    @RequestMapping("/join")
    private String doJoin(){
        return "/cairobones/join";
    }

    @RequestMapping(value = "/doJoin", method = {RequestMethod.POST})
    private String bonesJoin(tbl_doctor tbl_doctor){
        service.bonesJoin(tbl_doctor);
        return "/cairobones/login";
    }

    @RequestMapping("/login")
    private String doLogin(){
        return "/cairobones/login";
    }

    @RequestMapping(value = "/doLogin", method = {RequestMethod.POST})
    private String bonesLogin(tbl_doctor tbl_doctor, HttpSession session){
        tbl_doctor doctorVo = service.bonesLogin(tbl_doctor);
        if(doctorVo != null){
            session.setAttribute("doctorVo", doctorVo);
        }
        return "redirect:/join";
    }
}
