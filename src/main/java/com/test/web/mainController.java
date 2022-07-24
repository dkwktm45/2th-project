package com.test.web;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.mapper.accessController;
import com.test.mapper.exinfo;
import com.test.mapper.guest;
import com.test.mapper.mainMapper;
import com.test.mapper.videoDT;


@Controller
public class mainController {
	
	@Autowired
	private mainMapper mapper;
	
	@RequestMapping("/admin.do")
	public String admin(HttpServletRequest req) {
		
		HttpSession session = req.getSession();

		List<videoDT> memberVideo= mapper.ALLVideo();
		
		session.setAttribute("memberVideo", memberVideo);
		
		return "admin";
	}
	
	@RequestMapping("/admin_member.do")
	public String admin_member(Model model) {
		List<guest> member = mapper.adminList();
		model.addAttribute("member", member);
		return "admin_member";
	}
	
	@RequestMapping("/extensionMember.do")
	public String extensionMember(guest memberVO,Model model) {
		
		mapper.extensionMember(memberVO);
		return  "redirect:/admin_member.do";
	}
	
	@RequestMapping("/test.do")
	public String test() {
		return "test";
	}
	@RequestMapping("/calender.do")
	public String calender() {
		return "calender";
	}
	
	

	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/record.do")
	public String record(String user_id, HttpServletRequest req) {
		
		HttpSession session = req.getSession();

		List<videoDT> memberVideo= mapper.memberVideo(user_id);
		
		//System.out.println(memberVideo);
		session.setAttribute("memberVideo", memberVideo);
		

		//return "redirect:/record.do";
		return "record";
	}
	

	@RequestMapping("/join.do")
	public String join() {
		return "join";
	}
	
	
	@RequestMapping("/login.do")
	public String login() {
		//mapper.loginInsert(title);
		return "login"; 
	}
	
	@RequestMapping("/cam.do")
	public String cam() {
		return "cam"; 
	}
	
	@RequestMapping("/warmingup.do")
	public String warmingup() {
		return "warmingup"; 
	}
	

	//안 쓰는 것
	@RequestMapping(value="/insertEx.do")
    public String insertEx(exinfo memberVO , HttpServletRequest req,  RedirectAttributes rttr) throws Exception {
		
		//System.out.println(memberVO.getUser_id());
		System.out.println(memberVO.getEx_count());
		System.out.println(memberVO.getUser_set());
		System.out.println(memberVO.getUser_id());
		System.out.println(memberVO.getEx_name());
		System.out.println(memberVO.getEx_kinds());
		System.out.println(memberVO.getUser_id());
        
		HttpSession session = req.getSession();
		mapper.insertEx(memberVO);
		
		exinfo ex_seq2 = mapper.selectEx(memberVO);
		mapper.insertDeep(ex_seq2);
		
		System.out.println(ex_seq2);
		session.setAttribute("ex_seq2",ex_seq2);
        return "redirect:/cam.do";
        
	}
	
	
	@RequestMapping(value="/infoCalender.do")
    public String infoCalender(String user_id ,HttpServletRequest req){

		HttpSession session = req.getSession();
		List<accessController> day_time = mapper.infoCalender(user_id);
		session.setAttribute("day_time",day_time);
        return "redirect:/test.do";
        
	}
	
	
	@RequestMapping(value="/loginInsert.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String memberLogin(guest memberVO , HttpServletRequest req,  RedirectAttributes rttr) throws Exception {
		
		System.out.println(memberVO.getUser_id()); // 회원번호
		System.out.println(memberVO.getUser_gym()); // 지점
        
		HttpSession session = req.getSession();
        guest member = mapper.memberLogin(memberVO);
        
        if(member == null) {
        	System.out.print("로그인 실패");
            session.setAttribute("member", null);
            rttr.addFlashAttribute("msg", false);
            return "redirect:/login.do";
        } else {
        	if (member.getManager_yn() == 1) {
        		System.out.print("로그인 성공");
        		session.setAttribute("member", member);
        		return "redirect:/admin.do";
        	}else {
	        	System.out.print("로그인 성공");
	            session.setAttribute("member", member);
	            return "redirect:/main.do";
        	}
        }
	}
	
	@RequestMapping(value="/insertJoin.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String insertJoin(guest memberVO ) {
		
		mapper.insertJoin(memberVO);
        
        
        return "redirect:/join.do";
	}
}
