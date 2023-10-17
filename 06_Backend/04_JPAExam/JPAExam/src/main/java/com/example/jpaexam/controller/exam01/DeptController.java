package com.example.jpaexam.controller.exam01;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam01
 * fileName : DeptController
 * author : GGG
 * date : 2023-10-16
 * description : 부서 컨트롤러 : @RestController
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-16         GGG          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/exam01")
public class DeptController {

    @Autowired
    DeptService deptService; // 객체 가져오기 (DI)

    /** 전체 조회 */
    @GetMapping("/dept")
    public ResponseEntity<Object> getDeptAll() {
        try {
//          TODO: 전체조회 함수 호출
            List<Dept> list = deptService.findAll();
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

    /** 상세 조회 */
    @GetMapping("/dept/{dno}")
    public ResponseEntity<Object> getDeptId(
            @PathVariable int dno
    ) {
        try {
//          TODO: 전체조회 함수 호출
            Optional<Dept> optionalDept = deptService.findById(dno);
            if (optionalDept.isEmpty() == false) {
//              성공
                return new ResponseEntity<>(optionalDept, HttpStatus.OK);
            } else {
//              데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 저장 함수 */
    @PostMapping("/dept")
    public ResponseEntity<Object> createDept(
            @RequestBody Dept dept
    ) {
        try {
//          jpa 서비스 저장 함수 호출 : dept2(DB 저장된 객체)
            Dept dept2 = deptService.save(dept);
            return new ResponseEntity<>(dept2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 수정 함수 */
    @PutMapping("/dept/edit/{dno}")
    public ResponseEntity<Object> updateDept(
            @PathVariable int dno,
            @RequestBody Dept dept
    ) {
        try {
//          jpa 서비스 수정 함수 호출 : dept2(DB 저장된 객체)
            Dept dept2 = deptService.save(dept);
            return new ResponseEntity<>(dept2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /** 삭제 함수 */
    @DeleteMapping("/dept/delete/{dno}")
    public ResponseEntity<Object> deleteDept(
            @PathVariable int dno
    ) {
        try {
//          TODO: 삭제 함수 호출
            boolean bSuccess = deptService.removeById(dno);
            if (bSuccess == true) {
//              성공
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//              0건 삭제
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
