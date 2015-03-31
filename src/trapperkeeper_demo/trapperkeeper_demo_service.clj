(ns trapperkeeper-demo.trapperkeeper-demo-service
  (:require [clojure.tools.logging :as log]
            [trapperkeeper-demo.trapperkeeper-demo-core :as core]
            [puppetlabs.trapperkeeper.core :as trapperkeeper]))

(defprotocol HelloService
  (hello [this caller]))

;; Keep init etc functions, just log different messages
;; Slurp / parse a flat json file that maps from language -> word, store map in context
;; Pull out map from ctx and use in core functions
;; Cattify everything

(trapperkeeper/defservice hello-english-service
  HelloService
  []
  (init [this context]
    (log/info "Initializing hello service")
    context)
  (start [this context]
    (log/info "Starting hello service")
    context)
  (stop [this context]
    (log/info "Shutting down hello service")
    context)
  (hello [this caller]
         (core/english-hello caller)))

(trapperkeeper/defservice hello-french-service
  HelloService
  []
  (init)
  (start)
  (stop)
  (hello [this caller]
         (core/french-hello caller)))
