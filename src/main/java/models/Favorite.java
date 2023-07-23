package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * お気に入りデータのDTOモデル
 *
 */
@Table(name = "favorites")
@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class Favorite {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * お気に入り登録した従業員
     */
    @ManyToOne
    @JoinColumn(name = "empoyee_id", nullable = false)
    private Employee employee;

    /**
     * お気に入り登録された日報
     */
    @JoinColumn(name =JpaConst.FAV_COL_REP, nullable = false)
    private Integer report;


    /**
     * 登録日時
     */
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}