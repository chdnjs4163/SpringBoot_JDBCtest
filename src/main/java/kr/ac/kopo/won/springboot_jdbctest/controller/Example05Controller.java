package kr.ac.kopo.won.springboot_jdbctest.controller;

import kr.ac.kopo.won.springboot_jdbctest.domain.Detail;
import kr.ac.kopo.won.springboot_jdbctest.domain.Product;
import kr.ac.kopo.won.springboot_jdbctest.repository.DetailRepository;
import kr.ac.kopo.won.springboot_jdbctest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam05")
public class Example05Controller {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DetailRepository detailRepository;

    @GetMapping
    public String requestInsert(Model model) {
        Product product = new Product();
        product.setName("Iphone 17");
        product.setPrice(1300000);

        Detail detail = new Detail();
        detail.setDescription("아이폰 17 2025 신형");
        detail.setWeight(200f);
        detail.setWidth(75f);
        detail.setHeight(150f);

        product.setDetail(detail);

        productRepository.save(product);

        Iterable<Product> productList = productRepository.findAll();
        Iterable<Detail> detailList = detailRepository.findAll();

        model.addAttribute("productList", productList);
        model.addAttribute("detailList", detailList);
        return  "viewPage05";
    }
}