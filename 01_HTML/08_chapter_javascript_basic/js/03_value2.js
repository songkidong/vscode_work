// 문자열 연산(더하기 == 붙이기) *****
// 사용법 : let 변수명 = "문자열" + "문자열2" + ...;
// let hello = "안녕하세요" + " 송기동입니다."
// alert(hello);

// 자료형 : 문자열(String), 숫자(number)
// 참/거짓을 표시하는 자료형 bool(boolean)
// 사용법 : let 변수명 + true(혹은 false)
// C언어나 java와 달리 변수의 자료형을 나타내는 예약어가 없음
//      let(const) 이용해서 변수 정의
// let hello = true;
// alert(hello);
// let hello2 = false;
// alert(hello2);

// 비교 연산자 : >=(크거나 같음), <=(작거나 같음),
//              >(크다), <(작다),
//              ==(같다), ---(같다, 좀 더 엄격하게 검사)
// 코딩실수 예) 조건문 : if(hello = "안녕하세요"){} (X)

// 식별자 : 변수명, 상수명, 함수명 등
// 변수(변하는 공간), 상수(변하지 않는 공간)
// 변수, 상수의 이름 짓기 규칙(명명법)
// 변수명 규칙 : 1) 첫글자는 영문자, 달러($), 언더바(_)만 올 수 있음
//              2) 대소문자를 구분
//              3) js 예약어(let, const 등) 사용 못함
// 기타(참고) : 한글, 한자도 가능
// let hello = "안녕하세요";
// let Hello = "안녕하세요";
// let 안녕 = "안녕하세요";

// 명명법(이름을 정하는 규칙)
// 1) 카멜표기법(camelCase) : 낙타표기법
// 사용법) 단어와 단어사이는 대문자, 첫글자는 소문자
// 예) hello + world -> helloWorld
// 사용처 : 변수명, 함수명(메서드명) 등

// 2) 파스칼표기법(pascal)
// 사용법) 단어와 단어사이는 대문자, 첫글자는 대문자
// 예) hello + world -> HelloWorld
// 클래스명, 생성자명

// 기타(참고) : 언더바표기법(스네이크표기법), 마이너스표기법
// 예) hello + world -> hello_World(언더바표기법)
// 예) hello + world -> hello-World(마이너스표기법)

// 논리 연산자
// 참/거짓을 이용해서 논리 연산함
// 1) 논리 부정 : !(반대), (참이면 거짓, 거짓이면 참이 됨)
// let hello = !true;
// alert(hello);

// 2) 논리 곱 : &&(연산 시 하나라도 거짓이면 거짓)
// 리액트 코딩할 때 굉장히 많이 나옴
// let hello = true && true; // -> true
// let hello2 = true && false; // -> false

// 활용 : if문 대신 논리곱을 사용할 수 있음(고급 코딩)

// 논리 합(or) : ||(연산 시 하나라도 참이면 참)
// let hello = true || true; // -> true
// let hello2 = true || false; // -> true

// 대입 연산자 : = vs ==, --- (비교연산자)
let hello = "안녕하세요";
let num = 1;

// 대입연산자 축약형
// let x = 10; // x의 변수에 10 값을 저장(대입연산자 사용)
// x = x + 5; // 10 + 5 -> 다시 x로 저장됨
// x += 5; // +(덧셈) 축약형

// x = x - 5; // 10 - 5
// x -= 5; // -(뺄셈) 축약형

// x = x * 5; // 10 * 5
// x *= 5; // *(곱셈) 축약형

// x = x / 5; // 10 / 5
// x /= 5; // /(나눗셈) 축약형

// x = x % 5; // 10 % 5
// x %= 5; // %(나머지연산) 축약형

// 증감 연산자
// 사용법 : 변수++, ++변수, 변수--, --변수 등
// 1씩 증가 또는 1씩 감소함
// 앞에 붙이기 : ++변수, --변수
let x = 10;
++x;
alert(x); // x=11
--x;
alert(x); // x=10

// 뒤에 붙이기 : 변수++, 변수--
let y = 10;
y++;
alert(y); // y=11
y--;
alert(y); // y=10