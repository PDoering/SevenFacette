package de.p7s1.qa.sevenfacette

import de.p7s1.qa.sevenfacette.db.DatabaseFactory
import de.p7s1.qa.sevenfacette.kafka.KConsumer
import de.p7s1.qa.sevenfacette.kafka.KProducer
import de.p7s1.qa.sevenfacette.veritas.all
import de.p7s1.qa.sevenfacette.veritas.verification.contains

import de.p7s1.qa.sevenfacette.veritas.verification.hasLength
import de.p7s1.qa.sevenfacette.veritas.verification.hasSize
import de.p7s1.qa.sevenfacette.veritas.verification.isBoolean
import de.p7s1.qa.sevenfacette.veritas.verification.isEqualTo

import de.p7s1.qa.sevenfacette.veritas.verification.isInt
import de.p7s1.qa.sevenfacette.veritas.verification.isLessThan
import de.p7s1.qa.sevenfacette.veritas.verification.isNullLiteral
import de.p7s1.qa.sevenfacette.veritas.verification.isObject
import de.p7s1.qa.sevenfacette.veritas.verification.isString
import de.p7s1.qa.sevenfacette.veritas.verification.isTrue
import de.p7s1.qa.sevenfacette.veritas.verification.isValueNodeArray
import de.p7s1.qa.sevenfacette.veritas.verification.jsonIsEqualTo
import de.p7s1.qa.sevenfacette.veritas.verification.jsonNodeOf
import de.p7s1.qa.sevenfacette.veritas.verification.jsonPath
import de.p7s1.qa.sevenfacette.veritas.verification.startsWith
import de.p7s1.qa.sevenfacette.veritas.verifyThat

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ServerApplication

fun main(args: Array<String>) {
    val logger = LoggerFactory.getLogger(ServerApplication::class.java)

    // Start Database handling
    val statements = DbStatements()
    statements.add("SELECT * FROM role")

    val ccDB = DatabaseFactory().init("org.postgresql.Driver","jdbc:postgresql://localhost:5432/test_cc", "ucp_cc", "cc4all")

    val result: List<Map<String, Any>>
    result = DatabaseFactory().runStatements(statements, ccDB)

    val pvvStatements = DbStatements()
    pvvStatements.add("execute procedure disable_trigger('ton', 1);")
    pvvStatements.add("Insert into ton (id, bezeichnung, kuerzel) VALUES (get_next_id('ton'),'SG UCP QA SIT Audio CREATE','S');")
    pvvStatements.add("UPDATE ap_user_kst_log SET zugriffs_recht = zugriffs_recht;")

    val pvvDB = DatabaseFactory().init("com.informix.jdbc.IfxDriver","jdbc:informix-sqli://pspmddbixstar01x:1528/pvv:INFORMIXSERVER=stargate1", "stargate", "3edc4rfv")

    val resultPVV = DatabaseFactory().runStatements(pvvStatements, pvvDB)
    // End Database Handling

    // Start Assertion Handling
    verifyThat("Test").all {
        startsWith("T")
        hasLength(4)
    }

    val objectJson = """
            {
              "foo": "aaa",
              "bar": 1,
              "baz": true,
              "qux": null,
              "quux": [ "bbb", "ccc" ],
              "corge": {
                "grault": "ddd",
                "garply": "eee",
                "waldo": "fff"
              }
            }
        """



    val expectedJson = """
            {
              "foo": "aaa",
              "bar": 1,
              "baz": true,
              "qux": null,
              "corge": {
                "grault": "ddd",
                "garply": "eee",
                "waldo": "fff"
              }
            }
        """

    verifyThat(objectJson).jsonIsEqualTo(expectedJson)

    verifyThat(jsonNodeOf(objectJson)).isObject().all {
        jsonPath("$.foo").isString().isEqualTo("aaa")
        // or jsonPath("$.foo").isEqualTo("aaa")
        jsonPath("$.bar").isInt().isLessThan(10)
        jsonPath("$.baz").isBoolean().isTrue()
        jsonPath("$.qux").isNullLiteral()
        jsonPath("$.quux").isValueNodeArray().all {
            hasSize(2)
        }
        jsonPath("$.corge").isObject().all {
            jsonPath("$.grault").isString().contains("DD", ignoreCase = true)
            jsonPath("$.garply").isString().isEqualTo("eee")
        }
        jsonPath("$.corge.waldo").isString().isEqualTo("fff")
    }

    // End Assertion Handling

    // Start Kafka Handling

    val kafka = KConsumer("BootstrapServer")
    val topic = "kt-topic"

    val consumer = KConsumer(topic)
    Runtime.getRuntime().addShutdownHook(Thread(Runnable {
        consumer.stop()
    }))
    consumer.consume {
        println("got $it")
    }

    val producer = KProducer(topic)
    (1..10).forEach {
        val msg = "test message"
        producer.send(msg)
    }
    producer.flush()

    // End Kafka Handling
}