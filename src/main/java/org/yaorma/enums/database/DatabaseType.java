package org.yaorma.enums.database;

import org.yaorma.codeGenerator.impl.OrmCodeGeneratorImpl;
import org.yaorma.codeGenerator.impl.msaccess.MsAccessOrmCodeGenerator;
import org.yaorma.codeGenerator.impl.mssqlserver.MsSqlServerOrmCodeGenerator;
import org.yaorma.codeGenerator.impl.mysql.MySqlOrmCodeGenerator;

import lombok.Getter;

@Getter
public enum DatabaseType {

	MS_SQL_SERVER(new MsSqlServerOrmCodeGenerator()),
	MS_ACCESS(new MsAccessOrmCodeGenerator()),
	MY_SQL(new MySqlOrmCodeGenerator());

	private OrmCodeGeneratorImpl codeGenerator;
	
	private DatabaseType(OrmCodeGeneratorImpl gen) {
		this.codeGenerator = gen;
	}

}
