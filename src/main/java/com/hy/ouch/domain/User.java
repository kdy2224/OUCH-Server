package com.hy.ouch.domain;

import java.time.LocalDate;

import com.hy.ouch.domain.common.BaseEntity;
import com.hy.ouch.domain.enums.Gender;
import com.hy.ouch.domain.enums.UserStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 20)
	private String userId;

	@Column(nullable = false, length = 30)
	private String password;

	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false, length = 20)
	private String nickname;

	@Column(nullable = false, length = 15)
	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "VARCHAR(6)")
	private Gender gender;

	@Column(nullable = false)
	private LocalDate birthday;

	@Column(nullable = false, length = 30)
	private String email;

	@Column(nullable = false, length = 100)
	private String address;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "VARCHAR(8) DEFAULT 'ACTIVE'")
	private UserStatus status;

	private LocalDate inactiveDate;
}
