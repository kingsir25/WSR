package com.example.demo.jwt;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.example.demo.uitl.R;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class JwtUtil
{
	public static SecretKey generalKey(String secert)
	{
		byte[] encodedKey = secert.getBytes();
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length,
				"AES");
		return key;
	}

	/**
	 * 签发JWT
	 * 
	 * @param id
	 * @param subject
	 * @param ttlMillis
	 * @return
	 * @throws Exception
	 */
	public static String createJWT(String id, String subject, long ttlMillis)
	{
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey secretKey = generalKey("123456");
		JwtBuilder builder = Jwts.builder().setId(id).setSubject(subject)
				.setIssuedAt(now).signWith(signatureAlgorithm, secretKey);
		if (ttlMillis >= 0)
		{
			long expMillis = nowMillis + ttlMillis;
			Date expDate = new Date(expMillis);
			builder.setExpiration(expDate);
		}
		return builder.compact();
	}

	/**
	 * 验证JWT
	 * 
	 * @param jwtStr
	 * @param secert
	 * @return
	 */
	public static R validateJWT(String jwtStr)
	{
		try
		{
			@SuppressWarnings("unused")
			Claims claims = parseJWT(jwtStr, "123456");
		} catch (ExpiredJwtException e)
		{
			return R.authError("登录超时");
		} catch (SignatureException e)
		{
			return R.authError("请重新登录");
		} catch (Exception e)
		{
			return R.authError("请重新登录");
		}
		return R.ok();
	}

	/**
	 * 
	 * 解析JWT字符串
	 * 
	 * @param jwt
	 * @param secert
	 * @return
	 * @throws Exception
	 */
	public static Claims parseJWT(String jwt, String secert) throws Exception
	{
		SecretKey secretKey = generalKey(secert);
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt)
				.getBody();
	}
}
