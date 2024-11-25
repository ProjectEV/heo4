package kr.co.dong.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.Session;

import kr.co.dong.board.BoardDTO;
import kr.co.dong.board.BoardsDTO;
import kr.co.dong.board.ProjectService;
import kr.co.dong.board.UserDTO;

@Controller
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Inject
	ProjectService projectService;
	
	//로그인처리
	@RequestMapping(value ="product/login", method = RequestMethod.GET) 
	
	public String login() {
		return "login_2";
	}
	
	@RequestMapping(value ="product/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String,Object> map,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		request.setCharacterEncoding("UTF-8");
		Map<String, Object> user = projectService.login(map);
		
		if(user == null) {
			logger.info("로그인 실패");
			return "redirect:/product/login";
		}else {
			session.setAttribute("user", user);
			return "redirect:/";
		}
	}
	
	//회원가입  처리
	@RequestMapping(value ="product/join", method = RequestMethod.GET)
	public String join() {
		logger.info("회원가입 화면");
		return "join";
	}
	
	
	
	
	@RequestMapping(value ="product/join", method = RequestMethod.POST)
	public String join(UserDTO userDTO, HttpServletRequest request,RedirectAttributes rttr) throws Exception {
		request.setCharacterEncoding("UTF-8");
		logger.info("yes");
		int r = projectService.join(userDTO);
		
		if(r>0) {
			rttr.addFlashAttribute("msg","ok");			
			
		}
		return "login_2";
	}
	
	//리뷰작성 처리
	@RequestMapping(value="product/review", method = RequestMethod.GET)
	public String review(Model model, HttpSession session) {
		logger.info("리뷰작성 화면");
		//session에 담겨있는 아이디 값 리뷰 데이터로 넘겨주기 위한 처리
		Map r = (Map)session.getAttribute("user");
		String user_id =(String)r.get("user_id");
		model.addAttribute("user_id",user_id);
		
		   
		return "review";
	}
		
	@RequestMapping(value="product/review", method = RequestMethod.POST)
	
	public String review(BoardsDTO boardsDTO, HttpServletRequest request,RedirectAttributes rttr, HttpSession session,
		HttpServletResponse response ) throws Exception {
		request.setCharacterEncoding("UTF-8");
		logger.info("리뷰내용"+boardsDTO);
		
		int r = projectService.review(boardsDTO);
		
		if(r>0) {
			rttr.addFlashAttribute("msg","완료");
		}
		return "home_2";
		
	}
	
	@RequestMapping(value="product/id_check", method= RequestMethod.GET)
	public String id_check() {
		logger.info("중복체크 화면");
		return "id_check";
	}
	
	
	
	@RequestMapping(value="product/id_check", method = RequestMethod.POST)
	public String id_check(@RequestParam("user_id")String user_id, HttpServletRequest request, HttpServletResponse response,RedirectAttributes rttr, Model model) throws Exception {
		request.setCharacterEncoding("UTF-8");
		logger.info("중복체크");
		int r = projectService.id_check(user_id);
		
		model.addAttribute("r",r);
		model.addAttribute("user_id", user_id);
		
		return "id_check";
		
		
		
		
	}
	
	
	
	

	
	
	
}
