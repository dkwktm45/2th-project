package com.test.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.test.mapper.guest;
import com.test.mapper.mainMapper;
import com.test.mapper.videoDT;
import com.sun.org.apache.xerces.internal.util.URI;
import com.test.mapper.accessController;
import com.test.mapper.deepPostures;
import com.test.mapper.exinfo;

@RestController
public class Restmember {
	
	@Inject
	private mainMapper mapper;

	@RequestMapping(value="/insertExURL.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String insertURL(HttpServletRequest request) throws Exception {
		
    	System.out.println("저장할려는중");
    	String cnt = request.getParameter("cnt");
    	String user_id =  request.getParameter("user_id");
    	
    	int ex_seq = Integer.parseInt(request.getParameter("ex_seq"));
    	
    	ServletInputStream input = request.getInputStream();

    	
    	double randomValue = Math.random();
    	String file_name = Double.toString((randomValue*100)+1);
    	FileOutputStream out = new FileOutputStream(new File("C:\\Users\\SMHRD2\\project2\\"+file_name+".webm"));
    	
    	
    	
    	
        byte[] charBuffer = new byte[128];
        
        int bytesRead = -1;
        while ((bytesRead = input.read(charBuffer)) > 0) {
        	out.write(charBuffer, 0, bytesRead);
        }
    	
    	input.close();
    	out.close();

    	mapper.inertCNT(cnt , ex_seq);
        mapper.insertURL(user_id,ex_seq,file_name);
		return "main.do";
        
	}
	
	@RequestMapping(value="/insertBadImage.do", method= {RequestMethod.GET, RequestMethod.POST})
    public void insertBadImage(HttpServletRequest request) throws Exception {
		
    	//String fileName = file.getOriginalFilename();
    	//System.out.print(request.getParameter("data"));
    	System.out.println(request.getParameter("ai_comment"));
    	
    	String ai_comment =  request.getParameter("ai_comment");
    	
    	int ex_seq = Integer.parseInt(request.getParameter("ex_seq"));
    	
    	System.out.println(ex_seq);
    	
    	//ServletInputStream input = request.getInputStream();

    	
    	double randomValue = Math.random();
    	String pose_result = Double.toString((randomValue*100)+1);
    	FileOutputStream out = new FileOutputStream(new File("C:\\Users\\SMHRD2\\badImage\\"+pose_result+".jpg"));

        byte[] charBuffer = new byte[128];
        
        int bytesRead = 0;
        while ((bytesRead = System.in.read()) != -1) {
        	//System.out.println("저장중");
        	out.write(bytesRead);
        }
    	
    	//input.close();
    	out.close();
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("ai_comment", ai_comment);
    	map.put("ex_seq", ex_seq);
    	map.put("pose_result", pose_result);
    	
    	System.out.println("저장 끝");
    	
        mapper.insertbadImage(map);
		//return "main.do";
        
	}
	
    @RequestMapping(value="/memberExinfo.do", method= {RequestMethod.GET, RequestMethod.POST})
    public List<exinfo> memberExinfo(String user_id , HttpServletRequest req) throws Exception {
		System.out.println(user_id);
    	HttpSession session = req.getSession();
    	
    	List<exinfo> memberVideo = mapper.memberExinfo(user_id);
    	session.setAttribute("memberVideo", memberVideo);
    	System.out.println(memberVideo);
		return memberVideo;
        
	}
    
    @RequestMapping(value="/memberName.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "text/html; charset=utf-8")
    public String memberName(int video_seq , HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println(video_seq);
		req.setCharacterEncoding("utf-8");
		//HttpSession session = req.getSession();
		guest memberVideo = mapper.memberName(video_seq);
		//session.setAttribute("memberVideo", memberVideo);
		System.out.print(memberVideo.getUser_name());
		
		return memberVideo.getUser_name();
        
	}
    
    @RequestMapping(value="/calendarView.do" , method= {RequestMethod.GET, RequestMethod.POST})
    public List<exinfo> calendarView(String user_id , String ex_date , HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println(ex_date);
		System.out.println(user_id);
		//HttpSession session = req.getSession();
		List<exinfo> memberVideo = mapper.calendarView(user_id , ex_date);
		//session.setAttribute("memberVideo", memberVideo);
		System.out.print(memberVideo);
		
		return memberVideo;
        
	}
    
    @RequestMapping(value="/dateVideo.do", method= {RequestMethod.GET, RequestMethod.POST})
    public String dateVideo(String user_id ,String video_date, HttpServletRequest req) throws Exception {
		System.out.println(user_id);
		System.out.println(video_date);
    	
		HttpSession session = req.getSession();
    	
    	List<videoDT> memberVideo = mapper.dateVideo(user_id,video_date);
    	session.setAttribute("memberVideo", memberVideo);
    	//System.out.println(memberVideo);
		
    	return "record.do";
	}
    
    @RequestMapping(value="/insertPose.do", method= {RequestMethod.GET, RequestMethod.POST})
    public List<deepPostures> insertPose( Model model , int video_seq ,String video_date, HttpServletRequest req) throws Exception {
		
		System.out.println(video_seq);
		List<deepPostures> List = mapper.selectVideo(video_seq);
    	
		System.out.println(List);
		

		return List;
	}
}


















