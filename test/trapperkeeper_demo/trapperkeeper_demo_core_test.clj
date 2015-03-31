(ns trapperkeeper-demo.trapperkeeper-demo-core-test
  (:require [clojure.test :refer :all]
            [trapperkeeper-demo.trapperkeeper-demo-core :refer :all]))

(deftest hello-test
  (testing "says hello to caller"
    (is (= "Hello, foo!" (hello "foo")))))
