package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 부서 마스터 테이블
 * 부서 코드, 명칭, 구분, 정렬 순서 등을 저장
 */
@Entity
@Table(name = "T_PUSH_DEPT")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushDept {

    /**
     * 부서 코드 (Primary Key)
     */
    @Id
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
     * 정렬 순서
     */
    @Column(name = "SORT_ORDR")
    private Integer sortOrdr;
}
