package com.models;

public class User {
	String username = "ThanhTien";
	String password = "123456";
	String picturePath = "https://scontent.fsgn13-2.fna.fbcdn.net/v/t1.6435-9/125881179_2794089397504499_9171796041226421975_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=ZN1HvtksX2IAX9WW_wS&_nc_ht=scontent.fsgn13-2.fna&oh=00_AT8lKRc8PeB2MmhB5cFikWaaJEy1lXq46yijQ-1TOQPbrQ&oe=620D9911";
	public User() {
	}

	public boolean checkAuthority(String name, String pass) {
		if (username.equals(name) && password.equals(pass)) {
			return true;
		}
		return false;
	}
	public String getPicturePath() {
		return this.picturePath;
	}
}
