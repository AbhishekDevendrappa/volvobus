package com.wipro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="volvo_Bus")
@Data
public class VolvoBus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long busId;
	private String source;
	private String destination;
	private int amount;
	
	public long getBusId() {
		return busId;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public int getAmount() {
		return amount;
	}
	public void setBusId(long busId) {
		this.busId = busId;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
