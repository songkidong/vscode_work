// 리액트 주소 : http://localhost:3000
// http://(프로토콜),
// localhost(개인pc 인터넷주소),
// 3000 : 포트번호(0~30000), :80(80만 생략가능)
// App.js : 리액트의 1st 페이지(사이트 home페이지)
// => 리액트 서버가 가동되고 처음으로 실행되는 페이지(js)
// 리액트 페이지(js) : 컴포넌트(==페이지)
// 사용법 : 
// function 컴포넌트명() {
//   return {
//     <div>내용</div>
//   }
// }

import logo from './logo.svg';
import './App.css';
// 자식 컴포넌트(페이지) import
import Home from "./components/Home.js"

function App() {
  return (
    <div className="App">
      <div>
        <h1>Start React 200!</h1>
        <p>HTML 적용하기</p>
      </div>
      {/* Home.js 컴포넌트 태그 */}
      <Home></Home>
    </div>
  );
}

export default App;
