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
import com.hy.ouch.dto.user.request.UserCreateRequest;
import com.hy.ouch.dto.user.response.UserInfo;
import com.hy.ouch.dto.user.response.UserResponse;
import com.hy.ouch.service.user.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register") //사용자 등록
	public void saveUser(@RequestBody UserCreateRequest request) {
		userService.saveUser(request);
	}

	//오류..(한번 성공)
	@GetMapping("/users")
	public List<UserResponse> getUsers1() {
		return userService.getUsers1();
	}

	//오류..
	@GetMapping("/getUsers")
	public List<User> getUsers2() {
		return userService.getUsers2();
	}

	@GetMapping("/{id}") //사용자 정보 조회
	public UserInfo getUserInfo(@PathVariable Long id) {
		return userService.getUserInfo(id);
	}

	@PutMapping("/{id}") //사용자 정보 수정
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserCreateRequest request) {
		userService.updatenUser(id, request);
		return ResponseEntity.ok("User updated successfully.");
	}

	@DeleteMapping("/{id}") //사용자 삭제
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("User deleted successfully.");
	}
}
