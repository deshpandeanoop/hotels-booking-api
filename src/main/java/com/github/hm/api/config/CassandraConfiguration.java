package com.github.hm.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "k_hotels";
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean factoryBean = super.cluster();
        factoryBean.setJmxReportingEnabled(false);
        return factoryBean;
    }
}
