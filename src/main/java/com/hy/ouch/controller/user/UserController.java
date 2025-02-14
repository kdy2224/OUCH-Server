package com.hy.ouch.controller.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hy.ouch.dto.MessageResponse;
import com.hy.ouch.dto.user.request.MypageUserInfoUpdateRequest;
import com.hy.ouch.dto.user.request.UserCreateRequest;
import com.hy.ouch.dto.user.response.MypageUserInfoResponse;
import com.hy.ouch.dto.user.response.UserInfoResponse;
import com.hy.ouch.dto.user.response.UserSignupResponse;
import com.hy.ouch.service.user.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	//회원가입
	@PostMapping("/users/signup")
	public UserSignupResponse saveUser(@RequestBody @Valid UserCreateRequest request) {
		return userService.saveUser(request);
	}

	//유저 조회(테스트용)
	@GetMapping("/users/{userId}")
	public UserInfoResponse getUserInfo(@PathVariable Long userId) {
		return userService.getUserInfo(userId);
	}

	//유저 탈퇴(비활성화)
	@PatchMapping("/users/{userId}")
	public ResponseEntity<MessageResponse> deactivateUser(@PathVariable Long userId) {
		userService.deactivateUser(userId);
		return ResponseEntity.ok(new MessageResponse("Your account has been deactivated."));
	}

	//유저 삭제(테스트용)
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<MessageResponse> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok(new MessageResponse("Your account has been deleted."));
	}

	//마이페이지(내 정보) 조회
	@GetMapping("/mypage/users/{userId}")
	public MypageUserInfoResponse myPageGetUserInfo(@PathVariable Long userId) {
		return userService.myPageGetUserInfo(userId);
	}

	//내 정보 수정 (사용자로부터 모든 필드의 값을 받아 put 요청 처리)
	@PutMapping("/mypage/users/{userId}")
	public ResponseEntity<MessageResponse> myPageUpdateUserInfo(@PathVariable Long userId,
		@RequestBody @Valid MypageUserInfoUpdateRequest request) {
		userService.myPageUpdateUserInfo(userId, request);
		return ResponseEntity.ok(new MessageResponse("Your info has been updated."));
	}
}


















