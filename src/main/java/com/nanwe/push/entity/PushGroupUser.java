package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 푸시 사용자 그룹 구성원 테이블
 * 특정 그룹에 속한 사용자 정보를 저장
 */
@Entity
@Table(name = "T_PUSH_GRP_USER")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushGroupUser {

    /**
     * 그룹 사용자 매핑 ID (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRP_USER_ID")
    private Long grpUserId;

    /**
     * 그룹 ID (T_PUSH_GRP_M.GRP_ID)
     */
    @Column(name = "GRP_ID")
    private Long grpId;

    /**
     * 앱 ID
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 사용자 ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 사용자 이름
     */
    @Column(name = "USER_NM")
    private String userNm;

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
     * 부서 구분
     */
    @Column(name = "DEPT_DV")
    private String deptDv;
}
