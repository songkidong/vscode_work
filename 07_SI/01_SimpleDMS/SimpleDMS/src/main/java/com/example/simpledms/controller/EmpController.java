package com.example.simpledms.controller;

import com.example.simpledms.model.Dept;
import com.example.simpledms.model.Emp;
import com.example.simpledms.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.simpledms.controller
 * fileName : EmpController
 * author : GGG
 * date : 2023-10-19
 * description : 사원 컨트롤러 (@RestController - react 용)
 * 요약 :
*      react(3000) <-> springboot(8000) 연동 : axios
*      인터넷 기본 보안 : ip, port 최초에 지정된것과 달라지면
*                      => 해킹으로 기본 인정(블러킹 : 단절) CORS 보안
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-19         GGG          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class EmpController {

    @Autowired
    EmpService empService; // DI

    /** 전체 조회 + like 검색 */
    @GetMapping("/emp")
    public ResponseEntity<Object> getEmpAll(
            @RequestParam(defaultValue = "") String ename
    ) {
        try {
//          전체 조회 + like 검색
            List<Emp> list = empService.findAllByEnameContaining(ename);

            if (list.isEmpty() == false) {
//              성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//              데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
