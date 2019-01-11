package com.zime.toup.entity;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String phone;

    private String email;

    private String headimgpath;

    private Integer administrator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeadimgpath() {
        return headimgpath;
    }

    public void setHeadimgpath(String headimgpath) {
        this.headimgpath = headimgpath == null ? null : headimgpath.trim();
    }

    public Integer getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Integer administrator) {
        this.administrator = administrator;
    }

	public User(Integer id, String username, String password, String name, String phone, String email,
			String headimgpath, Integer administrator) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.headimgpath = headimgpath;
		this.administrator = administrator;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", email=" + email + ", headimgpath=" + headimgpath + ", administrator=" + administrator
				+ "]";
	}
}