package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.FaqDTO;
import com.example.demo.dto.NoticeDTO;
import com.example.demo.dto.QnaDTO;
import com.example.demo.service.BoardService;
import com.example.demo.session.AdminSession;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/admin")
public class AdminBoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private AdminSession adminSession;

	// 관리자 qna 목록
	@GetMapping("/qnaList")
	public String adminQnaList(Model model) {
		// ✅ 개발용: 로그인 없이 강제 로그인 처리
		if (!adminSession.isLoggedIn()) {
			AdminDTO admin = new AdminDTO();
			admin.setAid("admin"); // 샘플 관리자 아이디
			admin.setAname("관리자용"); // (선택) 이름도 설정
			adminSession.login(admin); // 세션에 저장
		}

		List<QnaDTO> qnaList = boardService.workList();
		model.addAttribute("qnaList", qnaList);
		return "admin/qnaList";
	}

	// 관리자 qna 질문 폼 페이지
	@GetMapping("/answerForm")
	public String answerForm(@RequestParam("qno") String qno, Model model) {
		// if (!adminSession.isLoggedIn()) return "redirect:/admin/login";
		QnaDTO qna = boardService.getQnaByQno(qno);
		model.addAttribute("qna", qna);
		return "admin/answerForm";
	}

	// 관리자 qna 답변 등록 처리
	@PostMapping("/answerUpdate")
	public String answerSubmit(QnaDTO qna) {
		// if (!adminSession.isLoggedIn()) return "redirect:/admin/login";
		qna.setQstatus("완료");
		boardService.updateAnswer(qna);
		return "redirect:/admin/qnaList";
	}

	// 관리자용 faq 목록 페이지
	@GetMapping("/faqList")
	public String adminFaqList(Model model) {
		List<FaqDTO> faqList = boardService.getFaqList(); // faq 목록 조회
		model.addAttribute("faqList", faqList);
		return "admin/faqList";
	}

	// 관리자용 faq 등록 폼 페이지
	@GetMapping("/faqForm")
	public String faqForm() {
		return "admin/faqForm";
	}

	// faq 등록 처리
	@PostMapping("/faqInsert")
	public String faqInsert(FaqDTO faq) {

		boardService.insertFaq(faq);

		return "redirect:/admin/faqList";
	}

	// faq 삭제 처리
	@PostMapping("/faqDelete")
	public String faqDelete(@RequestParam("fno") String fno) {

		boardService.deleteFaq(fno);
		return "redirect:/admin/faqList";
	}

	// notice 목록 페이지
	@GetMapping("/noticeList")
	public String noticeList(Model model) {
		List<NoticeDTO> noticeList = boardService.getNoticeList(); // 목록 조회
		model.addAttribute("noticeList", noticeList);
		return "admin/noticeList";
	}

	// notice 공지사항 등록 처리
	@PostMapping("/noticeInsert")
	public String noticeInsert(NoticeDTO notice) {

		notice.setNdate(new Date());
		boardService.insertNotice(notice);
		return "redirect:/admin/noticeList";

	}

	// notice 공지사항 폼 페이지
	@GetMapping("/noticeForm")
	public String noticeForm() {
		return "/admin/noticeForm";
	}

	// notice 공지사항 삭제 처리
	@PostMapping("/noticeDelete")
	public String noticeDelet(@RequestParam("nid") String nid) {
		boardService.deleteNotice(nid);
		return "redirect:/admin/noticeList";
	}

}
