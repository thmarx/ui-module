/**
 * communication with the server
 */

class ContentServer {
    
    #baseUrl
    
    constructor (baseUrl) {
        this.#baseUrl = baseUrl
    }

    getContentNode (url) {
        return {
            "url": url
        }
    }

    getContent (uri)  {
        return {
            uri: uri,
            content: ""
        }
    }

    setContent (uri, content) {

    }

    getMetadata (uri) {
        return {
            uri: uri,
            meta: {}
        }
    }

    setMetadata (uri, metadata) {

    }
}