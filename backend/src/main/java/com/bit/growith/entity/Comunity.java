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
public class Comunity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comunityId;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob
	private String content;
	
	private int count;
	
	@ManyToOne
	@JoinColumn(name = "memberId")
    private Member member;
	
	@ManyToOne
	@JoinColumn(name = "teamsId")
    private Teams teams;
	
	@CreationTimestamp
	private Timestamp createDate;
}
