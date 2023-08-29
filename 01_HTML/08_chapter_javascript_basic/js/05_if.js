// 조건문 : if문 (90%)
// 사용법 : 조건식이 참(true)이면 명령문이 실행됨
// if(조건식){
//    명령문(문장);
// }

// 예제) 19살 이상이면 성인입니다. 를 출력하세요
// let age = 20; // 변수 초기화
// age >= 19 : 조건식을 판단 (참? 거짓?)
// if(age >= 19) {
//     alert("성인입니다.");
// }

// 2) 조건문 : if/else 문
// 사용법 : 조건식이 참이면 실행문이 실행되고, 거짓이면 실행문2가 실행됨
// if(조건식) {
//    실행문(문장);
// } else {
//    실행문2(문장);
// } 
// 예제 : 19살 이상이면 성인입니다. 를 출력하고, 
//        19살 미만이면 미성년입니다. 를 출력하세요
// if(age >= 19){
//    alert("성인입니다.")
// } else{
//    alert("미성년입니다.")
// }

// 3) 조건문 : if/else if/else 문
// 사용법 : 조건식을 판단하여 참이면 실행문이 실행되고,
//          거짓이면 조건식2를 판단하여 참이면 실행문2가 실행되고,
//          모든 조건식이 거짓이면 실행문3이 실행됨
// if(조건식) {
//    실행문(문장);
// } else if {
//    실행문2(문장);
// } else {
//    실행문3(문장);
// }

// 예제) 19살 이상이면 성인입니다. 를 출력하고,
//       18살 이상이면 청소년입니다. 를 출력하고,
//       17살 이하이면 미성년입니다. 를 출력하세요
// 청소년입니다. 를 출력하시오
// if(age >= 19) {
//     alert("성인입니다.")
// } else if(age >= 18) {
//     alert("청소년입니다.")
// } else {
//     alert("미성년입니다.")
// }

// 연습) x = 10이고, y = 20 값이 있습니다.
// x와 y 가 같으면 "x 와 y가 같다" 출력하고,
// x < y 가 이면 "x 는 y보다 작다" 출력하고,
// x > y 가 이면 "x 는 y보다 크다" 출력하세요.
// let x = 10; y = 20;
// if(x == y) {
//     alert("x와 y가 같다")
// } else if(x < y) {
//     alert("x는 y보다 작다")
// } else {
//     alert("x는 y보다 크다")
// }

// 연습2) 10보다 작은수가 입력되면 small 을 출력하고,
//      10이상이면 아무것도 출력하지 마세요
// 입력 : 5
// 출력 : small
let num = Number(prompt("숫자를 입력하세요"))
if(num < 10) {
    alert("small")
} else {

}