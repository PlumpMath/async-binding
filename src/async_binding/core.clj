(ns async-binding.core
  (:gen-class :main true)
  (:require [clojure.core.async :refer [go <!]]))

(def ^:dynamic *foo* nil)

(defn -main [& args]
  (go
    (binding [*foo* nil]
      (<! (go 42))
      (println "done.")))

  (Thread/sleep 30000))
