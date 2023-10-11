package com.example.modelexam.service.exam08;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.service.exam08
 * fileName : DeptService
 * author : GGG
 * date : 2023-10-07
 * description : 부서 업무 서비스 클래스, @Service, @Autowired,
 *               findAll()
 * 요약 :
 *     @Service : 업무 로직 담당 클래스위에 붙이는 어노테이션
 *      => 스프링 서버 가동될때 그 클래스 생성해둠(싱글톤)
 *      => 객체를 만들어서 함수를 쓸때 : new 생성자함수() 하는데
 *      => 스프링에서는 하지 않고 미리 만들어 둔 객체를 받아서 사용함
 *      (참고: IOC: 제어의 역전)
 *      기타 : @Repository , @Component 등
 *     @Autowired : 스프링에서 미리 만들어 둔 객체를 가져오기
 *       사용법 : 변수위에 또는 생성자함수 위에 붙이는 가져올 수 있음
 *      (참고: DI : 의존성 주입)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-06         GGG          최초 생성
 */
@Service
public class Dept08Service {

    @Autowired
    DeptDao deptDao; // 가짜 DB에 접근하는 객체

    /**
     * 전체 조회 함수 : selectAll()(DAO 객체 함수) 호출
     * @return
     */
    public List<Dept> findAll() {
//      TODO: deptDao.selectAll() : db 조회 함수 호출
        List<Dept> list = deptDao.selectAll();

        return list;
    }

    /**
     * id(기본키)로 조회 : 상세조회(1건조회)
     * 수정 : null 방지 기능 추가
     * @param dno
     * @return
     */
    public Optional<Dept> findById(long dno) {
//       todo: db 상세조회(1건조회) 함수 호출
//          id(기본키)로 조회
        Dept dept = deptDao.selectById(dno);

//      todo: null 방지 클래스 사용
        Optional<Dept> optionalDept = Optional.ofNullable(dept);

        return optionalDept;
    }

    /**
     * 부서 정보 저장 함수
     * @param dept
     * @return
     */
    public List<Dept> save(Dept dept) {

        List<Dept> list = null;
//      todo: insert 시 dno 자동 생성
//        기존 부서번호 max 찾아서 + 10
        if(dept.getDno() == null) {
//            todo: 전체조회해서 현재 배열의 크기 가져오기
            int count = deptDao.selectAll().size();
//            todo: 새로운 부서번호 생성
            int newDno = (count + 1) * 10;
//            todo: 새로운 부서번호 저장 : dept
            dept.setDno(newDno);
//            todo: db 저장
            list = deptDao.insert(dept);
        } else {
//           todo: db 수정
            list = deptDao.update(dept);
        }

        return list;
    }

    /**
     * 부서번호로 삭제하는 함수
     * @param dno
     * @return
     */
    public boolean removeById(int dno) {
//        삭제 함수 호출 : 리턴값 : (삭제된 건수)
        int iCount = deptDao.deleteById(dno);
        
        return (iCount > 0)? true : false;
    }
}