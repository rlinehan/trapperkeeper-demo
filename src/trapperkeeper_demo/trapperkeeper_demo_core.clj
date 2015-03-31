(ns trapperkeeper-demo.trapperkeeper-demo-core)

(defn hello
  "Say hello to caller"
  [caller]
  (format "Hello, %s!" caller))
