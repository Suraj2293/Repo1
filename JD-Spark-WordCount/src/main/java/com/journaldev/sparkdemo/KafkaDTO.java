package com.journaldev.sparkdemo;

import lombok.Getter;
import lombok.Setter;

public class KafkaDTO {
	 private String topic;
	 private Integer partition;
	 private Long offsets;
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Integer getPartition() {
		return partition;
	}
	public void setPartition(Integer partition) {
		this.partition = partition;
	}
	public Long getOffsets() {
		return offsets;
	}
	public void setOffsets(Long offsets) {
		this.offsets = offsets;
	}
	 
	 
}
