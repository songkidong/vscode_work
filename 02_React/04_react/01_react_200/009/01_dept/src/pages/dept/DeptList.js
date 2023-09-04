// DeptList.js : dept 조회 페이지
// rfce
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom"; // 메뉴 라이브러리
// axios 공통 함수 파일 import
import DeptService from "../../services/DeptService";

function DeptList() {
  // TODO: 변수 정의 : 줄복사 단축키(ctrl + d), 자동정렬(ctrl + alt + l)
  let [dept, setDept] = useState([]); // 벡엔드 부서 데이터를(객체배열) 받을 변수
  let [searchDname, setSearchDname] = useState(""); // 검색어 변수

  // TODO: 함수 정의
  // nfn : 화살표 단축키
  // 벡엔드 모든 데이터 조회 함수 : axis 사용
  const retrieveDept = () => {
    // axios 함수 : get() 요청 : (js 공통 함수를 만들고 공통함수명으로 호출)
    // .then() : 성공(자동실행)
    // .catch() : 실패(자동실행)
    DeptService.getAll() // 벡엔드 요청
      .then((response) => {
        // 성공 자동실행
        setDept(response.data); // 실질적인 벡엔드 데이터 저장(response.data)
        // 로그 찍기
        console.log(response.data);
      })
      .catch((e) => {
        // 실패 자동실행
        console.log(e); // 에러메세지 콘솔로 출력
      });
  };

  //  화면이 뜰때 retrieveDept 실행
  // useEffect(()=>{실행문}, []);
  useEffect(() => {
    retrieveDept(); // 함수의 사용
  }, []);

  // 검색어 조회 함수 : findByDname()
  // nfn
  const findByDname = () => {
  };

  // 검색어 입력양식 : onChange={함수명}
  // 역바인딩 함수 : 코딩
  // nfn
  const onChangeSearchDname = (event) => {
    setSearchDname(event.target.value); // 역바인딩 코딩
  };

  return (
    // TODO: 여기
    <div>
      <div className="row">
        {/* 제목 시작 */}
        <div className="col-md-12 mb-5 mt-5">
          <h1>Dept List</h1>
        </div>
        {/* 제목 끝 */}
      </div>

      {/* 검색창 시작 */}
      <div className="row mb-5 justify-content-center">
        {/* w-50 : 크기 조정, mx-auto : 중앙정렬(margin: 0 auto), justify-content-center */}
        <div className="col-12 w-50 input-group mb-3">
          {/* 검색어 입력창 시작 */}
          <input
            type="text"
            className="form-control"
            placeholder="Search by dname"
            value={searchDname}
            onChange={onChangeSearchDname}
          />
          {/* 검색어 입력창 끝 */}

          {/* 검색 버튼 시작 */}
          <div className="input-group-append">
            <button
              className="btn btn-outline-secondary"
              type="button"
              onClick={findByDname}
            >
              Search
            </button>
          </div>
          {/* 검색 버튼 끝 */}
        </div>
      </div>
      {/* 검색창 끝 */}

      {/* 테이블 시작 */}
      <div className="col-md-12">
        {/* table start */}
        <table className="table">
          {/* 테이블 제목 시작 */}
          <thead className="table-light">
            <tr>
              <th scope="col">Dname</th>
              <th scope="col">Loc</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          {/* 테이블 제목 끝 */}
          <tbody>
            {/* 반복문 시작 */}
            {dept &&
              dept.map((data, index) => (
                <tr key={index}>
                  <td>{data.dname}</td>
                  <td>{data.loc}</td>
                  <td>
                    <Link to={"/dept/" + data.id}>
                      <span className="badge bg-success">Edit</span>
                    </Link>
                  </td>
                </tr>
              ))}
            {/* 반복문 끝 */}
          </tbody>
        </table>
        {/* table end */}
      </div>
      {/* 테이블 끝*/}
    </div>
  );
}

export default DeptList;
