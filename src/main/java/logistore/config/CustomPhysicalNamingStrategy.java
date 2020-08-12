package logistore.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Nicolas ENZWEILER
 */
public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {

	@Value("${spring.datasource.table-prefix}")
	private String tablePrefix;

	@Override
	public Identifier toPhysicalCatalogName(Identifier idntfr, JdbcEnvironment je) {
		return idntfr;
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier idntfr, JdbcEnvironment je) {
		return idntfr;
	}

	@Override
	public Identifier toPhysicalTableName(Identifier idntfr, JdbcEnvironment je) {
		return je.getIdentifierHelper().toIdentifier(tablePrefix + idntfr.getText());
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier idntfr, JdbcEnvironment je) {
		return idntfr;
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier idntfr, JdbcEnvironment je) {
		return convertToSnakeCase(idntfr);
	}

    private Identifier convertToSnakeCase(final Identifier identifier) {
        final String regex = "([a-z])([A-Z])";
        final String replacement = "$1_$2";
        final String newName = identifier.getText()
          .replaceAll(regex, replacement)
          .toLowerCase();
        return Identifier.toIdentifier(newName);
    }
}
