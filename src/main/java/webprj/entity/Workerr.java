package webprj.entity;

import java.util.Date;

public class Workerr {
	private int num;
	private Date regdate;
	private Date regtime;
	private String wname;
	private String ername;
	private String sid;
	private String identi;
	private String charger;
	private String errms;
	private String sysdatetime;
	private String reason;
	private String action;

	public Workerr() {
	
	}
	
	public Workerr(int num, Date regdate, Date regtime, String wname, String ername, String sid, String identi,
			String charger, String errms, String sysdatetime) {
		super();
		this.num = num;
		this.regdate = regdate;
		this.regtime = regtime;
		this.wname = wname;
		this.ername = ername;
		this.sid = sid;
		this.identi = identi;
		this.charger = charger;
		this.errms = errms;
		this.sysdatetime = sysdatetime;
		
	}
	
	public Workerr(int num, Date regdate, Date regtime, String wname, String ername, String sid, String identi,
			String charger, String errms, String reason, String action) {
		super();
		this.num = num;
		this.regdate = regdate;
		this.regtime = regtime;
		this.wname = wname;
		this.ername = ername;
		this.sid = sid;
		this.identi = identi;
		this.charger = charger;
		this.errms = errms;
		this.reason = reason;
		this.action = action;
		
	}
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getErname() {
		return ername;
	}

	public void setErname(String ername) {
		this.ername = ername;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getIdenti() {
		return identi;
	}

	public void setIdenti(String identi) {
		this.identi = identi;
	}

	public String getCharger() {
		return charger;
	}

	public void setCharger(String charger) {
		this.charger = charger;
	}

	public String getErrms() {
		return errms;
	}

	public void setErrms(String errms) {
		this.errms = errms;
	}

	public String getSysdatetime() {
		return sysdatetime;
	}

	public void setSysdatetime(String sysdatetime) {
		this.sysdatetime = sysdatetime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	
}