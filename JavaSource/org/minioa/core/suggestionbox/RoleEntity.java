package org.minioa.core.suggestionbox;

import java.io.Serializable;

public class RoleEntity implements Serializable {
	private static final long	serialVersionUID	= -1042449580199397136L;
	private boolean				checked				= false;
	private String				id;
	private String				name;
	private String				desc;

	public RoleEntity() {
	}

	public String getId() {
		return id;
	}

	public void setId(String data) {
		this.id = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String data) {
		this.name = data;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String data) {
		this.desc = data;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
