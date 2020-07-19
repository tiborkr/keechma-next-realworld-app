(ns codox.core
  (:require [codox.main :refer [generate-docs]]))

(defn build-docs
  []
  (generate-docs
    {:name "frontend"
     :version "0.1.0-SNAPSHOT"
     :description "Frontend for the application."
     :language :clojurescript
     :source-paths ["src"]
     :output-path "doc"
     :root-path "."
     :source-uri "https://our.git.server/dev/frontend/blob/{git-commit}/{filepath}#L{line}"
     :metadata {:doc/format :markdown :doc "FIXME: Write documentation."}
     :doc-paths ["doc"]
     :themes [:dark]}))