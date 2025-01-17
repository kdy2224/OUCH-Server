package com.hy.ouch.controller.user;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.ouch.domain.User;
import com.hy.ouch.dto.MessageResponse;
import com.hy.ouch.dto.language.request.AllLangsRequest;
import com.hy.ouch.dto.language.response.UserLangResponse;
import com.hy.ouch.dto.user.request.UserCreateRequest;
import com.hy.ouch.dto.user.response.AllUsersResponse;
import com.hy.ouch.dto.user.response.UserInfoResponse;
import com.hy.ouch.dto.user.response.UserSignupResponse;
import com.hy.ouch.service.user.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	//회원가입
	@PostMapping("/users/signup")
	public UserSignupResponse saveUser(@RequestBody UserCreateRequest request) {
		return userService.saveUser(request);
	}

	//모든 사용자 조회
	@GetMapping("/users/users")
	public List<AllUsersResponse> getUsers1() {
		return userService.getUsers1();
	}

	//모든 사용자 조회2 (오류..)
	@GetMapping("/users/getUsers")
	public List<User> getUsers2() {
		return userService.getUsers2();
	}

	//유저 조회(테스트용)
	@GetMapping("/users/{userId}")
	public UserInfoResponse getUserInfo(@PathVariable Long userId) {
		return userService.getUserInfo(userId);
	}

	//사용자 정보 수정
	@PutMapping("/users/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserCreateRequest request) {
		userService.updateUser(id, request);
		return ResponseEntity.ok("User updated successfully.");
	}

	//유저 탈퇴(비활성화)
	@PatchMapping("/users/{userId}")
	public ResponseEntity<?> deactivateUser(@PathVariable Long userId) {
		userService.deactivateUser(userId);
		MessageResponse body = new MessageResponse("Your account has been deactivated.");
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return new ResponseEntity<>(body, header, HttpStatus.OK);
	}

	//유저 삭제(테스트용)
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		MessageResponse body = new MessageResponse("Your account has been deleted.");
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return new ResponseEntity<>(body, header, HttpStatus.OK);
	}

	//언어 목록 조회
	@GetMapping("/languages")
	public List<AllLangsRequest> getLanguages() {
		return userService.getLanguages();
	}

	//사용자 언어 설정
	@PutMapping("/users/{userId}/language")
	public ResponseEntity<String> saveUserLanguage(@PathVariable Long userId, @RequestBody Long languageId) {
		userService.saveUserLanguage(userId, languageId);
		return ResponseEntity.ok("User language saved successfully.");
	}

	//사용자 설정 언어 조회
	@GetMapping("/users/{userId}/language")
	public UserLangResponse getUserLanguage(@PathVariable Long userId) {
		return userService.getUserLanguage(userId);
	}
}





















