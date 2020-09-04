package de.p7s1.qa.sevenfacette.kafka.config

import de.p7s1.qa.sevenfacette.kafka.KFactory

/**
 * Based on the KTableTopicConfig the consumer and producer object can be created
 *
 * @constructor the constructor receives the [kafkaConfig]
 *
 * @author Patrick Döring
 */
class KTableTopicConfig (var kafkaConfig: KConfig) {
    var kafkaTopic: String = ""

    /**
     * Creates a KConsumer object via a factory
     *
     * @param [autoStart]
     *
     * @return [KConsumer]
     */
    @JsName("createKConsumer")
    fun createKConsumer(autoStart: dynamic) : dynamic {
        return KFactory().createKConsumer(this@KTableTopicConfig, autoStart)
    }

    /**
     * Creates a KProducer object via a factory
     *
     * @param [autoSend]
     *
     * @return [KProducer]
     */
    @JsName("createKProducer")
    fun createKProducer(autoSend: dynamic) : dynamic {
        println("CREATING A NEW PRODUCER")
        return KFactory().createKProducer(this@KTableTopicConfig)
    }
}
