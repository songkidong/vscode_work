package chap06.sec04.verify.exam04;

/**
 * packageName : chap06.sec04.verify.exam04
 * fileName : PrinterApplication
 * author : GGG
 * date : 2023-09-20
 * description : 실행클래스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-09-20         GGG          최초 생성
 */

/**
 * TODO: 힌트 : static 함수 정의하기
 * 결과 :
 * 공유함수(int) : 10
 * 공유함수(boolean) : true
 * 공유함수(double) : 5.7
 * 공유함수(String) : 홍길동
 */
public class PrinterApplication {
    public static void main(String[] args) {
//        공유함수 오버로딩 예제
//        공유함수 호출하는 방법
//        사용법 : 클래스명.공유함수명();
        Printer.println(10);
        Printer.println(true);
        Printer.println(5.7);
        Printer.println("홍길동");
    }
}
