package kr.ac.kopo.won.springboot_jdbctest.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
//    단방향: Product에서 Detail를 참조
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "detail_id")
//    private Detail detail;

//    공유기본키를 사용한 양방향
    @OneToOne( mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Detail detail;
}
