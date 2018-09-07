package za.co.ratanang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.ratanang.entities.Contribution;
import za.co.ratanang.services.ContributionService;

import javax.validation.Valid;

@RestController
@RequestMapping("/contributions")
public class ContributionController {

  @Autowired private ContributionService contributionService;

  @GetMapping("/{idNumber}/all")
  public Page<Contribution> getAllContributionsByMemberId(
      @PathVariable(value = "idNumber") Long idNumber, Pageable pageable) {
    return contributionService.getAllContributionsByMemberId(idNumber, pageable);
  }

  @PostMapping("/{idNumber}/insert")
  public Contribution insertContribution(
      @PathVariable(value = "idNumber") Long idNumber,
      @Valid @RequestBody Contribution contributionDetails) {
    return contributionService.insertContribution(idNumber, contributionDetails);
  }

  @PutMapping("/{idNumber}/update/{contributionId}")
  public Contribution updateContribution(
      @PathVariable(value = "idNumber") Long idNumber,
      @PathVariable(value = "contributionId") Long contributionId,
      @Valid @RequestBody Contribution contributionDetails) {
    return contributionService.updateContribution(idNumber, contributionId, contributionDetails);
  }

  @DeleteMapping("/{idNumber}/delete/{contributionId}")
  public ResponseEntity<?> deleteContribution(
      @PathVariable(value = "idNumber") Long idNumber,
      @PathVariable(value = "contributionId") Long contributionId) {
    return contributionService.deleteContribution(idNumber, contributionId);
  }
}
