package kr.ac.kopo.won.springboot_jdbctest.controller;

import kr.ac.kopo.won.springboot_jdbctest.domain.Member;
import kr.ac.kopo.won.springboot_jdbctest.repository.MemderRepository02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/exam02")
public class Example02Controller {

    @Autowired
    MemderRepository02 repository;

    @GetMapping // 모든 레코드 조회 출력
    public  String viewHomePage(Model model) {
        Iterable<Member> memberList = repository.findAll(); //select * from member
        model.addAttribute("memberList", memberList);
        return "viewPage02";
    }

    @GetMapping("/new")  // 삽입 뷰 페이지 출력
    public  String newMethod(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "viewPage02_new";
    }

    @PostMapping("/insert") // 삽입 진행
    public String insertMethod(@ModelAttribute("member") Member member) {
        repository.save(member); // save가 같은게 없으면 update 있으면 imsert
        return "redirect:/exam02";
    }

    @GetMapping("/edit/{id}") // 수정 뷰 페이지 출력
    public  String editMethod(@PathVariable(name = "id")  int id, Model model) {
        //select * from member where id =1
        Optional<Member> member = repository.findById(id);
        model.addAttribute("member", member);
        return "viewPage02_edit";
    }

    @PostMapping("/update") // 수정 진행
    public String updateMethod(@ModelAttribute("member") Member member) {
        // update member set name='유현주', age=31, email='hyunju@naver.com' whrer id = 1
        repository.save(member);
        return "redirect:/exam02";
    }

    @GetMapping("/delete/{id}") // 삭제 진행
    public String deleteMethod(@PathVariable(name = "id")  int id) {
        repository.deleteById(id);
        return "redirect:/exam02";
    }

}

