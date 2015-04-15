(ns trapperkeeper-demo.trapperkeeper-demo-web-service
  (:require [clojure.tools.logging :as log]
            [compojure.core :as compojure]
            [trapperkeeper-demo.trapperkeeper-demo-web-core :as web-core]
            [puppetlabs.trapperkeeper.core :as trapperkeeper]
            [puppetlabs.trapperkeeper.services :as tk-services]))

(trapperkeeper/defservice meow-web-service
  [[:ConfigService get-in-config]
   [:WebroutingService add-ring-handler get-route]
   [:MeowService meow]]
  (init [this context]
    (log/info "Initializing meow webservice")
    (let [url-prefix (get-route this)]
      (add-ring-handler
        this
        (compojure/context url-prefix []
          (web-core/app meow)))
      (assoc context :url-prefix url-prefix)))

  (start [this context]
    (let [host (get-in-config [:webserver :host])
           port (get-in-config [:webserver :port])
           url-prefix (get-route this)]
          (log/infof "Meow web service started; visit http://%s:%s%s/world to check it out!"
                     host port url-prefix))
     context))
