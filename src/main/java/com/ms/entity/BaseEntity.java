package com.ms.entity;

import java.io.Serializable;

public abstract class BaseEntity<K> implements Serializable {
	protected static final long serialVersionUID = 1L;
	protected String message;
	protected String error;

	public boolean equals(Object object) {
		return object == this
				? true
				: (object != null && object.getClass() == this.getClass()
						? (this.getId() == null ? false : this.getId().equals(((BaseEntity) object).getId()))
						: false);
	}

	public abstract K getId();

	public abstract void setId(K arg0);

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}
}