(ns status-codes.middleware
  (:use [status-codes :only [keyword->code]]))

(defn wrap-status-codes
  "Middleware that converts keyword status codes to integers."
  [handler]
  (fn [req]
    (let [{code :status :as resp} (handler req)]
      (assoc resp :status (keyword->code code)))))
