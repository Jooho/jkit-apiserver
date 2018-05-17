package io.jkit.apiserver.model.config;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CONDITION_RESULT", uniqueConstraints = @UniqueConstraint(columnNames = { "acName", "condId", "condSubId" }))
public class ConditionResultModel implements Serializable {
	

	private static final long serialVersionUID = 8830170915107162718L;

	public ConditionResultModel() {

	}

	public ConditionResultModel(long condResultIndex, String acName, int condId, int condSubId, int condResult,
			String condDesc, String msg) {
		super();
		this.condResultIndex = condResultIndex;
		this.acName = acName;
		this.condId = condId;
		this.condSubId = condSubId;
		this.condResult = condResult;
		this.condDesc = condDesc;
		this.msg = msg;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long condResultIndex;
	
	private String acName;
	private int condId;
	private int condSubId;
	private int condResult;
	private String condDesc;
	private String msg;

	public long getCondResultIndex() {
		return condResultIndex;
	}

	public void setCondResultIndex(long condResultIndex) {
		this.condResultIndex = condResultIndex;
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName;
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

	public int getCondResult() {
		return condResult;
	}

	public void setCondResult(int condResult) {
		this.condResult = condResult;
	}

	public String getCondDesc() {
		return condDesc;
	}

	public void setCondDesc(String condDesc) {
		this.condDesc = condDesc;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
