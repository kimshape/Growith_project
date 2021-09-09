package com.bit.growith.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ComunityReply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ComunityReply;
		
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne
	@JoinColumn(name ="comunityId")
	private Comunity comunity;
	
	@ManyToOne
	@JoinColumn(name = "memberId")
    private Member member;
	
	@CreationTimestamp
	private Timestamp createDate;
}
