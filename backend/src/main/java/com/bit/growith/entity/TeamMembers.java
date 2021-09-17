package com.bit.growith.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

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
