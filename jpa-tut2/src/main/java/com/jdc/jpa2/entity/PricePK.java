package com.jdc.jpa2.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class PricePK implements Serializable {
	
	private int itemId;
	private Date refDate;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public Date getRefDate() {
		return refDate;
	}
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + ((refDate == null) ? 0 : refDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PricePK other = (PricePK) obj;
		if (itemId != other.itemId)
			return false;
		if (refDate == null) {
			if (other.refDate != null)
				return false;
		} else if (!refDate.equals(other.refDate))
			return false;
		return true;
	}

}
