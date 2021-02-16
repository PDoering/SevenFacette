package db

import de.p7s1.qa.sevenfacette.db.DbStatement
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Test class for [DbStatement].
 *
 * Testcases:
 *  Prepared Statement is valid -> false
 *  Prepared Statement is valid -> true
 *  Prepared Statement with whitespace at the end
 *  Prepared Statement without whitespace at the end
 *  Prepared Statement with format parameter in replacement like 'Person ?' -> no replacement
 *  Prepared Statement with format parameter in basic statement -> no replacement
 *  Prepared Statement without whitespace between format parameter
 *  Prepared Statement without constructor arguments and call replaceAll separately
 *
 * @author Patrick Döring
 */
class DbStatementTest {

    @Test
    fun validatePrepStatementFalse() {
        val dbStatement = DbStatement("SELECT * FROM person WHERE name = ? AND age = ?")
        assertFalse(dbStatement.validate())
    }

    @Test
    fun validatePrepStatementTrue() {
        val dbStatement = DbStatement("SELECT * FROM person WHERE name = ? " +
                "AND age = ? AND job = ? AND car = ? AND address = ?",
                "TestName", 25, true, null, "")

        assertTrue(dbStatement.validate())
    }

    @Test
    fun prepStatementWithEmptyCharEnding() {
        val dbStatement = DbStatement("SELECT * FROM person WHERE name = ? " +
                "AND age = ? AND job = ? AND car = ? AND address = ? ",
                "TestName", 25, true, null, "")

        assertEquals("SELECT * FROM person WHERE name = 'TestName' AND age = 25 AND " +
                "job = true AND car = null AND address = ''", dbStatement.sqlStatement)
    }

    @Test
    fun prepStatementWithoutEmptyCharEnding() {
        val dbStatement = DbStatement("SELECT * FROM person WHERE name = ? " +
                "AND age = ? AND job = ? AND car = ? AND address = ?",
                "TestName", 25, true, null, "")

        assertEquals("SELECT * FROM person WHERE name = 'TestName' AND age = 25 AND " +
                "job = true AND car = null AND address = ''", dbStatement.sqlStatement)
    }

    @Test
    fun replaceWithFormatParameterValue() {
        val dbStatement = DbStatement("SELECT * FROM person WHERE name = ? " +
                "AND age = ? AND job = ? AND car = ? AND address = ?",
                "Person ?", 25, true, null, "")

        assertTrue(dbStatement.validate())
    }

    @Test
    fun replaceOnlyFormatParameter() {
        val statement = DbStatement("SELECT * FROM person WHERE name = 'Peter?' " +
                "AND age = ? AND job = ? AND car = ? AND address = ?", 25, true, null, "")
        assertTrue(statement.validate())
    }

    @Test
    fun replaceWithoutEmptyCharacter() {
        val dbStatement = DbStatement("SELECT * FROM person WHERE name=?" +
                " AND age=? AND job=? AND car=? AND address=?",
                "Person ?", 25, true, null, "")

        assertEquals("SELECT * FROM person WHERE name='Person ?' AND age=25 AND " +
                "job=true AND car=null AND address=''", dbStatement.sqlStatement)
    }

    @Test
    fun replaceWithoutArgs() {
        val dbStatement = DbStatement("SELECT * FROM person WHERE name = 'Peter ?' " +
                "AND age = ? AND job = ? AND car = ? AND address = ?")

        dbStatement.replaceAll(25, true, null, "")

        assertTrue(dbStatement.validate())

        assertEquals("SELECT * FROM person WHERE name = 'Peter ?' AND age = 25 AND " +
                "job = true AND car = null AND address = ''", dbStatement.sqlStatement)
    }
}
