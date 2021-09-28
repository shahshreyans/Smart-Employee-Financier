package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="AddDataset")
public class DatasetVO 
{
	@Id
	@Column(name="DatasetId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int datasetId;
	
	@Column(name="DatasetName")
	private String datasetName;
	
	@Column(name="DatasetDescription")
	private String datasetDescription;
	
	@Column(name="DatasetPath")
	private String datasetPath;

	public int getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(int datasetId) {
		this.datasetId = datasetId;
	}

	public String getDatasetName() {
		return datasetName;
	}

	public void setDatasetName(String datasetName) {
		this.datasetName = datasetName;
	}

	public String getDatasetDescription() {
		return datasetDescription;
	}

	public void setDatasetDescription(String datasetDescription) {
		this.datasetDescription = datasetDescription;
	}

	public String getDatasetPath() {
		return datasetPath;
	}

	public void setDatasetPath(String datasetPath) {
		this.datasetPath = datasetPath;
	}
}
