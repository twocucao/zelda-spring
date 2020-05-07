package xyz.staffjoy.faraday.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.core.Ordered

/**
 * Faraday configuration properties
 */
@ConstructorBinding
@ConfigurationProperties("faraday")
data class FaradayProperties(

        /**
         * Faraday servlet filter order.
         */
        var filterOrder: Int = Ordered.HIGHEST_PRECEDENCE + 100,

        /**
         * Enable programmatic mapping or not,
         * false only in dev environment, in dev we use mapping via configuration file
         */
        var isEnableProgrammaticMapping: Boolean = true,

        /**
         * Properties responsible for collecting metrics during HTTP requests forwarding.
         */
        var metrics: MetricsProperties,

        /**
         * Properties responsible for tracing HTTP requests proxying processes.
         */
        var tracing: TracingProperties,

        /**
         * List of proxy mappings.
         */
        var mappings: List<MappingProperties>
)
