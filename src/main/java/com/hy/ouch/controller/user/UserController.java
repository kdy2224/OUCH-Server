package com.hy.ouch.controller.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.ouch.domain.User;
import com.hy.ouch.dto.language.request.AllLangsRequest;
import com.hy.ouch.dto.language.response.UserLangResponse;
import com.hy.ouch.dto.user.request.UserCreateRequest;
import com.hy.ouch.dto.user.response.AllUsersResponse;
import com.hy.ouch.dto.user.response.UserInfoResponse;
import com.hy.ouch.service.user.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	//사용자 등록
	@PostMapping("/users/register")
	public ResponseEntity<String> saveUser(@RequestBody UserCreateRequest request) {
		userService.saveUser(request);
		return ResponseEntity.ok("User registered successfully.");
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

	//사용자 정보 조회
	@GetMapping("/users/{id}")
	public UserInfoResponse getUserInfo(@PathVariable Long id) {
		return userService.getUserInfo(id);
	}

	//사용자 정보 수정
	@PutMapping("/users/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserCreateRequest request) {
		userService.updateUser(id, request);
		return ResponseEntity.ok("User updated successfully.");
	}

	//사용자 삭제 (오류..)
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("User deleted successfully.");
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





















