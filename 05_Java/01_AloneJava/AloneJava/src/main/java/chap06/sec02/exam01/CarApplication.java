package chap06.sec02.exam01;

/**
 * packageName : chap06.sec02.exam01
 * fileName : CarApplication
 * author : GGG
 * date : 2023-09-19
 * description : 실행 클래스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-09-19         GGG          최초 생성
 */
public class CarApplication {
    public static void main(String[] args) {
//        객체 생성 : 클래스명 객체변수명 = new 생성자함수();
//        생성자함수명 = 클래스명
        Car car = new Car();
//        TODO: 클래스의 속성 출력하기
        System.out.println("제작회사 : " + car.company);
        System.out.println("모델명 : " + car.model);
        System.out.println("색상 : " + car.color);
        System.out.println("최고속도 : " + car.maxSpeed);
        System.out.println("현재속도 : " + car.Speed); // 기본값 출력
    }
}
