package za.co.ratanang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.ratanang.repositories.MemberDao;
import za.co.ratanang.entities.Member;
import za.co.ratanang.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired private MemberDao memberDao;

  @Override
  public List<Member> getAllMembers() {
    return memberDao.findAll();
  }

  @Override
  public Member getMemberById(Long idNumber) {
    return memberDao
        .findById(idNumber)
        .orElseThrow(() -> new ResourceNotFoundException("Member", "idNumber", idNumber));
  }

  @Override
  public ResponseEntity<?> deleteMemberById(Long idNumber) {
    Member member =
        memberDao
            .findById(idNumber)
            .orElseThrow(() -> new ResourceNotFoundException("Member", "idNumber", idNumber));

    memberDao.delete(member);
    return ResponseEntity.ok().build();
  }

  @Override
  public Member updateMember(Long idNumber, Member memberDetails) {
    Member member =
        memberDao
            .findById(idNumber)
            .orElseThrow(() -> new ResourceNotFoundException("Member", "idNumber", idNumber));

    member.setName(memberDetails.getName());
    member.setSurname(memberDetails.getSurname());
    member.setTelephone(memberDetails.getTelephone());
    member.setAddress(memberDetails.getAddress());

    Member updatedMember = memberDao.save(member);

    return updatedMember;
  }

  @Override
  public Member insertMember(Member member) {
    return memberDao.save(member);
  }
}
