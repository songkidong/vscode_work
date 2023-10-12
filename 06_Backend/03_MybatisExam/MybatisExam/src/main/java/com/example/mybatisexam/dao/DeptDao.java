package com.example.mybatisexam.dao;

import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.vo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * packageName : com.example.mybatisexam.dao
 * fileName : DeptDao
 * author : GGG
 * date : 2023-10-12
 * description : DB접속 함수들이(CRUD) 있는 클래스(Mybatis mapper(dao) 클래스)
 * 요약 :
 *      @Mapper : 인터페이스 위에 달고, Mybatis 에서 사용할 인터페이스라는 것을 말함
 *                서버 시작시 자동으로 객체가 생성됨
 *      @Param("속성명") : 변수명 : sql 의 매개변수로 전달됨
 *      xml :
 *      pageReq.size : 1 페이지당 개수
 *      pageReq.page : 현재 페이지 번호
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-12         GGG          최초 생성
 */
@Mapper
public interface DeptDao {
    /** 전체 조회 : 부서명 like 기능 있음 */
    public List<Dept> findByDnameContaining(
            @Param("dname") String dname,
            PageReq pageReq
    );

    /** 전체 테이블 개수 세기 함수 */
    long countByDname(String dname);
}
