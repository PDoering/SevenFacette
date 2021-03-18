package de.p7s1.qa.sevenfacette.config.types

import kotlinx.serialization.Serializable
/**
 * TODO: Add Description
 *
 * @author Patrick Döring
 */
@Serializable
data class LoggingConfig(
        var level: LogLevel = LogLevel.NONE,
)

enum class LogLevel(val logLevel: String) {
    NONE(""),
    ERROR("error"),
    WARN("warn"),
    INFO ("info"),
    DEBUG("debug")
}
