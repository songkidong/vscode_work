package chap06.sec04.exam01;

/**
 * packageName : chap06.sec04.exam01
 * fileName : Calculator
 * author : GGG
 * date : 2023-09-20
 * description : 계산기 모델 클래스
 *              함수(멤버 메소드)
 * 요약 :
 *      MVC 디자인 패턴 : M(Model), V(View), C(Controller)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-09-20         GGG          최초 생성
 */
public class Calculator {
//    TODO: 속성(필드), 생성자함수, 함수(메소드)
//    속성 생략 : 사물이나 사람의 특징을 나타냄
//    생성자 생략
//    TODO: 함수 : 사물이나 사람의 동작을(행동) 나타냄

    /**
     * 전원 켜는 함수 : 리턴값 없이 만듬 : void
     * 사용법: 접근제어자 리턴자료형 함수명(매개변수1, ... 매개변수n){}
     *  접근제어자 : public(공용,*), private(개인,*), default(생략), protected
     */
    void powerOn(){
        System.out.println("전원을 켭니다.");
    }

    /**
     * 더하기 함수 : 리턴값이 있는 함수
     */
    int plus(int x, int y) {
        int result = x + y;
        return result; // 결과 내보내기의 자료형(정수:int)
    }

    /**
     * 나눗셈 함수 : calculator.divide(10, 4)
     */
    double divide(int x, int y) {
        double result = (double) x / (double) y;

        return result;
    }

    /**
     * 전원 끄는 함수 : calculator.powerOff() , "전원을 끕니다."
     */
    void powerOff() {
        System.out.println("전원을 끕니다.");
    }

}










