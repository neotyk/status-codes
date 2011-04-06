# status-codes

Easy response status codes for compojure.
[Get it](http://clojars.org/status-codes) from
[Clojars](http://clojars.org).

## Usage

### In Compojure

    (use 'status-codes.compojure
         '[compojure.core :only [GET routes]])
    (routes
       (GET "/ok"           _ :ok)
       (GET "/accepted"     _ :accepted)
       (GET "/ok-map"       _ {:status :ok})
       (GET "/accepted-map" _ {:status :accepted}))

### As ring middleware

    (use 'status-codes.middleware)
    (defn handler [req]
      ;; your handling code that can use keyword status codes
      {:status :accepted ..})
    ;; wrap your handler in status-codes middleware
    (def app
      (-> handler
        wrap-status-codes
        ;; other wrappers that you need
        ))

## License

Copyright (C) 2011 Hubert Iwaniuk

Distributed under the Eclipse Public License, the same as Clojure.
