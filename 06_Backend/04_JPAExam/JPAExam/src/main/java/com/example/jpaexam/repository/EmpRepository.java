package com.example.jpaexam.repository;

import com.example.jpaexam.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : EmpRepository
 * author : GGG
 * date : 2023-10-16
 * description : JPA 레포지포리 인터페이스 (DB 접속 함수들(CRUD) 있음) == DAO 비슷함
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-16         GGG          최초 생성
 */
@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
}
