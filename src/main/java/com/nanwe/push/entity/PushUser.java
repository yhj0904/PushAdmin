package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 사용자 마스터 테이블
 * 이름, 부서, 연락처 등 사용자 기본 정보를 저장
 */
@Entity
@Table(name = "T_PUSH_USER")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushUser {

    /**
     * 사용자 ID (Primary Key)
     */
    @Id
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 사용자 이름
     */
    @Column(name = "USER_NM")
    private String userNm;

    /**
     * 사용자 휴대전화번호
     */
    @Column(name = "USER_MOBILE")
    private String userMobile;

    /**
     * 부서 코드
     */
    @Column(name = "DEPT_CD")
    private String deptCd;

    /**
     * 부서명
     */
    @Column(name = "DEPT_NM")
    private String deptNm;

    /**
     * 부서 구분 (예: 본부, 팀 등)
     */
    @Column(name = "DEPT_DV")
    private String deptDv;

    /**
     * 부서 내 정렬 순서
     */
    @Column(name = "SORT_ORDR")
    private Integer sortOrdr;
}
