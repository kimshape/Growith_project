package com.bit.growith.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TeamMembers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long TeamMembers;
	
	@ManyToOne
	@JoinColumn(name = "memberId")
    private Member member;
	
	@ManyToOne
	@JoinColumn(name = "teamsId")
	private Teams teams;
	
	@Column(nullable = false, length = 10, unique = true)
	private String applyContent1;
	
	@Column(nullable = false, length = 50)
	private String applyContent2;
	
	@Enumerated
	private WatingStatusType watingStatus;
	
	@CreationTimestamp
	private Timestamp applicationDate;
	
	
}
