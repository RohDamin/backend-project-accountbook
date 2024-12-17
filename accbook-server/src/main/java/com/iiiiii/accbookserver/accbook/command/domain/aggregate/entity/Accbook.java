package com.iiiiii.accbookserver.accbook.command.domain.aggregate.entity;

import com.iiiiii.accbookserver.common.InOrOutOrTransfer;
import com.iiiiii.accbookserver.common.YesOrNo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder(toBuilder = true)
@Table(name = "accbook")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Accbook {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accbookCode;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "is_regular", nullable = false)
    @Enumerated(EnumType.STRING)
    private YesOrNo isRegular;

    @Column(name = "member_code", nullable = false)
    private Integer memberCode;

    @Column(name = "acc_category_code", nullable = true) // finance_type이 '이체'인 경우에는 카테고리 null
    private Integer accCategoryCode;

    @Column(name = "store_code", nullable = true)
    private Integer storeCode;

    @Column(name = "asset_code", nullable = false)
    private Integer assetCode;

    @Column(name = "finance_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private InOrOutOrTransfer financeType;

    @Column(name = "in_asset_code", nullable = true)    // 가계부 이체 시 '입금 자산'에 해당(이체하는 경우 제외 모두 null)
    private Integer inAssetCode;
}
