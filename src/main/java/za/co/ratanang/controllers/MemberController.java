package za.co.ratanang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.ratanang.entities.Member;
import za.co.ratanang.services.MemberServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/members")
public class MemberController {

  @Autowired private MemberServiceImpl memberServiceImpl;
  private static Logger LOG = Logger.getLogger(MemberController.class.toString());

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<Member> getAllMembers() {
    List<Member> memberList = memberServiceImpl.getAllMembers();
    if(LOG.isLoggable(Level.INFO)) LOG.info("memberList has " + memberList.size() + " members");
    return memberList;
  }

  @RequestMapping(value = "/get/{id}", method = RequestMethod.POST)
  public Member getMemberById(@PathVariable(value = "id") Long idNumber) {
    return memberServiceImpl.getMemberById(idNumber);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteMemberById(@PathVariable(value = "id") Long idNumber) {
    return memberServiceImpl.deleteMemberById(idNumber);
  }

  @RequestMapping(
      value = "/update/{id}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public Member updateMember(
      @PathVariable(value = "id") Long idNumber, @Valid @RequestBody Member memberDetails) {
    return memberServiceImpl.updateMember(idNumber, memberDetails);
  }

  @RequestMapping(
      value = "/insert",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public Member insertMember(@Valid @RequestBody Member member) {
    return memberServiceImpl.insertMember(member);
  }
}
