package xyz.zelda.gateway.view


data class ErrorPage (
        val title // Used in <title> and <h1>
            : String? = null,
        val explanation // Tell the user what's wrong
            : String? = null,
        val headerCode: Int = 0,
        val linkText // Where do you want user to go?
            : String? = null,
        val linkHref // what's the link?
            : String? = null,
        var sentryErrorId // What do we track the view as on the backend?
            : String? = null,
        var sentryPublicDsn // Config for app
            : String? = null,
        val imageBase64: String? = null
)