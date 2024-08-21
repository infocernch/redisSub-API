package org.example.pubsubapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Rec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String rec_id; //녹취 ID + 시퀀스

    private String cti_id;          //cti id
    private String speaker_type;    //화자 구분
    private String stt_text;        //STT 원문 TEXT
    private int stt_start_time;     //STT 원문 시작시간
    private int stt_end_time;       //STT 원문 종료시간
    private Date call_start_time;   //콜 시작시간
    private Date call_end_time;     //콜 종료시간
    private int key_c;              //key 구분 (주민번호,카드번호 등)
    private String pop;             //팝업코드 참조
    private String ars_bne_c;       //ars 업무 구분
    private String ars_path_cd;     //ars 메뉴 코드
    private String p_num;           //P번호 (P0123456789)


}
