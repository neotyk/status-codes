(ns status-codes.middleware.test
  (:use [status-codes.middleware] :reload)
  (:use clojure.test
        [ring.mock.request :only [request]]))

(defn- status-producing-handler
  [status]
  (->
   (fn [req]
     (if (= (:uri req)
            "/")
       {:status status
       :headers {}
       :body ""}))
   wrap-status-codes))

(deftest test-ring-middleware
  (are [expected status]
       (= expected (:status ((status-producing-handler status) (request :get "/"))))
       201 201
       202 :accepted))

(deftest test-fall-through
  (is (nil? ((status-producing-handler 200) (request :get "/nil")))))
