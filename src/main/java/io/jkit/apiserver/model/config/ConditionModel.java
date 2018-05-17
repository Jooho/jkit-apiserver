package io.jkit.apiserver.model.config;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CONDITION", uniqueConstraints = @UniqueConstraint(columnNames = {  "condId", "condSubId" }))
public class ConditionModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2179292544073404115L;

	public ConditionModel() {
		
	}
	public ConditionModel(long index,int condId, int condSubId, String condDesc, String yesDept, String noDept, String yesMsg,
			String noMsg) {
		super();
		this.condIndex = index;
		this.condId = condId;
		this.condSubId = condSubId;
		this.condDesc = condDesc;
		this.yesDept = yesDept;
		this.noDept = noDept;
		this.yesMsg = yesMsg;
		this.noMsg = noMsg;
	}
	
//	
//	@Id
//	@SequenceGenerator(name = "seqGen", sequenceName = "cond_index", initialValue = 1, allocationSize = 100)
//	@GeneratedValue(generator = "seqGen")
//	@Column(name = "cond_index", updatable = false, nullable = false)
//	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long condIndex;
	
	private int condId;
	private int condSubId;
	private String condDesc;
	private String yesDept;
	private String noDept;
	private String yesMsg;
	private String noMsg;


	public long getCondIndex() {
		return condIndex;
	}
	public void setCondIndex(long index) {
		this.condIndex = index;
	}
	public int getCondId() {
		return condId;
	}
	public void setCondId(int condId) {
		this.condId = condId;
	}
	public int getCondSubId() {
		return condSubId;
	}
	public void setCondSubId(int condSubId) {
		this.condSubId = condSubId;
	}
	public String getCondDesc() {
		return condDesc;
	}
	public void setCondDesc(String condDesc) {
		this.condDesc = condDesc;
	}
	public String getYesDept() {
		return yesDept;
	}
	public void setYesDept(String yesDept) {
		this.yesDept = yesDept;
	}
	public String getNoDept() {
		return noDept;
	}
	public void setNoDept(String noDept) {
		this.noDept = noDept;
	}
	public String getYesMsg() {
		return yesMsg;
	}
	public void setYesMsg(String yesMsg) {
		this.yesMsg = yesMsg;
	}
	public String getNoMsg() {
		return noMsg;
	}
	public void setNoMsg(String noMsg) {
		this.noMsg = noMsg;
	}
}

