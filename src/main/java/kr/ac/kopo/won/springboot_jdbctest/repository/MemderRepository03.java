package kr.ac.kopo.won.springboot_jdbctest.repository;

import jakarta.transaction.Transactional;
import kr.ac.kopo.won.springboot_jdbctest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MemderRepository03 extends JpaRepository<Member, Integer > {
   // 전체 레코드 조회 메서드
   @Transactional
   @Query(value = "select entity from Member entity")
   public List<Member> selectMethod();
}
