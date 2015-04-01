(ns trapperkeeper-demo.trapperkeeper-demo-web-core
  (:require [trapperkeeper-demo.trapperkeeper-demo-service :as meow-svc]
            [clojure.tools.logging :as log]
            [compojure.core :as compojure]
            [compojure.route :as route]))

(defn app
  [meow-service]
  (compojure/routes
    (compojure/GET "/:caller" [caller]
      (fn [req]
        (log/info "Handling request for caller:" caller)
        {:status  200
         :headers {"Content-Type" "text/plain"}
         :body    (meow-svc/meow meow-service caller)}))
    (route/not-found "Not Found")))
