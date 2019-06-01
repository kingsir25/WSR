package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.repository.UserRepository;
import com.example.demo.uitl.R;


@RestController
@RequestMapping("sys")
public class LoginController
{
	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public R login(@RequestParam String username, @RequestParam String password)
	{
		if (StringUtils.isEmpty(username))
		{
			return R.error("ユーザEIDを入力してください");
		}
		if (StringUtils.isEmpty(password))
		{
			return R.error("パスワードを入力してください");
		}
		User user = userRepository.findByUsername(username);
		if (user == null || !user.getPassword().equals(password))
		{
			return R.error("パスワードが正しくない");
		}
		String token = JwtUtil.createJWT(user.getUsername(),
				String.valueOf(user.getId()), 3600);
		return R.ok().put("token", token);
	}

	@PostMapping("/updatepwd")
	public R reg(String username, String password, String oldpassword)
	{
		User user = userRepository.findByUsername(username);
		if (user == null)
		{
			return R.error("ユーザが存在しません");
		}
		if (!user.getPassword().equals(oldpassword))
		{
			return R.error("パスワードが正しくないです");
		}
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		userRepository.save(u);
		return R.ok();
	}
}
