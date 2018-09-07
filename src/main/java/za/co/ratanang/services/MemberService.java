package za.co.ratanang.services;

import org.springframework.http.ResponseEntity;
import za.co.ratanang.entities.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAllMembers();

    Member getMemberById(Long idNumber);

    ResponseEntity<?> deleteMemberById(Long idNumber);

    Member updateMember(Long idNumber, Member memberDetails);

    Member insertMember(Member member);
}
