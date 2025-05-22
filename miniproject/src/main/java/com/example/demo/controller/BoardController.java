package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.FaqDTO;
import com.example.demo.dto.MemberDTO;
import com.example.demo.dto.NoticeDTO;
import com.example.demo.dto.QnaDTO;
import com.example.demo.service.BoardService;
import com.example.demo.session.AdminSession;
import com.example.demo.session.MemberSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private MemberSession userSession;

	// qna 등록 폼 페이지
	@GetMapping("/qnaForm")
	public String qnaForm() {
		return "board/qnaForm"; // 폼 페이지로 이동
	}

	// qna 등록 처리
	@PostMapping("/qnaInsert")
	public String submitQna(QnaDTO qna) {
		// 로그인 세션 확인 (비로그인일 경우 로그인 페이지로 리디렉션)
		if (!userSession.isLoggedIn()) {
			MemberDTO member = new MemberDTO();
			member.setId("user02"); // 샘플 회원 ID
			member.setName("홍길동"); // (선택) 이름
			userSession.login(member); // 로그인 처리

			// return "redirect:/login"; // 로그인 안된 경우 로그인 페이지로 이동
		}

		// 로그인된 사용자의 아이디를 QnA에 설정
		// 위에 나중에 임의로 넣은 값을 빼고 return만 살리면 됨
		qna.setId(userSession.getLoginMember().getId());

		// 기본값 설정
		// 사용자가 qna 등록한 순간 qstatust 대기 입력
		qna.setQstatus("대기");
		// 사용자가 qna 등록한 순간 qdate 현재 날짜 입력
		qna.setQdate(new Date());

		// 등록 처리
		boardService.insertQna(qna);

		// 등록 후 목록 페이지로 이동
		return "redirect:/board/qnaList";
	}

	// qna 페이지
	@GetMapping("/qnaList")
	public String qnaList(Model model) {
		
		
		// 임시로 세션 의 아이디에 user02를 넣어서 되게 만듬
		MemberDTO member = new MemberDTO();
		member.setId("user02"); 
		userSession.login(member); 
		
		 String userId = userSession.getLoginMember().getId();
		
		List<QnaDTO> qnaList = boardService.getQnaList(userId); // qna 목록 조회
		model.addAttribute("qnaList", qnaList);
		return "board/qnaList";
	}

	// qnaList 페이지의 제목을 눌러 상세페이지 들어가는 용
	@GetMapping("/view")
	public String qnaDetail(@RequestParam("qno") String qno, Model model) {
		QnaDTO qna = boardService.getQnaByQno(qno); // qna 상세 조회
		model.addAttribute("qna", qna);
		return "board/qnaDetail";
	}

	// faq 페이지
	@GetMapping("/faqList")
	public String faqList(Model model) {
		List <FaqDTO> faqList = boardService.getFaqList();// faq 목록 조회
		model.addAttribute("faqList",faqList);
		return "board/faqList";
	}
	
	
	// notice 페이지
	@GetMapping("/noticeList")
	public String noticeList(Model model) {
		List<NoticeDTO> noticeList = boardService.getNoticeList();
		model.addAttribute("noticeList", noticeList);
		return "board/noticeList";
	}

}
