package webprj.entity;

import java.util.Date;

public class Jclerror {
	private int num;
	private Date regdate;
	private Date regtime;
	private String id;
	private String work;
	private String name;
	private String charger;
	private String reason;
	private String action;
	private String jobclass;
	private String factors;
	private Date actiontime;
	private int hit;
	
	public Jclerror() {
		
	}
	
	public Jclerror(int num, Date regdate, String id, String work, String name, String charger, String jobclass, String factors, int hit) {
		super();
		this.num = num;
		this.regdate = regdate;
		this.id = id;
		this.work = work;
		this.name = name;
		this.charger = charger;
		this.jobclass = jobclass;
		this.factors = factors;
		this.hit = hit;
		
	}

	public Jclerror(int num, Date regdate, Date regtime, String id, String work, String name, String charger,
			String reason, String action, Date actiontime, int hit) {
		super();
		this.num = num;
		this.regdate = regdate;
		this.regtime = regtime;
		this.id = id;
		this.work = work;
		this.name = name;
		this.charger = charger;
		this.reason = reason;
		this.action = action;
		this.actiontime = actiontime;
		this.hit = hit;
	}
	
	public Jclerror(int num, Date regdate, Date regtime, String id, String work, String name, 
			String charger, String jobclass, String factors, String reason, String action, Date actiontime, int hit) {
		this.num = num;
		this.regdate = regdate;
		this.regtime = regtime;
		this.id = id;
		this.work = work;
		this.name = name;
		this.charger = charger;
		this.jobclass = jobclass;
		this.factors = factors;
		this.reason = reason;
		this.action = action;
		this.actiontime = actiontime;
		this.hit = hit;
		
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharger() {
		return charger;
	}

	public void setCharger(String charger) {
		this.charger = charger;
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

	public Date getActiontime() {
		return actiontime;
	}

	public void setActiontime(Date actiontime) {
		this.actiontime = actiontime;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public String getJobclass() {
		return jobclass;
	}

	public void setJobclass(String jobclass) {
		this.jobclass = jobclass;
	}

	public String getFactors() {
		return factors;
	}

	public void setFactors(String factors) {
		this.factors = factors;
	}
	
	

}
