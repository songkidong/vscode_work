package com.example.modelexam.controller.exam05;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam05.Dept05Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam05
 * fileName : DeptController
 * author : GGG
 * date : 2023-10-10
 * description : 부서 컨트롤러 , @Slf4j, findAll()
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-10         GGG          최초 생성
 */
// TODO: @Slf4j - 롬북 , 로깅 라이브러리를 위한 어노테이션 ( 디자인패턴 : Facade 패턴 )
//      로깅 라이브러리 : log4j -> log4j2 , logback -> 함수호출을 일원화 시켜주는 기능
//    사용법 : 클래스 위에 붙이면 사용가능 : log.debug(값)
//        ( 간략정보 : Error -> Info -> Debug -> Warn -> Trace : 상세정보 )
//    logback 설치 :
//        1) log4jdbc.log4j2.properties, logback-spring.xml 기본 설정 파일 추가
//          - log4jdbc.log4j2.properties : sql 로그를 출력하기 위한 설정파일
//          - logback-spring.xml : logback 의 다양한 레벨 옵션 설정
@Slf4j
@Controller
@RequestMapping("/exam05")
public class Dept05Controller {

    //    todo: MVC 의 Model(Service클래스) 객체 가져오기
    @Autowired
    Dept05Service deptService;

    @GetMapping("/dept")
    public String getDeptAll(Model model) {

//      TODO: Service 객체의 전체조회 함수 호출
        List<Dept> list = deptService.findAll();
        model.addAttribute("list", list);

//      TODO: 로그 찍기
        log.debug(list.toString());

        return "exam05/dept/dept_all.jsp";
    }

    @GetMapping("/dept/{dno}")
    public String getDeptId(@PathVariable long dno,
                            Model model
    ) {
//      todo: 서비스 상세조회 호출
        Dept dept = deptService.findById(dno);
        model.addAttribute("dept", dept);
        return "exam05/dept/dept_id.jsp";
    }

    //  todo: 부서 추가 페이지 열기 함수
    @GetMapping("/dept/addition")
    public String addDept() {
        return "exam05/dept/add_dept.jsp";
    }

    //  todo: 저장 버튼 클릭시 db 저장하기 함수
    @PostMapping("/dept/add")
    public RedirectView createDept(@ModelAttribute Dept dept) {
//      todo: 서비스 저장함수 호출
        deptService.save(dept);
//      todo: 저장 후 전체조회 url 로 강제 페이지 이동
//        사용법 : new RedirectView("강제이동될url주소")
        return new RedirectView("/exam05/dept");
    }

    //  todo: 수정 페이지 열기 : 화면이 보일때 데이터도 화면에 미리 출력해야함
    @GetMapping("/dept/edition/{dno}")
    public String editDept(@PathVariable long dno, Model model) {
        Dept dept = deptService.findById(dno); //
        model.addAttribute("dept", dept);
        return "exam05/dept/update_dept.jsp";
    }

    // todo: 수정 저장 : 리다이렉트(강제 이동) : 전체조회페이지로 이동
    @PutMapping("/dept/edit/{dno}")
    public RedirectView updateDept(@PathVariable long dno,
                                   @ModelAttribute Dept dept) {
//        todo: 수정 저장 함수 호출
        deptService.save(dept);
        return new RedirectView("/exam05/dept");
    }

}





