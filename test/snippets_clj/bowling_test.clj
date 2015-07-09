(ns snippets-clj.bowling-test
  (:require [clojure.test :refer :all]
            [snippets-clj.bowling :refer :all]))

(deftest gutter-game
  (testing "Bowling game with the worlds worst bowler"
    (is (= (bowling-score '(0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0)) 0))))

(deftest game-of-ones
  (testing "Bowling game where 1 pin is dropped each roll"
    (is (= (bowling-score '(1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1)) 20))))

(deftest game-with-one-strike
  (testing "Game where the first roll is a strike"
    (is (= (bowling-score '(10 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1)) 30))))

(deftest game-with-one-spare
  (testing "Game where the first frame is a spare"
    (is (= (bowling-score '(5 5 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1)) 29))))

(deftest game-with-all-spares
  (testing "Game where every frame is a spare"
    (is (= (bowling-score '(5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5)) 150))))

(deftest perfect-game
  (testing "Game with all strikes"
    (is (= (bowling-score '(10 10 10 10 10 10 10 10 10 10 10 10)) 300))))
