package com.micro.claim.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "settlement")
public class Settlement 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int settlementId;
	private int settlementAmount;
	private String settlementStatus;
	
	@OneToOne(targetEntity = InsuranceClaim.class, cascade = CascadeType.ALL)
	private InsuranceClaim insuranceclaim;

	public Settlement() 
	{
		super();
	}

	public Settlement(int settlementId, int settlementAmount, String settlementStatus, InsuranceClaim insuranceclaim) {
		super();
		this.settlementId = settlementId;
		this.settlementAmount = settlementAmount;
		this.settlementStatus = settlementStatus;
		this.insuranceclaim = insuranceclaim;
	}

	public int getSettlementId() {
		return settlementId;
	}

	public void setSettlementId(int settlementId) {
		this.settlementId = settlementId;
	}

	public int getSettlementAmount() {
		return settlementAmount;
	}

	public void setSettlementAmount(int settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public String getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public InsuranceClaim getInsuranceclaim() {
		return insuranceclaim;
	}

	public void setInsuranceclaim(InsuranceClaim insuranceclaim) {
		this.insuranceclaim = insuranceclaim;
	}

	@Override
	public String toString() {
		return "Settlement [settlementId=" + settlementId + ", settlementAmount=" + settlementAmount
				+ ", settlementStatus=" + settlementStatus + ", insuranceclaim=" + insuranceclaim + "]";
	}
}
