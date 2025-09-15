package kr.ac.kopo.won.springboot_jdbctest.repository;

import jakarta.transaction.Transactional;
import kr.ac.kopo.won.springboot_jdbctest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MemderRepository03 extends JpaRepository<Member, Integer > {
   // 전체 레코드 조회 메서드
   @Transactional
   @Query(value = "select entity from Member entity")
   public List<Member> selectMethod();


   @Transactional
   @Query(value = "select entity from Member entity where id = :e_id")
   public List<Member> selectMethodById(@Param("e_id")  int id);

   @Transactional
   @Modifying
   @Query(value = "insert into Member(name, age, email) values(:e_name, :e_age, :e_email)")
   public int insertMethod(@Param("e_name")String name, @Param("e_age")int age, @Param("e_email")String email);

   @Transactional
   @Modifying
   @Query(value = "update Member set name=:e_name, age=:e_age, email=:e_email where  id=:e_id")
   public int updateMethod(@Param("e_name")String name, @Param("e_age")int age, @Param("e_email")String email, @Param("e_id")int id);

   @Transactional
   @Modifying
   @Query(value = "delete from Member where id=:e_id")
   public int deleteMethod(@Param("e_id")int id);;

}
