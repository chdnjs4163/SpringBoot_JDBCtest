package kr.ac.kopo.won.springboot_jdbctest.controller;

import kr.ac.kopo.won.springboot_jdbctest.domain.Member;
import kr.ac.kopo.won.springboot_jdbctest.repository.MemderRepository03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Example03Controller {
    @Autowired
    MemderRepository03 repository;

    @GetMapping
    public String viewHomePage(Model model) {
      Iterable<Member> memberList = repository.selectMethod();
      model.addAttribute("memberList", memberList);
        return "viewPage03";
    }

    @GetMapping("/new")
    public String newMethod(Model model) {
        model.addAttribute("member", new Member());
        return "viewPage03_new";
    }

    @PostMapping("/insert")
    public String insertMethod(@ModelAttribute("member") Member member) {
        repository.insertMethod(member.getName(),member.getAge(),member.getEmail());
        return "redirect:/exam03";
    }
}
