(ns snippets-clj.fizzbuzz)

(defn- divisible?
  "Return true if n is divisible by m"
  [n m]
  (= (mod n m) 0))

(defn- fb
  "Convert a number according to the fizzbuzz rules"
  [n]
  (cond
    (divisible? n 15) "fizzbuzz"
    (divisible? n 3) "fizz"
    (divisible? n 5) "buzz"
    :else (str n)))

(defn fizzbuzz
  "Return numbers from 1 to n according to fizzbuzz rules"
  [n]
  (map fb (range 1 (inc n))))


