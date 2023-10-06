package com.example.controllerexam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.controllerexam.model
 * fileName : Qna
 * author : GGG
 * date : 2023-10-06
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-06         GGG          최초 생성
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Qna {
    Integer no;
    String title;
    String content;
}
