(ns trapperkeeper-demo.trapperkeeper-demo-web-core
  (:require [clojure.tools.logging :as log]
            [compojure.core :as compojure]
            [compojure.route :as route]))

(defn app
  [meow-fn]
  (compojure/routes
    (compojure/GET "/:caller" [caller]
      (fn [req]
        (log/info "Handling request for caller:" caller)
        {:status  200
         :headers {"Content-Type" "text/plain"}
         :body    (meow-fn caller)}))
    (route/not-found "Not Found")))
