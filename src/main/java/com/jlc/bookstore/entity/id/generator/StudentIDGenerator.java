package com.jlc.bookstore.entity.id.generator;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.boot.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class StudentIDGenerator extends SequenceStyleGenerator {

	public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
	public static final String VALUE_PREFIX_DEFAULT = "";
	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%d";
	private String valuePrefix;
	private String numberFormat;

	/**
	 * The generate method gets called when Hibernate needs a primary key value to
	 * persist a new entity. The implementation of it is pretty simple. You call the
	 * generate method on the superclass to get the next value from the sequence,
	 * transform that value into the configured format and add it to the defined
	 * prefix.
	 */
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		return valuePrefix + String.format(numberFormat, super.generate(session, object));
	}

	/**
	 * Hibernate calls the configure method when it instantiates a
	 * StringPrefixedSequenceIdGenerator. Within this method, you need to do 2
	 * things:
	 * 
	 * 1. You need to call the configure method on the superclass and make sure to
	 * set the Type parameter to LongType. This is necessary because the sequence
	 * value will be part of a String, but Hibernate can’t handle String-based
	 * sequences. So, you need to tell Hibernate to generate a sequence value of
	 * type Long and convert it afterward.
	 * 
	 * 2. You can also read all configuration parameters provided for this
	 * generator. I will show you how to set these parameters in the following code
	 * snippet. Let’s, for now, focus on the handling of these parameters. All
	 * parameters are part of the Properties params object. You can use the
	 * ConfigurationHelper class to get a parameter by its name and to use a default
	 * value for undefined parameters. In this example, I read the parameter
	 * valuePrefix, which defines the prefix of the generated value, and the
	 * numberFormat parameter, which specifies the format of the sequence number.
	 * Both of these parameters are used by the generate method.
	 */
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {

		super.configure(LongType.INSTANCE, params, serviceRegistry);

		valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params, VALUE_PREFIX_DEFAULT);
		numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT);
	}
}
