package com.senyint.common.sys;

public enum DataSourceHolder {

	INSTANCE;

	private String sourceKeyHolder;

	private DataSourceHolder() {
		sourceKeyHolder = "ds_def";
	}

	public void setDataSourceKey(String dataSourceKey) {
		this.sourceKeyHolder = dataSourceKey;
	}

	public String getDataSourceKey() {
		return sourceKeyHolder;
	}
}