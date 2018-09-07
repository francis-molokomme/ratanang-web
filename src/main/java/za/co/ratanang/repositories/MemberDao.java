package za.co.ratanang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.ratanang.entities.Member;

@Repository
public interface MemberDao extends JpaRepository<Member, Long> {}
