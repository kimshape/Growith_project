package com.bit.growith.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Teams {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamsId;
	
//	private Long teamsLeader;
	
//	@ManyToOne
//	@JoinColumn(name = "memberId")
//    private Member member;
	
	@Column(nullable = false, length = 30, unique = true)
	private String teamsName;
	
//	@Column(nullable = false, length = 10)
//	private String teamsStatus;
	
	@Column(nullable = false, length = 150)
	private String teamsDescription;

	@CreationTimestamp
	private LocalDateTime teamsInstDate;
	
	
}
