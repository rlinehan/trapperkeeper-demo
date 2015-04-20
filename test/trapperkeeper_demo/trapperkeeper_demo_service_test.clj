(ns trapperkeeper-demo.trapperkeeper-demo-service-test
  (:require [clojure.test :refer :all]
            [puppetlabs.trapperkeeper.app :as app]
            [puppetlabs.trapperkeeper.testutils.bootstrap :as tk-testutils]
            [trapperkeeper-demo.trapperkeeper-demo-service :as svc]))

(deftest meow-services-test
  (testing "says meow to caller in various languages"
    (doseq [[sound service] [["meow" svc/meow-english-service]
                             ["miaou" svc/meow-french-service]
                             ["nyaa" svc/meow-japanese-service]]]

    (tk-testutils/with-app-with-config app [service]
      {:meow-service {:db-path "resources/test-meowdb.json"}}
      (let [meow-service (app/get-service app :MeowService)]
        (is (= (str "=^.^= < " sound " foo")
               (svc/meow meow-service "foo"))))))))
