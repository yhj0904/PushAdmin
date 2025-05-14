package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 공통 코드 테이블
 * 코드 그룹 및 상세 코드, 명칭, 사용 여부 등을 저장
 */
@Entity
@Table(name = "T_PUSH_CODE")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushCode {

    /**
     * 코드 ID (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_ID")
    private Long codeId;

    /**
     * 코드 그룹 (예: PUSH_STATE)
     */
    @Column(name = "GRP_CD")
    private String grpCd;

    /**
     * 코드 값
     */
    @Column(name = "CODE")
    private String code;

    /**
     * 코드명 (설명)
     */
    @Column(name = "CODE_NM")
    private String codeNm;

    /**
     * 정렬 순서
     */
    @Column(name = "SORT_ORDR")
    private Integer sortOrdr;

    /**
     * 사용 여부 (Y/N)
     */
    @Column(name = "USE_AT")
    private String useAt;
}
