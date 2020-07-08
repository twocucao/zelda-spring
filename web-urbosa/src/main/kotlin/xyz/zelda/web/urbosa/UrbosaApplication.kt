package xyz.zelda.web.urbosa

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class UrbosaApplication

fun main(args: Array<String>) {
    runApplication<UrbosaApplication>(*args) {
        setBannerMode(Banner.Mode.CONSOLE)
    }
}
