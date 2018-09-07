package za.co.ratanang.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "contribution")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
    value = {"effectiveDate", "updatedDate"},
    allowGetters = true)
public class Contribution {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long contributionId;

  @NotNull private String contributionPeriod;
  @NotNull private double monthlyContribution;

  private double fineContribution;
  private double candleContribution;
  private double transportContribution;
  private double fundingContribution;
  private double joiningContribution;
  private double totalContribution;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_number", nullable = false)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  @JsonIgnore
  private Member member;

  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date effectiveDate;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedDate;

  public Long getContributionId() {
    return contributionId;
  }

  public void setContributionId(Long contributionId) {
    this.contributionId = contributionId;
  }

  public String getContributionPeriod() {
    return contributionPeriod;
  }

  public void setContributionPeriod(String contributionPeriod) {
    this.contributionPeriod = contributionPeriod;
  }

  public double getMonthlyContribution() {
    return monthlyContribution;
  }

  public void setMonthlyContribution(double monthlyContribution) {
    this.monthlyContribution = monthlyContribution;
  }

  public double getFineContribution() {
    return fineContribution;
  }

  public void setFineContribution(double fineContribution) {
    this.fineContribution = fineContribution;
  }

  public double getCandleContribution() {
    return candleContribution;
  }

  public void setCandleContribution(double candleContribution) {
    this.candleContribution = candleContribution;
  }

  public double getTransportContribution() {
    return transportContribution;
  }

  public void setTransportContribution(double transportContribution) {
    this.transportContribution = transportContribution;
  }

  public double getFundingContribution() {
    return fundingContribution;
  }

  public void setFundingContribution(double fundingContribution) {
    this.fundingContribution = fundingContribution;
  }

  public double getJoiningContribution() {
    return joiningContribution;
  }

  public void setJoiningContribution(double joiningContribution) {
    this.joiningContribution = joiningContribution;
  }

  public double getTotalContribution() {
    return totalContribution;
  }

  public void setTotalContribution(double totalContribution) {
    this.totalContribution = totalContribution;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public Date getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }
}
