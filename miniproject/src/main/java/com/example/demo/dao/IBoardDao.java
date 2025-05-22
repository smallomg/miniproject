package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.FaqDTO;
import com.example.demo.dto.NoticeDTO;
import com.example.demo.dto.QnaDTO;

@Mapper
public interface IBoardDao {
//	회원용
    void insertQna(QnaDTO qna);  // QnA 등록용

	List<QnaDTO> selectQnaList(String id); // Qna 목록 조회
	
	QnaDTO selectQnaByQno(String qno); // Qna 상세 조회

	List<FaqDTO> selectFaqList(); // FAQ 목록 조회
	
	List<NoticeDTO> selectNoticeList(); // notice 공지 목록 조회
	
	
	
	
//	 관리자용
	void updateAnswer(QnaDTO qna); // 관리자 Qna 답변 업데이트

	void insertFaq(FaqDTO faq); // 관리자 FAQ 등록용

	void deleteFaq(String fno); // 관리자 FAQ 처리용

	void insertNotice(NoticeDTO notice); // 관리자 Notice 공지사항 등록용

	List<QnaDTO> selectQnaByQstatus(); //  관리자 Qna에서 대기만 보게하는 용

	void deleteNotice(String nid); // 관리자 Notice 공지사항 삭제용

	
}
