package com.example.demo.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import com.example.demo.dto.MemberDTO;

@Component
@SessionScope
public class MemberSession {
    
    private MemberDTO loginMember;  // 로그인된 관리자 정보 저장
    
    // 로그인
    public void login(MemberDTO member) {
    	loginMember = member;
    }
    
    // 로그아웃
    public void logout() {
    	loginMember = null;
    }
    
    // 로그인 여부 확인
    public boolean isLoggedIn() {
        return loginMember != null;
    }
    
    // 로그인된 관리자 정보 조회
    public MemberDTO getLoginMember() {
        return loginMember;
    }
}
