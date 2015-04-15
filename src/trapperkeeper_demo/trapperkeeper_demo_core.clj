(ns trapperkeeper-demo.trapperkeeper-demo-core
  (:require [clojure.tools.logging :as log]))

(defn cat-say
  "Say something as a cat."
  [msg]
  (format "=^.^= < %s" msg))

(defn french-meow
  "As a cat, greet someone in french"
  [db caller]
  (log/info "Meowing in French!")
  (cat-say (format "%s %s" (:french db) caller)))

(defn japanese-meow
  "As a cat, greet someone in japanese"
  [db caller]
  (log/info "Meowing in Japanese!")
  (cat-say (format "%s %s" (:japanese db) caller)))

(defn english-meow
  "As a cat, greet someone in english"
  [db caller]
  (log/info "Meowing in English!")
  (cat-say (format "%s %s" (:english db) caller)))
