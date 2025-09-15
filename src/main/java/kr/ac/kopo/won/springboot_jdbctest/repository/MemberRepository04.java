package kr.ac.kopo.won.springboot_jdbctest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import kr.ac.kopo.won.springboot_jdbctest.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

// EntityManager를 사용할 떄는 JpaRepository를 상속 받지 않는다.
// @PersistenceContext를 사용하여 entityManager의 참조값을 주입 받는다.

@Repository
public class MemberRepository04 {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Member> selectMethod(){
        String jsql = "select entity from Member entity";

        Query query = entityManager.createQuery(jsql);
        List<Member> memberList = query.getResultList();
        return memberList;
    }


    @Transactional
    public void inserMethod(Member member) {
        String jsql = "INSERT into Member (name, age,email) values(:e_name, :e_age, :e_email)";
        Query query = entityManager.createQuery(jsql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.executeUpdate();
    }

    public Member selectMethodById(int id) {
        String jsql = "select entity from Member entity where id = :e_id";
        Query query = entityManager.createQuery(jsql);
        query.setParameter("e_id", id);
        Member member = (Member) query.getSingleResult();
        return member;
    }

    @Transactional
    public void updateMethod(Member member) {
        String jsql = "UPDATE Member SET name=:e_name, age=:e_age, email=:e_email WHERE id=:e_id";
        Query query = entityManager.createQuery(jsql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.setParameter("e_id", member.getId());
        query.executeUpdate();
    }

    @Transactional
    public void deleteMethod(int id) {
        String jsql = "DELETE FROM Member WHERE id=:e_id";
        Query query = entityManager.createQuery(jsql);
        query.setParameter("e_id", id);
        query.executeUpdate();
    }

}
