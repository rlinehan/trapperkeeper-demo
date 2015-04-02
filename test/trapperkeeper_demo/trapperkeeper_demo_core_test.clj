(ns trapperkeeper-demo.trapperkeeper-demo-core-test
  (:require [clojure.test :refer :all]
            [trapperkeeper-demo.trapperkeeper-demo-core :as core]))

(deftest cat-say-test
  (testing "can say things as a cat"
    (is (= "=^.^= < hi" (core/cat-say "hi")))))

(deftest meowing
  (testing "when meowing"
    (testing "can meow in french"
      (is (= "=^.^= < miaou world" (core/french-meow {:french "miaou"} "world"))))
    (testing "can meow in english"
      (is (= "=^.^= < meow world" (core/english-meow {:english "meow"} "world"))))
    (testing "can meow in japanese"
      (is (= "=^.^= < nyaa world" (core/japanese-meow {:japanese "nyaa"} "world"))))))

