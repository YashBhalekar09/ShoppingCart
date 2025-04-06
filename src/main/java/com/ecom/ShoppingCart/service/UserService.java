package com.ecom.ShoppingCart.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecom.ShoppingCart.model.UserDtls;

public interface UserService {

	public UserDtls saveUser(UserDtls user);
	
	public UserDtls getUserByEmail(String email);
	
	public List<UserDtls> getUsers(String role);

	public Boolean updateAccountStatus(Integer id, Boolean status);

	public void updateUserResetToken(String email, String resetToken);
	
	public UserDtls getUserByToken(String token);
	
	public UserDtls updateUser(UserDtls user);

	public UserDtls updateUserProfile(UserDtls user, MultipartFile img);
	
	public Boolean existsEmail(String email);
	
}
