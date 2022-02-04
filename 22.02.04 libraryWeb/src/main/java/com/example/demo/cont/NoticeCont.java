package com.example.demo.cont;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.svc.NoticeSVC;
import com.example.demo.vo.NoticeVO;
import com.example.demo.vo.PagingVO;

@Controller
@RequestMapping("/library")
public class NoticeCont {
	
	@Autowired
	private NoticeSVC noticeSvc;
     
    @RequestMapping("/notice")
    public String noticeList(@ModelAttribute("Notice") NoticeVO notice,
                            @RequestParam(defaultValue="1") String page,
                            Model model
                                ) {
    	int curPage = Integer.parseInt(page);
    		if (page.equals("undefined")) {
    			curPage = 1;
    		}
        int listCnt = noticeSvc.getNoticeListCount();
        PagingVO paging = new PagingVO(listCnt, curPage);
        notice.setStartIndex(paging.getStartIndex());
        notice.setCntPerPage(paging.getPageSize());
             
        List<NoticeVO> noticeList=noticeSvc.getNoticeList(notice);
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("listCnt", listCnt);
        model.addAttribute("paging", paging);
        return "notice/noticeList";
    }
     
    @RequestMapping("/noticeRegi")
    public String noticeRegi() {
            return "notice/noticeEdit";
    }
     
    @RequestMapping("/noticeDetail/{notice_id}")
    public String noticeDetail(@PathVariable String notice_id, Model model) {
        model.addAttribute("notice",noticeSvc.getNoticeOne(notice_id));
        return "notice/noticeDetail";
    }
    
    @GetMapping("/noticeEdit")
    public String noticeEdit(
    		@RequestParam("notice_id") String notice_id ,
    		@RequestParam("curPage") int curPage,
    		Model model) {
        model.addAttribute("notice",noticeSvc.getNoticeOne(notice_id));
        model.addAttribute("curPage",curPage);
        return "notice/noticeEdit";
    }

     
    @ResponseBody
    @PostMapping("/noticeInsert")
    public boolean noticeInsert(NoticeVO notice) {
      return noticeSvc.NoticeInsert(notice);
    }
     
    @ResponseBody
    @PostMapping("/noticeUpdate")
    public boolean noticeUpdate(NoticeVO notice) {
        return noticeSvc.NoticeUpdate(notice);
    }
     
    @PostMapping("/noticeDelete")
    @ResponseBody
    public Map<String,Object> noticeDelete(@RequestParam("no") String no) {
    	Map<String,Object> map = new HashMap<>();
    	map.put("ok" , noticeSvc.NoticeDelete(no));
        return map;
    }
}
