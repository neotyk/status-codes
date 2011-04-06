(ns status-codes.compojure
  (:use compojure.response
        [ring.util.response :only [response status]]
        [status-codes :only [keyword->code]]))

(extend-type clojure.lang.Keyword
  Renderable
  (render [code _]
    (-> (response "")
        (status (keyword->code code)))))

(extend-type clojure.lang.APersistentMap
  Renderable
  (render [m _]
    (merge (response "")
           (assoc m :status (keyword->code (:status m))))))
