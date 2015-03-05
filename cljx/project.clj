(defproject cljx/cljx-parent "0.1.0-SNAPSHOT"
  :packaging "pom"
  :plugins [[lein-modules "0.3.10"]]

  :profiles {:provided {:dependencies [[org.clojure/clojure _]]}}

  :modules {:subprocess false
            :inherited
            {:vcs :git}

            :versions {org.clojure/clojure "1.6.0"}})
