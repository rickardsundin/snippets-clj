(ns snippets-clj.fizzbuzz-test
  (:require [clojure.test :refer :all]
            [snippets-clj.fizzbuzz :refer :all]))

(deftest fizzbuzz-20-test
  (testing "Return numbers from 1 to 10 according to fizzbuzz rules"
    (is (= (fizzbuzz 20) '("1" "2" "fizz" "4" "buzz" "fizz" "7" "8" "fizz" "buzz"
                           "11" "fizz" "13" "14" "fizzbuzz" "16" "17" "fizz" "19" "buzz")))))
