(ns looop.core
  (:require [reagent.core :as r :refer [atom]]
            )
  (:require-macros [reagent.ratom :refer [run!]]))

(enable-console-print!)

(def app-state (r/atom {:this 1 :that 2}))

(defn side-effect
  [x]
  (println "  do side effect with" (pr-str x))
  (println "    update :that")
  (swap! app-state update :that inc))

(defn get-state
  [path]
  (get-in @app-state path))

(defn subscribe
  [path f]
  (run!
    @(r/cursor app-state path)                              ; just for triggering the run! block
    (f)))

(println "subscribe to :this")

(subscribe [:this] #(side-effect (get-state [:that])))

(println "update :that")
(swap! app-state update :that inc)

(defn init! [])
