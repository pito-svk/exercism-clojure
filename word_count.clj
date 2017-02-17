(ns word-count)

(require '[clojure.string :as str])

(defn only-alpha-num-or-space [char]
  (if (or (Character/isDigit char) (Character/isLetter char) (= \space char)) char)
)

(defn remove-non-alpha [text]
  (apply str (filter only-alpha-num-or-space text))
)

(defn word-count [sentence]
 (frequencies (str/split (str/lower-case (remove-non-alpha sentence)) #"\s+"))
)
