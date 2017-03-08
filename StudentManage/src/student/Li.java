package student;

import java.math.BigDecimal;
import java.util.Date;

public class Li {

	private String sno,sname,sex,sour;
	private Date scssj;
	private BigDecimal sources,scor;
	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSour() {
		return sour;
	}

	public void setSour(String sour) {
		this.sour = sour;
	}

	public Date getScssj() {
		return scssj;
	}

	public void setScssj(Date scssj) {
		this.scssj = scssj;
	}

	public BigDecimal getSources() {
		return sources;
	}

	public void setSources(BigDecimal sources) {
		this.sources = sources;
	}

	public BigDecimal getScor() {
		return scor;
	}

	public void setScor(BigDecimal scor) {
		this.scor = scor;
	}

	public Li() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Li(String sno, String sname, String sex, String sour, Date scssj,
			BigDecimal sources, BigDecimal scor) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.sour = sour;
		this.scssj = scssj;
		this.sources = sources;
		this.scor = scor;
	}

	@Override
	public String toString() {
		return "List [sno=" + sno + ", sname=" + sname + ", sex=" + sex
				+ ", sour=" + sour + ", scssj=" + scssj + ", sources="
				+ sources + ", scor=" + scor + "]";
	}
	
	
}
