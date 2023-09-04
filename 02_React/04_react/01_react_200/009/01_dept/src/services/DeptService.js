// DeptService.js : axios 공통 함수가 정의된 파일
// axios 기본 주소 정의 파일 import : http-common(확장자 생략가능)
import http from "../utils/http-common";

// 공통 모든 데이터 조회 함수 : /dept
const getAll = () => {
  return http.get("/dept");
};

// 검색어 조회 함수 : /dept?dname=검색어
// 인터넷 주소 : http://url:포트번호/추가url?변수명=값
// 웹브라우저 주소창에서 다른 페이지 이동 시 변수에 값을 저장해서 전달할 수 있음
// 예) 1번페이지 : /dept 2번페이지 : /dept-detail?변수=값
const findByDname = (dname) => {
  return http.get(`/dept?name=${dname}`);
};

const DeptService = {
  getAll, // 모든 테이터 조회
  findByDname, // 검색어 조회
};

export default DeptService; // 함수 내보내기
