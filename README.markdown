# status-codes

Easy response status codes for compojure.

## Usage

    (use 'status-codes
         '[compojure.core :only [GET routes]])
    (routes
       (GET "/ok"           _ :ok)
       (GET "/accepted"     _ :accepted)
       (GET "/ok-map"       _ {:status :ok})
       (GET "/accepted-map" _ {:status :accepted}))

## License

Copyright (C) 2011 Hubert Iwaniuk

Distributed under the Eclipse Public License, the same as Clojure.
