(ns uuid-test
  (:require
     #+clj  [clojure.test :refer :all]
     #+cljs [cemerick.cljs.test :refer-macros (deftest testing is)]
            [uuid :as sut]))

(deftest uuid-test
  (testing "generates a new uuid"
    #+clj (do
            (is (java.util.UUID/fromString (str (sut/uuid-v4))))
            (is (instance? java.util.UUID (sut/uuid-v4))))
    #+cljs (do
             (is (= 36 (count (str (sut/uuid-v4)))))
             (is (instance? UUID (sut/uuid-v4))))))

