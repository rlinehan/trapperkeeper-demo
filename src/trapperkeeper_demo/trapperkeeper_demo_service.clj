(ns trapperkeeper-demo.trapperkeeper-demo-service
  (:require [clojure.tools.logging :as log]
            [cheshire.core :as json]
            [trapperkeeper-demo.trapperkeeper-demo-core :as core]
            [puppetlabs.trapperkeeper.services :refer [service-context]]
            [puppetlabs.trapperkeeper.core :as trapperkeeper]))

(defprotocol MeowService
  (meow [this caller]))

(defn read-db [path]
  (json/parse-string (slurp path) true))

(trapperkeeper/defservice meow-english-service
  MeowService
  [[:ConfigService get-in-config get-config]]
  (init [this context]
    (log/info "Hello, initializing meow service in English")
    (assoc context :db (read-db (get-in-config [:meow-service :db-path]))))

  (start [this context]
    (log/info "Starting meow service in English")
    context)

  (stop [this context]
    (log/info "Shutting down English meow service")
    context)

  (meow [this caller]
        (let [db (:db (service-context this))]
          (core/english-meow db caller))))

(trapperkeeper/defservice meow-french-service
  MeowService
  [[:ConfigService get-in-config]]
  (init [this context]
    (log/info "Bonjour, initializing meow service in French")
    (assoc context :db (read-db (get-in-config [:meow-service :db-path]))))

  (start [this context]
    (log/info "Starting meow service in French")
    context)

  (stop [this context]
    (log/info "Shutting down French meow service")
    context)

  (meow [this caller]
        (let [db (:db (service-context this))]
          (core/french-meow db caller))))

(trapperkeeper/defservice meow-japanese-service
  MeowService
  [[:ConfigService get-in-config]]
  (init [this context]
    (log/info "こんにちは, initializing meow service in Japanese")
    (assoc context :db (read-db (get-in-config [:meow-service :db-path]))))

  (start [this context]
    (log/info "Starting meow service in Japanese")
    context)

  (stop [this context]
    (log/info "Shutting down Japanese meow service")
    context)

  (meow [this caller]
        (let [db (:db (service-context this))]
          (core/japanese-meow db caller))))
