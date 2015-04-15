(ns trapperkeeper-demo.trapperkeeper-demo-web-service-test
  (:require [clojure.test :refer :all]
            [puppetlabs.trapperkeeper.app :as app]
            [puppetlabs.trapperkeeper.testutils.bootstrap :refer [with-app-with-config]]
            [puppetlabs.trapperkeeper.services.webserver.jetty9-service :refer [jetty9-service]]
            [puppetlabs.trapperkeeper.services.webrouting.webrouting-service :refer [webrouting-service]]
            [clj-http.client :as client]
            [trapperkeeper-demo.trapperkeeper-demo-service :as svc]
            [trapperkeeper-demo.trapperkeeper-demo-web-service :as web-svc]))

(deftest meow-web-service-test
  (testing "says meow to caller"
    (with-app-with-config app
      [svc/meow-japanese-service
       web-svc/meow-web-service
       jetty9-service
       webrouting-service]
      {:webserver {:host "localhost"
                   :port 8080}
       :meow-service {:db-path "resources/test-meowdb.json"}
       :web-router-service {
         :trapperkeeper-demo.trapperkeeper-demo-web-service/meow-web-service "/meow"}}
      (let [resp (client/get "http://localhost:8080/meow/foo" {:as :text})]
        (is (= "=^.^= < nyaa foo" (:body resp)))))))
