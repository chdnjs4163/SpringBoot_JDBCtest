package kr.ac.kopo.won.springboot_jdbctest.repository;

import kr.ac.kopo.won.springboot_jdbctest.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository  extends JpaRepository<Team, Long> {
}
