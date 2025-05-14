package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 푸시 사용자 그룹 마스터 테이블
 * 앱 내 사용자 그룹(예: 부서, 관심사 등)을 정의
 */
@Entity
@Table(name = "T_PUSH_GRP_M")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushGroup {

    /**
     * 그룹 ID (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRP_ID")
    private Long grpId;

    /**
     * 앱 ID
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 그룹명
     */
    @Column(name = "GRP_NM")
    private String grpNm;

    /**
     * 그룹 소속 부서 코드
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

    /**
     * 그룹 내 정렬 순서
     */
    @Column(name = "SORT_ORDR")
    private Integer sortOrdr;
}
