import "./App.css";
import Header from "./components/Header"; // 공통 메뉴(머리말) 컴포넌트
import { Routes, Route } from "react-router-dom"; // 메뉴 라이브러리
import Home from "./pages/Home"; // 자식 컴포넌트
import NotFound from "./components/NotFound"; // 공통 컴포넌트
import DeptList from "./pages/dept/DeptList"; // 자식 컴포넌트
import AddDept from "./pages/dept/AddDept"; // 자식 컴포넌트
import EmpList from "./pages/emp/EmpList"; // 자식 컴포넌트
import AddEmp from "./pages/emp/AddEmp"; // 자식 컴포넌트

function App() {
  return (
    <div className="App">
      {/* 메뉴 컴포넌트 : Header */}
      <Header />
      
      {/* 본문 : 라우팅 설정 */}
      <div className="container mt-3"></div>
      <Routes>
        {/* 1st 페이지 : / */}
        <Route path="/" element={<Home />} />
        {/* path="*" : 지정되지 않은 모든 url */}
        <Route path="*" element={<NotFound />} />

        {/* 부서 메뉴 */}
        <Route path="/dept" element={<DeptList />} />
        <Route path="/add-dept" element={<AddDept />} />

        {/* 연습) 사원 메뉴 */}
        <Route path="/emp" element={<EmpList />} />
        <Route path="/add-emp" element={<AddEmp />} />
      </Routes>
    </div>
  );
}

export default App;
