(defproject cljx/core "0.1.0-SNAPSHOT"
  :plugins [[lein-modules "0.3.10"]
            [lein-cljsbuild "1.0.4"]]

  :dependencies [[org.clojure/clojure _]]

  :cljx
  {:builds
   [{:source-paths ["src"], :output-path "target/generated/src", :rules :clj}
    {:source-paths ["test"], :output-path "target/generated/test", :rules :clj}
    {:source-paths ["src"], :output-path "target/generated/src", :rules :cljs}
    {:source-paths ["test"], :output-path "target/generated/test", :rules :cljs}]}

  :prep-tasks [["cljx" "once"]]
  :source-paths ["src" "target/generated/src"]
  :test-paths   ["test" "target/generated/test"]
  :jar-exclusions [#"\.cljx"]

  :cljsbuild
  {:builds
   [{:source-paths ["target/generated/src" "target/generated/test"]
     :compiler {:output-to "target/main.js"}}]
   :test-commands {"unit-tests" ["phantomjs" :runner "target/main.js"]}}

  :aliases
  {"test-cljs" ["do" ["cljx" "once"]
                     ["cljsbuild" "test"]]}

  :profiles
  {:provided {:dependencies [[org.clojure/clojurescript "0.0-2913"]]}
   :dev {:jvm-opts ^:replace {}
         :plugins [[com.keminglabs/cljx "0.6.0"]
                   [com.cemerick/clojurescript.test "0.3.3"]]}})
