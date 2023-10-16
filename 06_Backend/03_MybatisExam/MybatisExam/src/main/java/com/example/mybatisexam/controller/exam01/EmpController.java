package com.example.mybatisexam.controller.exam01;

import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.common.PageRes;
import com.example.mybatisexam.model.vo.Emp;
import com.example.mybatisexam.service.exam01.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

/**
 * packageName : com.example.mybatisexam.controller.exam01
 * fileName : EmpController
 * author : GGG
 * date : 2023-10-12
 * description : 사원 컨트롤러 (@Controller : jsp 용)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-12         GGG          최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam01")
public class EmpController {
    
    @Autowired
    EmpService empService; // 서비스 객체 가져오기

    /** 전체 조회 : like 가능 (+) */
//  TODO: @RequestParam - url?변수=값&변수2=값2
    @GetMapping("/emp")
    public String getEmpAll(
            @RequestParam(defaultValue = "") String ename,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            Model model
    ) {
//      TODO: 페이징 요청 객체
//        page : 현재페이지 번호, size : 1 페이지당 개수
        PageReq pageReq = new PageReq(page, size);

//      TODO: 전체 조회 함수 호출
        PageRes pageRes = empService.findByEnameContaining(ename, pageReq);

//      TODO: jsp 정보 전달(부서배열, 페이징정보)
        model.addAttribute("emp", pageRes.getContent()); // 사원배열
        model.addAttribute("currentPage", pageRes.getNumber()); // 현재페이지 번호
        model.addAttribute("totalItems", pageRes.getTotalElements()); // 전체테이블 건수
        model.addAttribute("totalPages", pageRes.getTotalPages()); // 전체페이지 개수
        model.addAttribute("startPage", pageRes.getStartPage()); // 현재 시작페이지 번호
        model.addAttribute("endPage", pageRes.getEndPage()); // 현재 끝페이지 번호

        log.debug(model.toString()); // 로그 출력

        return "exam01/emp/emp_all.jsp";
    }

    /** 상세조회 */
    @GetMapping("/emp/{eno}")
    public String getEmpId(@PathVariable int eno,
                           Model model
    ) {
//      서비스 상세 조회 함수 호출
        Optional<Emp> optionalEmp = empService.findById(eno);
        model.addAttribute("emp", optionalEmp.get());

        return "exam01/emp/emp_id.jsp";
    }


    /** 저장함수 : 저장 페이지로 이동 */
    @GetMapping("/emp/addition")
    public String addEmp(){
        return "exam01/emp/add_emp.jsp";
    }

    /** 저장함수 : db 저장 */
    @PostMapping("/emp/add")
    public RedirectView createEmp(
            @ModelAttribute Emp emp
    ){
        empService.save(emp); // db 저장

//      전체 조회 페이지로 강제 이동
        return new RedirectView("/exam01/emp");
    }

    /** 수정함수 : 수정 페이지로 이동 + 상세조회 */
    @GetMapping("/emp/edition/{eno}")
    public String editEmp(
            @PathVariable int eno,
            Model model
    ) {
//      서비스 상세조회 함수 호출
        Optional<Emp> optionalEmp = empService.findById(eno);
//      jsp 전달
        model.addAttribute("emp", optionalEmp.get());
        return "exam01/emp/update_emp.jsp";
    }

    /** 수정함수 : db 수정 저장 */
    @PutMapping("/emp/edit/{eno}")
    public RedirectView updateEmp(
            @PathVariable int eno,
            @ModelAttribute Emp emp
    ) {
        empService.save(emp); // db 수정 저장
//      전체 조회 페이지로 강제 이동
        return new RedirectView("/exam01/emp");
    }

    /** 삭제함수 */
    @DeleteMapping("/emp/delete/{eno}")
    public RedirectView deleteEmp(@PathVariable int eno) {
        empService.removeById(eno); // db 삭제

        return new RedirectView("/exam01/emp");
    }
}
