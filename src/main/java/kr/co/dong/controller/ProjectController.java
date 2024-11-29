package kr.co.dong.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.dong.board.AuthService;
import kr.co.dong.board.BoardsDTO;
import kr.co.dong.board.NaverUserInfo;
import kr.co.dong.board.ProductDTO;
import kr.co.dong.board.ProjectService;
import kr.co.dong.board.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Inject
	ProjectService projectService;
	
	@Inject
	AuthService authService;

    @Autowired
    public void SocialLoginController(AuthService authService) {
        this.authService = authService;
    }

    // 네이버 로그인 콜백
	@RequestMapping(value ="product/naver_login", method = RequestMethod.GET)
    public String naverCallback(@RequestParam("code") String code, @RequestParam("state") String state, HttpSession session) {
        try {
            // 1. 액세스 토큰 발급
            String accessToken = authService.getAccessToken(code);

            // 2. 사용자 정보 가져오기
            NaverUserInfo userInfo = authService.getUserInfo(accessToken);

            // 3. 세션에 사용자 정보 저장
            session.setAttribute("socialUser", userInfo);
            
            // 4. 메인 페이지로 리다이렉트
            return "redirect:/";

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login?error=true";
        }
    }
	

	
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
	
	//로그아웃 처리
	@RequestMapping(value="product/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, RedirectAttributes rttr) {
		session.invalidate();
		logger.info("로그아웃 구현");
		rttr.addFlashAttribute("msg","로그아웃 완료");
		return "redirect:/";
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
	
	//중복체크 처리
	@RequestMapping(value="product/id_check", method= RequestMethod.GET)
	public String id_check(@RequestParam("user_id")String user_id, HttpServletRequest request, Model model) throws Exception{
		model.addAttribute("user_id", user_id);

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
	
	//아이디  찾기 처리
	@RequestMapping(value="product/id_search", method = RequestMethod.GET)
	public String id_search() {
		logger.info("아이디 찾기 화면");
		return "id_search";
	}
	
	@RequestMapping(value="product/id_search", method = RequestMethod.POST)
	public String id_Search(@RequestParam Map<String,Object> map, 
		HttpServletRequest request, HttpServletResponse response,
		RedirectAttributes rttr, Model model ) throws Exception {
			request.setCharacterEncoding("UTF-8");
			logger.info("아이디 찾기");
			
			String id = projectService.id_search(map);
			
			model.addAttribute("id",id);
			
			if(id == null) {
				rttr.addFlashAttribute("msg","존재하지 않는 아이디입니다.");
			}else {
				rttr.addFlashAttribute("msg",id+"입니다.");
			}
			//get으로 감
			return "redirect:/product/id_search";
			
	}
			
			
		//비밀번호 찾기 처리
		@RequestMapping(value="product/pwd_search", method = RequestMethod.GET)
		public String pwd_search() {
			logger.info("비밀번호 찾기 화면");
			return "pwd_search";
		}
		
		@RequestMapping(value="product/pwd_search", method = RequestMethod.POST)
		public String pwd_search(@RequestParam("user_id")String user_id, HttpServletRequest request,
				HttpServletResponse response, RedirectAttributes rttr, Model model)throws Exception{
			request.setCharacterEncoding("UTF-8");
			logger.info("비밀번호 찾기");
			
			String id = projectService.pwd_search(user_id);
			
			 if (id == null) { // ID가 없는 경우
			        rttr.addFlashAttribute("msg", "존재하지 않는 아이디입니다."); // 메시지 전달
			        return "redirect:/product/pwd_search"; // 비밀번호 찾기 화면으로 이동
			    }

			    model.addAttribute("id", id); // ID를 JSP로 전달
			    return "pwd_search"; // 성공 시 JSP로 전달
			}
		
		
			//비밀번호 변경 처리
			@RequestMapping(value="product/pwd_change", method = RequestMethod.POST)
			public String pwd_change(@RequestParam("user_id")String user_id, @RequestParam("user_password")String user_password, HttpServletRequest request,
				 HttpServletResponse response, RedirectAttributes rttr, Model model)throws Exception{
				request.setCharacterEncoding("UTF-8");
				logger.info("비밀번호 변경");
				
				int result = projectService.pwd_change(user_id, user_password);
				
				//model.addAttribute("r",r);
				
				if (result > 0) { // 변경 성공
			        rttr.addFlashAttribute("msg", "비밀번호가 성공적으로 변경되었습니다!");
			    } else { // 변경 실패
			        rttr.addFlashAttribute("msg", "비밀번호 변경에 실패했습니다. 다시 시도해 주세요.");
			    }

			    return "redirect:/product/pwd_search"; // 완료 후 비밀번호 찾기 화면으로 이동
			}
			
	//제품 상세페이지
		@RequestMapping(value="product/detail", method=RequestMethod.GET)
		public String ProductDetail(@RequestParam("product_id") String product_id, Model model) {
			ProductDTO vo = projectService.productDetail(product_id);
			model.addAttribute("product", vo);
			
			//제품의 모든 이미지 조회
			List<String> file_name = projectService.fileSelect(product_id);
			model.addAttribute("file_name", file_name);
			
			List<BoardsDTO> review_list = projectService.review_list(product_id);
			model.addAttribute("review_list", review_list);

			//상품평
		
			logger.info("상세페이지");
			return "product_detail";
		}
	
	
	
	

	
	
	
}
