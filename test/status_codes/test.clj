(ns status-codes.test
  (:use [status-codes] :reload)
  (:use [clojure.test]
        [compojure.response]
        [compojure.core :only [GET routes]]
        [ring.mock.request :only [request]]))

(def keywords-handler
  ^{:private true :doc "keywords test handler"}
  (routes
   (GET "/ok" _ :ok)
   (GET "/accepted" _ :accepted)))

(deftest test-keyword-result
  (are [path resp]
       (= (keywords-handler (request :get path))
          resp)
       "/ok"       {:status 200 :headers {} :body ""}
       "/accepted" {:status 202 :headers {} :body ""}))
