package com.example.demo.cont;

import java.io.File;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("library")
public class UploadCont {

	@Autowired
  ResourceLoader resourceLoader;
	
  @PostMapping("upload")
  @ResponseBody
  public String uploadajax(@RequestParam("files")MultipartFile[] mfiles,
        HttpServletRequest request) {
     ServletContext context = request.getServletContext();
     String savePath = context.getRealPath("/WEB-INF/upload");
     Random rd = new Random();
     try {
        for(int i=0;i<mfiles.length;i++) {
        	String saveName = savePath+"/"
        +Integer.toString(rd.nextInt(9999))+"%"
        			+mfiles[i].getOriginalFilename();
          mfiles[i].transferTo(new File(saveName));
        }
        String msg = String.format("파일(%d)개가 업로드 되었습니다.", mfiles.length);
        return msg;
     } catch (Exception e) {
        e.printStackTrace();
        return "파일 저장 실패:";
     }

  }

  
}
