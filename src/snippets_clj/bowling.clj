(ns snippets-clj.bowling)

(defn strike?
  "Return true if the first of rolls is a strike"
  [rolls]
  (= (first rolls) 10))

(defn spare?
  "Return true if the first two rolls is a spare"
  [rolls]
  (= (apply + (take 2 rolls)) 10)) 

(defn bonus-frame-score
  "Return the score for the first frame of rolls, including strike or spare bonus"
  [rolls]
  (apply + (take 3 rolls)))

(defn normal-frame-score
  "Return the score for the first frame of rolls, without bonus"
  [rolls]
  (apply + (take 2 rolls)))

(defn frame-scores
  "Given remaining rolls, the current frame number, and accumulated score,
  return the total score including strike and spare bonuses."
  [rolls frame score]
  (cond
    (> frame 10) 
    score

    (strike? rolls)
    (recur (rest rolls) (inc frame) (+ score (bonus-frame-score rolls)))
    
    (spare? rolls)
    (recur (drop 2 rolls) (inc frame) (+ score (bonus-frame-score rolls)))

    :else
    (recur (drop 2 rolls) (inc frame) (+ score (normal-frame-score rolls)))))


(defn bowling-score
  "Given a sequence with the number of pins that was struck down for each roll
  in a one person bowling game, return the total score."
  [rolls]
  (frame-scores rolls 1 0))
