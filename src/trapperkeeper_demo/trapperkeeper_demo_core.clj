(ns trapperkeeper-demo.trapperkeeper-demo-core)

(defn cat-say
  "Say something as a cat."
  [msg]
  (format "=^.^= < %s" msg))

(defn french-meow
  "As a cat, greet someone in french"
  [db caller]
  (cat-say (format "%s %s" (:french db) caller)))

(defn japanese-meow
  "As a cat, greet someone in japanese"
  [db caller]
  (cat-say (format "%s %s" (:japanese db) caller)))

(defn english-meow
  "As a cat, greet someone in english"
  [db caller]
  (cat-say (format "%s %s" (:english db) caller)))
