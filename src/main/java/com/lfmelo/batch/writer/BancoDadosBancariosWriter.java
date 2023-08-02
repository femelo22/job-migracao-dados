package com.lfmelo.batch.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lfmelo.batch.domain.DadosBancarios;

@Configuration
public class BancoDadosBancariosWriter {

	@Bean
	public JdbcBatchItemWriter<DadosBancarios> bancoDadosBancariosWriter(@Qualifier("app.datasource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<DadosBancarios>()
				.dataSource(dataSource)
				.sql("INSERT INTO dados_bancarios (id, pessoa_id, agencia, conta, banco) VALUES (:id, :pessoaId, :agencia, :conta, :banco)")
				.beanMapped()
				.build();
	}
}
