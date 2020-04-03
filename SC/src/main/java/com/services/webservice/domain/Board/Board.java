package com.services.webservice.domain.Board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.services.webservice.domain.Member.Member;
import com.services.webservice.library.entity.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Board extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, foreignKey = @ForeignKey(name = "fk_member_to_board_id"))
	private Member member;

	private String title;

	@Column(columnDefinition = "Text")
	private String contents;

	@Builder
	public Board(long id, Member member, String title, String contents) {
		super();
		this.id = id;
		this.member = member;
		this.title = title;
		this.contents = contents;
	}
}
