package de.p7s1.qa.sevenfacette.database;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.p7s1.qa.sevenfacette.db.DBConnection;
import de.p7s1.qa.sevenfacette.db.DFactory;
import de.p7s1.qa.sevenfacette.db.DbStatements;
import de.p7s1.qa.sevenfacette.db.config.DConfig;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import org.jetbrains.exposed.sql.Database;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 * TODO: Add Description
 *
 * @author Patrick Döring
 */
class JDatabaseTest {

  static DConfig dbConfig;
  static DbStatements createStatements;
  static DbStatements selectStatements;
  static DbStatements deleteStatements;
  private List<Map<String, Object>> dbResultSet;

  @BeforeAll
  static void setUp() {
    dbConfig = new DConfig();
    dbConfig.setDbDriver(System.getenv("DB_DRIVER"));
    dbConfig.setDbUrl(System.getenv("DB_URL"));
    dbConfig.setDbUser(System.getenv("DB_USER"));
    dbConfig.setDbPW(System.getenv("DB_PW"));
    createStatements = new DbStatements();
    selectStatements = new DbStatements();
    deleteStatements = new DbStatements();
  }
  @Test
  void connectDB() {
    createStatements.add("Statement 1;");
    createStatements.add("Statement 2;");

    dbConfig.executeQuery(createStatements);

    selectStatements.add("SELECT * FROM table;");

    dbResultSet = dbConfig.executeQuery(selectStatements);


    deleteStatements.add("Statement 1;");
    deleteStatements.add("DELETE FROM table WHERE ...;");

    dbConfig.executeQuery(deleteStatements);
  }
}
