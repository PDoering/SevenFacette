package de.p7s1.qa.sevenfacette.kafka

/**
 * Data class to hold the consumed record data.
 *
 * @constructor the constructor receives the [key], [value], [offset] and [partition]
 *
 * @author Patrick Döring
 */
data class DKRecord(var key: String?, var value: String?, var offset: Long, var partition: Int) {}
