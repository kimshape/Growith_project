package com.bit.growith.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

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
