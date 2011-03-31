(ns status-codes
  (:use compojure.response
        [ring.util.response :only [response status]]))

(def response-codes
  ^{:doc                            "HTTP Response Status Codes"}
  {:continue                        100
   :switch-protocol                 101
   :ok                              200
   :OK                              200
   :created                         201
   :accepted                        202
   :non-authoritative               203
   :no-content                      204
   :reset-content                   205
   :partial-content                 206
   :multiple-choices                300
   :moved-permanently               301
   :found                           302
   :see-other                       303
   :not-modifies                    304
   :use-proxy                       305
   :temporary-redirect              307
   :bad-request                     400
   :unauthorized                    401
   :payment-required                402
   :forbidden                       403
   :not-found                       404
   :method-not-allowed              405
   :not-acceptable                  406
   :proxy-authentication-required   407
   :request-timeout                 408
   :conflict                        409
   :gone                            410
   :length-required                 411
   :precondition-failed             412
   :request-entity-too-large        413
   :request-uri-too-long            414
   :unsupported-media-type          415
   :requested-range-not-satisfiable 416
   :expectation-failed              417
   :internal-server-error           500
   :not-implemented                 501
   :bad-gateway                     502
   :service-unavailable             503
   :gateway-timeout                 504
   :http-version-not-supported      505})

(extend-type clojure.lang.Keyword
  Renderable
  (render [code _]
    (-> (response "")
        (status (response-codes code)))))

(defn keyword->code
  "Converts keyworded status code to status code in response map."
  [code]
  (if code
    (or (response-codes code)
        code)
    200))

(extend-type clojure.lang.APersistentMap
  Renderable
  (render [m _]
    (merge (response "") (assoc m :status (keyword->code (:status m))))))
