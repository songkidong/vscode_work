package com.example.simpledms.repository;

import com.example.simpledms.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.simpledms.repository
 * fileName : EmpRepository
 * author : GGG
 * date : 2023-10-19
 * description : JPA 레포 (CRUD)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-19         GGG          최초 생성
 */
@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
//    ename like 검색 : 쿼리메소드
    List<Emp> findAllByEnameContaining(String ename);
}
