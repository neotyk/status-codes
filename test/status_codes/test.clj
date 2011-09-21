(ns status-codes.test
  (:use [status-codes] :reload)
  (:use clojure.test))

(deftest test-keyword->code
  (are [expected k]
       (= expected (keyword->code k))
       200 nil
       202 202
       410 :gone
       304 :not-modified))
