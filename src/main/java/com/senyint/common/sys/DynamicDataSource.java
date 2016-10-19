package com.senyint.common.sys;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @version 1.0
 * @author NaiFei Wang
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	protected Object determineCurrentLookupKey() {
		return DataSourceHolder.INSTANCE.getDataSourceKey();
	}
}
