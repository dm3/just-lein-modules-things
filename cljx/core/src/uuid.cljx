(ns uuid
  #+clj (:import [java.util UUID]))

(defn uuid-v4 []
  #+cljs
  ;; randomly generated
  (UUID. "2b16645a-0a5d-4414-adce-4bc640ae8c86")

  #+clj
  (UUID/randomUUID))
