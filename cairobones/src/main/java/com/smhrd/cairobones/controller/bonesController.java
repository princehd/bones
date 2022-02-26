package com.smhrd.cairobones.controller;

import com.smhrd.cairobones.VO.tbl_doctorVO;
import com.smhrd.cairobones.VO.tbl_patientVO;
import com.smhrd.cairobones.service.bonesService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class bonesController {

    @Autowired
    bonesService service;

    @RequestMapping("/join")
    private String doJoin() {
        return "/cairobones/join";
    }

    @RequestMapping(value = "/doJoin", method = {RequestMethod.POST})
    private String bonesJoin(tbl_doctorVO tbl_doctor) {
        service.bonesJoin(tbl_doctor);
        return "/cairobones/login";
    }

    @RequestMapping("/login")
    private String doLogin() {
        return "/cairobones/login";
    }

    @RequestMapping(value = "/doLogin", method = {RequestMethod.POST})
    private String bonesLogin(tbl_doctorVO tbl_doctor, HttpSession session) {
        tbl_doctorVO doctorVo = service.bonesLogin(tbl_doctor);
        if (doctorVo != null) {
            session.setAttribute("doctorVo", doctorVo);
        }
        return "/cairobones/insert";
    }

    // 티스토리 블로그

    @RequestMapping("/fileUpload")
    private String fileUpload(@ModelAttribute tbl_patientVO tbl_patient, @RequestPart MultipartFile file,
                              HttpServletRequest request) throws IllegalStateException, IOException, Exception{

        if(file.isEmpty()){
            service.fileUpload(tbl_patient);
        }else{
            // 사용자 컴퓨터에 저장된 파일명
            String fileName = file.getOriginalFilename();
            //확장자
            String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
            // DB에 저장할 파일 고유명
            File destinationFile;
            String destinationFileName;
            // 절대경로 설정 (설정하지 않으면 마음대로 들어감)
            String fileUrl = "C:\\Users\\cairobones\\xray";

            do{
                //고유명 생성
                destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "_" + fileNameExtension;
                destinationFile = new File(fileUrl + destinationFileName);
            }while(destinationFile.exists());

            destinationFile.getParentFile().mkdirs();
            file.transferTo(destinationFile);

            service.fileUpload(tbl_patient);

            tbl_patientVO patientVO = new tbl_patientVO();
            patientVO.setP_xraypath(destinationFileName);
            patientVO.setP_xray(fileName);
            patientVO.setP_xraypath(fileUrl);

            service.fileUpload(patientVO);
        }

        return "/cairobones/results";
    }

    @RequestMapping("/fileView")
    private String fileView(@PathVariable("p_seq") int p_seq, Model model){
        model.addAttribute("view", service.fileView(p_seq));
        return "/cairobones/results";
    }

    /*// 사진 업로드
    @PostMapping("/fileUpload")
    public String fileUpload(tbl_patientVO tbl_patient, Model model, MultipartFile file) throws Exception {
        service.fileUpload(tbl_patient, file);

        model.addAttribute("message", "파일 업로드가 완료되었습니다.");
        model.addAttribute("serchUrl", "/results");
        return "message";
    }*/

    /*// 사진 수정
    @PostMapping("/fileUpdate")
    public void fileUpdate(@PathVariable("p_seq") tbl_patientVO tbl_patient, MultipartFile file) throws Exception {
        tbl_patientVO voTemp = service.fileView(tbl_patient);
        voTemp.setP_diagnosis(tbl_patient.getP_diagnosis());
        voTemp.setP_prescription(tbl_patient.getP_prescription());
        service.fileUpload(voTemp, file);
    }*/

//    @Value("${spring.servlet.multipart.location}")
//    String filePath;
//
//    @GetMapping("/download")
//    public ResponseEntity<Resource> download(@ModelAttribute tbl_patientVO tbl_patient) throws IOException {
//        Path path = Paths.get(filePath + "/" + tbl_patient.getP_xray());
//        String contentType = Files.probeContentType(path);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(tbl_patient.getP_xray(), StandardCharsets.UTF_8).build());
//        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
//        Resource resource = new InputStreamResource(Files.newInputStream(path));
//        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
//    }

//    @GetMapping("/display")
//    public ResponseEntity<Resource> display(@RequestParam("filename") String filename) {
//        String path = "C:\\Temp\\upload\\";
//        String folder = "";
//        Resource resource = new FileSystemResource(path + folder + filename);
//        if (!resource.exists()) return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
//        HttpHeaders header = new HttpHeaders();
//        Path filePath = null;
//        try {
//            filePath = Paths.get(path + folder + filename);
//            header.add("Content-type", Files.probeContentType(filePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
//    }


}
