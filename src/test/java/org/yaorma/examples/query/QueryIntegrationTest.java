package org.yaorma.examples.query;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.yaorma.dao.Dao;
import org.yaorma.database.Database;
import org.yaorma.testoutput.msaccess.northwind.dvo.CustomersDvo;
import org.yaorma.testutil.database.MsAccessConnectionUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueryIntegrationTest {

	@Test
	public void shouldGetCustomers() {
		log.info("Getting customers...");
		Connection conn = MsAccessConnectionUtil.getNorthWind();
		try {
			String sqlString = "select * from customers where \"first name\" is not null and \"business phone\" is not null limit 10";
			List<CustomersDvo> customers = Dao.findListBySql(new CustomersDvo(), sqlString, conn);
			log.info("Got " + customers.size() + " customers");
			for(CustomersDvo dvo : customers) {
				String msg = "\t";
				msg += StringUtils.rightPad(dvo.getId() + "", 5) + "\t";
				msg += StringUtils.rightPad(dvo.getFirst_SPACE_name(), 15);
				msg += StringUtils.rightPad(dvo.getLast_SPACE_name(), 25);
				msg += dvo.getBusiness_SPACE_phone();
				log.info(msg);
			}
		} finally {
			log.info("Closing connection");
			Database.close(conn);
		}
		log.info("Done.");
	}

}
