package com.example.demo.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import com.example.demo.dto.AdminDTO;

@Component
@SessionScope
public class AdminSession {
    
    private AdminDTO loginAdmin;  // 로그인된 관리자 정보 저장
    
    // 로그인
    public void login(AdminDTO admin) {
        loginAdmin = admin;
    }
    
    // 로그아웃
    public void logout() {
        loginAdmin = null;
    }
    
    // 로그인 여부 확인
    public boolean isLoggedIn() {
        return loginAdmin != null;
    }
    
    // 로그인된 관리자 정보 조회
    public AdminDTO getLoginAdmin() {
        return loginAdmin;
    }
}
