package webprj.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JclLoginDTO  {
	
	private String userid;
	private String username;
	private Collection<? extends GrantedAuthority> sessionId;
	private String userpwd;
	
	public JclLoginDTO(String userid, String username, Collection<? extends GrantedAuthority> sessionId, String userpwd) {
		super();
		this.userid = userid;
		this.username = username;
		this.sessionId = sessionId;
		this.userpwd = userpwd;
	}
	
	public JclLoginDTO(String userid, Collection<? extends GrantedAuthority> sessionId) {
		super();
		this.userid = userid;
		this.sessionId = sessionId;
	}
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<? extends GrantedAuthority> getSessionId() {
		return sessionId;
	}
	public void setSession_id(Collection<? extends GrantedAuthority> sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	
}
