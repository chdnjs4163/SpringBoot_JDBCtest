package kr.ac.kopo.won.springboot_jdbctest.repository;

import kr.ac.kopo.won.springboot_jdbctest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface MemderRepository02 extends JpaRepository<Member, Integer>{
}
